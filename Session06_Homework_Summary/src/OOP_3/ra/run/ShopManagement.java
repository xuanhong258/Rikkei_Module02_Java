package OOP_3.ra.run;

import OOP_3.ra.entity.Categories;
import OOP_3.ra.entity.Product;

import java.util.Scanner;

public class ShopManagement {
    static int indexCategorie = 0;
    static int indexProduct = 0;
    static Categories[] categories = new Categories[100];
    static Product[] products = new Product[100];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("******************SHOP MENU*******************");
            System.out.println("1. Quản lý danh mục sản phẩm");
            System.out.println("2. Quản lý sản phẩm");
            System.out.println("3. Kết thúc chương trình");
            System.out.println("Lựa chọn của bạn là: ");

            int choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
                    displayCategoriesMenu(scanner);
                    break;
                case 2:
                    displayProductMenu(scanner);
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    break;
            }
        } while (true);
    }

    public static void displayCategoriesMenu(Scanner scanner) {
        boolean flag = true;
        do {
            System.out.println("********************CATEGORIES MENU***********");
            System.out.println("1. Nhập thông tin danh mục");
            System.out.println("2. Hiển thị các thông tin các danh mục");
            System.out.println("3. Cập nhật thông tin danh mục");
            System.out.println("4. Xóa danh mục");
            System.out.println("5. Cập nhật trạng thái danh mục");
            System.out.println("6. Thoát");

            System.out.println("Nhập vào lựa chọn của bạn");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    inputCategoriesInfo(scanner);
                    break;
                case 2:
                    displayCategories();
                    break;
                case 3:
                    updateCategories(scanner);
                    break;
                case 4:
                    deleteCategories(scanner);
                    break;
                case 5:
                    updateCategoriesStatus(scanner);
                    break;
                case 6:
                    flag = false;
                    break;
                default:
                    System.err.println("Vui lòng lựa chọn từ 1 -> 6");
                    break;
            }
        } while (flag);
    }

    public static void inputCategoriesInfo(Scanner scanner) {
        System.out.println("Nhập vào số lượng danh mục muốn nhập");
        int quantityCategories = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < quantityCategories; i++) {
            categories[indexCategorie] = new Categories();
            categories[indexCategorie].inputData(scanner, categories, indexCategorie);
            indexCategorie++;
        }
    }

    public static void displayCategories() {
        for (int i = 0; i < indexCategorie; i++) {
            categories[i].displayData();
            System.out.print("\n");
        }
    }

    public static int indexCatalogId(int catalogId) {
        int index = -1;
        for (int i = 0; i < indexCategorie; i++) {
            if (categories[i].getCatalogId() == catalogId) {
                index = i;
            }
        }
        return index;
    }

    public static void updateCategories(Scanner scanner) {
        boolean flag = false;
        System.out.println("Nhập vào mã danh mục muốn cập nhật");
        int catalogId = Integer.parseInt(scanner.nextLine());

        int index = indexCatalogId(catalogId);

        if (index >= 0) {
            flag = true;
        }else {
            System.err.println("Mã danh mục không tồn tại, vui lòng nhập lại");
        }
        do {
            System.out.println("Vui lòng lựa chọn mục muốn cập nhật cho danh mục");
            System.out.println("1. Cập nhật mô tả danh mục");
            System.out.println("2. Cập nhật tên danh mục");
            System.out.println("3. Cập nhật trạng thái danh mục");
            System.out.println("4. Thoát cập nhật");
            System.out.println("Lựa chọn của bạn là");
            int yourChoice = Integer.parseInt(scanner.nextLine());

            switch (yourChoice) {
                case 1:
                    System.out.println("Cập nhật mô tả danh mục là: ");
                    String updateDescription = scanner.nextLine();
                    categories[index].setDescriptions(updateDescription);
                    break;
                case 2:
                    System.out.println("cập nhật tên danh mục là: ");
                    String updateName = scanner.nextLine();
                    categories[index].setCatalogName(updateName);
                    break;
                case 3:
                    System.out.println("Cập nhật trạng thái danh mục là:");
                    boolean updateStatus = Boolean.parseBoolean(scanner.nextLine());
                    categories[index].setCatalogStatus(updateStatus);
                    break;
                case 4:
                    flag = false;
                    break;
                default:
                    System.err.println("Vui lòng lựa chọn từ 1 -> 4");
                    break;
            }
        } while (flag);
    }

    public static void deleteCategories(Scanner scanner) {
        System.out.println("Nhập vào mã danh mục cần xóa");
        int catalogId = Integer.parseInt(scanner.nextLine());

        int index = indexCatalogId(catalogId);
        int count = 0;

        for (int i = 0; i < indexProduct; i++) {
            if (products[i].getCatalogId() == catalogId) {
                count++;
            }
        }

        if (count == 0) {
            for (int i = index; i < indexCategorie; i++) {
                categories[i] = categories[i + 1];
            }
            indexCategorie--;
        } else {
            System.err.println("Không thể xóa danh mục, vì danh mục có chứa sản phẩm");
        }

    }

    public static void updateCategoriesStatus(Scanner scanner) {
        System.out.println("Nhập vào mã danh mục cần cập nhật trạng thái");
        int catalogId = Integer.parseInt(scanner.nextLine());
        int index = indexCatalogId(catalogId);
        categories[index].setCatalogStatus(!categories[index].isCatalogStatus());
    }

    //-----------------------Product Menu----------------------------------

    public static void displayProductMenu(Scanner scanner) {
        boolean flag = true;
        do {
            System.out.println("*****************PRODUCT MENU***********");
            System.out.println("1. Nhập thông tin các sản phẩm");
            System.out.println("2. Hiển thị các thông tin các sản phẩm");
            System.out.println("3. Sắp xếp các sản phẩm theo giá");
            System.out.println("4. Cập nhật thông tin sản phẩm theo mã sản phẩm");
            System.out.println("5. Xóa sản phẩm theo mã sản phẩm");
            System.out.println("6. Tìm kiếm các sản phẩm theo tên sản phẩm");
            System.out.println("7. Tìm kiếm sản phẩm trong khoảng giá a – b (a,b nhập từ bàn phím)");
            System.out.println("8. Thoát");

            System.out.println("Nhập vào lựa chọn của bạn");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    inputProductInfo(scanner);
                    break;
                case 2:
                    displayProduct();
                    break;
                case 3:
                    sortProductByPrice();
                    break;
                case 4:
                    updateProduct(scanner);
                    break;
                case 5:
                    deleteProduct(scanner);
                    break;
                case 6:
                    findProductByName(scanner);
                    break;
                case 7:
                    findProductByPrice(scanner);
                    break;
                case 8:
                    flag = false;
                    break;
                default:
                    System.err.println("Vui lòng lựa chọn từ 1 -> 6");
                    break;
            }
        } while (flag);
    }

    public static void inputProductInfo(Scanner scanner) {
        System.out.println("Nhập vào số lượng sản phẩm muốn nhập thông tin");
        int productQuantity = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < productQuantity; i++) {
            products[indexProduct] = new Product();
            products[indexProduct].inputData(scanner, products, indexProduct, categories, indexCategorie);
        }
    }

    public static void displayProduct() {
        for (int i = 0; i < indexProduct; i++) {
            products[i].displayData();
            System.out.println("\n");
        }
    }

    public static void sortProductByPrice(){
        for (int i = 0; i < indexProduct - 1; i++) {
            for (int j = i + 1; j < indexProduct; j++) {
                if(products[i].getPrice() > products[j].getPrice()){
                    Product tmp = products[i];
                    products[i] = products[j];
                    products[j] = tmp;
                }
            }
        }
    }

    public static int indexProductId(String productId) {
        int index = -1;
        for (int i = 0; i < indexProduct; i++) {
            if (products[i].getProductId().equals(productId)) {
                index = i;
            }
        }
        return index;
    }

    public static void updateProduct(Scanner scanner){
        System.out.println("Nhập mã sản phẩm muốn cập nhật gồm 4 ký tự bắt đầu là một trong 3 ký tự (C, S, A)");
        String productId = scanner.nextLine();
        int index = indexProductId(productId);
        boolean flag = false;
        if (index >= 0) {
            flag = true;
        }else {
            System.err.println("Mã sản phẩm không tồn tại, vui lòng nhập lại");
        }
        do {
            System.out.println("Vui lòng lựa chọn mục muốn cập nhật cho sản phẩm");
            System.out.println("1. Cập nhật tên sản phẩm");
            System.out.println("2. Cập nhật giá sản phẩm");
            System.out.println("3. Cập nhật mô tả sản phẩm");
            System.out.println("4. Cập nhật ngày nhập sản phẩm");
            System.out.println("5. Cập nhật danh mục của sản phẩm");
            System.out.println("6. Cập nhật trạng thái sản phẩm");
            System.out.println("7. Thoát cập nhật");
            System.out.println("Lựa chọn của bạn là");
            int yourChoice = Integer.parseInt(scanner.nextLine());

            switch (yourChoice) {
                case 1:
                    System.out.println("Cập nhật tên sản phẩm ");
                    String updateName = scanner.nextLine();
                    products[index].setProductName(updateName);
                    break;
                case 2:
                    System.out.println("Cập nhật giá sản phẩm: ");
                    float updatePrice = Float.parseFloat(scanner.nextLine());
                    products[index].setPrice(updatePrice);
                    break;
                case 3:
                    System.out.println("Cập nhật mô tả sản phẩm: ");
                    String updateProductDescription = scanner.nextLine();
                    products[index].setDescriptions(updateProductDescription);
                    break;
                case 4:
                    System.out.println("Cập nhật ngày nhập sản phẩm:");
                    String updateCreated = scanner.nextLine();
                    products[index].setCreated(updateCreated);
                    break;
                case 5:
                    System.out.println("Cập nhật danh mục của sản phẩm:");
                    int updateProductCategory = Integer.parseInt(scanner.nextLine());
                    products[index].setCatalogId(updateProductCategory);
                    break;
                case 6:
                    System.out.println("Cập nhật trạng thái của sản phẩm 0,1,2:");
                    int updateProductStatus = Integer.parseInt(scanner.nextLine());
                    products[index].setProductStatus(updateProductStatus);
                    break;
                case 7:
                    flag = false;
                    break;
                default:
                    System.err.println("Vui lòng lựa chọn từ 1 -> 7");
                    break;
            }
        } while (flag);
    }

    public static void deleteProduct(Scanner scanner){
        System.out.println("Nhập mã sản phẩm muốn xóa");
        String productId = scanner.nextLine();

        int index = indexProductId(productId);
        if (index >= 0) {
            for (int i = index; i < indexProduct; i++) {
                products[i] = products[i + 1];
            }
            indexProduct--;
        }else {
            System.err.println("Mã sản phẩm không tồn tại, vui lòng nhập lại");
        }
    }

    public static void findProductByName(Scanner scanner){
        System.out.println("Nhập vào tên sản phẩm muốn tìm kiếm");
        String productName = scanner.nextLine();
        int index = -1;
        for (int i = 0; i < indexProduct; i++) {
           if(products[i].getProductName().equals(productName)){
               index = i;
               break;
           }
        }
        if (index >= 0){
            products[index].displayData();
        }else {
            System.err.println("Tên sản phẩm không tồn tại, vui lòng nhập lại");
        }
    }

    public static void findProductByPrice(Scanner scanner){
        boolean flag = true;
        do {
            System.out.println("Nhập vào giá đầu tiên");
            float priceNumber1 = Float.parseFloat(scanner.nextLine());
            System.out.println("Nhập vào giá thứ 2");
            float priceNumber2 = Float.parseFloat(scanner.nextLine());
            if (priceNumber2 > priceNumber1){
                flag = false;

                for (int i = 0; i < indexProduct; i++) {
                    if(products[i].getPrice() >= priceNumber1 && products[i].getPrice() <= priceNumber2){
                        products[i].displayData();
                        System.out.print("\n");
                    }
                }
            }else {
                System.err.println("Giá trị thứ 2 phải lớn hơn giá trị thứ nhất, vui lòng nhập lại");
            }
        }while (flag);
    }

}
