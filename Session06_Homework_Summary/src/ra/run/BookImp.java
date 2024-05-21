package ra.run;

import ra.entity.Book;

import java.util.Scanner;

public class BookImp {
    Book[] books = new Book[1000];
    int currenIndex = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BookImp book = new BookImp();
        do{
            System.out.println("1. Nhập thông tin n sách");
            System.out.println("2. Tính lợi nhuận các sách");
            System.out.println("3. Hiển thị thông tin sách");
            System.out.println("4. Sắp xếp theo giá bán tăng dần");

            System.out.println("5. Sắp xếp theo lợi nhuận giảm dần");
            System.out.println("6. Tìm sách theo tên sách");
            System.out.println("7. Thống kê số lượng sách theo năm xuất bản");
            System.out.println("8. Thống kê số lượng sách theo tác giả");
            System.out.println("9. Thoát");

            System.out.print("Lựa chọn của bạn là: ");

            int choose = Integer.parseInt(scanner.nextLine());

            switch (choose){
                case 1:
                    book.inputBookInfo(scanner);
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    System.exit(0);
                    break;
                default:
                    System.err.println("Vui lòng chọn từ 1->9");
            }
        }while (true);
    }

    public void inputBookInfo(Scanner scanner){
        System.out.println("Vui lòng nhập số lượng sách muốn nhập thông tin");
        currenIndex = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < currenIndex; i++) {
            books[i] = new Book();
            books[i].inputData(scanner, books, currenIndex);
        }
    }
}
