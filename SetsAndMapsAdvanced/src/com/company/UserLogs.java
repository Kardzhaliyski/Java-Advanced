package com.company;

import java.util.*;

public class UserLogs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        var logs = new TreeMap<String, LinkedHashMap<String, Integer>>();

        var input = "";

        while (!"end".equalsIgnoreCase(input = sc.nextLine())) {
            var rawData = input.split("\\s+");
            var iP = rawData[0].split("=")[1];
            var username = rawData[2].split("=")[1];
            logs.putIfAbsent(username, new LinkedHashMap<>());
            logs.get(username).putIfAbsent(iP, 0);
            logs.get(username)
                    .put(iP, logs.get(username).get(iP) + 1);
        }

        for (Map.Entry<String, LinkedHashMap<String, Integer>> user : logs.entrySet()) {
            System.out.println(user.getKey() + ": ");
            for (Iterator<Map.Entry<String, Integer>> iterator = user.getValue().entrySet().iterator(); iterator.hasNext(); ) {
                Map.Entry<String, Integer> iP = iterator.next();
                if(iterator.hasNext()) {
                    System.out.print(iP.getKey() + " => " + iP.getValue() + ", ");
                } else {
                    System.out.println(iP.getKey() + " => " + iP.getValue() + ".");
                }
            }
        }
    }
}
