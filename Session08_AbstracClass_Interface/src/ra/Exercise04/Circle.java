package ra.Exercise04;

public class Circle extends Shape{
    private float radius;

    private final float PI = 3.14F;

    public Circle() {
    }

    public Circle(String color, float radius) {
        super(color);
        this.radius = radius;
    }


    @Override
    public double getArea() {
        return Math.pow(this.radius,2) * PI;
    }
}
