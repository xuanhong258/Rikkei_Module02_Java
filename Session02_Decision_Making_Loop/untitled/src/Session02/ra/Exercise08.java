package Session02.ra;

import java.util.Scanner;

public class Exercise08 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean flag = true;

        do {
            System.out.println("Vui lòng nhập vào cạnh thứ nhất của tam giác: ");

            int firstSide = Integer.parseInt(sc.nextLine());

            System.out.println("Vui lòng nhập vào cạnh thứ hai của tam giác: ");

            int secondSide = Integer.parseInt(sc.nextLine());

            System.out.println("Vui lòng nhập vào cạnh thứ ba của tam giác: ");

            int thirdSide = Integer.parseInt(sc.nextLine());

            if (firstSide + secondSide <= thirdSide || secondSide + thirdSide <= thirdSide || thirdSide + firstSide <= secondSide) {
                System.out.println("Vui lòng nhập lại độ dàiiii");
            }else {
                flag = false;
                int circumferenceTriangular = firstSide + secondSide + thirdSide;
                double halfCircumference = 1.0F * circumferenceTriangular / 2 ;
                double area = Math.sqrt(halfCircumference * (halfCircumference - firstSide) * (halfCircumference - secondSide) * (halfCircumference - thirdSide));

                System.out.println("Chu vi tam giác là: " + circumferenceTriangular);
                System.out.printf("Diện tích tam giác là: %.3f", area);
            }
        } while (flag);

    }
}
