package genericbox;


import genericclasses.GenericBox;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in))) {

            var count = Integer.parseInt(bfr.readLine());
            var box = new GenericBox<String>();
            for (int i = 0; i < count; i++) {
                box.setElement(bfr.readLine());
                System.out.println(box);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
