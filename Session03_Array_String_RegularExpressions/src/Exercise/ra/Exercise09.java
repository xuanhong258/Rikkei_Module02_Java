package Exercise.ra;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Exercise09 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Regex với password thì phải không có dấu cách (space) và phải lơn hơn 6 kí tự
        String regexPassword = "[\\S]?.{7,}";

        System.out.println("......result: " + Pattern.matches(regexPassword,"abc1234"));

//        String regexEmail = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9]))\\.){3}(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9])|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";
//
//        System.out.print("Vui lòng nhập email:");
//
//        String emailInput = sc.nextLine();
//
//        System.out.printf("\n");
//
//        System.out.print("Vui lòng nhập password:");
//
//        String passwordInput = sc.nextLine();
//
//        System.out.printf("\n");
//
//        if (!Pattern.matches(regexEmail, emailInput)) {
//            System.out.println("Email không hợp lệ");
//        } else if (!Pattern.matches(regexPassword, passwordInput)) {
//            System.out.println("Password không hợp lệ");
//        } else {
//            System.out.println("Email và password hợp lệ");
//        }

    }
}
