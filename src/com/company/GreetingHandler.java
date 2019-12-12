package com.company;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;

class GreetingHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        Date date = new Date();
        String name = "Bob";
        String response = getGreeting(date, name);
//        exchange.getRequestMethod() This gets what type of request it is.
        exchange.sendResponseHeaders(200, response.length()); //need to know length of content
        OutputStream os = exchange.getResponseBody(); //gets the location where the response body will go when we write to it.
        os.write(response.getBytes());
        os.close();
    }

    static String getGreeting(Date date, String name) {
        return "Hi " + name + ". The date and time is " + date;
    }
}