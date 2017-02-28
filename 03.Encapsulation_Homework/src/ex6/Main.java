package ex6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, Team> teams = new HashMap<>();

        String[] input = console.readLine().split(";");
        while (!"END".equals(input[0])){

            switch (input[0]){
                case "Team":
                    try {
                    Team team = new Team(input[1]);
                    teams.put(team.getName(), team);
                    }catch (IllegalArgumentException ex){
                        System.out.println(ex.getMessage());
                    }
                    break;
                case "Add":
                    if (teams.containsKey(input[1])){
                        try {
                            Player player = new Player(input[2],
                                    Integer.valueOf(input[3]),
                                    Integer.valueOf(input[4]),
                                    Integer.valueOf(input[5]),
                                    Integer.valueOf(input[6]),
                                    Integer.valueOf(input[7]));
                            teams.get(input[1]).addPlayer(player);
                        }catch (IllegalArgumentException ex){
                            System.out.println(ex.getMessage());
                        }
                    }else {
                        System.out.printf("Team %s does not exist.%n", input[1]);
                    }
                    break;
                case "Remove":
                    if (teams.containsKey(input[1])) {
                        try {
                            teams.get(input[1]).removePlayer(input[2]);
                        } catch (IllegalArgumentException ex) {
                            System.out.println(ex.getMessage());
                        }
                    }else {
                        System.out.printf("Team %s does not exist.%n", input[1]);
                    }
                    break;
                case "Rating":
                    if (teams.containsKey(input[1])){
                        System.out.printf("%s - %.0f", input[1], teams.get(input[1]).calcRating());
                    }else {
                        System.out.printf("Team %s does not exist.%n", input[1]);
                    }

            }

            input = console.readLine().split(";");
        }
    }




}
