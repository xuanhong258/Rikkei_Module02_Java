package ra.entity;

import java.util.Scanner;

public class Product {
    private String productId;
    private String productName;
    private float productPrice;
    private String productTitle;
    private int catalogId;
    private boolean productStatus;

    public Product() {
    }

    public Product(String productId, String productName, float productPrice, String productTitle, int catalogId, boolean productStatus) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productTitle = productTitle;
        this.catalogId = catalogId;
        this.productStatus = productStatus;
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

    public float getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(float productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public boolean isProductStatus() {
        return productStatus;
    }

    public void setProductStatus(boolean productStatus) {
        this.productStatus = productStatus;
    }

    public void inputData(Scanner scanner){
        System.out.println("Nhập vào mã sản phẩm");
        this.productId = scanner.nextLine();
        System.out.println("Nhập vào tên sản phẩm");
        this.productName = scanner.nextLine();
        System.out.println("Nhập vào giá sản phẩm");
        this.productPrice = Float.parseFloat(scanner.nextLine());
        System.out.println("Nhập vào mô tả sản phẩm");
        this.productTitle = scanner.nextLine();
        System.out.println("Nhập vào mã danh mục của sản phẩm");
        this.catalogId = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập vào trạng thái sản phẩm");
        this.productStatus = Boolean.parseBoolean(scanner.nextLine());
    }

    public void displayData(){
        System.out.printf("Mã sản phẩm: %s - Tên SP: %s - Giá: %.2f - Mô tả: %s", this.productId, this.productName, this.productPrice, this.productTitle);
        System.out.printf(" - Mã danh mục: %d - Trạng thái: %s", this.catalogId, this.productStatus ? "Còn hàng": "Hết hàng");
        System.out.print("\n");
    }
}
