package com.company.world.http;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;;
import java.io.*;
import java.util.Date;
import java.util.HashMap;

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
                Request request = RequestReaderParser.readAndParseRequest(exchange);
               response = Responses.getGreeting(dateToday, people);
                break;
            case "POST": {
               request = RequestReaderParser.readAndParseRequest(exchange);
                people.put(people.size(), request.getValue()); //separate set of functions - separate class - business logic. Validatino. Call another class that acts on the hashmap (inteface) - data layer. Data layer knows it's a hashmap.
                response = Responses.getGreeting(dateToday, people);
                break;
            }
            case "PUT": {
                request = RequestReaderParser.readAndParseRequest(exchange);
                people.replace(Integer.parseInt(request.getKey()), request.getValue());
                response = Responses.getGreeting(dateToday, people);
                break;
            }
            case "DELETE": {
                request = RequestReaderParser.readAndParseRequest(exchange);
//                Before this the business logic needs to takes the parsed request and provide instructions to the data layer but also calls the data layer. CRUD.
//                Indexed by whatever info is relevant and passes it to the data layer. Business logic doesn't need to know what the data structure is. So how do i test it when it's data structure agnostic
//                Business loci could return an error
                people.entrySet().removeIf(entry -> (request.getValue().equals(entry.getValue())));
                response = Responses.getGreeting(dateToday, people);
                break;
            }
//            Default response code 409 method not allowed.
        }

        exchange.sendResponseHeaders(200, response.length()); //need to know length of content
        OutputStream os = exchange.getResponseBody(); //gets the location where the response body will go when we write to it.
        os.write(response.getBytes());
        os.close();
    }



}