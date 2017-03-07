package ex3;


public class Tiger extends Feline {

    public Tiger(String animalType, String animalName, double animalWeight, String livingRegion) {
        super(animalType, animalName, animalWeight, livingRegion);
    }

    @Override
    protected String makeSound() {
        return "ROAAR!!!";
    }

    @Override
    protected void eat(Food food) {
        if (food.getType().equals("Meat")){
            super.setFoodEaten(super.getFoodEaten() + food.getQuantity());
        }else {
            throw new IllegalArgumentException("Tigers are not eating that type of food!");
        }
    }
}
