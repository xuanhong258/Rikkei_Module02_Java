package Exercise.ra;

import java.util.Scanner;

public class Exercise05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào số lượng phần tử của mảng");
        int arrQuatity = Integer.parseInt(sc.nextLine());
        int[] numbers = new int[arrQuatity];

        for (int i = 0; i < numbers.length; i++) {
            System.out.printf("Nhập vào phần tử thứ %d: ", (i + 1));
            numbers[i] = Integer.parseInt(sc.nextLine());
        }

        System.out.println("Mảng sau khi nhập là");
        for (int number : numbers) {
            System.out.printf("%d\t", number);
        }
        System.out.printf("\n");

        int minArray = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if(minArray > numbers[i]){
                minArray = numbers[i];
            }
        }

        System.out.printf("Phần tử nhỏ nhất của mảng là: %d", minArray);
    }
}
