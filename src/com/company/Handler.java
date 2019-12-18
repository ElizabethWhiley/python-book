package com.company;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

class Handler implements HttpHandler {
    private HashMap<Integer, String> people;

    public Handler(HashMap<Integer, String> people) {
        this.people = people;
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {

        String response = "";
        Date dateToday = new Date();

        if (exchange.getRequestMethod().equals("POST")) {
            Scanner scanner = new Scanner(exchange.getRequestBody(), StandardCharsets.UTF_8.name());
            String requestBody = scanner.useDelimiter("\\A").next();
            people.put(people.size(), requestBody);
            response = World.getGreeting(dateToday, people);
        } else if(exchange.getRequestMethod().equals("GET")) {
            response = World.getGreeting(dateToday, people);
        }

        exchange.sendResponseHeaders(200, response.length()); //need to know length of content
        OutputStream os = exchange.getResponseBody(); //gets the location where the response body will go when we write to it.
        os.write(response.getBytes());
        os.close();
    }




}