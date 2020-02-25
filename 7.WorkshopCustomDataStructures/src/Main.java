import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in))) {
            SmartArray sArr = new SmartArray();
            for (int i = 0; i < 20; i++) {
                sArr.add(i);
            }

            sArr.add(1);
            sArr.add(3);
            sArr.add(15);
            System.out.println(sArr.sum());


//            for (int i = 0; i < sArr.getSize(); i++) {
//                System.out.println(sArr.get(i));
//            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
