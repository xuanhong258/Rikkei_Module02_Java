package ra.homeworkOnLearn;

import java.util.ArrayList;
import java.util.List;

public class Exercise04 {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        stringList.add("Nguyen Van C");
        stringList.add("Nguyen Van B");
        stringList.add("Nguyen Van A");

        System.out.println("Mảng chuỗi sau khi sắp xếp là: ");

        stringList.stream().sorted().forEach(System.out::println);
    }
}
