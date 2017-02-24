package ex3;

public class Chicken {
    private final int MIN_AGE = 0;
    private final int MAX_AGE = 15;

    private String name;
    private int age;

    public Chicken(String name, int age) {
        this.setName(name);
        this.setAge(age);
    }

    private void setName(String name) {
        if (name.isEmpty() || name.trim().length() == 0) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        this.name = name;
    }

    private void setAge(int age) {
        if (age < MIN_AGE || age > MAX_AGE) {
            throw new IllegalArgumentException("Age should be between 0 and 15.");
        }
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    int getAge() {
        return this.age;
    }

    public double getProductPerDay() {
        return this.calculateProductPerDay();
    }

    private double calculateProductPerDay() {
        if (this.getAge() < 6){
            return 2;
        }else if (this.getAge() < 12){
            return 1;
        }else {
            return 0.75;
        }
    }
}
