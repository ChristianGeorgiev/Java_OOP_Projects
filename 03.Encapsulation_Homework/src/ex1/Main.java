package ex1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        double length = Double.valueOf(console.readLine());
        double width = Double.valueOf(console.readLine());
        double height = Double.valueOf(console.readLine());

        Figure figure = new Figure(length, width, height);
        System.out.println(figure.toString());
    }
}
