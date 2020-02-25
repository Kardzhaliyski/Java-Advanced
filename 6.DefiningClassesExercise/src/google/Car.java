package google;

public class Car {
    private String model;
    private String speed;

    public void setModel(String model) {
        this.model = model;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    @Override
    public String toString() {
        return String.format("%s %s", this.model, this.speed);
    }
}
