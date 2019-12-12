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
        String response = "Hello Bob. The date is " + date;
        exchange.sendResponseHeaders(200, response.length()); //What does this do from this line down?
        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }
}

