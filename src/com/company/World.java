package com.company;

import java.io.OutputStream;
import java.util.Date;
import java.util.HashMap;

public class World {

    static String getGreeting(Date date, HashMap<Integer, String> people) {
        return "Hi " + people.get(0) + ". The date and time is " + date;
    }

    public static String addPerson(OutputStream responseBody) {

    }
}
