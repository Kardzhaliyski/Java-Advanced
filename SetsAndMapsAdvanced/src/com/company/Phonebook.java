package com.company;

import java.util.HashMap;
import java.util.Scanner;

public class Phonebook {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        var phonebook = new HashMap<String, String>();

        var input = "";
        while (!"search".equals(input = sc.nextLine())) {
            var dataInput = input.split("-", 2);
            var name = dataInput[0];
            var phoneNumber = dataInput[1];
            phonebook.put(name, phoneNumber);
        }

        while (!"stop".equals(input = sc.nextLine())) {
            if(phonebook.containsKey(input)) {
                System.out.printf("%s -> %s%n", input, phonebook.get(input));
            } else {
                System.out.printf("Contact %s does not exist.%n", input);
            }
        }
    }
}
