package com.company;

import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class ResponsesTest {
    @Test
    void getGreeting_whenGivenADateAndName_ReturnsCorrectResponse() {
        Date date = new Date(1576130640952L);
        HashMap<Integer, String> people = new HashMap<>();
        people.put(0, "Elizabeth");
        String expected = "Hi Elizabeth. The date and time is Thu Dec 12 17:04:00 AEDT 2019";
        String greeting = Responses.getGreeting(date, people);
        assertEquals(expected, greeting);
    }

    @Test
    void getGreeting_whenGivenADateAndTwoNames_ReturnsCorrectResponse(){
        Date date = new Date(1576130640952L);
        HashMap<Integer, String> people = new HashMap<>();
        people.put(0, "Elizabeth");
        people.put(1, "Nik");
        String expected = "Hi Elizabeth and Nik. The date and time is Thu Dec 12 17:04:00 AEDT 2019";
        String greeting = Responses.getGreeting(date, people);
        assertEquals(expected, greeting);
    }

    @Test
    void getGreeting_whenGivenADateAndThreeNames_ReturnsCorrectResponse(){
        Date date = new Date(1576130640952L);
        HashMap<Integer, String> people = new HashMap<>();
        people.put(0, "Elizabeth");
        people.put(1, "Nik");
        people.put(2, "Pavel");
        String expected = "Hi Elizabeth, Nik and Pavel. The date and time is Thu Dec 12 17:04:00 AEDT 2019";
        String greeting = Responses.getGreeting(date, people);
        assertEquals(expected, greeting);
    }

    @Test
    void getAllUsers_whenGivenUserDatabse_ReturnsCorrectListResponse(){
        HashMap<Integer, String> people = new HashMap<>();
        people.put(0, "Elizabeth");
        people.put(1, "Nik");
        people.put(2, "Pavel");
        String expected = "Elizabeth\nNik\nPavel";
        String greeting = Responses.getAllUsers(people);
        assertEquals(expected, greeting);
    }
}