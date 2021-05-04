package com.kalenikov.bot;

//   "id": 22020,
//   "type": "message",
//   "date": "2021-05-02T17:00:01",
//   "from": "Sergey",
//   "from_id": "user399848983",
//   "text": "Ебучие скрепы"

public class Message {
    private int id;
    private String type;
    private String date;
    private String from;
    private String from_id;
    private String text;

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getDate() {
        return date;
    }

    public String getFrom() {
        return from;
    }

    public String getFrom_id() {
        return from_id;
    }

    public String getText() {
        return text;
    }

    public Message(int id, String type, String date, String from, String from_id, String text) {
        this.id = id;
        this.type = type;
        this.date = date;
        this.from = from;
        this.from_id = from_id;
        this.text = text;
    }

    public Message(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", date='" + date + '\'' +
                ", from='" + from + '\'' +
                ", from_id='" + from_id + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
