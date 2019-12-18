package com.company;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

//TODO: TEst with fake Scanner
public class RequestReader {
    private Scanner scanner;

    public RequestReader(Scanner scanner) {
        this.scanner = scanner;
    }

    public String getRequestAsString() {
        return scanner.useDelimiter("\\A").next();
    }
}
