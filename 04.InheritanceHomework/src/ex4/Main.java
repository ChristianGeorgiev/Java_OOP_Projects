package ex4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        Gandalf gandalf = new Gandalf();
        String[] input = console.readLine().split("[,|\\s*]");
        if (input.length == 1 && (input[0].isEmpty() || input[0].trim().length() == 0)){
            gandalf.calculateMood();
            System.out.println(gandalf);
            return;
        }
        for (String s : input) {
            Food food = new Food(s);
            gandalf.eat(food);
        }

        gandalf.calculateMood();
        System.out.println(gandalf);
    }
}
