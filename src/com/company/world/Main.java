package com.company.world;


import com.company.world.http.Server;

public class Main {

    public static void main(String[] args) throws Exception {
        Server server = new Server();
        server.start();
    }
}
