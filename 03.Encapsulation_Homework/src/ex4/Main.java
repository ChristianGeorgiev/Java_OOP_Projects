package ex4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        String[] peopleArr = console.readLine().split(";");
        String[] productsArr = console.readLine().split(";");

        LinkedHashMap<String, Person> people = new LinkedHashMap<>();
        LinkedHashMap<String, Product> products = new LinkedHashMap<>();

        try {

            for (int i = 0; i < peopleArr.length; i++) {
                String name = peopleArr[i].split("=")[0];
                int money = Integer.valueOf(peopleArr[i].split("=")[1]);

                Person person = new Person(name, money);
                people.putIfAbsent(name, person);

            }

            for (int i = 0; i < productsArr.length; i++) {
                String name = productsArr[i].split("=")[0];
                int price = Integer.valueOf(productsArr[i].split("=")[1]);

                Product product = new Product(name, price);
                products.putIfAbsent(name, product);

            }

            String[] command = console.readLine().split("\\s+");

            while (!"END".equals(command[0])) {
                String personName = command[0];
                String productName = command[1];

                if (people.containsKey(personName) && products.containsKey(productName)) {
                    people.get(personName).addProduct(products.get(productName));
                    System.out.println(personName + " bought " + productName);

                }
                command = console.readLine().split("\\s+");
            }
        }catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }

        for (String s : people.keySet()) {
            System.out.println(people.get(s).toString());
        }

    }
}
