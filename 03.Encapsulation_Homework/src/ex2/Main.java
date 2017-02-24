package ex2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        double length = Double.valueOf(console.readLine());
        double width = Double.valueOf(console.readLine());
        double height = Double.valueOf(console.readLine());
        Figure figure = null;

        try {
            figure = new Figure(length, width, height);
            System.out.println(figure.toString());
        }catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }
    }
}
