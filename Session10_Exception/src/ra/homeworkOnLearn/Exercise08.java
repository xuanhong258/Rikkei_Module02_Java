package ra.homeworkOnLearn;

import java.util.Scanner;

public class Exercise08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        checkTriangle(scanner);
    }

    public static void checkTriangle(Scanner scanner) {
        boolean isExit = true;
        do {
            boolean check1 = true;
            boolean check2 = true;
            boolean check3 = true;
            int firstSide = 0, secondSide = 0, thirdSide = 0;
            do {
                try {
                    System.out.println("Nhập vào độ dài của cạnh thứ nhất");
                    boolean checkFirstSide = true;
                    do {
                        firstSide = Integer.parseInt(scanner.nextLine());
                        if (firstSide > 0) {
                            checkFirstSide = false;
                            check1 = false;
                        } else {
                            System.err.println("Độ dài phải lớn hơn 0, vui lòng nhập lại");
                        }
                    } while (checkFirstSide);
                } catch (NumberFormatException nfe) {
                    System.err.println("Giá trị nhập vào phải là số nguyên");
                }
            } while (check1);
            do {
                try {
                    System.out.println("Nhập vào độ dài của cạnh thứ hai");
                    boolean checkSecondSide = true;
                    do {
                        secondSide = Integer.parseInt(scanner.nextLine());
                        if (secondSide > 0) {
                            checkSecondSide = false;
                            check2 = false;
                        } else {
                            System.err.println("Độ dài phải lớn hơn 0, vui lòng nhập lại");
                        }
                    } while (checkSecondSide);
                } catch (NumberFormatException nfe) {
                    System.err.println("Giá trị nhập vào phải là số nguyên");
                }
            }while (check2);

            do {
                try {
                    System.out.println("Nhập vào độ dài của cạnh thứ ba");
                    boolean checkThirdSide = true;
                    do {
                        thirdSide = Integer.parseInt(scanner.nextLine());
                        if (thirdSide > 0) {
                            checkThirdSide = false;
                            check3 = false;
                        } else {
                            System.err.println("Độ dài phải lớn hơn 0, vui lòng nhập lại");
                        }
                    } while (checkThirdSide);
                }catch (NumberFormatException nfe) {
                    System.err.println("Giá trị nhập vào phải là số nguyên");
                }
            }while (check3);


            if(firstSide + secondSide > thirdSide && secondSide + thirdSide > firstSide && thirdSide + firstSide > secondSide){
                System.out.println("THÕA MÃN 3 CẠNH CỦA TAM GIÁC");
                isExit = false;
            }else {
                System.err.println("Độ dài 3 cạnh chưa thỏa mãn tạo thành tam giác, vui lòng nhập lại");
            }
        }while (isExit);

    }
}
