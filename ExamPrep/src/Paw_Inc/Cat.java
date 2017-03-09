package Paw_Inc;

public class Cat extends Animal {
    private int intelligenceCoef;

    protected Cat(String name, int age, int intelligenceCoef) {
        super(name, age);
        this.setIntelligenceCoef(intelligenceCoef);
    }

    private void setIntelligenceCoef(int intelligenceCoef){
        this.intelligenceCoef = intelligenceCoef;
    }
}
