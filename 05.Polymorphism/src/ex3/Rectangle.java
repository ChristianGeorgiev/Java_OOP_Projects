package ex3;

public class Rectangle extends Shape {
    private double height;
    private double width;

    private double getHeight() {
        return this.height;
    }

    private void setHeight(double height) {
        this.height = height;
    }

    private double getWidth() {
        return this.width;
    }

    private void setWidth(double width) {
        this.width = width;
    }

    @Override
    protected double calculateArea() {
        return this.height * this.width;
    }

    @Override
    protected double calculatePerimeter() {
        return (this.height * 2) + (this.width * 2);
    }
}
