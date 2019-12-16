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

//        Maybe the database needs to be established somewhere else and passed into handler?
        HashMap<Integer, String> people = new HashMap<>();
        people.put(0, "Bob");
        String response = "";

        if (exchange.getRequestMethod().equals("POST")) {
//            Need  to send the request body to a method that pulls the name out and adds it to the database. Then returns the database to give to the greeter.
            response = World.addPerson(exchange.getResponseBody()); //need to write a test and update this method to print two people's names, and then three people's names
        } else if(exchange.getRequestMethod().equals("GET")) {
            response = World.getGreeting(date, people);
        }

        exchange.sendResponseHeaders(200, response.length()); //need to know length of content
        OutputStream os = exchange.getResponseBody(); //gets the location where the response body will go when we write to it.
        os.write(response.getBytes());
        os.close();
    }


}