package Exercise.ra;

import java.util.Scanner;

public class Exercise06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Nhập vào chuỗi đầu tiên");

        String stringOne = sc.nextLine();

        System.out.println("Nhập vào chuỗi thứ hai");

        String stringTwo = sc.nextLine();

        System.out.println("Chuỗi sau khi nối là: " + stringOne.concat(stringTwo));
    }
}
