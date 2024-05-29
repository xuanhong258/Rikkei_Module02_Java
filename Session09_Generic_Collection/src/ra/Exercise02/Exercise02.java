package ra.Exercise02;

import java.util.ArrayList;
import java.util.List;

public class Exercise02 {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();

        stringList.add("Hong");
        stringList.add("Ho");
        stringList.add("H");
        stringList.add("Xuan");

        System.out.println("Các chuỗi có độ dài lớn hơn 3 ký tự là:");
        for (String element : stringList){
            if (element.length() > 3){
                System.out.printf("%s\n", element);
            }
        }
    }
}
