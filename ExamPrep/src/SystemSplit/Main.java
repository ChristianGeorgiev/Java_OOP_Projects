package SystemSplit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        TheSystem system = new TheSystem();

        String[] input = console.readLine().split("(\\(|\\)|, )");
        while (!"System Split".equals(input[0])){
            switch (input[0]){
                case "RegisterPowerHardware":
                    system.registerPowerHardware(input[1], Integer.valueOf(input[2]), Integer.valueOf(input[3]));
                    break;
                case "RegisterHeavyHardware":
                    system.registerHeavyHardware(input[1], Integer.valueOf(input[2]), Integer.valueOf(input[3]));
                    break;
                case "RegisterExpressSoftware":
                    system.registerExpressSoftware(input[1], input[2],
                            Integer.valueOf(input[3]), Integer.valueOf(input[4]));
                    break;
                case "RegisterLightSoftware":
                    system.registerLightSoftware(input[1], input[2],
                            Integer.valueOf(input[3]), Integer.valueOf(input[4]));
                    break;
                case "ReleaseSoftwareComponent":
                    system.releaseSoftwareComponent(input[1], input[2]);
                    break;
                case "Analyze":
                    System.out.println(system.analyze());
                    break;
                case "Dump":
                    system.dump(input[1]);
                    break;
                case "Restore":
                    system.restore(input[1]);
                    break;
                case "Destroy":
                    system.destroy(input[1]);
                    break;
                case "DumpAnalyze":
                    System.out.println(system.dumpAnalyze());
                    break;
                default:
                    break;
            }
            input = console.readLine().split("(\\(|\\)|, )");
        }

        System.out.println(system.split());
    }
}
