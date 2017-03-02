package ex4;

import java.util.ArrayList;
import java.util.List;

public class Gandalf {
    private String mood;
    private int happinessPoints;
    private List<Food> foodEaten;

    public Gandalf(){
        this.foodEaten = new ArrayList<>();
        this.happinessPoints = 0;
    }

    public void eat(Food food){
        this.foodEaten.add(food);
    }

    public void calculateMood(){
        if (this.foodEaten.size() > 0) {
            for (Food food : foodEaten) {
                this.happinessPoints += food.getHappinessPoints();
            }
        }

        if (this.happinessPoints < -5){
            this.mood = "Angry";
        }else if (this.happinessPoints < 0){
            this.mood = "Sad";
        }else if (this.happinessPoints < 15){
            this.mood = "Happy";
        }else {
            this.mood = "JavaScript";
        }
    }

    @Override
    public String toString() {
        return String.format("%d%n%s%n", this.happinessPoints, this.mood);
    }
}
