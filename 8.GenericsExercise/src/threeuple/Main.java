package threeuple;

import genericclasses.Threeuple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in))) {
            var input = bfr.readLine().split("\\s+");
            var threeuple1 = new Threeuple<String, String, String>(
                    input[0] + " " + input[1],
                    input[2],
                    input[3]
            );
            System.out.println(threeuple1);

            input = bfr.readLine().split("\\s+");
            var threeuple2 = new Threeuple<String, Integer, Boolean>();
            threeuple2.setItem1(input[0]);
            threeuple2.setItem2(Integer.parseInt(input[1]));
            threeuple2.setItem3(input[2].equalsIgnoreCase("drunk"));

            System.out.println(threeuple2);


            input = bfr.readLine().split("\\s+");
            var threeuple3 = new Threeuple<String, Double, String>(
                    input[0],
                    Double.parseDouble(input[1]),
                    input[2]
            );
            System.out.println(threeuple3);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
