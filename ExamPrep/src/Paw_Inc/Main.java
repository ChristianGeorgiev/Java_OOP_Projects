package Paw_Inc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.Collator;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        AnimalCenterManager acm = new AnimalCenterManager();

        String[] input = console.readLine().split("\\s\\|\\s");
        while (!"Paw Paw Pawah".equals(input[0])){
            switch (input[0]){
                case "RegisterCleansingCenter":
                        acm.registerCleansingCenter(input[1]);
                        break;
                case "RegisterAdoptionCenter":
                    acm.registerAdoptionCenter(input[1]);
                        break;
                case "RegisterDog":
                        acm.registerDog(input[1], Integer.valueOf(input[2]), Integer.valueOf(input[3]), input[4]);
                        break;
                case "RegisterCat":
                        acm.registerCat(input[1], Integer.valueOf(input[2]), Integer.valueOf(input[3]), input[4]);
                        break;
                case "SendForCleansing":
                        acm.sendForCleansing(input[1], input[2]);
                        break;
                case "Cleanse":
                        acm.cleanse(input[1]);
                        break;
                case "Adopt":
                        acm.adopt(input[1]);
                        break;
                default:break;
            }
            input = console.readLine().split("\\s\\|\\s");
        }

        acm.printStatistics();


    }
}
