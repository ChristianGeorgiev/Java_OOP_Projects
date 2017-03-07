package ex3;

import java.text.DecimalFormat;

public class Cat extends Feline {
    private String breed;

    public Cat(String animalType, String animalName, double animalWeight, String livingRegion, String breed) {
        super(animalType, animalName, animalWeight, livingRegion);
        this.setBreed(breed);
    }

    private String getBreed(){
        return this.breed;
    }

    private void setBreed(String breed){
        this.breed = breed;
    }

    @Override
    protected String makeSound() {
        return "Meowwww";
    }

    @Override
    protected void eat(Food food) {
        super.setFoodEaten(super.getFoodEaten() + food.getQuantity());
    }

    @Override
    public String toString() {
        DecimalFormat decimalFormat = new DecimalFormat("#.############");
        return String.format("%s[%s, %s, %s, %s, %d]", super.getAnimalType(),
                                                        super.getAnimalName(),
                                                        this.getBreed(),
                                                        decimalFormat.format(super.getAnimalWeight()),
                                                        super.getLivingRegion(),
                                                        super.getFoodEaten());
    }
}
