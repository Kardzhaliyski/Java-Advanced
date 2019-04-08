import java.util.ArrayDeque;
import java.util.Scanner;

public class DecimalToBinaryConverter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayDeque<Integer> number = new ArrayDeque<>();
        var num = Integer.parseInt(sc.nextLine());

        if(num == 0){
            System.out.println(0);
            return;
        }

        while(num > 0){
            var leftOver = num % 2;
            num /= 2;
            number.push(leftOver);
        }

        for (Integer curNum : number) {
            System.out.print(curNum);
        }

    }
}
