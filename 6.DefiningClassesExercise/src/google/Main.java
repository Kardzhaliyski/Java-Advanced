package google;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in))) {
            Map<String,Person> people = new LinkedHashMap<>();

            var tokens = bfr.readLine().split("\\s+");
            while (!tokens[0].equalsIgnoreCase("End")) {
                var personName = tokens[0];
                people.putIfAbsent(personName, new Person(personName));
                people.get(personName).addData(tokens);

                tokens = bfr.readLine().split("\\s+");
            }

            var personToPrint = bfr.readLine();
            people.get(personToPrint).printData();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
