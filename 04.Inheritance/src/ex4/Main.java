package ex4;

public class Main {
    public static void main(String[] args) {
        Predator pred = new Predator();
        pred.feedAll(new Food[] {new Food(), new Food()});
        pred.feed(new Food());
    }
}
