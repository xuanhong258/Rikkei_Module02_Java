package ra.Exercise03;

import java.util.ArrayList;
import java.util.List;


public class Exercise03{
    public static void main(String[] args) {
        List<Integer> listInteger = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            listInteger.add((int) Math.floor(Math.random()*100 + 1));
        }

        int sum = 0;

        for (Integer element : listInteger){
            sum += element;
        }

        System.out.println("Tổng số nguyên trong dãy là: " + sum);
    }

}
