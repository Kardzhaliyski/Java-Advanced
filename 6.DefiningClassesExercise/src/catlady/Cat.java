package catlady;

public class Cat {
    private String name;
    private double specialParameter;

    public Cat(String name, double specialParameter) {
        this.name = name;
        this.specialParameter = specialParameter;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return String.format("%s %s %.2f",
                this.getClass().getSimpleName(), this.name, this.specialParameter );
    }
}
