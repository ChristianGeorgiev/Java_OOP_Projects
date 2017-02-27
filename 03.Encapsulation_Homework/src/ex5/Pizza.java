package ex5;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private String name;
    private Dough dough;
    private List<Topping> toppings;
    private int toppingCount;


    public Pizza (String name, int toppingCount){
        this.setName(name);
        this.setToppingCount(toppingCount);
        this.toppings = new ArrayList<>();
    }

    public String getName(){
        return this.name;
    }

    private void setName(String name){
        this.name = name;
    }

    public void setDough(Dough dough){
        this.dough = dough;
    }

    public int getToppingCount(){
        return this.toppingCount;
    }

    private void setToppingCount(int count){
        if (count < 10 && count >= 0) {
            this.toppingCount = count;
        }else {
            throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
        }
    }

    public void addTopping(Topping topping){
        this.toppings.add(topping);
    }

    public double calcCalories(){
        double doughCalories = this.dough.calcCalories();
        double toppingCalories = 0;
        for (Topping topping : toppings) {
            toppingCalories += topping.calcCalories();
        }
        return doughCalories + toppingCalories;
    }

    @Override
    public String toString(){
        return String.format("%s - %.2f%n", this.getName(), this.calcCalories());
    }
}
