package Exercise05;

import java.util.Scanner;

public class Menu_Student {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Student[] students = new Student[100];
        int currenIndex = 0;

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
                    System.out.println("Danh sách sinh viên là: ");
                    for (int i = 0; i < currenIndex; i++) {
                        System.out.printf("%d. ", (i + 1));
                        students[i].displayData();
                    }
                    System.out.printf("\n");
                    break;
                case 2:
                    System.out.println("Nhập thông tin sinh viên muốn thêm: ");
                    students[currenIndex] = new Student();
                    students[currenIndex].inputData(scanner);
                    currenIndex++;
                    break;
                case 3:
                    System.out.print("Nhập mã sinh viên muốn sửa: ");
                    String inputId = scanner.nextLine();
                    for (int i = 0; i < currenIndex; i++) {
                        if (inputId.equals(students[i].getStudentId())){
                            System.out.printf("Nhập vào tên muốn sửa: ");
                            System.out.printf("\n");
                            students[i].setStudentName(scanner.nextLine());
                            System.out.printf("Nhập vào tuổi muốn sửa: ");
                            System.out.printf("\n");
                            students[i].setAge(Integer.parseInt(scanner.nextLine()));
                            System.out.printf("Nhập vào giới tính muốn sửa: ");
                            System.out.printf("\n");
                            students[i].setGen(Boolean.parseBoolean(scanner.nextLine()));
                            System.out.printf("Nhập vào địa chỉ muốn sửa: ");
                            students[i].setAddress(scanner.nextLine());
                            System.out.printf("\n");
                            System.out.printf("Nhập vào số điện thoại muốn sửa: ");
                            students[i].setPhoneNumber(scanner.nextLine());
                        }
                    }
                    System.out.printf("\n");
                    break;
                case 4:
                    System.out.print("Nhập mã sinh viên muốn xóa: ");
                    String deleteId = scanner.nextLine();
                    for (int i = 0; i < currenIndex; i++) {
                        if (deleteId.equals(students[i].getStudentId())){
                            students[i] = students[i + 1];
                            currenIndex--;
                        }
                    }
                    System.out.printf("\n");
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
