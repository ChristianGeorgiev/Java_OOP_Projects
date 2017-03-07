package ex2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        Vehicle car = null;
        Vehicle truck = null;
        Bus bus = null;

        String[] carInfo = console.readLine().split("\\s+");
        String[] truckInfo = console.readLine().split("\\s+");
        String[] busInfo = console.readLine().split("\\s+");

        try{
            car = new Car(Double.valueOf(carInfo[1]),
                    Double.valueOf(carInfo[2]),Double.valueOf(carInfo[3]));
        }catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }
        try{
            truck = new Truck(Double.valueOf(truckInfo[1]),
                    Double.valueOf(truckInfo[2]), Double.valueOf(carInfo[3]));
        }catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }
        try{
            bus = new Bus(Double.valueOf(busInfo[1]),
                    Double.valueOf(busInfo[2]),Double.valueOf(busInfo[3]));
        }catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }





        int n = Integer.valueOf(console.readLine());
        for (int i = 0; i < n; i++) {
            String[] commandArgs = console.readLine().split("\\s+");

            switch (commandArgs[0]){
                case "Drive":
                    if (commandArgs[1].equals("Car")){
                        System.out.println(car.drive(Double.valueOf(commandArgs[2])));
                    }else if (commandArgs[1].equals("Truck")) {
                        System.out.println(truck.drive(Double.valueOf(commandArgs[2])));
                    }else {
                        System.out.println(bus.drive(Double.valueOf(commandArgs[2])));
                    }
                    break;
                case "DriveEmpty":
                    System.out.println(bus.driveEmpty(Double.valueOf(commandArgs[2])));
                    break;
                case "Refuel":
                    try {
                        if (commandArgs[1].equals("Car")) {
                            car.refuel(Double.valueOf(commandArgs[2]));
                        } else if (commandArgs[1].equals("Truck")){
                            truck.refuel(Double.valueOf(commandArgs[2]));
                        }else {
                            bus.refuel(Double.valueOf(commandArgs[2]));
                        }
                    }catch (IllegalArgumentException ex){
                        System.out.println(ex.getMessage());
                    }
                    break;
            }
        }

        System.out.println(car);
        System.out.println(truck);
        System.out.println(bus);

    }
}
