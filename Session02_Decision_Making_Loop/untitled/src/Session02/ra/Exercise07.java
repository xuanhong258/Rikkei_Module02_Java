package Session02.ra;

import java.util.Scanner;

public class Exercise07 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Vui lòng nhập số từ 1 -> 4");
            System.out.println("1.Kiểm tra tính chẵn lẻ của 1 số");
            System.out.println("2.Kiểm tra số nguyên tố");
            System.out.println("3.Kiểm tra 1 ố có chia hết cho 3 không");
            System.out.println("4.Thoát");
            int chooseNumber = Integer.parseInt(sc.nextLine());
            switch (chooseNumber) {
                case 1:
                    System.out.println("Vui lòng nhập vào số muốn kiểm tra");
                    int number = Integer.parseInt(sc.nextLine());

                    if (number % 2 == 0) {
                        System.out.printf("%d là số chẵn\n", number);
                    } else {
                        System.out.printf("%d là số lẻ\n", number);
                    }
                    break;
                case 2:
                    System.out.println("Vui lòng nhập vào số muốn kiểm tra");
                    int numberInteger = Integer.parseInt(sc.nextLine());
                    if (Exercise05.checkIntegerNumber(numberInteger) == 1) {
                        System.out.printf("%d là số nguyên tố\n", numberInteger);
                    } else {
                        System.out.printf("%d không phải là số nguyên tố\n", numberInteger);
                    }
                    break;
                case 3:
                    System.out.println("Vui lòng nhập vào số muốn kiểm tra");
                    int numberDivThree = Integer.parseInt(sc.nextLine());
                    if (numberDivThree % 3 == 0) {
                        System.out.printf("%d chia hết cho 3\n", numberDivThree);
                    } else {
                        System.out.printf("%d không chia hết cho 3\n", numberDivThree);
                    }
                    break;
                case 4:
                    int status;
                    System.exit(status = 0);
                    break;
                default:
                    System.out.println("Vui lòng nhập số từ 1 -> 4");
            }
        } while (true);

    }
}
