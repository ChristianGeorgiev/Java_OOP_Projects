package ex9;

public class Car {
    private String name;
    private String speed;

    public Car(String name, String speed) {
        this.name = name;
        this.speed = speed;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpeed() {
        return this.speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    @Override
    public String toString() {
        return String.format("%s %s%n", this.getName(), this.getSpeed());
    }
}
