package ra.homeworkOnLearn;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Exercise04 {

    public static void main(String[] args) {

    }

    public static Date validateDate(Scanner scanner){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        do {
            String inputDateString = scanner.nextLine();
            try {
                Date inputDate = simpleDateFormat.parse(inputDateString);
                return inputDate;
            }catch (Exception ex){
                System.err.println("Ngày nhập phải có định dạng dd/MM/yyyy");
            }
        }while (true);
    }
}
