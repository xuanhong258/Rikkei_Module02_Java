package Exercise06;

public class TestCircle {
    public static void main(String[] args) {
        Circle circle1 = new Circle(2);

        System.out.printf("Bán kính của hình tròn là: %.2f", circle1.getRadius());
        System.out.printf("\n");
        System.out.printf("Diện tích của hình tròn là: %.2f", circle1.getArea());
    }
}
