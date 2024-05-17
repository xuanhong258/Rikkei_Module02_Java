package Exercise.ra;

import java.util.Scanner;

public class Exam02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Nhập vào số dòng của ma trận: ");
        int row = Integer.parseInt(sc.nextLine());
        System.out.println("Nhập vào số cột của ma trận: ");
        int col = Integer.parseInt(sc.nextLine());

        System.out.printf("\n");
        int[][] matrixInteger = new int[row][col];

        do {
            System.out.println("*******************MENU*******************");
            System.out.println("1. Nhập giá trị các phần tử của mảng ");
            System.out.println("2. In giá trị các phần tử trong mảng theo ma trận");
            System.out.println("3. Tính số lượng các phần tử chia hết cho 2 vad 3 trong mảng");
            System.out.println("4. In các phần tử và tổng các phần tử nằm trên đường biên, đường chéo chính và \n" +
                    "đường chéo phụ");
            System.out.println("5. Sử dụng thuật toán sắp xếp lựa chọn sắp xếp các phần tử tăng dần theo cột của \n" +
                    "mảng");
            System.out.println("6. In ra các phần tử là số nguyên tố trong mảng");
            System.out.println("7. Sử dụng thuật toán chèn (Insertion sort) sắp xếp các phần tử trên đường chéo chính \n" +
                    "của mảng giảm dần");
            System.out.println("8. Nhập giá trị một mảng 1 chiều gồm m phần tử và chỉ số dòng muốn chèn vào mảng, \n" +
                    "thực hiện chèn vào mảng 2 chiều");
            System.out.println("9. Thoát");

            System.out.print("Lựa chọn của bạn là: ");

            int choose = Integer.parseInt(sc.nextLine());

            switch (choose) {
                case 1:
                    for (int i = 0; i < matrixInteger.length; i++) {
                        for (int j = 0; j < matrixInteger[i].length; j++) {
                            System.out.printf("Nhập vào phần tử [%d][%d]: ", i, j);
                            matrixInteger[i][j] = Integer.parseInt(sc.nextLine());
                        }
                    }
                    System.out.printf("\n");
                    break;
                case 2:
                    System.out.println("Ma trận vừa nhập là: ");
                    for (int i = 0; i < matrixInteger.length; i++) {
                        for (int j = 0; j < matrixInteger[i].length; j++) {
                            System.out.printf("%5d", matrixInteger[i][j]);
                        }
                        System.out.printf("\n");
                    }
                    break;
                case 3:
                    int cnt = 0;
                    for (int i = 0; i < matrixInteger.length; i++) {
                        for (int j = 0; j < matrixInteger[i].length; j++) {
                            if (matrixInteger[i][j] % 2 == 0 && matrixInteger[i][j] % 3 == 0) {
                                cnt++;
                            }
                        }
                    }

                    System.out.printf("Số lượng pần tử chia hết cho 2 và 3 là: %d", cnt);
                    System.out.printf("\n");
                    break;
                case 4:
                    int sum = 0;

                    System.out.print("Các phần tử nằm trên đường biên là: ");
                    for (int i = 0; i < row; i++) {
                        sum = sum + matrixInteger[i][0] + matrixInteger[i][col - 1];
                        System.out.printf("%d\t%d\t", matrixInteger[i][0], matrixInteger[i][col - 1]);
                    }

                    for (int j = 1; j < col - 1; j++) {
                        sum = sum + matrixInteger[0][j] + matrixInteger[row - 1][j];
                        System.out.printf("%d\t%d\t", matrixInteger[0][j], matrixInteger[row - 1][j]);
                    }
                    System.out.printf("\n");
                    System.out.printf("Tổng các phần tử nằm trên đường biên là: %d ", sum);
                    System.out.printf("\n");

                    if (row == col) {
                        int sumCrossMainLine = 0;
                        int sumCrossSubLine = 0;
                        System.out.print("Đường chéo chính của ma trận là: ");
                        for (int i = 0; i < row; i++) {
                            for (int j = 0; j < col; j++) {
                                if (i == j) {
                                    sumCrossMainLine += matrixInteger[i][j];
                                    System.out.printf("%d\t", matrixInteger[i][j]);
                                }
                            }
                        }
                        System.out.printf("\n");

                        System.out.printf("Tổng của đường chéo chính ma trận là: %d", sumCrossMainLine);

                        System.out.printf("\n");

                        System.out.print("Đường chéo phụ của ma trận là: ");
                        for (int i = 0; i < row; i++) {
                            for (int j = 0; j < col; j++) {
                                if (j == row - i - 1) {
                                    sumCrossSubLine += matrixInteger[i][j];
                                    System.out.printf("%d\t", matrixInteger[i][j]);
                                }
                            }
                        }
                        System.out.printf("\n");

                        System.out.printf("Tổng của đường chéo phụ ma trận là: %d", sumCrossSubLine);

                        System.out.printf("\n");
                    } else {
                        System.err.println("Vui lòng nhập số hàng số cột bằng nhau");
                    }
                    break;
                case 5:
                    for (int i = 0; i < col; i++) {
                        for (int j = 0; j < row - 1; j++) {
                            int min_index = j;
                            for (int k = j + 1; k < row; k++) {
                                if (matrixInteger[min_index][i] > matrixInteger[k][i]) {
                                    min_index = k;
                                }
                            }
                            int tmp = matrixInteger[min_index][i];
                            matrixInteger[min_index][i] = matrixInteger[j][i];
                            matrixInteger[j][i] = tmp;
                        }
                    }
                    System.out.println("Ma trận sau khi sắp xếp là: ");
                    for (int i = 0; i < row; i++) {
                        for (int j = 0; j < col; j++) {
                            System.out.printf("%5d", matrixInteger[i][j]);
                        }
                        System.out.printf("\n");
                    }
                    System.out.printf("\n");
                    break;
                case 6:

                    break;
                case 7:

                    break;
                case 8:
                    ;
                    break;
                case 9:
                    System.exit(0);
                default:
                    System.out.println("Vui lòng lựa chọn từ 1 -> 9");
            }

        } while (true);
    }
}
