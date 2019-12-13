package com.company;
//
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class HandlerTest {
    @Test
    void getGreeting_whenGivenADateAndName_ReturnsCorrectString() {
       Date date = new Date(1576130640952L);
       String name = "Bob";
       String expected = "Hi Bob. The date and time is Thu Dec 12 17:04:00 AEDT 2019";
       String greeting = Handler.getGreeting(date, name);
       assertEquals(expected, greeting);
    }

}