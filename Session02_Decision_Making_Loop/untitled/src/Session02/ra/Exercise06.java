package Session02.ra;


public class Exercise06 {
    public static void main(String[] args) {

        int count = 0;
        int i = 2;
        System.out.println("20 nguyên số đầu tiên là");
        while (count < 20){
            if (checkIntegerNumber(i) == 1){
                System.out.print(i + "\t");
                count++;
                i++;
            }
            i++;
        }
    }

    public static int checkIntegerNumber(int number) {
        return Exercise05.checkIntegerNumber(number);
    }
}
