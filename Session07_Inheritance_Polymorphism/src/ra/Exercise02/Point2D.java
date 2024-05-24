package ra.Exercise02;

public class Point2D {
    private float x = 0.0F;
    private float y = 0.0F;

    public Point2D() {
    }

    public Point2D(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setXY(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public String getXY(){
        float[] xy = {getX(), getY()};
        return "x: " + xy[0] + ", y: " + xy[1];
    }

    @Override
    public String toString() {
        return "(" + getX() + "," + getY() + ")";
    }

}
