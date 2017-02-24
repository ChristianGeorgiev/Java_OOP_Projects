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


    public void setFlourType(String flourType) {
        if (flourType.equals("White") || flourType.equals("Wholegrain")) {
            this.flourType = flourType;
        }else {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
    }

    public void setBakingTechnique(String bakingTechnique) {
        if (bakingTechnique.equals("Chewy")
                || bakingTechnique.equals("Crispy")
                || bakingTechnique.equals("Homemade")) {
            this.bakingTechnique = bakingTechnique;
        }else {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
    }

    public void setWeight(int weight) {
        if (weight < 1 || weight > 200){
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
        this.weight = weight;
    }


    private double calcModifier(String type) {
        switch (type){
            case "White":
                return 1.5;
            case "Wholegrain":
                return 1.0;
            case "Crispy":
                return 0.9;
            case "Chewy":
                return 1.1;
            case "Homemade":
                return 1.0;
            default: return 0;
        }
    }
}
