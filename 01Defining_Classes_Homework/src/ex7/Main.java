package ex7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.valueOf(console.readLine());
        HashMap<String, Engine> engines = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] input = console.readLine().split("\\s+");
            Engine engine = null;
            if (input.length == 4){
                engine = new Engine(input[0], input[1], Integer.valueOf(input[2]), input[3]);
            }else if (input.length == 3 && Character.isDigit(input[2].charAt(input[2].length()-1))){
                engine = new Engine(input[0], input[1], Integer.valueOf(input[2]));
            }else if (input.length == 3 && !Character.isDigit(input[2].charAt(input[2].length()-1))){
                engine = new Engine(input[0], input[1], input[2]);
            }else {
                engine = new Engine(input[0], input[1]);
            }

            engines.put(engine.getModel(), engine);
        }

        int m = Integer.valueOf(console.readLine());
        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            String[] input = console.readLine().split("\\s+");
            Car car = null;
            Engine engine = null;
            if (engines.containsKey(input[1])){
                engine = engines.get(input[1]);
            }

            if (input.length == 4){
                car = new Car(input[0], engine, Integer.valueOf(input[2]), input[3]);
            }else if (input.length == 3 && Character.isDigit(input[2].charAt(input[2].length()-1))){
                car = new Car(input[0], engine, Integer.valueOf(input[2]));
            }else if (input.length == 3 && !Character.isDigit(input[2].charAt(input[2].length()-1))){
                car = new Car(input[0], engine, input[2]);
            }else {
                car = new Car(input[0], engine);
            }

            cars.add(car);
        }

        for (Car car : cars) {
            System.out.println(car);
        }
    }
}
