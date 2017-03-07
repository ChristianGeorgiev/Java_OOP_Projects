package ex3;


public class Zebra extends Mammal{
    public Zebra(String animalType, String animalName, double animalWeight, String livingRegion) {
        super(animalType, animalName, animalWeight, livingRegion);
    }

    @Override
    protected String makeSound() {
        return "Zs";
    }

    @Override
    protected void eat(Food food) {
        if (food.getType().equals("Vegetable")){
            super.setFoodEaten(super.getFoodEaten() + food.getQuantity());
        }else {
            throw new IllegalArgumentException("Zebras are not eating that type of food!");
        }
    }

}
