package Exercise.ra;

import java.util.Scanner;

public class Exercise01 {
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

        System.out.println("Nhập vào phần tử muốn xóa");
        int numRemove = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == numRemove) {
                for (int j = i; j < numbers.length - 1; j++) {
                    numbers[j] = numbers[j + 1];
                }
                numbers[numbers.length - 1] = 0;
            }

        }

        System.out.println("Mảng sau khi xóa là");
        for (int number : numbers) {
            System.out.printf("%d\t", number);
        }
    }
}
