package ex3;

import java.text.DecimalFormat;

public abstract class Mammal extends Animal {
    private String livingRegion;
    protected Mammal(String animalType, String animalName, double animalWeight, String livingRegion) {
        super(animalType, animalName, animalWeight);
        this.setLivingRegion(livingRegion);
    }

    protected String getLivingRegion(){
        return this.livingRegion;
    }

    private void setLivingRegion(String livingRegion){
        this.livingRegion = livingRegion;
    }

    @Override
    public String toString() {
        DecimalFormat decimalFormat = new DecimalFormat("#.############");
        return String.format("%s[%s, %s, %s, %d]", super.getAnimalType(),
                super.getAnimalName(),
                decimalFormat.format(super.getAnimalWeight()),
                this.getLivingRegion(),
                super.getFoodEaten());
    }
}
