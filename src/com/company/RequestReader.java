package com.company;

import java.util.Scanner;

//TODO: Test with fake Scanner
//InputStr = new ByteArrayInputStream(request.getBytes(StandardCharsets.UTF_8));
public class RequestReader {
    private Scanner scanner;

    public RequestReader(Scanner scanner) {
        this.scanner = scanner;
    }

    public String getRequestAsString() {
        return scanner.useDelimiter("\\A").next();
    }
}
