package com.company;

import com.sun.net.httpserver.HttpExchange;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class RequestReaderParser {
//TODO Should I pass in the Reader and parser and fake the scanner and just test the parsing here?
    public static Request readAndParseRequest(HttpExchange exchange) {
        Scanner scanner = new Scanner(exchange.getRequestBody(), StandardCharsets.UTF_8.name());
        RequestReader requestReader = new RequestReader(scanner);
        String requestBody = requestReader.getRequestAsString();
        return RequestBodyParser.parseRequest(requestBody);
    }

}
