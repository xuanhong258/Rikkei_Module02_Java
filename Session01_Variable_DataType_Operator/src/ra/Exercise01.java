package ra;

import java.util.Scanner;

public class Exercise01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter your name:");

        String userName = sc.nextLine();

        System.out.println("Hello: " + userName);
    }
}
