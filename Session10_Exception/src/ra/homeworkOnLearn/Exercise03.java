package ra.homeworkOnLearn;

public class Exercise03 {
    public static void main(String[] args) {
        int[] arr = new int[0];

        int max = findMaxArray(arr);

        System.out.println("Max là: " + max);
    }

    public static int findMaxArray(int[] arr) {
        if (arr.length == 0) {
            throw new ArrayIndexOutOfBoundsException("Mảng không có phần tử nào");
        } else {
            int max = arr[0];
            for (int i = 1; i < arr.length - 1; i++) {
                if (max < arr[i]) {
                    max = arr[i];
                }
            }
            return max;
        }
    }
}
