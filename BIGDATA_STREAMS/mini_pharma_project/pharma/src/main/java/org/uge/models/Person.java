package org.uge.models;


import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;

public record Person(String firstName, String lastName, Long cip, Double price, Long idPharma) {

    public static String openSchema() throws URISyntaxException, IOException {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        var inputStream = classloader.getResourceAsStream("persons.avsc");
        var resultStringBuilder = new StringBuilder();

        if (inputStream != null) {
            try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
                String line;
                while ((line = br.readLine()) != null) {
                    resultStringBuilder.append(line).append("\n");
                }
            }
        }
        return resultStringBuilder.toString();
    }
}


