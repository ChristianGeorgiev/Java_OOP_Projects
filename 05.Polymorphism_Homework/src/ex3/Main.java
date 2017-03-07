package ex3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        int lineCount = 0;
        while (true){
            String[] inputAnimal = console.readLine().split("\\s+");
            if (inputAnimal[0].equals("End")){ break; }
            String[] inputFood = console.readLine().split("\\s+");
            if (inputFood[0].equals("End")){ break; }

            Mammal animal = null;
            Food food = null;


                switch (inputAnimal[0]){
                    case "Cat":
                        animal = new Cat(inputAnimal[0], inputAnimal[1],
                                Double.valueOf(inputAnimal[2]), inputAnimal[3], inputAnimal[4]);
                        break;
                    case "Tiger":
                        animal = new Tiger(inputAnimal[0], inputAnimal[1],
                            Double.valueOf(inputAnimal[2]), inputAnimal[3]);
                        break;
                    case "Zebra":
                        animal = new Zebra(inputAnimal[0], inputAnimal[1],
                                Double.valueOf(inputAnimal[2]), inputAnimal[3]);
                        break;
                    case "Mouse":
                        animal = new Mouse(inputAnimal[0], inputAnimal[1],
                                Double.valueOf(inputAnimal[2]), inputAnimal[3]);
                        break;
                }

                switch (inputFood[0]){
                    case "Meat":
                        food = new Meat(inputFood[0], Integer.valueOf(inputFood[1]));
                        break;
                    case "Vegetable":
                        food = new Vegetable(inputFood[0], Integer.valueOf(inputFood[1]));
                        break;
                }
                System.out.println(animal.makeSound());
                try {
                    animal.eat(food);
                }catch (IllegalArgumentException ex){
                    System.out.println(ex.getMessage());
                }
            System.out.println(animal.toString());
        }
    }
}
