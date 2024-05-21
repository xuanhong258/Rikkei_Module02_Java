package ra.run;

import ra.entity.Book;

import java.util.Scanner;

public class BookImp {
    Book[] books = new Book[1000];
    int currenIndex = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BookImp book = new BookImp();
        do {
            System.out.println("************MENU**************");
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

            switch (choose) {
                case 1:
                    book.inputBookInfo(scanner);
                    break;
                case 2:
                    book.profitEachBook();
                    break;
                case 3:
                    book.displayBookInfo();
                    System.out.printf("\n");
                    break;
                case 4:
                    book.sortByExportPrice();
                    System.out.printf("\n");
                    break;
                case 5:
                    book.sortByInterest();
                    System.out.printf("\n");
                    break;
                case 6:
                    book.findByBookName(scanner);
                    System.out.printf("\n");
                    break;
                case 7:
                    book.quantityOfBookByYear(scanner);
                    System.out.printf("\n");
                    break;
                case 8:
                    book.quantityOfBookByAuthor(scanner);
                    System.out.printf("\n");
                    break;
                case 9:
                    System.exit(0);
                    break;
                default:
                    System.err.println("Vui lòng chọn từ 1->9");
            }
        } while (true);
    }

    public void inputBookInfo(Scanner scanner) {
        System.out.println("Vui lòng nhập số lượng sách muốn nhập thông tin");
        int numberOfBook = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numberOfBook; i++) {
            books[currenIndex] = new Book();
            books[currenIndex].inputData(scanner, books, currenIndex);
            currenIndex++;
        }
    }

    public void profitEachBook() {
        for (int i = 0; i < currenIndex; i++) {
            books[i].profitBook();
        }
    }

    public void displayBookInfo() {
        for (int i = 0; i < currenIndex; i++) {
            books[i].displayData();
            System.out.printf("\n");
        }
    }

    public void sortByExportPrice() {
        for (int i = 0; i < currenIndex - 1; i++) {
            for (int j = i + 1; j < currenIndex; j++) {
                if (books[i].getExportPrice() > books[j].getExportPrice()) {
                    Book tmp = books[i];
                    books[i] = books[j];
                    books[j] = tmp;
                }
            }
        }
    }

    public void sortByInterest() {
        for (int i = 0; i < currenIndex - 1; i++) {
            for (int j = i + 1; j < currenIndex; j++) {
                if (books[i].getInterest() < books[j].getInterest()) {
                    Book tmp = books[i];
                    books[i] = books[j];
                    books[j] = tmp;
                }
            }
        }
    }

    public void findByBookName(Scanner scanner) {
        System.out.println("Nhập vào tên sách muốn tìm:");
        String bookName = scanner.nextLine();
        int index = -1;
        for (int i = 0; i < currenIndex; i++) {
            if (books[i].getBookName().equals(bookName)) {
                index = i;
                break;
            }
        }

        if (index >= 0) {
            books[index].displayData();
        } else {
            System.err.println("Không tìm thấy sách cần tìm");
        }
    }

    public void quantityOfBookByYear(Scanner scanner) {
        System.out.println("Nhập vào số năm xuất bản: ");
        int year = Integer.parseInt(scanner.nextLine());
        int quantity = 0;
        for (int i = 0; i < currenIndex; i++) {
            if (books[i].getYear() == year) {
                quantity++;
            }
        }
        if (quantity > 0) {
            System.out.printf("Số lượng sách xuất bản năm %d là: %d", year, quantity);
        } else {
            System.err.printf("Không có sách xuất bản năm %d", year);
        }
    }

    public void quantityOfBookByAuthor(Scanner scanner) {
        System.out.println("Nhập vào tên tác giả: ");
        String author = scanner.nextLine();
        int quantity = 0;
        for (int i = 0; i < currenIndex; i++) {
            if (books[i].getAuthor().equals(author)) {
                quantity++;
            }
        }

        if (quantity > 0) {
            System.out.printf("Số lượng sách của tác giả %s là: %d", author, quantity);
        } else {
            System.err.printf("Không có sách nào của tác giả %s", author);
        }
    }
}
