package speedracing;

public class Car {
    public String model;
    public double fuelAmount;
    public double fuelCostPer1Km;
    public int distanceTraveled;

    public Car(String model, double fuelAmount, double fuelCostPer1Km) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCostPer1Km = fuelCostPer1Km;
    }

    public Car(String model, String fuelAmount, String fuelCostPer1Km) {
        this.model = model;
        this.fuelAmount = Double.parseDouble(fuelAmount);
        this.fuelCostPer1Km = Double.parseDouble(fuelCostPer1Km);
    }

    public void drive(int distance) {
        var fuelCost = distance * this.fuelCostPer1Km;
        if(this.fuelAmount >= fuelCost) {
            this.fuelAmount -= fuelCost;
            this.distanceTraveled += distance;
        } else {
            System.out.println("Insufficient fuel for the drive");
        }
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %d",
                this.model, this.fuelAmount, this.distanceTraveled);
    }
}
