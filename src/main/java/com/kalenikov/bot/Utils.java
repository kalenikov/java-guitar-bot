package com.kalenikov.bot;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Utils {
    public static void main(String[] args) throws IOException {

        String path = "c:\\temp\\java\\toxic_data\\result.json";
//        FileInputStream fis = new FileInputStream(path);
//        InputStreamReader is = new InputStreamReader(fis);
//        BufferedReader br = new BufferedReader(is);
//
//        String line = br.readLine();
//        while (line != null) {
//            System.out.println(line);
//            line = br.readLine();
//        }


//        String test = "{\"id\": 22020,\"type\": \"message\",\"date\": \"2021-05-02T17:00:01\",\"from\": \"Sergey\",\"from_id\": \"user399848983\",\"text\": \"Ебучие скрепы\"  }";
//        Gson gson = new Gson();
//        Message text = gson.fromJson(test, Message.class);
//        System.out.println(text);

        Type MESSAGE_TYPE = new TypeToken<List<Message>>() {
        }.getType();

        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(Message.class, new MessageConverter());
        Gson gson = builder.create();
        JsonReader jsonReader = new JsonReader(new FileReader(path));
        List<Message> l = gson.fromJson(jsonReader, MESSAGE_TYPE);
        var rsl = l.stream()
                .filter(m -> !m.getFrom().isBlank())
                .collect(
                        Collectors.groupingBy(Message::getFrom, Collectors.counting()));

        Map<String, Long> finalMap = new LinkedHashMap<>();
        rsl.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .forEachOrdered(e -> finalMap.put(e.getKey(), e.getValue()));

        finalMap.forEach((k, v) -> System.out.printf("%s %d%n", k, v));
    }
}
