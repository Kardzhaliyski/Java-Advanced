package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SortEvenNumbers {
    public static void main(String[] args) {
        try (BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in))){

            int[] numbersArr = Arrays.stream(bfr.readLine().split(", "))
                    .mapToInt(Integer::parseInt)
                    .filter(n -> n % 2 == 0)
                    .toArray();
            printArray(numbersArr);
            numbersArr = Arrays.stream(numbersArr)
                    .sorted()
                    .toArray();
            printArray(numbersArr);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    private static void printArray(int[] numbersArr) {
        System.out.println(concatenateArrayToString2(numbersArr));
    }

//
//    private static String concatenateArrayToString(int[] numbersArr) {
//        StringBuilder resultString = new StringBuilder();
//        if (numbersArr.length == 0) {
//            return "";
//        }
//
//        resultString.append(numbersArr[0]);
//        for (int i = 1; i < numbersArr.length; i++) {
//            resultString.append(", ").append(numbersArr[i]);
//        }
//
//        return resultString.toString();
//    }

    private static String concatenateArrayToString2(int[] numbersArr) {
        String[] stringArr = Arrays.stream(numbersArr).mapToObj(String::valueOf).toArray(String[]::new);
        return String.join(", " , stringArr);
    }
}
