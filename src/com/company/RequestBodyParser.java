package com.company;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class RequestBodyParser {

    public static Request parseRequest(String stringInput) {
        String[] request = stringInput.split("=");
        int key = Integer.parseInt(request[0]);
        String value = request[1];
        return new Request(key, value);
    }
}
