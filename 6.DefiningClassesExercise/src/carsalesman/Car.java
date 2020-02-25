package carsalesman;


public class Car {
    String model;
    Engine engine;
    String weight = "n/a";
    String color = "n/a";


    public Car(String[] tokens, Engine engine) {
        this.model = tokens[0];
        this.engine = engine;
        if (tokens.length == 3) {
            if (Character.isDigit(tokens[2].charAt(0))) {
                this.weight = tokens[2];
            } else {
                this.color = tokens[2];
            }
        } else if (tokens.length == 4) {
            if (Character.isDigit(tokens[2].charAt(0))) {
                this.weight = tokens[2];
                this.color = tokens[3];
            } else {
                this.weight = tokens[3];
                this.color = tokens[2];
            }
        }
    }

    @Override
    public String toString () {
        return this.model + ":" + System.lineSeparator() +
                this.engine.toString() + System.lineSeparator() +
                "Weight: " + this.weight + System.lineSeparator() +
                "Color: " + this.color;
    }

    public String getModel() {
        return this.model;
    }
}
