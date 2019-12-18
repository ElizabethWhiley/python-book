package com.company;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

class World {

    static String getGreeting(Date date, HashMap<Integer, String> people) {
        if (people.size() == 1) {
            return "Hi " + people.get(0) + ". The date and time is " + date;
        } else {
            return "Hi " + namesAsString(people) + ". The date and time is " + date;
        }
    }

    private static String namesAsString(HashMap<Integer, String> people) {
        ArrayList<String> names = new ArrayList<>(people.values());
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < names.size() - 1; i++ ) {
            stringBuilder.append(names.get(i)).append(", ");
        }

        return stringBuilder.toString()
                .substring (0, stringBuilder.length()-2)
                + " and "
                + names.get(names.size() - 1);
    }

}
