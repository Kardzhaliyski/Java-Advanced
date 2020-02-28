import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in))) {
            LinkedList linkedList = new LinkedList();
            linkedList.addLast(1);
            linkedList.addLast(2);
            linkedList.addLast(3);
            linkedList.addLast(4);

            System.out.println(linkedList.removeAt(0));
            System.out.println(linkedList.removeAt(0));
//            linkedList.forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
