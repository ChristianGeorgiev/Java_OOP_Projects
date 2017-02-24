package ex11;

public class StreetExtraordinaire extends Cat {
    private Double decibelsOfMeows;

    public StreetExtraordinaire(String name, Double decibelsOfMeows) {
        super(name);
        this.decibelsOfMeows = decibelsOfMeows;
    }

    public Double getDecibelsOfMeows() {
        return this.decibelsOfMeows;
    }

    public void setDecibelsOfMeows(Double decibelsOfMeows) {
        this.decibelsOfMeows = decibelsOfMeows;
    }

    @Override
    public String toString(){
        return "StreetExtraordinaire " + super.getName() + " " + String.format("%.0f%n",this.getDecibelsOfMeows());
    }
}
