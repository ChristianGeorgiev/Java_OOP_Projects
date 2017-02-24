package ex9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        LinkedHashMap<String, Person> persons = new LinkedHashMap<>();
        String[] input = console.readLine().split("\\s+");

        while (!"End".equals(input[0])){
            String personName = input[0];
            persons.putIfAbsent(personName, new Person(personName));

            switch (input[1]){
                case "car":
                    Car car = new Car(input[2], input[3]);
                    persons.get(personName).setCar(car);
                    break;
                case "company":
                    Company company = new Company(input[2], input[3], Double.valueOf(input[4]));
                    persons.get(personName).setCompany(company);
                    break;
                case "pokemon":
                    Pokemon pokemon = new Pokemon(input[2], input[3]);
                    persons.get(personName).addPokemon(pokemon);
                    break;
                case "parents":
                    Parent parent = new Parent(input[2], input[3]);
                    persons.get(personName).addParent(parent);
                    break;
                case "children":
                    Child child = new Child(input[2], input[3]);
                    persons.get(personName).addChild(child);
                    break;
                default:
                    break;
            }
            input = console.readLine().split("\\s+");
        }

        String name = console.readLine();
        if (persons.containsKey(name)){
            System.out.println(persons.get(name).toString());
        }
    }
}
