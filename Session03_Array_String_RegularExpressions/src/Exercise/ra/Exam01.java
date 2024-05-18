package Exercise.ra;

import java.util.Scanner;

public class Exam01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] numberIntegers = new int[100];
        int currentIndex = 0;
        do {
            System.out.println("*******************MENU*******************");
            System.out.println("1. Nhập giá trị n phần tử của mảng (n nhập từ bàn phím)");
            System.out.println("2. In giá trị các phần tử trong mảng");
            System.out.println("3. Tính trung bình các phần tử dương (>0) trong mảng");
            System.out.println("4. In ra vị trí(chỉ số) các phần tử có giá trị bằng k trong mảng (k nhập từ bàn phím)");
            System.out.println("5. Sử dụng thuật toán sắp xếp nổi bọt sắp xếp mảng giảm dần");
            System.out.println("6. Tính số lượng các phần tử là số nguyên tố trong mảng");
            System.out.println("7. Sắp xếp các phần tử chẵn chia hết cho 3 ở đầu mảng theo thứ tự tăng dần, " +
                    "các phần tử lẻ chia hết cho 3 ở cuối mảng theo thứ tự giảm dần, các phần tuer còn lại " +
                    "ở giữa mảng theo thứ tự tăng dần");
            System.out.println("8. Nhập giá trị m từ bàn phím, chèn giá trị m vào mảng (sắp xếp giảm dần) đúng vị trí");
            System.out.println("9. Thoát");

            System.out.print("Lựa chọn của bạn là: ");

            int choose = Integer.parseInt(sc.nextLine());
            switch (choose) {
                case 1:
                    System.out.println("Nhập vào số lượng phần của mảng: ");
                    int quantity = Integer.parseInt(sc.nextLine());
                    for (int i = 0; i < quantity; i++) {
                        System.out.printf("Nhập vào phần tử %d: ", (i + 1));
                        numberIntegers[currentIndex++] = Integer.parseInt(sc.nextLine());
                    }
                    break;
                case 2:
                    System.out.println("Các phần tử trong mảng là: ");
                    for (int i = 0; i < currentIndex; i++) {
                        System.out.printf("%d\t", numberIntegers[i]);
                    }
                    System.out.printf("\n");
                    break;
                case 3:
                    int cnt = 0;
                    int sum = 0;
                    for (int i = 0; i < currentIndex; i++) {
                        if (numberIntegers[i] > 0) {
                            sum += numberIntegers[i];
                            cnt++;
                        }
                    }
                    float average = (float) sum / cnt;

                    System.out.println("Trung bình của các phần tử dương là: " + average);
                    break;
                case 4:
                    System.out.print("Nhập vào phần tử cần tìm vị trí có trong mảng: ");
                    int findIndex = Integer.parseInt(sc.nextLine());
                    boolean flag = false;
                    System.out.printf("Các vị trí có giá trị bằng %d là: ", findIndex);
                    for (int i = 0; i < currentIndex; i++) {
                        if (numberIntegers[i] == findIndex) {
                            flag = true;
                            System.out.printf("%3d", i);
                        }
                    }
                    System.out.printf("\n");
                    if (!flag) {
                        System.out.printf("Không có giá trị %d trong mảng\n", findIndex);
                    }
                    System.out.printf("\n");
                    break;
                case 5:
                    System.out.printf("Mảng sau khi sắp xếp là: ");
                    for (int i = 0; i < currentIndex; i++) {
                        for (int j = i + 1; j < currentIndex - i - 1; j++) {
                            if (numberIntegers[i] < numberIntegers[j]) {
                                int tmp = numberIntegers[i];
                                numberIntegers[i] = numberIntegers[j];
                                numberIntegers[j] = tmp;
                            }
                        }
                    }
                    System.out.printf("\n");
                    break;
                case 6:
                    boolean isCheck = false;
                    int count = 0;
                    for (int i = 0; i < currentIndex; i++) {
                        for (int j = 2; j <= Math.sqrt(numberIntegers[i]); i++) {
                            if (numberIntegers[i] % j == 0) {
                                isCheck = true;
                                break;
                            }
                        }
                        if (!isCheck) {
                            count++;
                        }
                    }
                    System.out.printf("Số lượng các phần tử là số nguyên tố trong mảng là: %d", count);
                    System.out.printf("\n");
                    break;
                case 7:
                    int[] newArray = new int[currentIndex];
                    int i = 0;
                    int k = 0;
                    int m = 0;
                    for (int c = 0; c < currentIndex; c++) {
                        if (numberIntegers[c] % 3 == 0 && numberIntegers[c] % 2 == 0 && numberIntegers[c] != 0) {
                            newArray[i] = numberIntegers[c];
                            i++;
                        }
                    }
                    for (int a = 0; a < i; a++) {
                        for (int b = a + 1; b < i - a - 1; b++) {
                            if (newArray[a] > newArray[b]) {
                                int tmp = newArray[a];
                                newArray[a] = newArray[b];
                                newArray[b] = tmp;
                            }
                        }
                    }

                    for (int c = 0; c < currentIndex; c++) {
                        if (numberIntegers[c] % 3 != 0) {
                            newArray[i + m] = numberIntegers[c];
                            m++;
                        }
                    }

                    for (int a = i; a < i + m; a++) {
                        for (int b = a + 1; b < i + m; b++) {
                            if (newArray[a] > newArray[b]) {
                                int tmp = newArray[a];
                                newArray[a] = newArray[b];
                                newArray[b] = tmp;
                            }
                        }
                    }

                    for (int c = 0; c < currentIndex; c++) {
                        if (numberIntegers[c] % 3 == 0 && numberIntegers[c] % 2 != 0) {
                            newArray[i + m + k] = numberIntegers[c];
                            k++;
                        }
                    }

                    for (int a = i + m; a < i + m + k; a++) {
                        for (int b = a + 1; b < i + m + k; b++) {
                            if (newArray[a] < newArray[b]) {
                                int tmp = newArray[a];
                                newArray[a] = newArray[b];
                                newArray[b] = tmp;
                            }
                        }
                    }

                    System.out.println("Mảng mới là: ");
                    for (int c = 0; c < currentIndex; c++) {
                        System.out.printf("%d\t", newArray[c]);
                    }
                    System.out.printf("\n");
                    break;
                case 8:
                    for (int j = 0; j < currentIndex - 1; j++) {
                        for (int l = 0; l < currentIndex - j - 1; l++) {
                            if (numberIntegers[l] < numberIntegers[l + 1]) {
                                int tmp = numberIntegers[l];
                                numberIntegers[l] = numberIntegers[l + 1];
                                numberIntegers[l + 1] = tmp;
                            }
                        }
                    }
                    System.out.printf("Mảng sau khi sắp xếp giảm dần là: ");
                    for (int c = 0; c < currentIndex; c++) {
                        System.out.printf("%d\t", numberIntegers[c]);
                    }
                    System.out.printf("\n");

                    int[] newArrayAfterInsert = new int[currentIndex + 1];

                    System.out.print("Vui lòng nhập vào số muốn chèn: ");

                    int insertNumber = Integer.parseInt(sc.nextLine());
                    int index = -1;
                    for (int j = 0; j < currentIndex; j++) {
                        if (insertNumber < numberIntegers[j] && insertNumber > numberIntegers[j + 1]) {
                            newArrayAfterInsert[j] = insertNumber;
                            index = j;
                        }
                    }

                    for (int j = 0; j <= currentIndex; j++) {
                        if(j < index + 1){
                            newArrayAfterInsert[j] = numberIntegers[j];
                        }else if(j == index + 1){
                            newArrayAfterInsert[j] = insertNumber;
                        }else {
                            newArrayAfterInsert[j] = numberIntegers[j - 1];
                        }
                    }

                    System.out.print("Mảng sau khi chèn là: ");

                    for (int element : newArrayAfterInsert){
                        System.out.printf("%d\t", element);
                    }
                    System.out.printf("\n");
                    break;
                case 9:
                    System.exit(0);
                default:
                    System.out.println("Vui lòng lựa chọn từ 1 -> 9");
            }
        } while (true);

    }
}
