package Exercise03;

public class QuadraticEquation {
    private double a;
    private double b;
    private double c;

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    public double getDiscriminant(){
        double delta = Math.pow(this.b,2) - 4*this.a*this.c;
        return delta;
    }

    public double getRoot1(){
        if (this.getDiscriminant() >= 0){
            double root1 = (-this.b + Math.pow(this.getDiscriminant(), 0.5)) / (2 * this.a);
            return root1;
        }else {
            return 0;
        }
    }

    public double getRoot2(){
        if (this.getDiscriminant() >= 0){
            double root2 = (-this.b - Math.pow(this.getDiscriminant(), 0.5)) / (2 * this.a);
            return root2;
        }else {
            return 0;
        }
    }

    public void displayRoot(){
        if (this.getRoot1() == 0 || this.getRoot2() == 0){
            System.err.println("The equation has no real roots");
        }else if(this.getDiscriminant() == 0){
            System.out.printf("The equation has one root %f", this.getRoot1());
        }else {
            System.out.printf("The equation has two roots %f and %f ", this.getRoot1(), this.getRoot2());
        }
    }
}
