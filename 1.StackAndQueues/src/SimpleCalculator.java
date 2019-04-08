import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayDeque<String> numbers = new ArrayDeque<>();
        String[] input = sc.nextLine().split("\\s+");
        Collections.addAll(numbers, input);

        while (numbers.size() > 1) {
            int num1 = Integer.parseInt(numbers.pop());
            String operator = numbers.pop();
            int num2 = Integer.parseInt(numbers.pop());
            int sum = 0;
            if (operator.equals("+")) {
                sum = num1 + num2;
            } else {
                sum = num1 - num2;
            }

            numbers.push(sum + "");
        }

        System.out.println(numbers.peek());
    }
}
