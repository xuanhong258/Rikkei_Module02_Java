package ra.Exercise05;

public class ArrayCalculator {

    public int maxOfArray(int[] arr){
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(max < arr[i])
                max = arr[i];
        }
        return max;
    }

    public double maxOfArray(double[] arr){
        double max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(max < arr[i])
                max = arr[i];
        }
        return max;
    }

    public int minOfArray(int[] arr){
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(min > arr[i])
                min = arr[i];
        }
        return min;
    }

    public double minOfArray(double[] arr){
        double min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(min > arr[i])
                min = arr[i];
        }
        return min;
    }
}
