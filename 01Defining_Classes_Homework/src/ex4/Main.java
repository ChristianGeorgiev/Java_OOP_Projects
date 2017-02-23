package ex4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.valueOf(console.readLine());

        HashMap<String, Department> departments = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] input = console.readLine().split("\\s+");
            String departmentName = input[3];
            departments.putIfAbsent(departmentName, new Department(departmentName));

            Employee employee = null;
            if (input.length == 4){
                employee = new Employee(input[0], Double.parseDouble(input[1]), input[2]);
            }else if(input.length == 5){
                if (Character.isDigit(input[4].charAt(input[4].length()-1))){
                    employee = new Employee(input[0],
                            Double.parseDouble(input[1]),
                            input[2],
                            Integer.parseInt(input[4]));
                }else {
                    employee = new Employee(input[0],
                            Double.parseDouble(input[1]),
                            input[2],
                            input[4]);
                }
            }else {
                employee = new Employee(input[0], Double.parseDouble(input[1]), input[2], input[4], Integer.parseInt(input[5]));
            }
            departments.get(departmentName).addEmployee(employee);
        }

        TreeMap<Double, Department> sorted = new TreeMap<>(Collections.reverseOrder());

        for (String s : departments.keySet()) {
            sorted.put(departments.get(s).getAvgSalary(), departments.get(s));
        }

        for (Double aDouble : sorted.keySet()) {
            System.out.print("Highest Average Salary: ");
            System.out.println(sorted.get(aDouble).getName());
            List<Employee> employees = sorted.get(aDouble).getEmployees();
            employees.stream().sorted((x, y) -> y.getSalary().compareTo(x.getSalary())).forEach(x -> System.out.println(x));
            break;
        }

    }
}


