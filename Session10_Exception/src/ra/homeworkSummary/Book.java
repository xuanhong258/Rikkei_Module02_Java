package ra.homeworkSummary;

import java.util.Calendar;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Book implements IEntity {
    private String id;
    private String title;
    private String author;
    private String publisher;
    private int year;
    private String description;
    private int categoryId;

    public Book() {
    }

    public Book(String id, String title, String author, String publisher, int year, String description, int categoryId) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.year = year;
        this.description = description;
        this.categoryId = categoryId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public void input(Scanner scanner) {
        this.id = inputId(scanner);
        this.title = inputTitle(scanner);
        this.author = inputAuthor(scanner);
        this.publisher = inputPublisher(scanner);
        this.year = inputYear(scanner);
        this.description = inputDescription(scanner);
        this.categoryId = inputCategoryId(scanner);
    }

    @Override
    public void output() {
        System.out.printf("ID: %s - Title: %s - Author: %s", this.id, this.title, this.author);
        System.out.printf(" - Tác giả: %s - NXB: %d - Mô tả: %s", this.publisher, this.year, this.description);
        for (Category category : Library.categoryList) {
            if (category.getId() == this.categoryId) {
                System.out.printf(" - Tên danh mục: %s", category.getName());
                break;
            }
        }
        System.out.printf("\n");
    }

    public String inputId(Scanner scanner) {
        System.out.println("Nhập vào mã sách");
        do {
            String id = scanner.nextLine();
            String idRegex = "[B][\\w]{3}";
            if (!id.isEmpty()) {
                if (Pattern.matches(idRegex, id)) {
                    boolean isCheck = false;
                    for (Book book : Library.bookList) {
                        if (book.equals(id)) {
                            isCheck = true;
                            break;
                        }
                    }
                    if (isCheck) {
                        System.err.println("Mã sách đã tồn tại, vui lòng nhập lại");
                    } else {
                        return id;
                    }
                } else {
                    System.err.println("Mã sách phải bắt đầu bằng chữ B và có 4 ký tự, vui lòng nhập lại");
                }
            } else {
                System.err.println("Không để trống mã sách, vui lòng nhập lại");
            }
        } while (true);
    }

    public String inputTitle(Scanner scanner) {
        System.out.println("Nhập vào tiêu đề sách");
        do {
            String title = scanner.nextLine();
            String idRegex = "[\\w[\\s]]{6,50}";
            if (!title.isEmpty()) {
                if (Pattern.matches(idRegex, title)) {
                    boolean isCheck = false;
                    for (Book book : Library.bookList) {
                        if (book.equals(title)) {
                            isCheck = true;
                            break;
                        }
                    }
                    if (isCheck) {
                        System.err.println("Tiêu đề sách đã tồn tại, vui lòng nhập lại");
                    } else {
                        return title;
                    }
                } else {
                    System.err.println("Tiêu đề sách phải dài từ 6 -> 50 ký tự, vui lòng nhập lại");
                }
            } else {
                System.err.println("Không được để trống tên sách, vui lòng nhập lại");
            }

        } while (true);
    }

    public String inputAuthor(Scanner scanner) {
        System.out.println("Vui lòng nhập vào tên tác giả");
        do {
            String author = scanner.nextLine();
            if (!author.isEmpty()) {
                return author;
            } else {
                System.err.println("Không được để trống tên tác giả, vui lòng nhập lại");
            }
        } while (true);
    }

    public String inputPublisher(Scanner scanner) {
        System.out.println("Vui lòng nhập vào tên nhà xuất bản");
        do {
            String publisher = scanner.nextLine();
            if (!publisher.isEmpty()) {
                return publisher;
            } else {
                System.err.println("Không được để trống nhà xuất bản, vui lòng nhập lại");
            }
        } while (true);
    }

    public int inputYear(Scanner scanner) {
        System.out.println("Nhập vào năm xuất bản");

        do {
            try {
                Calendar instance = Calendar.getInstance();
                int yearNow = instance.get(Calendar.YEAR);

                int year = Integer.parseInt(scanner.nextLine());

                if (year >= 1970 && year <= yearNow) {
                    return year;
                } else {
                    System.err.println("Năm xuất bản phải lớn hơn 1970 và nhỏ hơn năm hiện tại, vui lòng nhập lại");
                }
            } catch (Exception ex) {
                System.err.println("Năm xuất bản chưa đúng định dạng, vui lòng nhập lại");
            }
        } while (true);
    }

    public String inputDescription(Scanner scanner) {
        System.out.println("Vui lòng nhập vào mô tả sách");
        do {
            String description = scanner.nextLine();
            if (!description.isEmpty()) {
                return description;
            } else {
                System.err.println("Không được để trống mô tả sách, vui lòng nhập lại");
            }
        } while (true);
    }

    public int inputCategoryId(Scanner scanner) {
        System.out.println("Mã danh mục hiện có là:");
        for (Category category : Library.categoryList) {
            System.out.printf("ID: %d. %s", category.getId(), category.getName());
            System.out.printf("\n");
        }
        System.out.println("Vui lòng nhập vào mã danh mục cho sách");
        do {
            try {
                int categoryId = Integer.parseInt(scanner.nextLine());
                boolean isCheck = false;
                for (Category category : Library.categoryList) {
                    if (category.getId() == categoryId) {
                        isCheck = true;
                        break;
                    }
                }
                if (isCheck) {
                    return categoryId;
                } else {
                    System.err.println("Mã danh mục vừa nhập không có trong mã danh mục đã lưu,vui lòng nhập lại");
                }
            } catch (NumberFormatException ate) {
                System.err.println("Mã danh mục phải là số nguyên");
            } catch (Exception ex) {
                System.err.println("Không được để trống mã danh mục");
            }
        } while (true);
    }
}
