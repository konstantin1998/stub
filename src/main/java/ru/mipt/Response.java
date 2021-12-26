package ru.mipt;

public class Response {
    private String id;
    private int statusCode;

    public Response(String id, int statusCode) {
        this.id = id;
        this.statusCode = statusCode;
    }

    public Response(){}

    public void setId(String id) {
        this.id = id;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getId() {
        return id;
    }

    public int getStatusCode() {
        return statusCode;
    }
}
