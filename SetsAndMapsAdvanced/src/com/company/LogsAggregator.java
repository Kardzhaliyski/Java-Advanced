package com.company;

import java.util.*;
import java.util.stream.Collectors;

public class LogsAggregator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int logsToRead = Integer.parseInt(sc.nextLine());
        var usersTotalTime = new TreeMap<String, Integer>();
        var usersIps = new HashMap<String, Set<String>>();

        for (int i = 0; i < logsToRead; i++) {
            var logData = sc.nextLine().split("\\s+");
            var ip = logData[0];
            var username = logData[1];
            var duration = Integer.parseInt(logData[2]);

            usersTotalTime.putIfAbsent(username, 0);
            usersTotalTime.put(username, usersTotalTime.get(username) + duration);

            usersIps.putIfAbsent(username, new TreeSet<>());
            usersIps.get(username).add(ip);
        }

        for (Map.Entry<String, Integer> userTimeKvP : usersTotalTime.entrySet()) {
            var username = userTimeKvP.getKey();
            var totalDuration = userTimeKvP.getValue();
            System.out.println(String.format("%s: %d [%s]",
                    username,
                    totalDuration,
                    String.join(", ", usersIps.get(username))));
        }

    }
}
