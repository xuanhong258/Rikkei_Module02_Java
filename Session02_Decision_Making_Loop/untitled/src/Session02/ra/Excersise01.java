package Session02.ra;

import java.util.Scanner;

public class Excersise01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Vui long nhap so tu nhien");
        int number = Integer.parseInt(sc.nextLine());

        if(number % 3 == 0 && number % 5 == 0){
            System.out.printf("So %d chia het cho 3 & 5",number);
        }else{
            System.out.printf("So %d khong chia het cho 3 & 5",number);
        }
    }
}
