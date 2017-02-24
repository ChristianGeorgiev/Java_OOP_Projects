package ex8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        LinkedHashMap<String, Trainer> trainers = new LinkedHashMap<>();


        String[] input = console.readLine().split("\\s+");
        while (!"Tournament".equals(input[0])){
            String trainerName = input[0];
            trainers.putIfAbsent(trainerName, new Trainer(trainerName));

            Pokemon pokemon = new Pokemon(input[1], input[2], Integer.valueOf(input[3]));
            trainers.get(trainerName).addPokemon(pokemon);

            input = console.readLine().split("\\s+");
        }

        String inputElement = console.readLine();
        while (!"End".equals(inputElement)){
            for (String s : trainers.keySet()) {
                trainers.get(s).elementarize(inputElement);
            }

            inputElement = console.readLine();
        }

        trainers.values().stream()
                .sorted((x, y) -> Integer.compare(y.getBadgesCount(), x.getBadgesCount()))
                .forEach(x -> System.out.printf("%s %d %d%n", x.getName(), x.getBadgesCount(), x.getPokemons().size()));

//        for (String s : trainers.keySet()) {
//            System.out.printf("%s %d %d%n",
//                    trainers.get(s).getName(),
//                    trainers.get(s).getBadgesCount(),
//                    trainers.get(s).getPokemons().size());
//        }

    }
}
