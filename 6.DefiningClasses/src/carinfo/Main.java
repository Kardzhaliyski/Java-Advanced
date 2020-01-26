package carinfo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        try (BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in))) {
            int inputCarsLimit = Integer.parseInt(bfr.readLine());
            List<Car> cars = new ArrayList<>();

            for (int i = 0; i < inputCarsLimit; i++) {
                var carData = bfr.readLine().split("\\s+");

                Car car;
                var carMake = carData[0];

                if(carData.length == 1) {
                    car = new Car(carMake);
                } else {
                    var carModel = carData[1];
                    var carHorsePower = carData[2];

                    car = new Car(
                            carMake,
                            carModel,
                            Integer.parseInt(carHorsePower));

                }

                cars.add(car);
            }

            for (Car car : cars) {
                System.out.println(car.getInfo());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
