package ra.Exercise01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Exercise01 {
    public static void main(String[] args) {
        List<Integer> listInteger = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            listInteger.add((int) Math.floor(Math.random()*100 + 1));
        }

        for(Integer i : listInteger) {
            System.out.printf("%d\t", i);
        }

        Collections.sort(listInteger, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        System.out.printf("\n");
        System.out.println("Sắp xếp tăng dần");
        for(Integer i : listInteger) {
            System.out.printf("%d\t", i);
        }
        System.out.printf("\n");
        System.out.println("Phần tử lớn nhất là: " + listInteger.toArray()[listInteger.toArray().length - 1]);
    }
}
