package ex5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        String[] input = console.readLine().split("\\s+");
        Pizza pizza = null;
        while (!"END".equals(input[0])){
            switch (input[0]){
                case "Pizza":
                    try {
                        pizza = new Pizza(input[1], Integer.valueOf(input[2]));
                    }catch (IllegalArgumentException ex){
                        System.out.println(ex.getMessage());
                        return;
                    }
                    break;
                case "Dough":
                    try {
                        Dough dough = new Dough(input[1], input[2], Integer.valueOf(input[3]));
                        if (pizza != null) {
                            pizza.setDough(dough);
                        }else {
                            System.out.println(String.format("%.2f", dough.calcCalories()));
                        }
                    }catch (IllegalArgumentException ex){
                        System.out.println(ex.getMessage());
                        return;
                    }
                    break;

                case "Topping":
                    if (pizza != null){
                    for (int i = 0; i < pizza.getToppingCount(); i++) {
                        try {
                            Topping topping = new Topping(input[1], Integer.valueOf(input[2]));
                            if (pizza != null) {
                                pizza.addTopping(topping);
                            } else {
                                System.out.println(String.format("%.2f", topping.calcCalories()));
                            }
                        } catch (IllegalArgumentException ex) {
                            System.out.println(ex.getMessage());
                            return;
                        }
                        input = console.readLine().split("\\s+");
                        if (input[0].equals("END")) {
                            System.out.println(pizza);
                            return;
                        }
                    }
                    }else {
                        try {
                            Topping topping = new Topping(input[1], Integer.valueOf(input[2]));
                            System.out.println(String.format("%.2f", topping.calcCalories()));
                        }catch (IllegalArgumentException ex){
                            System.out.println(ex.getMessage());
                        }
                    }
                    break;
                    default:break;
            }

            input = console.readLine().split("\\s+");
        }
        if (pizza != null) {
            System.out.println(pizza);
        }
    }
}
