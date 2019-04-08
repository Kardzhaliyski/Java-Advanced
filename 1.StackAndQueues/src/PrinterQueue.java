import java.util.ArrayDeque;
import java.util.Scanner;

public class PrinterQueue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        ArrayDeque<String> printerQueue = new ArrayDeque<>();

        while (!input.equals("print")){
            if(input.equals("cancel")){
                if(printerQueue.size() >= 1){
                    System.out.println("Canceled " + printerQueue.poll());
                } else {
                    System.out.println("Printer is on standby");
                }
            } else {
                printerQueue.offer(input);
            }

            input = sc.nextLine();
        }

        for (String toPrint : printerQueue) {
            System.out.println(toPrint);
        }
    }
}
