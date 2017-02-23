package ex6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.valueOf(console.readLine());
        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] input = console.readLine().split("\\s+");

            String model = input[0];
            Engine engine = new Engine(Integer.valueOf(input[1]), Integer.valueOf(input[2]));
            Cargo cargo = new Cargo(Integer.valueOf(input[3]), input[4]);

            HashSet<Tire> tires = new HashSet<>();
            tires.add(new Tire(Double.valueOf(input[5]), Integer.valueOf(input[6])));
            tires.add(new Tire(Double.valueOf(input[7]), Integer.valueOf(input[8])));
            tires.add(new Tire(Double.valueOf(input[9]), Integer.valueOf(input[10])));
            tires.add(new Tire(Double.valueOf(input[11]), Integer.valueOf(input[12])));

            cars.add(new Car(model, engine, cargo, tires));
        }

        String command = console.readLine();

        switch (command){
            case "fragile":
                    printFragile(cars);
                break;
            case "flamable":
                    printFlamable(cars);
                break;
        }
    }

    private static void printFlamable(List<Car> cars) {
        for (Car car : cars) {
            if (car.getCargo().getType().equals("flamable") && car.getEngine().getEnginePower() > 250){
                System.out.println(car);
            }
        }
    }

    private static void printFragile(List<Car> cars) {
        for (Car car : cars) {
            if (car.getCargo().getType().equals("fragile") && car.tirePressureLessThanOne()){
                System.out.println(car);
            }
        }
    }
}
