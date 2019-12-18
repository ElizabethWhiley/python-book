package com.company;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;

class RequestBodyParserTest {
    @Test
    void getNameRequest_whenGivenNameInputStream_ReturnsNameString() {
        String requestBody = "name: elizabeth";
        Request requestExpected = new Request("name", "elizabeth");

        assertEquals(requestExpected.getKey(), RequestBodyParser.parseRequest(requestBody).getKey());
        assertEquals(requestExpected.getValue(), RequestBodyParser.parseRequest(requestBody).getValue());
    }

    @Test
    void getEditRequest_whenGivenKeyAndValue_ReturnsREsponseObject() {
//        TODO: need to do test this - change method to take a string
//        String str = "elizabeth";
//        InputStream stream = new ByteArrayInputStream(str.getBytes(StandardCharsets.UTF_8));
//        System.out.println(RequestBodyParser.getNameRequest(stream));
//        assertEquals(str, RequestBodyParser.getNameRequest(stream));
    }
}