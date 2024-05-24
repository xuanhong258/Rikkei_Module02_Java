package ra.Exercise02;

public class Point3D extends Point2D {
    private float z = 0.0F;

    public Point3D() {
    }

    public Point3D(float x, float y, float z) {
        super(x, y);
        this.z = z;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public void setXYZ(float x, float y, float z) {
        setX(x);
        setY(y);
        setZ(z);
    }

    public String getXYZ(){
        float[] xyz = {getX(), getY(), getZ()};
        return "x: " + getX() + ", y: " + getY() + ", z: " + getZ();
    }

    public String toString() {
        return "(" + getX() + ", " + getY() + ", " + getZ() + ")";
    }


}
