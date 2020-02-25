package carsalesman;

public class Engine {
    String model;
    String power;
    String displacement = "n/a";
    String efficiency = "n/a";


    public Engine(String[] tokens) {
        this.model = tokens[0];
        this.power = tokens[1];
        if(tokens.length == 3) {
            if(Character.isDigit(tokens[2].charAt(0))) {
                this.displacement = tokens[2];
            } else {
                this.efficiency = tokens[2];
            }
        } else if (tokens.length == 4) {
            if(Character.isDigit(tokens[2].charAt(0))) {
                this.displacement = tokens[2];
                this.efficiency = tokens[3];
            } else {
                this.displacement = tokens[3];
                this.efficiency = tokens[2];
            }
        }
    }

    public String getModel() {
        return model;
    }

    @Override
    public String toString() {
        return this.model + ":" + System.lineSeparator() +
                "Power: " + this.power + System.lineSeparator() +
                "Displacement: " + this.displacement + System.lineSeparator() +
                "Efficiency: " + this.efficiency;
    }
}
