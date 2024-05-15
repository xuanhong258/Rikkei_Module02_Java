package Session02.ra;


public class Exercise05 {
    public static void main(String[] args) {
        System.out.println("Các số nguyên tố nhỏ hơn 100 là: ");
        for (int i = 1; i < 100; i++) {
            int result = checkIntegerNumber(i);
            if(result == 1){
                System.out.printf("%d\t",i);
            }
        }
    }

    public static int checkIntegerNumber(int number) {
        if (number < 0) return 0;
        if (number == 1) return 0;
        for (int i = 2; i <= Math.sqrt(number); i++){
            if(number % i == 0){
                return 0;
            }
        }
        return 1;
    }
}
