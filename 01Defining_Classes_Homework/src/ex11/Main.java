package ex11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        LinkedHashMap<String, Cat> cats = new LinkedHashMap<>();

        String[] input = console.readLine().split("\\s+");
        while (!"End".equals(input[0])){
            Cat cat = null;

            switch (input[0]){
                case "Siamese":
                    cat = new Siamese(input[1], Double.valueOf(input[2]));
                    cats.putIfAbsent(input[1], cat);
                    break;
                case "Cymric":
                    cat = new Cymric(input[1], Double.valueOf(input[2]));
                    cats.putIfAbsent(input[1], cat);
                    break;
                case "StreetExtraordinaire":
                    cat = new StreetExtraordinaire(input[1], Double.valueOf(input[2]));
                    cats.putIfAbsent(input[1], cat);
                    break;
                default:
                    break;
            }
            input = console.readLine().split("\\s+");
        }

        String catName = console.readLine();
        if (cats.containsKey(catName)){
            System.out.println(cats.get(catName).toString());
        }
    }
}
