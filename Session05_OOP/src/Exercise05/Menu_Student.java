package Exercise05;

import java.util.Scanner;

public class Menu_Student {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        do{
            System.out.println("1. Hiển thị danh sách sinh viên");
            System.out.println("2. Thêm mới học sinh");
            System.out.println("3. Sửa thông tin học sinh theo mã sinh viên");
            System.out.println("4. Xóa học sinh dựa vào mã dinh viên");
            System.out.println("5. Thoát");

            System.out.println("Lựa chọn của bạn là: ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.err.println("Vui lòng lựa chọn từ 1 -> 5");
            }
        }while (true);
    }
}
