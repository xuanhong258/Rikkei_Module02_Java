package Exercise.ra;

import java.util.Scanner;

public class Exercise07 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Nhập vào chuỗi đầu tiên");

        String stringOne = sc.nextLine();

        System.out.println("Nhập vào chuỗi thứ hai");

        String stringTwo = sc.nextLine();

        if(stringOne.contains(stringTwo)){
            System.out.println("Chuỗi đầu tiên có chứa chuỗi thứ hai");
        }else{
            System.err.println("Chuỗi đầu tiên không chứa chuỗi thứ hai");
        }
    }
}
