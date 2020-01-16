package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Function;

public class AppliedArithmetic {
    public static void main(String[] args) {
        try (BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in))) {
            var numbers = Arrays.stream(bfr.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            var command = "";
            while (!(command = bfr.readLine()).equalsIgnoreCase("end")) {
                if(command.equalsIgnoreCase("print")) {
                    for (int num : numbers) {
                        System.out.print(num + " ");
                    }
                    System.out.println();

                } else {
                    mathOperations(command, numbers);
                }
            }



        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void mathOperations(String command, int[] numbers) {
        Function<int[], int[]> function = arr -> {
            for (int i = 0; i < arr.length; i++) {
                if (command.equalsIgnoreCase("add")) {
                    arr[i]++;
                } else if (command.equalsIgnoreCase("subtract")) {
                    arr[i]--;
                } else if (command.equalsIgnoreCase("multiply")) {
                    arr[i] *= 2;
                }
            }

            return arr;
        };

        function.apply(numbers);
    }
}
