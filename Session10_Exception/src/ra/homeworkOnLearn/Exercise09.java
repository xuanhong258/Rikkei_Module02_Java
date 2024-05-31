package ra.homeworkOnLearn;

import java.util.Scanner;

public class Exercise09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        greatestCommonDivisor(scanner);
    }

    public static void greatestCommonDivisor(Scanner scanner) {
        boolean isExit = true;
        do {
            boolean check1 = true;
            boolean check2 = true;
            int firstNumber = 0, secondNumber = 0;
            do {
                try {
                    System.out.println("Nhập vào số thứ nhất");
                    firstNumber = Integer.parseInt(scanner.nextLine());
                    check1 = false;
                } catch (NumberFormatException nfe) {
                    System.err.println("Giá trị nhập vào phải là số nguyên");
                }
            } while (check1);
            do {
                try {
                    System.out.println("Nhập vào số thứ hai");
                    secondNumber = Integer.parseInt(scanner.nextLine());
                    check2 = false;
                } catch (NumberFormatException nfe) {
                    System.err.println("Giá trị nhập vào phải là số nguyên");
                }
            } while (check2);

            if (firstNumber == 0 && secondNumber == 0){
                System.err.println("Hai số nhập vào không thỏa mãn khác 0, vui lòng nhập lại");
            }else {
                while(firstNumber != secondNumber) {
                    //Lấy số lớn trừ số bé.
                    if (firstNumber > secondNumber) {
                        firstNumber -= secondNumber;
                    } else {
                        secondNumber -= firstNumber;
                    }
                    System.out.println("Ước chung lớn nhất của 2 số là: " + firstNumber);
                }
                isExit = false;
            }

        } while (isExit);
    }
}
