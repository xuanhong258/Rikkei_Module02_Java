package ra.homeworkOnLearn;

import java.util.ArrayList;
import java.util.List;

public class Exercise02 {
    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            integerList.add((int) Math.floor(Math.random() * 100 + 1));
        }

        System.out.println("Mảng số nguyên là: ");
        integerList.stream().forEach(System.out::println);

        System.out.println("Mảng các số nguyên chẵn là: ");

        integerList.stream().filter(number -> number % 2 == 0).forEach(System.out::println);
    }
}
