package ra.homeworkOnLearn;

import java.util.Scanner;

public class Exercise01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isCheck = true;
        do {
            try {
                System.out.println("Nhập vào số đầu tiên");
                int firstNumber = Integer.parseInt(scanner.nextLine());
                System.out.println("Nhập vào số thứ 2");
                int secondNumber = Integer.parseInt(scanner.nextLine());

                int result = firstNumber / secondNumber;
                System.out.printf("Kết quả của phép tính %d / %d = %d", firstNumber, secondNumber, result);
                isCheck = false;
            } catch (NumberFormatException nfe) {
                System.err.println("Vui lòng nhập vào số nguyên");
            } catch (ArithmeticException ame) {
                System.err.println("Không thể chia cho số 0");
            }
        } while (isCheck);
    }
}
