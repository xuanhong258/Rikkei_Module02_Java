package ra.Exercise04;

public class Main {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle("blue", 10.5F, 20.5F);
        Circle circle = new Circle("yellow", 5.5F);

        rectangle.display();
        System.out.printf("\n");
        System.out.printf("Diện tích hình chữ nhật là: %.3f", rectangle.getArea());
        System.out.printf("\n");
        circle.display();
        System.out.printf("\n");
        System.out.printf("Diện tích hình tròn là: %.3f", circle.getArea());
    }
}
