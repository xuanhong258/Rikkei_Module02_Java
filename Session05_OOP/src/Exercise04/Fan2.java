package Exercise04;

public class Fan2 {
    public static void main(String[] args) {
        Fan fan2 = new Fan();
        fan2.setSpeed(fan2.getMEDIUM());
        fan2.setRadius(5);
        fan2.setColor("blue");
        fan2.setOn(false);

        System.out.printf("%s",fan2.toString());
    }
}
