import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Scanner;

public class MatchingBrackets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayDeque<Integer> bracketsIndex = new ArrayDeque<>();
        String text = sc.nextLine();

        for (int i = 0; i < text.length(); i++) {
            char currChar = text.charAt(i);
            if(currChar == '('){
                bracketsIndex.push(i);
            } else if(currChar == ')'){
                System.out.println(text.substring(bracketsIndex.pop(), i + 1));
            }
        }
    }
}
