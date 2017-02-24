package ex11;

public class Siamese extends Cat {
    private Double earSize;

    public Siamese(String name, Double earSize) {
        super(name);
        this.earSize = earSize;
    }

    public Double getEarSize() {
        return this.earSize;
    }

    public void setEarSize(Double earSize) {
        this.earSize = earSize;
    }

    @Override
    public String toString(){
        return "Siamese " + super.getName() + " " + String.format("%.0f%n", this.getEarSize());
    }
}
