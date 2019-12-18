package com.company;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.HashMap;

public class Server {

    private HashMap<Integer, String> people;

    public Server() {
        this.people = new HashMap<>();
        people.put(0, "Bob");
    }

    void start() throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
        server.createContext("/", new IndexHandler(people));
        server.createContext("/users", new UsersHandler(people));
        server.setExecutor(null);
        server.start();
        System.out.println("Listening on http://localhost:8000");
    }

}
