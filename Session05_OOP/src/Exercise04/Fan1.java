package Exercise04;

public class Fan1 {
    public static void main(String[] args) {
        Fan fan1 = new Fan();
        fan1.setSpeed(fan1.getFAST());
        fan1.setRadius(10);
        fan1.setColor("yellow");
        fan1.setOn(true);

        System.out.printf("%s",fan1.toString());
    }
}
