package Paw_Inc;

public class Dog extends Animal {
    private int amountOfCommands;

    protected Dog(String name, int age, int amountOfCommands) {
        super(name, age);
        this.setAmountOfCommands(amountOfCommands);
    }

    private void setAmountOfCommands(int amountOfCommands){
        this.amountOfCommands = amountOfCommands;
    }
}
