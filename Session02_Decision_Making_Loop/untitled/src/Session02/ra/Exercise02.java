package Session02.ra;

import java.util.Scanner;

public class Exercise02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Vui lòng nhập vào số từ 0 -> 9");

        int inputNumber = Integer.parseInt(sc.nextLine());

        switch (inputNumber) {
            case 0:
                System.out.println("Không");
                break;
            case 1:
                System.out.println("Một");
                break;
            case 2:
                System.out.println("Hai");
                break;
            case 3:
                System.out.println("Ba");
                break;
            case 4:
                System.out.println("Bốn");
                break;
            case 5:
                System.out.println("Năm");
                break;
            case 6:
                System.out.println("Sáu");
                break;
            case 7:
                System.out.println("Bảy");
                break;
            case 8:
                System.out.println("Tám");
                break;
            case 9:
                System.out.println("Chín");
                break;
            default:
                System.out.println("Vui lòng nhập vào số từ 0 -> 9");
        }
    }
}
