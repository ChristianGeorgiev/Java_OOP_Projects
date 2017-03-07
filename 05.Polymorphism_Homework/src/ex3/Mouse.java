package ex3;

public class Mouse extends Mammal {
    public Mouse(String animalType, String animalName, double animalWeight, String livingRegion) {
        super(animalType, animalName, animalWeight, livingRegion);
    }

    @Override
    protected String makeSound() {
        return "SQUEEEAAAK!";
    }

    @Override
    protected void eat(Food food) {
        if (food.getType().equals("Vegetable")){
            super.setFoodEaten(super.getFoodEaten() + food.getQuantity());
        }else {
            throw new IllegalArgumentException("Mouses are not eating that type of food!");
        }
    }
}
