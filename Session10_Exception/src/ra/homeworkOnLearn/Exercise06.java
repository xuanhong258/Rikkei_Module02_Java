package ra.homeworkOnLearn;

import java.util.Scanner;

public class Exercise06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        sumOfIntegerArray(scanner);
    }

    public static void sumOfIntegerArray(Scanner scanner){
        System.out.println("Nhập vào số lượng phần tử của mảng số nguyên");
        boolean isExit = true;
        do {
            try {
                int quantity = Integer.parseInt(scanner.nextLine());
                if (quantity > 0){
                    int[] arrInt = new int[quantity];
                    System.out.println("Vui lòng nhập vào các phần tử của mảng");
                    for (int i = 0; i < quantity; i++) {
                        boolean isCheck = true;
                        do {
                            try {
                                System.out.printf("arrInt[%d]:", i);
                                arrInt[i] = Integer.parseInt(scanner.nextLine());
                                isCheck = false;
                            } catch (NumberFormatException nfe) {
                                System.err.println("Phải nhập vào số nguyên, vui lòng nhập lại");
                            }
                        }while (isCheck);
                    }

                    int sum = 0;
                    for (int number : arrInt){
                        sum += number;
                    }
                    System.out.printf("Tổng của mảng số nguyên là: %d", sum);
                }else {
                    System.err.println("Số phần tử của mảng phải lớn hơn 0, vui lòng nhập lại");
                }
                isExit = false;
            }catch (NumberFormatException nfe){
                System.err.println("Phải nhập vào số nguyên, vui lòng nhập lại");
            }
        }while (isExit);
    }
}
