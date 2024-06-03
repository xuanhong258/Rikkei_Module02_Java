package ra.homeworkOnLearn;

import java.util.ArrayList;
import java.util.List;

public class Exercise05 {
    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            integerList.add((int) Math.floor(Math.random() * 100 + 1));
        }

        System.out.println("Mảng số nguyên là: ");
        integerList.forEach(number -> System.out.println(number));
    }
}
