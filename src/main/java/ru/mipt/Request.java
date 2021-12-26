package ru.mipt;

public class Request {
    private String id;

    public Request(String id) {
        this.id = id;
    }

    public Request() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
