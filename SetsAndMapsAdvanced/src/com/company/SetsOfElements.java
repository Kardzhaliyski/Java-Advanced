package com.company;

import java.util.*;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        var sizes = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        var firstSet = new LinkedHashSet<String>();
        for (int i = 0; i < sizes[0]; i++) {
            firstSet.add(sc.nextLine());
        }

        var secoundSet = new HashSet<String>();
        for (int i = 0; i < sizes[1]; i++) {
            secoundSet.add(sc.nextLine());
        }

        for (String element : firstSet) {
            if(secoundSet.contains(element)) {
                System.out.print(element + " ");
            }
        }
    }
}
