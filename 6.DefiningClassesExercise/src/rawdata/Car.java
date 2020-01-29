package rawdata;

import java.util.ArrayList;
import java.util.List;

public class Car {
    public String model;
    public Engine engine;
    public Cargo cargo;
    public List<Tire> tires = new ArrayList<>();

    public Car(String[] rawData) {
        //"<Model> <EngineSpeed> <EnginePower> <CargoWeight> <CargoType> <Tire1Pressure> <Tire1Age> <Tire2Pressure> <Tire2Age> <Tire3Pressure> <Tire3Age> <Tire4Pressure> <Tire4Age>"
        this.model = rawData[0];
        this.engine = new Engine(Integer.parseInt(rawData[1]), Integer.parseInt(rawData[2]));
        this.cargo = new Cargo(Integer.parseInt(rawData[3]), rawData[4]);
        this.tires.add(new Tire(Double.parseDouble(rawData[5]), Integer.parseInt(rawData[6])));
        this.tires.add(new Tire(Double.parseDouble(rawData[7]), Integer.parseInt(rawData[8])));
        this.tires.add(new Tire(Double.parseDouble(rawData[9]), Integer.parseInt(rawData[10])));
        this.tires.add(new Tire(Double.parseDouble(rawData[11]), Integer.parseInt(rawData[12])));
    }

    public double getLowestTirePressure() {
        return tires.stream().mapToDouble(t -> t.pressure).min().getAsDouble();
    }
}
