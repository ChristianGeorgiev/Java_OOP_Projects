package ex4;

public class Food {
    private String name;
    private int happinessPoints;

    public Food(String name){
        this.setName(name);
        this.setHappinessPoints(name);
    }

    private void setName(String name) {
        this.name = name;
    }

    public int getHappinessPoints(){
        return this.happinessPoints;
    }
    private void setHappinessPoints(String name) {
        int points;
        switch (name.toLowerCase()){
            case "cram":
                points = 2;
                break;
            case "lembas":
                points = 3;
                break;
            case "apple":
                points = 1;
                break;
            case "melon":
                points = 1;
                break;
            case "honeycake":
                points = 5;
                break;
            case "mushrooms":
                points = -10;
                break;
            default: points = -1; break;
        }
        this.happinessPoints = points;
    }
}
