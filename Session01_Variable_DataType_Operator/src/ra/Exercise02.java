package ra;

import java.util.Scanner;

public class Exercise02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int EXCHANGE_RATE = 23000;
        System.out.println("Enter the amount of money: ");

        double amountUSD = sc.nextDouble();
        double amountVND = amountUSD * EXCHANGE_RATE;

        System.out.printf("%f USD = %f VND", amountUSD, amountVND);
    }
}
