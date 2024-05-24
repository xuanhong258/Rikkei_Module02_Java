package ra.Exercise05;

public class Main {
    public static void main(String[] args) {

        int[] arrIntegerNumber = {1,2,3,4,5,6};
        double[] arrDoubleNumber = {1.3,2.5,3.4,4.6,5.7,6.9};
        ArrayCalculator arr = new ArrayCalculator();

        System.out.println("Số nguyên lớn nhất trong mảng là: " + arr.maxOfArray(arrIntegerNumber));
        System.out.println("Số thực lớn nhất trong mảng là: " + arr.maxOfArray(arrDoubleNumber));
        System.out.println("Số nguyên nhỏ nhất trong mảng là: " + arr.minOfArray(arrIntegerNumber));
        System.out.println("Số thực nhỏ nhất trong mảng là: " + arr.minOfArray(arrDoubleNumber));
    }
}
