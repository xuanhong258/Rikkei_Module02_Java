package ra;

import java.util.Scanner;

public class Exercise03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the length of the square: ");

        double lengthOfSquare = sc.nextDouble();

        double circumference = lengthOfSquare * 4;

        double area = lengthOfSquare * lengthOfSquare;


        System.out.println("The circumference of the square is " + circumference);
        System.out.println("The area of the square is " + area);
    }
}
