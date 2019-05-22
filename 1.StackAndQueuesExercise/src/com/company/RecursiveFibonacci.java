package com.company;

        import java.util.ArrayDeque;
        import java.util.ArrayList;
        import java.util.Scanner;

public class RecursiveFibonacci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        var wantedNumberIndex = Integer.parseInt(sc.nextLine());
        var fibNums = new Long[wantedNumberIndex + 1];
        fibNums[0] = 1L;
        fibNums[1] = 1L;

        System.out.println(findFibNum(fibNums, wantedNumberIndex));

    }

    private static long findFibNum(Long[] fibNums, int wantedNumberIndex) {
        if(fibNums[wantedNumberIndex] != null) {
            return fibNums[wantedNumberIndex];
        }

        fibNums[wantedNumberIndex] = findFibNum(fibNums, wantedNumberIndex -1) + findFibNum(fibNums, wantedNumberIndex -2);
        return fibNums[wantedNumberIndex];
    }
}
