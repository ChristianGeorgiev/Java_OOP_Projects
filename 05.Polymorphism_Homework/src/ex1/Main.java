package ex1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        String[] carInfo = console.readLine().split("\\s+");
        String[] truckInfo = console.readLine().split("\\s+");

        Vehicle car = new Car(Double.valueOf(carInfo[1]), Double.valueOf(carInfo[2]));
        Vehicle truck = new Truck(Double.valueOf(truckInfo[1]), Double.valueOf(truckInfo[2]));


        int n = Integer.valueOf(console.readLine());
        for (int i = 0; i < n; i++) {
            String[] commandArgs = console.readLine().split("\\s+");

            switch (commandArgs[0]){
                case "Drive":
                    if (commandArgs[1].equals("Car")){
                        System.out.println(car.drive(Double.valueOf(commandArgs[2])));
                    }else {
                        System.out.println(truck.drive(Double.valueOf(commandArgs[2])));
                    }
                    break;
                case "Refuel":
                    if (commandArgs[1].equals("Car")){
                        car.refuel(Double.valueOf(commandArgs[2]));
                    }else {
                        truck.refuel(Double.valueOf(commandArgs[2]));
                    }
                    break;
            }
        }

        System.out.println(car);
        System.out.println(truck);

    }
}
