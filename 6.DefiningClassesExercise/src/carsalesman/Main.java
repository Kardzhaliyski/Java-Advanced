package carsalesman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in))) {
            Map<String, Engine> engines = new HashMap<>();

            var engineCount = Integer.parseInt(bfr.readLine());
            for (int i = 0; i < engineCount; i++) {
                var tokens = bfr.readLine().split("\\s+");
                Engine engine = new Engine(tokens);
                engines.putIfAbsent(engine.getModel(), engine);
            }

            List<Car> cars = new ArrayList<>();
            var carCount = Integer.parseInt(bfr.readLine());
            for (int i = 0; i < carCount; i++) {
                var tokens = bfr.readLine().split("\\s+");
                Engine currEngine = engines.get(tokens[1]);
                Car tempCar = new Car(tokens, currEngine);
                cars.add(tempCar);
            }

            cars.forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
