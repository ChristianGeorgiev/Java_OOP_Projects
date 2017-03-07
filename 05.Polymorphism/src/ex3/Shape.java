package ex3;

public abstract class Shape {
    private double perimeter;
    private double area;

    private double getPerimeter() {
        return this.perimeter;
    }

    private void setPerimeter(double perimeter) {
        this.perimeter = perimeter;
    }

    private double getArea() {
        return this.area;
    }

    private void setArea(double area) {
        this.area = area;
    }

    protected abstract double calculateArea();
    protected abstract double calculatePerimeter();
}
