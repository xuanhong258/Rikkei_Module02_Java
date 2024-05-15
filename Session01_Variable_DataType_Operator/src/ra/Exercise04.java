package ra;

import java.util.Scanner;

public class Exercise04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter math point");

        float mathPoint = sc.nextFloat();

        System.out.println("Enter literature point");

        float literaturePoint = sc.nextFloat();

        System.out.println("Enter english point");

        float englishPoint = sc.nextFloat();

        float avgMark = (mathPoint + literaturePoint + englishPoint) / 3;


        System.out.println("Average of 3 subjects are: " + avgMark);
    }
}
