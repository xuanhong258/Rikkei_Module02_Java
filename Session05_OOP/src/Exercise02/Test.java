package Exercise02;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Employee employee1 = new Employee();
        Scanner scanner = new Scanner(System.in);
        employee1.inputData(scanner);
        employee1.displayData();
    }
}
