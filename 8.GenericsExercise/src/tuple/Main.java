package tuple;

import genericclasses.Tuple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in))) {
            var input = bfr.readLine().split("\\s+");
            Tuple<String, String> tuple1 = new Tuple<String, String>(
                    input[0] + " " + input[1],
                    input[2]);
            System.out.println(tuple1);

            input = bfr.readLine().split("\\s+");
            var tuple2 = new Tuple<String, Integer>(
                    input[0],
                    Integer.parseInt(input[1]));
            System.out.println(tuple2);

            input = bfr.readLine().split("\\s+");
            var tuple3 = new Tuple<Integer, Double>(
                    Integer.parseInt(input[0]),
                    Double.parseDouble(input[1]));
            System.out.println(tuple3);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
