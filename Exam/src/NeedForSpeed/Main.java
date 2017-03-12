package NeedForSpeed;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        CarManager cm = new CarManager();

        String[] input = console.readLine().split("\\s+");
        while (!"Cops".equals(input[0])){

            switch (input[0]){
                case "register":
                    cm.register(Integer.valueOf(input[1]),
                                input[2], input[3], input[4], Integer.valueOf(input[5]),
                            Integer.valueOf(input[6]), Integer.valueOf(input[7]),
                            Integer.valueOf(input[8]), Integer.valueOf(input[9]));
                    break;
                case "check":
                    System.out.println(cm.check(Integer.valueOf(input[1])));
                    break;
                case "open":
                    if (input[2].equals("Circuit") || input[2].equals("TimeLimit")){
                        cm.open(Integer.valueOf(input[1]), input[2], Integer.valueOf(input[3]), input[4], Integer.valueOf(input[5]), Integer.valueOf(input[6]));
                    } else{
                        cm.open(Integer.valueOf(input[1]), input[2], Integer.valueOf(input[3]), input[4], Integer.valueOf(input[5]));
                    }
                    break;
                case "participate":
                    cm.participate(Integer.valueOf(input[1]), Integer.valueOf(input[2]));
                    break;
                case "start":
                    System.out.println(cm.start(Integer.valueOf(input[1])));
                    break;
                case "park":
                    cm.park(Integer.valueOf(input[1]));
                    break;
                case "unpark":
                    cm.unpark(Integer.valueOf(input[1]));
                    break;
                case "tune":
                    cm.tune(Integer.valueOf(input[1]), input[2]);
            }



            input = console.readLine().split("\\s+");
        }
    }
}
