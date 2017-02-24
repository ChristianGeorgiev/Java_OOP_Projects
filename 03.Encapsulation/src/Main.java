import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        List<Person> persons = new ArrayList<>();
        Team footballSucks = new Team("FootballSucks");

        for (int i = 0; i < n; i++) {
            String[] input = reader.readLine().split(" ");
            Person person = null;
            try{
                person = new Person(input[0], input[1], Integer.parseInt(input[2]), Double.parseDouble(input[3]));
                persons.add(person);
            }catch (IllegalArgumentException ex){
                System.out.println(ex.getMessage());
            }
        }

        for (Person person : persons) {
            footballSucks.addPlayer(person);
        }

        System.out.println("First team have " + footballSucks.getFirstTeam().size() + " players");
        System.out.println("Reserve team have " + footballSucks.getReserveTeam().size() + " players");
    }
}
