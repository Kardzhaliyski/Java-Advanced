package com.company;

import java.util.*;

public class MathPotato {

    private static ArrayList<Integer> primes = new ArrayList<>(Arrays.asList(2, 3, 5, 7, 11));

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cycle = 1;
        var turnQueue = new ArrayDeque<String>();
        var playersInputArr = sc.nextLine().split("\\s+");
        Collections.addAll(turnQueue, playersInputArr);
        int removePerNTurns = Integer.parseInt(sc.nextLine());
        var output = new StringBuilder();

        while (turnQueue.size() > 1) {
            for (int i = 1; i < removePerNTurns; i++) {
                turnQueue.add(turnQueue.remove());
            }

            if(isPrime(cycle)){
                var stringToPrint = String.format("Prime " + turnQueue.peek() + "%n");
                output.append(stringToPrint);

            } else {
                var stringToPrint = String.format("Removed " + turnQueue.remove() + "%n");
                output.append(stringToPrint);
            }

            cycle++;
        }

        output.append("Last is ");
        output.append(turnQueue.remove());

        System.out.println(output);

    }

     private static boolean isPrime(int num) {
        if(num == 1) {
            return false;
        }
        if (num > primes.get(primes.size() - 1)) {
            getNextPrime();
        }

        return primes.contains(num);
    }

    private static void getNextPrime() {
        var currNum = primes.get(primes.size() -1) +1;

        while (true) {
            if(currNum % 2 == 0) {
                currNum += 1;
                continue;
            }

            for (int i = 0; i < primes.size(); i++) {
                var currPrime = primes.get(i);

                if(currPrime * currPrime > currNum){
                    primes.add(currNum);
                    return;
                }

                if(currNum % currPrime == 0) {
                    currNum += 2;
                    break;
                }
            }
        }
    }
}
