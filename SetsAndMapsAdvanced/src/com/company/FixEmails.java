package com.company;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FixEmails {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        var emailAdresses = new LinkedHashMap<>();
        var input = "";
        final String regex = "(?i)\\.((us)|(uk)|(com)){1}+$";
        final Pattern pattern = Pattern.compile(regex);
        while(!"stop".equalsIgnoreCase(input = sc.nextLine())) {
            var name = input;
            var email = sc.nextLine();
            final Matcher matcher = pattern.matcher(email);
            if(!matcher.find()) {
                emailAdresses.putIfAbsent(name, email);
            }
        }

        for (Map.Entry<Object, Object> entry : emailAdresses.entrySet()) {
            System.out.printf("%s -> %s%n", entry.getKey(), entry.getValue());
        }
    }
}
