package datingapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in))) {

            var males = Arrays.stream(bfr.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            var females = Arrays.stream(bfr.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            ArrayDeque<Integer> maleStack = new ArrayDeque<>();
            for (int male : males) {
                maleStack.push(male);
            }

            ArrayDeque<Integer> femaleStack = new ArrayDeque<>();
            for (int i = females.length - 1; i >= 0; i--) {
                femaleStack.push(females[i]);
            }

            var matchCount = 0;

            while (!maleStack.isEmpty() && !femaleStack.isEmpty()) {

                var male = getNext(maleStack);
                if(male == null) {
                    break;
                }

                var female = getNext(femaleStack);
                if(female == null) {
                    maleStack.push(male);
                    break;
                }

                if(male == female) {
                    matchCount++;
                } else {
                    male -= 2;
                    maleStack.push(male);
                }
            }

            System.out.println("Matches: " + matchCount);
            System.out.println("Males left: " + joinStack(maleStack));
            System.out.println("Females left: " + joinStack(femaleStack));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String joinStack(ArrayDeque<Integer> maleStack) {
        if(maleStack.isEmpty()) {
            return "none";
        }

        return maleStack.stream()
                .map(s -> s.toString())
                .collect(Collectors.joining(", "));
    }

    private static Integer getNext(ArrayDeque<Integer> stack) {
        if(stack.isEmpty()) {
            return null;
        }

        Integer currentNum = stack.pop();

        while (currentNum % 25 == 0 || currentNum <= 0) {
            if(currentNum <= 0) {
                if(!stack.isEmpty()) {
                    currentNum = stack.pop();
                } else {
                    return null;
                }
            } else {
                if (stack.size() >= 2) {
                    stack.pop();
                    currentNum = stack.pop();
                } else if (stack.size() == 1) {
                    stack.pop();
                    return null;
                } else {
                    return null;
                }
            }
        }

        return currentNum;
    }
}
