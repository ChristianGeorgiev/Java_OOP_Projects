package ex2;

public class Figure {
    private double length;
    private double width;
    private double height;

    public Figure(double length, double width, double height) {
        this.setLength(length);
        this.setWidth(width);
        this.setHeight(height);
    }

    private void setLength(double length) {
        if (length <= 0){
            throw new IllegalArgumentException("Length cannot be zero or negative.");
        }
        this.length = length;
    }

    private void setWidth(double width) {
        if (width <= 0){
            throw new IllegalArgumentException("Width cannot be zero or negative.");
        }
        this.width = width;
    }

    private void setHeight(double height) {
        if (height <= 0){
            throw new IllegalArgumentException("Height cannot be zero or negative.");
        }
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
