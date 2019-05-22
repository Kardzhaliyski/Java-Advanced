package com.company;

import java.sql.Array;
import java.util.*;

public class InfixToPostfix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] inputMathExpression = sc.nextLine().split("\\s+");
        Deque<String> outputQueue = new ArrayDeque<>();
        Deque<String> operatorStack = new ArrayDeque<>();
        Map<String, Integer> operators = new HashMap<>();
        operators.put("-", 2);
        operators.put("+", 2);
        operators.put("/", 3);
        operators.put("*", 3);

        for (int i = 0; i < inputMathExpression.length; i++) {
            var currToken = inputMathExpression[i];
            if (currToken.equals("(")) {
                operatorStack.push(currToken);
            } else if (currToken.equals(")")) {
                if (!operatorStack.isEmpty()) {
                    while (!operatorStack.peek().equals("(")) {
                        outputQueue.offer(operatorStack.pop());
                        if (operatorStack.isEmpty()) {
                            break;
                        }
                    }
                }

                if (!operatorStack.isEmpty()) {
                    operatorStack.pop();
                }

            } else if (operators.containsKey(currToken)) {
                if (operatorStack.isEmpty()) {
                    operatorStack.push(currToken);
                } else {
                    if (!operatorStack.peek().equals("(")) {
                        while (operators.get(currToken) <= operators.get(operatorStack.peek())) {
                            outputQueue.offer(operatorStack.pop());
                            if (operatorStack.isEmpty() || operatorStack.peek().equals("(")) {
                                break;
                            }
                        }
                    }
                    operatorStack.push(currToken);
                }
            } else {
                outputQueue.offer(currToken);
            }
        }

        while (!operatorStack.isEmpty()) {
            outputQueue.offer(operatorStack.pop());
        }

        while (!outputQueue.isEmpty()) {
            System.out.print(outputQueue.pop() + " ");
        }
    }
}