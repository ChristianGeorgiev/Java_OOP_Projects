package ex1;

public class Figure {
    private double length;
    private double width;
    private double height;

    public Figure(double length, double width, double height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public double calcSurfaceArea(){
        return 2 * (this.length * this.width)
                + 2 * (this.length * this.height)
                + 2 * (this.width * this.height);
    }

    public double calcLateralSurface(){
        return 2 * (length * height) + 2 * (width * height);
    }

    public double calcVolume(){
        return length * height * width;
    }

    @Override
    public String toString(){
        return String.format("Surface Area - %.2f%nLateral Surface Area - %.2f%nVolume - %.2f%n",
                            this.calcSurfaceArea(), this.calcLateralSurface(), this.calcVolume());
    }
}
