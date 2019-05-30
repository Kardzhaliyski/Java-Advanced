package com.company;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class AMinerTask {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        var resourcesLog = new LinkedHashMap<String, Long>();
        var input = "";
        while (!"stop".equalsIgnoreCase(input = sc.nextLine())) {
            var mineralName = input;
            var mineralQuantity = Integer.parseInt(sc.nextLine());
            resourcesLog.putIfAbsent(mineralName, 0L);
            resourcesLog.put(mineralName, resourcesLog.get(mineralName) + mineralQuantity);
        }

        for (Map.Entry<String, Long> entry : resourcesLog.entrySet()) {
            System.out.printf("%s -> %d%n", entry.getKey(), entry.getValue());
        }
    }
}
