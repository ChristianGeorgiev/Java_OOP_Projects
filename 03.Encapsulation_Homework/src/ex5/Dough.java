package ex5;

public class Dough {
    private String flourType;
    private String bakingTechnique;
    private int weight;

    private double flourModifier;
    private double bakingModifier;

    public Dough(String flourType, String bakingTechnique, int weight){
        this.setFlourType(flourType);
        this.setBakingTechnique(bakingTechnique);
        this.setWeight(weight);

        this.flourModifier = calcModifier(this.flourType);
        this.bakingModifier = calcModifier(this.bakingTechnique);
    }


    private void setFlourType(String flourType) {
        String lower = flourType.toLowerCase();
        if (lower.equals("white") || lower.equals("wholegrain")) {
            this.flourType = flourType;
        }else {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
    }

    private void setBakingTechnique(String bakingTechnique) {
        String lower = bakingTechnique.toLowerCase();
        if (lower.equals("chewy")
                || lower.equals("crispy")
                || lower.equals("homemade")) {
            this.bakingTechnique = bakingTechnique;
        }else {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
    }

    private void setWeight(int weight) {
        if (weight < 1 || weight > 200){
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
        this.weight = weight;
    }


    private double calcModifier(String type) {
        switch (type.toLowerCase()){
            case "white":
                return 1.5;
            case "wholegrain":
                return 1.0;
            case "crispy":
                return 0.9;
            case "chewy":
                return 1.1;
            case "homemade":
                return 1.0;
            default: return 0;
        }
    }

    public double calcCalories(){
        return (2*this.weight) * bakingModifier * flourModifier;
    }
}
