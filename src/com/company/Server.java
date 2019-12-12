package com.company;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class Server { //Is this the right name/class for this code?

    static void start() throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0); //What is this actually doing?
        server.createContext("/", new GreetingHandler()); // Is this like a route? How does it know if it's a get or a post request
        server.setExecutor(null); //what's this?
        server.start();
        System.out.println("Listening on http://localhost:8080");
    }

}
