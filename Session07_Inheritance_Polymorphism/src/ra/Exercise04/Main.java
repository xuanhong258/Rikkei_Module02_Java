package ra.Exercise04;

public class Main {
    public static void main(String[] args) {
        int[] array1 = {1, 2, 3, 4, 5, 6};
        double[] array2 = {1.5, 2.6, 3.3, 4.2, 5.8, 6.9};
        ArrayCalculator arrayCalculator1 = new ArrayCalculator();

        System.out.println("Tổng của mảng số nguyên array1 là: " + arrayCalculator1.sumOfArray(array1));
        System.out.println("Tổng của mảng số thực array2 là: " + arrayCalculator1.sumOfArray(array2));
    }
}
