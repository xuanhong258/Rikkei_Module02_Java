package Session02.ra;

import java.util.Scanner;

public class Exercise04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Vui lòng nhập vào một số tự nhiên đầu tiên");
        int firstNumber = Integer.parseInt(sc.nextLine());
        System.out.println("Vui lòng nhập vào một số tự nhiên thứ hai lớn hơn số đầu tiên");
        int secondNumber = Integer.parseInt(sc.nextLine());
        System.out.printf("Các số chẵn trong khoảng từ %d đến %d là: \n",firstNumber,secondNumber);
        for(int i = firstNumber; i <= secondNumber; i++){
            if(i % 2 == 0){
                System.out.print(i + "\t");
            }
        }
    }
}
