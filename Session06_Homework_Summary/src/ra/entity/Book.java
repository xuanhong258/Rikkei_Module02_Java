package ra.entity;

import java.util.Scanner;

public class Book {
    private String bookId;
    private String bookName;
    private float importPrice;
    private float exportPrice;
    private String author;
    private float interest;
    private int year;

    public Book() {
    }

    public Book(String bookId, String bookName, float importPrice, float exportPrice, String author, float interest, int year) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.author = author;
        this.interest = interest;
        this.year = year;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public float getInterest() {
        return interest;
    }

    public void setInterest(float interest) {
        this.interest = interest;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void inputData(Scanner scanner, Book[] books, int currentIndex) {
        this.bookId = inputBookId(scanner, books, currentIndex);
        this.bookName = inputBookName(scanner, books, currentIndex);
        this.importPrice = inputImportPrice(scanner);
        this.exportPrice = exportImportPrice(scanner);
        this.author = inputAuthor(scanner);
        this.year = yearInput(scanner);
    }


    public void displayData() {
        System.out.printf("Mã sách: %s - Tên sách: %s - Giá nhập: %.3f - Giá xuất: %.3f - Tác giả: %s", this.bookId, this.bookName, this.importPrice, this.exportPrice, this.author);
        System.out.printf(" - Lợi nhuận: %.3f - Năm xuất bản: %d", this.interest, this.year);
    }

    public String inputBookId(Scanner scanner, Book[] books, int currentIndex) {
        System.out.println("Nhập vào bookId:");
        boolean isCheck = false;
        do {
            String bookId = scanner.nextLine();
            for (int i = 0; i < currentIndex; i++) {
                if (bookId.equals(books[i].getBookId())) {
                    isCheck = true;
                    break;
                }
            }
            if (isCheck) {
                System.err.println("Mã sách đã bị trùng lặp, vui lòng nhập lại");
            } else {
                return bookId;
            }
        } while (true);
    }

    public String inputBookName(Scanner scanner, Book[] books, int currentIndex) {
        System.out.println("Nhập vào tên sách: ");
        do {
            boolean bookNameUnique = false;
            boolean bookLengthCheck = false;
            boolean bookStartWithB = false;
            String bookName = scanner.nextLine();
            for (int i = 0; i < currentIndex; i++) {
                if (bookName.equals(books[i].getBookName())) {
                    bookNameUnique = true;
                    break;
                }
            }

            if (bookNameUnique) {
                System.err.println("Tên sách bị trùng lặp, vui lòng nhập lại tên sách");
            }else{
                if (bookName.length() == 4) {
                    if (bookName.startsWith("B")) {
                        return bookName;
                    } else {
                        bookStartWithB = true;
                    }
                } else {
                    bookLengthCheck = true;
                }
            }
            if (bookLengthCheck) {
                System.err.println("Độ dài phải gồm 4 kí tự, vui lòng nhập lại");
            }
            if (bookStartWithB) {
                System.err.println("Phải bắt đầu bằng ký B, vui lòng nhập lại");
            }
        } while (true);
    }

    public float inputImportPrice(Scanner scanner) {
        System.out.println("Vui lòng nhập vào giá nhập của sách");
        do {
            float importPrice = Float.parseFloat(scanner.nextLine());
            if (importPrice > 0) {
                return importPrice;
            } else {
                System.err.println("Giá nhập của sách phải lớn hơn 0");
            }
        } while (true);
    }

    public float exportImportPrice(Scanner scanner) {
        System.out.println("Vui lòng nhập vào giá xuất của sách");
        do {
            float exportPrice = Float.parseFloat(scanner.nextLine());
            if (exportPrice >= 1.3 * this.importPrice) {
                return exportPrice;
            } else {
                System.err.println("Giá xuất của sách phải lớn hơn ít nhất 30% so với giá nhập");
            }
        } while (true);
    }

    public String inputAuthor(Scanner scanner) {
        System.out.println("Nhập vào tên tác giả: ");
        do {
            String author = scanner.nextLine();
            if (author.length() >= 6 && author.length() <= 50) {
                return author;
            } else {
                System.err.println("Độ dài tên tác giả phải từ 6-50 ký tự, vui lòng nhập lại");
            }
        } while (true);
    }

    public void profitBook() {
        this.interest = this.exportPrice - this.importPrice;
    }

    public int yearInput(Scanner scanner) {
        System.out.println("Vui lòng nhập vào năm xuất bản:");
        do {
            int year = Integer.parseInt(scanner.nextLine());
            if (year > 2000) {
                return year;
            } else {
                System.err.println("Năm xuất bản phải xuất bản sau năm 2000, vui lòng thử lại");
            }
        } while (true);
    }
}
