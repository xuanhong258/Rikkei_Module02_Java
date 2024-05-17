package Exercise.ra;

import java.util.Scanner;

public class Exercise03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào số lượng phần tử của mảng đầu tiên");
        int arrQuatityOne = Integer.parseInt(sc.nextLine());
        int[] numbersOne = new int[arrQuatityOne];

        for (int i = 0; i < numbersOne.length; i++) {
            System.out.printf("Nhập vào phần tử thứ %d: ", (i + 1));
            numbersOne[i] = Integer.parseInt(sc.nextLine());
        }

        System.out.println("Nhập vào số lượng phần tử của mảng thứ hai");
        int arrQuatityTwo = Integer.parseInt(sc.nextLine());
        int[] numbersTwo = new int[arrQuatityTwo];

        for (int i = 0; i < numbersTwo.length; i++) {
            System.out.printf("Nhập vào phần tử thứ %d: ", (i + 1));
            numbersTwo[i] = Integer.parseInt(sc.nextLine());
        }

        int[] numbersThree = new int[arrQuatityOne + arrQuatityTwo];

       int i = 0;
       int j = 0;
       int k = 0;

       while (k < numbersThree.length){
           if(i < numbersOne.length){
               numbersThree[k] = numbersOne[i];
               i++;
           } else if (j < numbersTwo.length) {
               numbersThree[k] = numbersTwo[j];
               j++;
           }else{
               break;
           }
           k++;
       }


        System.out.println("Mảng sau khi gộp là: ");
        for (int number : numbersThree) {
            System.out.printf("%d\t", number);
        }

    }
}

