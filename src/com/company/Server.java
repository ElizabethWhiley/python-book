package com.company;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class Server {

    static void start() throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        server.createContext("/greeting", new GreetingHandler());
        server.setExecutor(null);
        server.start();
        System.out.println("Listening on http://localhost:8080");
    }

}
