package ra.homeworkOnLearn;

import java.util.Scanner;

public class Exercise05 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        reverseString(scanner);
    }

    public static void reverseString(Scanner scanner) {
        System.out.println("Vui lòng nhập vào chuỗi cần đảo");
        boolean isExit = true;
        do {
            try {
                String inputStr = scanner.nextLine();
                StringBuilder str = new StringBuilder(inputStr);
                if (inputStr != null) {
                    if(!inputStr.isEmpty()){
                        str.reverse();
                        System.out.println(str);
                        isExit = false;
                    }else {
                        System.err.println("Chuỗi nhập vào là chỗi rỗng, vui lòng nhập lại");
                    }
                }
            } catch (Exception ex) {
                System.err.println("Chuỗi nhập vào không hợp lệ, vui lòng nhập lại");
            }
        }while (isExit);
    }
}
