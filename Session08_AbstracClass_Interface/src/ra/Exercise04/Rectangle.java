package ra.Exercise04;

public class Rectangle extends Shape{
    private float width;
    private float height;

    public Rectangle() {
    }

    public Rectangle(String color, float width, float height) {
        super(color);
        this.width = width;
        this.height = height;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    @Override
    public double getArea() {
        return this.height * this.width;
    }
}
