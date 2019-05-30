package com.company;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class UniqueUsernames {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        var inputNum = Integer.parseInt(sc.nextLine());

        Set<String> usernames = new LinkedHashSet<>();
        for (int i = 0; i < inputNum; i++) {
            var inputUsername = sc.nextLine();
                usernames.add(inputUsername);
        }

        for (String username : usernames) {
            System.out.println(username);
        }
    }
}
