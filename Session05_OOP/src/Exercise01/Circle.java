package Exercise01;

import java.util.Scanner;


public class Circle {
    private int radius;
    private String color;
    final float PI = 3.14F;
    public Circle() {
    }

    public Circle(int radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public float chuvi() {
        return this.radius * 2 * PI;
    }

    public float dientich() {
        return this.radius * this.radius * PI;
    }

    public void inputData(Scanner scanner) {
        System.out.println("Nhập vào bán kính đường tròn");
        this.radius = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập vào màu sắc của đường tròn");
        this.color = scanner.nextLine();
    }

    public void displayData() {
        System.out.printf("Bán kính đường tròn là: %d - Màu sắc của hình tròn là: %s", this.radius, this.color);
    }
}

