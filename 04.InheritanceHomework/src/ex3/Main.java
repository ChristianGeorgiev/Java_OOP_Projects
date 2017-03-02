package ex3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        String[] studentArgs = console.readLine().split("\\s+");
        String[] workerArgs = console.readLine().split("\\s+");

        try {
            Student student = new Student(studentArgs[0], studentArgs[1], studentArgs[2]);
            System.out.println(student);

            Worker worker = new Worker(workerArgs[0], workerArgs[1],
                    Double.valueOf(workerArgs[2]), Integer.valueOf(workerArgs[3]));
            System.out.println(worker);
        }catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }
    }
}
