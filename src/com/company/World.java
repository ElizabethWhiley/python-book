package com.company;

import com.sun.net.httpserver.HttpExchange;

import java.io.*;
import java.util.Date;
import java.util.HashMap;
import java.util.stream.Collectors;

public class World {

    static String getGreeting(Date date, HashMap<Integer, String> people) {
        return "Hi " + people.get(0) + ". The date and time is " + date;
    }

//    static String addPerson(String httpExchange) throws IOException {
//
//    }
}
