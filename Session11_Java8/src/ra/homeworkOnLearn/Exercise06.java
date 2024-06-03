package ra.homeworkOnLearn;

import java.util.ArrayList;
import java.util.List;

public class Exercise06 {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        stringList.add("Nguyen Van C");
        stringList.add("Nguyen Van B");
        stringList.add("Nguyen Van A");

        stringList.stream().map(element -> element.toUpperCase()).forEach(System.out::println);
    }
}
