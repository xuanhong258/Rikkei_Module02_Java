package ra.Exercise01;

public class Cylinder extends Circle{
    private float height;

    public Cylinder() {
    }

    public Cylinder(float radius, String color, float area, float height) {
        super(radius, color, area);
        this.height = height;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float calVolume(){
        return super.getArea() * this.height;
    }

    public String toString(){
        return "Radius: " + super.getRadius() + " - Color: " + super.getColor() + " - Area: " +
                super.getArea() + " - Height: " + this.height + " - Volume: " + this.calVolume();
    }

    public static void main(String[] args) {
        Cylinder cylinder = new Cylinder();

        cylinder.setRadius(5);
        cylinder.setColor("Blue");
        cylinder.setHeight(10);

        System.out.println(cylinder);
    }
}
