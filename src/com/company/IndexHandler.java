package com.company;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

class IndexHandler implements HttpHandler {
    private HashMap<Integer, String> people;

    IndexHandler(HashMap<Integer, String> people) {
        this.people = people;
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {

        String response = "";
        Date dateToday = new Date();

        switch (exchange.getRequestMethod()) {

            case "GET":
                response = Responses.getGreeting(dateToday, people);
                break;
            case "POST": {
                Request request = RequestReaderParser.readAndParseRequest(exchange);
                people.put(people.size(), request.getValue());
                response = Responses.getGreeting(dateToday, people);
                break;
            }
            case "PUT": {
                Request request = RequestReaderParser.readAndParseRequest(exchange);
                people.replace(Integer.parseInt(request.getKey()), request.getValue());
                response = Responses.getGreeting(dateToday, people);
                break;
            }
            case "DELETE": {
                Request request = RequestReaderParser.readAndParseRequest(exchange);
                people.entrySet().removeIf(entry -> (request.getValue().equals(entry.getValue())));
                response = Responses.getGreeting(dateToday, people);
                break;
            }
        }

        exchange.sendResponseHeaders(200, response.length()); //need to know length of content
        OutputStream os = exchange.getResponseBody(); //gets the location where the response body will go when we write to it.
        os.write(response.getBytes());
        os.close();
    }



}