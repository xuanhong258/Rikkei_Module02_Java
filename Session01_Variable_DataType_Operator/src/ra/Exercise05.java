package ra;

import java.util.Scanner;

public class Exercise05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final float PI = 3.14F;
        System.out.println("Enter the radius: ");

        float radius = sc.nextFloat();

        double circumference = 2 * PI * radius;

        double area = PI * radius * radius;

        System.out.println("Circumference of the circle is: " + circumference);

        System.out.println("Area of the circle is: " + area);
    }
}
