package ra.homeworkOnLearn;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Exercise01 {
    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            integerList.add((int) Math.floor(Math.random() * 100 + 1));
        }

        System.out.println("Mảng số nguyên là: ");
        integerList.stream().forEach(System.out::println);

        System.out.println("Số lớn nhất trong mảng là: " + integerList.stream().max(Comparator.comparing(key -> key)).get());
    }
}
