package stackiterator;

import classes.CustomStack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in))) {
            var stack = new CustomStack<Integer>();

            var inputCommand = bfr.readLine().split("\\s+", 2);
            while (!inputCommand[0].equals("END")) {

                switch (inputCommand[0]) {
                    case "Push":{
                        var elements = Arrays.stream(inputCommand[1].split(", "))
                                .map(String::trim)
                                .map(Integer::parseInt)
                                .toArray(Integer[]::new);
                        stack.push(elements);
                        break;
                    }
                    case "Pop": {
                        stack.pop();
                        break;
                    }
                }

                inputCommand = bfr.readLine().split("\\s+", 2);
            }

            for (Integer integer : stack) {
                System.out.println(integer);
            }

            for (Integer integer : stack) {
                System.out.println(integer);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
