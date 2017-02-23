package ex5;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.valueOf(console.readLine());
        LinkedHashMap<String, Car> cars = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] input = console.readLine().split("\\s+");
            Car car = new Car(input[0], Double.valueOf(input[1]), Double.valueOf(input[2]));
            cars.putIfAbsent(input[0], car);
        }

        String command = console.readLine();
        while (!"End".equals(command)){
            String model = command.split("\\s+")[1];
            int kilometers = Integer.valueOf(command.split("\\s+")[2]);
            cars.get(model).drive(kilometers);
            command = console.readLine();
        }

        for (String s : cars.keySet()) {
            System.out.println(cars.get(s).toString());
        }

    }
}
