package ex3;

public class Circle extends Shape {
    private double radius;

    private final double getRadius() {
        return this.radius;
    }

    private void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    protected double calculateArea() {
        return Math.PI * Math.pow(this.radius, 2);
    }

    @Override
    protected double calculatePerimeter() {
        return 2 * Math.PI * this.radius;
    }
}
