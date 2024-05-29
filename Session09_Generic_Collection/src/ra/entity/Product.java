package ra.entity;

import ra.IShop;
import ra.run.ShopManagement;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Product implements IShop {
    private String productId;
    private String productName;
    private float price;
    private String title;
    private int catalogId;
    private boolean status;

    public Product() {
    }

    public Product(String productId, String productName, float price, String title, int catalogId, boolean status) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.title = title;
        this.catalogId = catalogId;
        this.status = status;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public void inputData(Scanner scanner) {
        this.productId = inputProductId(scanner);
        this.productName = inputProductName(scanner);
        this.price = inputPrice(scanner);
        this.title = inputTitle(scanner);
        this.catalogId = inputCatalogId(scanner);
        this.status = inputProductStatus(scanner);
    }

    @Override
    public void displayData() {
        System.out.printf("productId: %s - Name: %s - Price: %.3f", this.productId, this.productName, this.price);
        System.out.printf(" - Title: %s - CatalogId: %d - Status: %b", this.title, this.catalogId, this.status);
        System.out.printf("\n");
    }

    public String inputProductId(Scanner scanner) {
        System.out.println("Nhập vào id sản phẩm");
        do {
            String productId = scanner.nextLine();
            String regexProductId = "[P][\\w]{4}";
            boolean isCheck = false;
            if (Pattern.matches(regexProductId, productId)) {
                for (Product product : ShopManagement.productList) {
                    if (product.getProductId().equals(productId)) {
                        isCheck = true;
                        break;
                    }
                }
                if (isCheck) {
                    System.err.println("Mã sản phẩm bị trùng lặp, vui lòng nhập lại");
                } else {
                    return productId;
                }
            } else {
                System.err.println("Id sản phẩm phải bắt đầu là P và gồm 5 ký tự, vui lòng nhập lại");
            }
        } while (true);
    }

    public String inputProductName(Scanner scanner) {
        System.out.println("Nhập vào tên sản phẩm");
        do {
            String productName = scanner.nextLine();
            boolean isCheck = false;

            for (Product product : ShopManagement.productList) {
                if (product.getProductName().equals(productName)) {
                    isCheck = true;
                    break;
                }
            }
            if (isCheck) {
                System.err.println("Tên sản phẩm bị trùng lặp, vui lòng nhập lại");
            } else {
                return productName;
            }

        } while (true);
    }

    public float inputPrice(Scanner scanner){
        System.out.println("Nhập vào giá của sản phẩm");
        do {
            float price = Float.parseFloat(scanner.nextLine());
            if (price > 0){
                return price;
            }else{
                System.err.println("Giá sản phẩm phải lớn hơn 0, vui lòng nhập lại");
            }
        }while (true);
    }

    public String inputTitle(Scanner scanner){
        System.out.println("Nhập tiêu đề sản phẩm");
        return title = scanner.nextLine();
    }

    public int inputCatalogId(Scanner scanner){
        System.out.println("Danh mục đang quản lý là: ");
        for (Categories categories: ShopManagement.categoriesList) {
            System.out.printf("%d. %s\n", categories.getCatalogId(), categories.getCatalogName());
        }
        System.out.println("Chọn danh mục");
        return Integer.parseInt(scanner.nextLine());
    }

    public boolean inputProductStatus(Scanner scanner){
        System.out.println("Nhập vào trạng thái sản phẩm");
        do {
            String productStatus = scanner.nextLine();
            if (productStatus.equals("true") || productStatus.equals("false")) {
                return Boolean.parseBoolean(productStatus);
            } else {
                System.err.println("Trạng thái sản phẩm chỉ nhận giá trị true hoặc false, vui lòng nhập lại");
            }
        }while (true);
    }
}
