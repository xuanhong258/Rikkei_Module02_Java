package Exercise.ra;

import java.util.Scanner;

public class Exercise04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Nhập vào số hàng ma trận: ");

        int row = Integer.parseInt(sc.nextLine());

        System.out.println("Nhập vào số cột ma trận: ");

        int col = Integer.parseInt(sc.nextLine());

        int[][] matrixNumber = new int[row][col];

        for (int i = 0; i < matrixNumber.length ; i++) {
            for (int j = 0; j < matrixNumber[i].length; j++) {
                System.out.printf("Nhập phần tử [%d][%d]: ",i,j);
                matrixNumber[i][j] = Integer.parseInt(sc.nextLine());
            }
        }

        System.out.println("Ma trận vừa nhập là: ");
        for (int i = 0; i < matrixNumber.length ; i++) {
            for (int j = 0; j < matrixNumber[i].length; j++) {
                System.out.printf("%5d", matrixNumber[i][j]);
            }
            System.out.printf("\n");
        }


        int maxMatrix = matrixNumber[0][0];
        for (int i = 0; i < matrixNumber.length ; i++) {
            for (int j = 1; j < matrixNumber[i].length; j++) {
                if(matrixNumber[i][j] > maxMatrix){
                    maxMatrix = matrixNumber[i][j];
                }
            }
        }

        System.out.printf("\nGiá trị lớn nhất của ma trận là: %d ", maxMatrix);
    }
}
