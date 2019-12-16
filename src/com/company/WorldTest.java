package com.company;

import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class WorldTest {
    @Test
    void getGreeting_whenGivenADateAndName_ReturnsCorrectString() {
        Date date = new Date(1576130640952L);
        HashMap<Integer, String> people = new HashMap<>();
        people.put(0, "Bob");
        String expected = "Hi Bob. The date and time is Thu Dec 12 17:04:00 AEDT 2019";
        String greeting = World.getGreeting(date, people);
        assertEquals(expected, greeting);
    }

}