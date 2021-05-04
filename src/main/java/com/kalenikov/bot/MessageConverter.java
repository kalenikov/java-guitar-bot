package com.kalenikov.bot;

import com.google.gson.*;

import java.lang.reflect.Type;

public class MessageConverter implements JsonDeserializer<Message> {
    @Override
    public Message deserialize(JsonElement json, Type type, JsonDeserializationContext ctx) throws JsonParseException {
        JsonObject jo = json.getAsJsonObject();
        int id = jo.get("id").getAsInt();
        String typeMessage = jo.get("type").getAsString();
        String date = jo.get("date").getAsString();
        String from = jo.get("from") == null ? "" : jo.get("from").getAsString();
        String from_id = jo.get("from_id") == null ? "" : jo.get("from_id").getAsString();
        String text = jo.get("text").isJsonArray() ? "" : jo.get("text").getAsString();
        return new Message(id, typeMessage, date, from, from_id, text);
    }
}
