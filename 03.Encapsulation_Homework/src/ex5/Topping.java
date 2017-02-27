package ex5;

public class Topping {
    private String toppingType;
    private int weight;
    private double modifier;

    public Topping(String toppingType, int weight){
        this.setToppingType(toppingType);
        this.setWeight(weight);
        calcModifier(toppingType);
    }

    private void setToppingType(String toppingType){
        String lower = toppingType.toLowerCase();
        if (lower.equals("meat") || lower.equals("veggies")
                || lower.equals("cheese") || lower.equals("sauce")) {
            this.toppingType = toppingType;
        }else {
            throw new IllegalArgumentException("Cannot place " + toppingType +" on top of your pizza.");
        }
    }

    private void setWeight(int weight){
        if (weight >= 1 && weight <= 50){
            this.weight = weight;
        }else {
            throw new IllegalArgumentException(this.toppingType + " weight should be in the range [1..50].");
        }
    }

    private void calcModifier(String toppingType){
        switch (toppingType.toLowerCase()){
            case "meat":
                this.modifier = 1.2;
                break;
            case "veggies":
                this.modifier = 0.8;
                break;
            case "cheese":
                this.modifier = 1.1;
                break;
            case "sauce":
                this.modifier = 0.9;
                break;
                default:break;
        }
    }

    public double calcCalories(){
        return this.weight * 2 * this.modifier;
    }
}
