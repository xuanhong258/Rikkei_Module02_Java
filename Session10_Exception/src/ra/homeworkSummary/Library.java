package ra.homeworkSummary;

import java.util.*;

public class Library {
    public static List<Category> categoryList = new ArrayList<>();
    public static List<Book> bookList = new ArrayList<>();


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("=========== QUẢN LÝ THƯ VIỆN ===========");
            System.out.println("1. Quản lý Thể loại");
            System.out.println("2. Quản lý Sách");
            System.out.println("3. Thoát");
            System.out.print("Lựa chọn của bạn là: ");
            boolean isCheck = true;
            do {
                try {
                    int choice = Integer.parseInt(scanner.nextLine());
                    if (choice > 0) {
                        switch (choice) {
                            case 1:
                                categoryMenu(scanner);
                                break;
                            case 2:
                                bookMenu(scanner);
                                break;
                            case 3:
                                System.exit(0);
                            default:
                                System.err.println("Vui lòng nhập từ 1 -> 3");
                                break;
                        }
                        isCheck = false;
                    } else {
                        System.err.println("Vui lòng nhập vào số nguyên lớn hơn 0");
                    }
                } catch (NumberFormatException ate) {
                    System.err.println("Vui lòng nhập vào số nguyên");
                }
            } while (isCheck);
        } while (true);
    }

    //-------------------------CATEGORY MENU----------------------------------------------
    public static void categoryMenu(Scanner scanner) {
        boolean isExit = true;
        do {
            System.out.println("=========== QUẢN LÝ THỂ LOẠI ===========");
            System.out.println("1. Thêm mới thể loại");
            System.out.println("2. Hiển thị danh sách theo tên A - Z");
            System.out.println("3. Thống kê thể loại và số sách có trong mỗi thể loại");
            System.out.println("4. Cập nhật thể loại");
            System.out.println("5. Xóa thể loại");
            System.out.println("6. Quay lại");
            System.out.print("Lựa chọn của bạn là: ");
            boolean isCheck = true;
            do {
                try {
                    int choice = Integer.parseInt(scanner.nextLine());
                    if (choice > 0) {
                        switch (choice) {
                            case 1:
                                addNewCategory(scanner);
                                break;
                            case 2:
                                System.out.println("DANH MỤC ĐƯỢC SẮP XẾP TỪ A-Z LÀ:");
                                displayCategory();
                                break;
                            case 3:
                                statisticCategoryAndBook();
                                break;
                            case 4:
                                updateCategory(scanner);
                                break;
                            case 5:
                                deleteCategory(scanner);
                                break;
                            case 6:
                                isExit = false;
                                break;
                            default:
                                System.err.println("Vui lòng nhập từ 1 -> 6");
                                break;
                        }
                        isCheck = false;
                    } else {
                        System.err.println("Vui lòng nhập vào số nguyên lớn hơn 0");
                    }
                } catch (NumberFormatException ate) {
                    System.err.println("Vui lòng nhập vào số nguyên");
                }
            } while (isCheck);
        } while (isExit);
    }

    public static void addNewCategory(Scanner scanner) {
        Category category = new Category();
        category.input(scanner);
        categoryList.add(category);
    }

    public static void displayCategory() {
        categoryList.stream().sorted(Comparator.comparing(Category::getName)).forEach(System.out::println);
    }

    public static void statisticCategoryAndBook() {
        for (Category category : categoryList) {
            int sum = 0;
            for (Book book : bookList) {
                if (category.getId() == book.getCategoryId()) {
                    sum++;
                }
            }
            System.out.printf("ID Danh mục: %d - Tên danh mục: %s - Số sách thuộc thể loại %s là: %d", category.getId(), category.getName(), category.getName(), sum);
            System.out.printf("\n");
        }
    }

    public static void updateCategory(Scanner scanner) {
        System.out.println("Danh mục hiện đang quản lý là: ");
        displayCategory();
        System.out.println("Nhập vào mã danh mục muốn cập nhật");
        boolean isCheck = true;
        try {
            int categoryId = Integer.parseInt(scanner.nextLine());
            for (Category category : categoryList) {
                if (category.getId() == categoryId) {
                    isCheck = false;
                    choiceItemUpdateCategory(scanner, category);
                    break;
                }
            }
            if (isCheck) {
                System.err.println("Mã danh mục không tồn tại, vui lòng nhập lại");
            }
        } catch (NumberFormatException nfe) {
            System.err.println("Yêu cầu nhập vào số nguyên, vui lòng nhập lại");
        }
    }

    public static void choiceItemUpdateCategory(Scanner scanner, Category category) {
        boolean isCheck = true;
        do {
            System.out.println("1. Cập nhật tên danh mục");
            System.out.println("2. Cập nhật trạng thái danh mục");
            System.out.println("3. Thoát");
            System.out.print("Lựa chọn của bạn là: ");
            boolean isExit = true;
            do {
                try {
                    int choice = Integer.parseInt(scanner.nextLine());
                    if (choice > 0) {
                        switch (choice) {
                            case 1:
                                System.out.println("Nhập vào tên mới của danh mục");
                                String newCategoryName = scanner.nextLine();
                                category.setName(newCategoryName);
                                System.out.println("----CẬP NHẬT THÀNH CÔNG-----");
                                break;
                            case 2:
                                System.out.println("Nhập vào trạng thái mới của danh mục");
                                String newStatus = scanner.nextLine();
                                if (newStatus.equals("true") || newStatus.equals("false")) {
                                    category.setStatus(Boolean.parseBoolean(newStatus));
                                } else {
                                    System.err.println("Trạng thái của danh mục phải là true hoặc false, vui lòng nhập lại");
                                }
                                System.out.println("----CẬP NHẬT THÀNH CÔNG-----");
                                break;
                            case 3:
                                isCheck = false;
                                break;
                            default:
                                System.err.println("Vui lòng nhập từ 1 -> 3, vui lòng nhập lại");
                                break;
                        }
                        isExit = false;
                    } else {
                        System.err.println("Số nhập vào phải lớn hơn 0, vui lòng nhập lại");
                    }
                } catch (NumberFormatException nfe) {
                    System.err.println("Dữ liệu nhập vào phải là 1 số nguyên");
                }
            } while (isExit);
        } while (isCheck);
    }

    public static void deleteCategory(Scanner scanner) {
        System.out.println("Danh mục hiện đang quản lý là: ");
        displayCategory();
        System.out.println("Nhập vào mã danh mục muốn xóa");
        boolean isCheck = true;
        try {
            int categoryId = Integer.parseInt(scanner.nextLine());
            for (Category category : categoryList) {
                if (category.getId() == categoryId) {
                    isCheck = false;
                    categoryList.remove(category);
                    break;
                }
            }
            if (isCheck) {
                System.err.println("Mã danh mục không tồn tại, vui lòng nhập lại");
            }
        } catch (NumberFormatException nfe) {
            System.err.println("Yêu cầu nhập vào số nguyên, vui lòng nhập lại");
        }
    }

    //-----------------------BOOK MENU------------------------------------------------------
    public static void bookMenu(Scanner scanner) {
        boolean isExit = true;
        do {
            System.out.println("=========== QUẢN LÝ SÁCH ===========");
            System.out.println("1. Thêm mới sách");
            System.out.println("2. Cập nhật thông tin sách");
            System.out.println("3. Xóa sách");
            System.out.println("4. Tìm kiếm sách");
            System.out.println("5. Hiển thị danh sách sách theo nhóm thể loại");
            System.out.println("6. Quay lại");
            System.out.print("Lựa chọn của bạn là: ");
            boolean isCheck = true;
            do {
                try {
                    int choice = Integer.parseInt(scanner.nextLine());
                    if (choice > 0) {
                        switch (choice) {
                            case 1:
                                addNewBook(scanner);
                                break;
                            case 2:
                                updateBook(scanner);
                                break;
                            case 3:
                                deleteBook(scanner);
                                break;
                            case 4:
                                searchBook(scanner);
                                break;
                            case 5:
                                displayBookByCategory();
                                break;
                            case 6:
                                isExit = false;
                                break;
                            default:
                                System.err.println("Vui lòng nhập từ 1 -> 6");
                                break;
                        }
                        isCheck = false;
                    } else {
                        System.err.println("Vui lòng nhập vào số nguyên lớn hơn 0");
                    }
                } catch (NumberFormatException ate) {
                    System.err.println("Vui lòng nhập vào số nguyên");
                }
            } while (isCheck);
        } while (isExit);
    }

    public static void addNewBook(Scanner scanner) {
        Book book = new Book();
        book.input(scanner);
        bookList.add(book);
    }

    public static void displayBook() {
        for (Book book : bookList) {
            book.output();
        }
    }

    public static void updateBook(Scanner scanner) {
        System.out.println("Sách hiện đang quản lý là: ");
        displayBook();
        System.out.println("Nhập vào mã sách muốn cập nhật");
        boolean isCheck = true;
        String bookId = scanner.nextLine();

        if (!bookId.isEmpty()) {
            for (Book book : bookList) {
                if (book.getId().equals(bookId)) {
                    isCheck = false;
                    choiceItemUpdateBook(scanner, book);
                    break;
                }
            }
            if (isCheck) {
                System.err.println("Mã sách không tồn tại, vui lòng nhập lại");
            }
        } else {
            System.err.println("Mã sách không được để trống, vui lòng nhập lại");
        }

    }

    public static void choiceItemUpdateBook(Scanner scanner, Book book) {
        boolean isCheck = true;
        do {
            System.out.println("1. Cập nhật tiêu đề sách");
            System.out.println("2. Cập nhật tên tác giả");
            System.out.println("3. Cập nhật nhà xuất bản");
            System.out.println("4. Cập nhật năm xuất bản");
            System.out.println("5. Cập nhật mô tả sách");
            System.out.println("6. Cập nhật mã thể loại sách");
            System.out.println("7. Thoát");
            System.out.print("Lựa chọn của bạn là: ");
            boolean isExit = true;
            do {
                try {
                    int choice = Integer.parseInt(scanner.nextLine());
                    if (choice > 0) {
                        switch (choice) {
                            case 1:
                                System.out.println("Nhập vào tiêu đề mới của sách");
                                String newBookTitle = scanner.nextLine();
                                if (!newBookTitle.isEmpty()) {
                                    book.setTitle(newBookTitle);
                                } else {
                                    System.err.println("Không được để trống tiêu đề sách, vui lòng nhập lại");
                                }
                                break;
                            case 2:
                                System.out.println("Nhập vào tên tác giả mới của sách");
                                String newBookAuthor = scanner.nextLine();
                                if (!newBookAuthor.isEmpty()) {
                                    book.setAuthor(newBookAuthor);
                                } else {
                                    System.err.println("Không được để trống tên tác giả, vui lòng nhập lại");
                                }
                                break;
                            case 3:
                                System.out.println("Nhập vào nhà xuất bản mới của sách");
                                String newBookPublisher = scanner.nextLine();
                                if (!newBookPublisher.isEmpty()) {
                                    book.setPublisher(newBookPublisher);
                                } else {
                                    System.err.println("Không được để trống nhà xuất bản, vui lòng nhập lại");
                                }
                                break;
                            case 4:
                                System.out.println("Nhập vào năm xuất bản mới của sách");
                                try {
                                    Calendar instance = Calendar.getInstance();
                                    int yearNow = instance.get(Calendar.YEAR);

                                    int newYear = Integer.parseInt(scanner.nextLine());
                                    if (newYear >= 1970 && newYear <= yearNow) {
                                        book.setYear(newYear);
                                    } else {
                                        System.err.println("Năm xuất bản phải lớn hơn 1970 và nhỏ hơn năm hiện tại, vui lòng nhập lại");
                                    }
                                } catch (NumberFormatException nfe) {
                                    System.err.println("Năm xuất bản phải là số nguyên, vui lòng nhập lại");
                                }
                                break;
                            case 5:
                                System.out.println("Nhập vào mô tả mới của sách");
                                String newBookDescription = scanner.nextLine();
                                if (!newBookDescription.isEmpty()) {
                                    book.setDescription(newBookDescription);
                                } else {
                                    System.err.println("Không được để trống mô tả sách, vui lòng nhập lại");
                                }
                                break;
                            case 6:
                                System.out.println("Danh mục hiện đang quản lý là");
                                for (Category category : categoryList) {
                                    System.out.printf("ID: %d - Name: %s", category.getId(), category.getName());
                                    System.out.printf("\n");
                                }

                                System.out.println("Vui lòng chọn 1 danh mục hiện có để cập nhật cho danh mục cũ của sách");
                                try {
                                    int newCategoryId = Integer.parseInt(scanner.nextLine());
                                    boolean flag = false;
                                    for (Category category : categoryList) {
                                        if (newCategoryId == category.getId()) {
                                            flag = true;
                                            break;
                                        }
                                    }
                                    if (flag) {
                                        book.setCategoryId(newCategoryId);
                                    } else {
                                        System.err.println("Mã danh mục không trùng với mã danh mục hiện có, vui lòng nhập lại");
                                    }
                                } catch (NumberFormatException nfe) {
                                    System.err.println("Mã danh mục phải là số nguyên, vui lòng nhập lại");
                                }
                                break;
                            case 7:
                                isCheck = false;
                                break;
                            default:
                                System.err.println("Vui lòng nhập từ 1 -> 7, vui lòng nhập lại");
                                break;
                        }
                        isExit = false;
                    } else {
                        System.err.println("Số nhập vào phải lớn hơn 0, vui lòng nhập lại");
                    }
                } catch (NumberFormatException nfe) {
                    System.err.println("Dữ liệu nhập vào phải là 1 số nguyên");
                }
            } while (isExit);
        } while (isCheck);
    }

    public static void deleteBook(Scanner scanner) {
        System.out.println("Danh sách sách hiện đang quản lý là: ");
        displayBook();
        System.out.println("Nhập vào mã danh sách muốn xóa");
        boolean isCheck = true;

        String bookId = scanner.nextLine();
        if(!bookId.isEmpty()){
            for (Book book : bookList) {
                if (book.getId().equals(bookId)) {
                    isCheck = false;
                    bookList.remove(book);
                    break;
                }
            }
            if (isCheck) {
                System.err.println("Mã danh mục không tồn tại, vui lòng nhập lại");
            }
        }else {
            System.err.println("Không được để trống mã sách, vui lòng nhập lại ");
        }
    }

    public static void searchBook(Scanner scanner){
        System.out.println("Nhập vào nội dung muốn tìm kiếm");

        String inputSearch = scanner.nextLine();

        if (!inputSearch.isEmpty()){
            int cnt = 0;
            for (Book book : bookList){
                if (book.getTitle().contains(inputSearch) || book.getAuthor().contains(inputSearch) || book.getPublisher().contains(inputSearch)){
                    cnt++;
                    book.output();
                }
            }
            if(cnt == 0){
                System.err.println("Không có sách nào tìm thấy, vui lòng nhập lại");
            }
        }else {
            System.err.println("Không được để trống trường tìm kiếm, vui lòng nhập lại");
        }
    }

    public static void displayBookByCategory(){
        for (Category category : categoryList){
            List<Book> bookWithCategory = new ArrayList<>();
            for (Book book: bookList){
                if (category.getId() == book.getCategoryId()){
                    Book tmp = book;
                    bookWithCategory.add(tmp);
                }
            }
            System.out.printf("%s: \n", category.getName());
            for (Book book : bookWithCategory){
                System.out.printf("\t%s\n", book.getTitle());
            }
            System.out.printf("\n");
        }
    }
}
