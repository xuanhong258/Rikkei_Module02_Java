package ra.Exercise01;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] shape = new String[100];
        final float PI = 3.14F;
        System.out.println("Nhập vào số lượng các hình");

        int quantity = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < quantity; i++) {
            System.out.println("Nhập vào tên hình");
            shape[i] = scanner.nextLine();

            switch (shape[i]){
                case "Hình tròn":
                    Circle circle = new Circle();
                    System.out.println("Nhập vào bán kính của hình tròn");
                    double radius = Double.parseDouble(scanner.nextLine());
                    double areaCircle = PI * Math.pow(radius,2);
                    System.out.println("Diện tích của hình tròn ban đầu là: " + areaCircle);
                    double percentCircle = Math.floor(Math.random() * 100 + 1);
                    circle.resize(percentCircle);
                    System.out.println(" là: " + areaCircle * (100 + percentCircle)/100);
                    break;
                case "Hình chữ nhật":
                    Rectangle rectangle = new Rectangle();
                    System.out.println("Nhập vào chiều dài của hình chữ nhật");
                    double lengthSide = Double.parseDouble(scanner.nextLine());
                    System.out.println("Nhập vào chiều rộng của hình chữ nhật");
                    double shortSide = Double.parseDouble(scanner.nextLine());
                    double areaRectangle = lengthSide * shortSide;
                    System.out.println("Diện tích của chữ nhật ban đầu là: " + areaRectangle);
                    double percentRectangle = Math.floor(Math.random() * 100 + 1);
                    rectangle.resize(percentRectangle);
                    System.out.println(" là: " + areaRectangle*(100 + percentRectangle)/100);
                    break;
                case "Hình vuông":
                    Square square = new Square();
                    System.out.println("Nhập vào chiều dài của hình vuông");
                    double lengthSquare = Double.parseDouble(scanner.nextLine());
                    double areaSquare = lengthSquare * lengthSquare;
                    System.out.println("Diện tích của chữ nhật ban đầu là: " + areaSquare);
                    double percentSquare = Math.floor(Math.random() * 100 + 1);
                    square.resize(percentSquare);
                    System.out.println(" là: " + areaSquare*(100 + percentSquare)/100);
                    break;
                default:
                    System.err.println("Vui lòng nhập tên hình : Hình tròn, Hình chữ nhật, Hình vuông ");
                    break;
            }
        }

    }
}
