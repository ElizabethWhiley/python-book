package com.company;

public class Request {

    private String key;
    private String value;

    public Request(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

}
