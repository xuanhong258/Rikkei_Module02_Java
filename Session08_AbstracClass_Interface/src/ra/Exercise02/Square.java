package ra.Exercise02;

public class Square implements IColorable{
    public float side;

    public Square() {
    }

    public Square(float side) {
        this.side = side;
    }

    public float getSide() {
        return side;
    }

    public void setSide(float side) {
        this.side = side;
    }

    public String toString() {
        return "A Square with side = "
                + getSide();
    }

    @Override
    public void howToColor() {
        System.out.println("Color all four sides..");
    }
}
