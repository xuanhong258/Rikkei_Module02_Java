package Exercise.ra;

import java.util.Scanner;

public class Exercise02 {
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

        boolean flag = true;
        do {
            System.out.println("Nhập vào vị trí cần chèn");

            int position = Integer.parseInt(sc.nextLine());

            System.out.println("Nhập vào giá trị cần chèn: ");

            int valueInsert = Integer.parseInt(sc.nextLine());

            if (position <= -1 || position >= numbers.length) {
                System.err.println("Vị trí chèn không hợp lệ");
            } else {
                flag = false;
                for (int i = 0; i < numbers.length; i++) {
                    if (position == i) {
                        for (int j = numbers.length - 1; j >= position + 1; j--) {
                            numbers[j] = numbers[j - 1];
                        }
                        numbers[i] = valueInsert;
                    }
                }
                System.out.println("Mảng sau khi chèn là:");
                for (int number : numbers) {
                    System.out.printf("%d\t", number);
                }

            }
        } while (flag);

    }
}
