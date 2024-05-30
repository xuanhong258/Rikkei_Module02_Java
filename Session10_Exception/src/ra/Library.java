package ra;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Library {
    public static List<Category> categoryList = new ArrayList<>();
    public static List<Book> bookList = new ArrayList<>();


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("======QUẢN LÝ THƯ VIỆN======");
            System.out.println("1. Quản lý Thể loại");
            System.out.println("2. Quản lý Sách");
            System.out.println("3. Thoát");
            System.out.print("Lựa chọn của bạn là: ");
            boolean isCheck = true;
            do {
                try{
                    int choice = Integer.parseInt(scanner.nextLine());
                    if (choice > 0){
                        switch (choice){
                            case 1:

                                break;
                            case 2:
                                break;
                            case 3:
                                System.exit(0);
                            default:
                                System.err.println("Vui lòng nhập từ 1 -> 3");
                                break;
                        }
                    }else {
                        System.err.println("Vui lòng nhập vào số nguyên lớn hơn 0");
                    }
                }catch (Exception ate){
                    System.err.println("Vui lòng nhập vào số nguyên");
                }
            }while (isCheck);

        }while (true);
    }


    public static void categoryMenu(Scanner scanner){
        boolean isExit = true;
        do {
            System.out.println("=========== QUẢN LÝ THỂ LOẠI =====");
            System.out.println("1. Thêm mới thể loại");
            System.out.println("2. Hiển thị danh sách theo tên A - Z");
            System.out.println("3. Thống kê thể loại và số sách có trong mỗi thể loại");
            System.out.println("4. Cập nhật thể loại");
            System.out.println("5. Xóa thể loại");
            System.out.println("6. Quay lại");
        }while (isExit);
    }
}
