package com.company;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.HashMap;

class Handler implements HttpHandler {

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        Date date = new Date();
        HashMap<Integer, String> peopleDatabase = new HashMap<>();
        peopleDatabase.put(0, "Bob");

        if (exchange.getRequestMethod().equals("POST")) {

        } else {
            String response = getGreeting(date, name);
            exchange.sendResponseHeaders(200, response.length()); //need to know length of content
            OutputStream os = exchange.getResponseBody(); //gets the location where the response body will go when we write to it.
            os.write(response.getBytes());
            os.close();
        }
    }


}