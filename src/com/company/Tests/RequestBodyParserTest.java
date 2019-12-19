package com.company.Tests;

import com.company.Request;
import com.company.RequestBodyParser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RequestBodyParserTest {
    @Test
    void getNameRequest_whenGivenNameInputStream_ReturnsNameString() {
        String requestBody = "name: elizabeth";
        Request requestExpected = new Request("name", "elizabeth");

        Assertions.assertEquals(requestExpected.getKey(), RequestBodyParser.parseRequest(requestBody).getKey());
        assertEquals(requestExpected.getValue(), RequestBodyParser.parseRequest(requestBody).getValue());
    }

}