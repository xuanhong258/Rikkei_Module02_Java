package ra.homeworkOnLearn;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Exercise07 {
    public static void main(String[] args) {
//        covertStringToNumber("456123");

        String str1 = "a4b6c123";
        List<String> str2 = new ArrayList<>();
        for (int i = 0; i < str1.length(); i++) {
            str2.add("" + str1.charAt(i));
        }
        List<Integer> str3 = new ArrayList<>();
        for (String el : str2){
            try {
                str3.add(Integer.parseInt(el));
            }catch (Exception ex){
                System.err.println("Chuỗi không thể convert sang kiểu số");
            }
        }

        for (Integer el : str3){
            System.out.printf("%d",el);
        }
    }

}
