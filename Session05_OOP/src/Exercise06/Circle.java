package Exercise06;

public class Circle {
    private double radius = 1.0;
    private String color = "red";

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public double getArea(){
        final float PI = 3.14F;
        return PI*Math.pow((this.radius),2);
    }
}
