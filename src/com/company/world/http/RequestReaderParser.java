package com.company.world.http;

import com.sun.net.httpserver.HttpExchange;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class RequestReaderParser {
//TODO How to test this?
    public static Request readAndParseRequest(HttpExchange exchange) {
        Scanner scanner = new Scanner(exchange.getRequestBody(), StandardCharsets.UTF_8.name());
        RequestReader requestReader = new RequestReader(scanner);
        String requestBody = requestReader.getRequestAsString();
        return RequestBodyParser.parseRequest(requestBody);
    }

}
