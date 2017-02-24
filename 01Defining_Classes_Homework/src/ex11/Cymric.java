package ex11;

public class Cymric extends Cat {

    private Double furLength;

    public Cymric(String name, Double furLength) {
        super(name);
        this.furLength = furLength;
    }

    public Double getFurLength() {
        return this.furLength;
    }

    public void setFurLength(Double furLength) {
        this.furLength = furLength;
    }

    @Override
    public String toString(){
        return "Cymric " + super.getName() + " " + String.format("%.2f%n", this.getFurLength());
    }
}
