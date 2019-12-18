package com.company;

public class RequestBodyParser {

    public static Request parseRequest(String stringInput) {
        String[] request = stringInput.split(": ");
        String key = request[0];
        String value = request[1];
        return new Request(key, value);
    }
}
