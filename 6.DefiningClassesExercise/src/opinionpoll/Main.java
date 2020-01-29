package opinionpoll;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in))) {
            var numOfPeople = Integer.parseInt(bfr.readLine());
            List<Person> people = new ArrayList<>();
            for (int i = 0; i < numOfPeople; i++) {
                var personInfo = bfr.readLine().split("\\s+");
                var personName = personInfo[0];
                var personAge = personInfo[1];
                people.add(new Person(personName, personAge));
            }

            people.stream()
                    .filter(p -> p.age > 30)
                    .sorted(Comparator.comparing(f -> f.name))
                    .forEach(s -> System.out.println(s.name + " - " + s.age));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
