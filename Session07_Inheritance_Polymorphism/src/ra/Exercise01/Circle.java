package ra.Exercise01;

public class Circle {
    private float radius;
    private String color;
    private float area;
    final float PI = 3.14F;
    public Circle() {
    }

    public Circle(float radius, String color, float area) {
        this.radius = radius;
        this.color = color;
        this.area = area;
    }

    public float getRadius() {
        return radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public float getArea() {
        this.calArea();
        return area;
    }

    public void setArea(float area) {
        this.area = area;
    }

    public void calArea(){
        this.area = this.radius * this.radius * PI;
    }

    public String toString(){
        return "Radius: " + this.radius + " - Color: " + this.color + " - Area: " + this.area;
    }
}
