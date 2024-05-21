package ra.entity;

import java.util.Scanner;

public class Product {
    private String productId;
    private String productName;
    private float importPrice;
    private float exportPrice;
    private float profit;
    private int quantity;
    private String descriptions;
    private boolean status;

    public Product() {
    }

    public Product(String productId, String productName, float importPrice, float exportPrice, float profit, int quantity, String descriptions, boolean status) {
        this.productId = productId;
        this.productName = productName;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.profit = profit;
        this.quantity = quantity;
        this.descriptions = descriptions;
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

    public float getProfit() {
        return profit;
    }

    public void setProfit(float profit) {
        this.profit = profit;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void inputData(Scanner scanner, Product[] arrProduct, int currentIndex) {
        this.productId = inputProductId(scanner, arrProduct, currentIndex);
        this.productName = inputProductName(scanner, arrProduct, currentIndex);
        this.importPrice = inputImportPrice(scanner);
        this.exportPrice = inputExportPrice(scanner);
        this.quantity = inputQuantity(scanner);
        this.descriptions = inputDescriptions(scanner);
        this.status = inputStatus(scanner);
    }

    public void displayData(){
        System.out.printf("Mã sản phẩm: %s - Tên sản phẩm: %s - Giá nhập: %.3f - Giá xuất: %.3f", this.productId, this.productName, this.importPrice, this.exportPrice);
        System.out.printf(" - Lợi nhuận: %.3f - Số lượng: %d - Mô tả: %s - Status: %s", this.profit, this.quantity, this.descriptions, this.status?"Đang bán":"Không bán");
        System.out.printf("\n");
    }

    public String inputProductId(Scanner scanner, Product[] arrProduct, int currentIndex) {
        System.out.println("Nhập id sản phẩm:");
        do {
            boolean productIdCheck = true;
            String productId = scanner.nextLine();
            for (int i = 0; i < currentIndex; i++) {
                if(arrProduct[i].getProductId().equals(productId)){
                    productIdCheck = false;
                    break;
                }
            }
            if(productIdCheck){
                if (productId.length() == 4){
                    return productId;
                }else{
                    System.err.println("Mã sản phẩm gồm 4 ký tự, vui lòng nhập lại");
                }
            }else{
                System.err.println("Id sản phẩm bị trùng, vui lòng nhập lại");
            }
        } while (true);
    }

    public String inputProductName(Scanner scanner, Product[] arrProduct, int currentIndex){
        System.out.println("Nhập vào tên sản phẩm");
        do{
            String productName = scanner.nextLine();
            boolean productNameCheck = true;
            for (int i = 0; i < currentIndex; i++) {
                if(arrProduct[i].getProductName().equals(productName)){
                    productNameCheck = false;
                    break;
                }
            }
            if(productNameCheck){
                if (productName.length() >= 6 && productName.length() <= 50){
                    return productName;
                }else{
                    System.err.println("Tên sản phẩm phải gồm từ 6-50 ký tự, vui lòng nhập lại");
                }
            }else {
                System.err.println("Tên sản phẩm bị trùng lặp, vui lòng nhập lại tên khác");
            }
        }while (true);
    }

    public float inputImportPrice(Scanner scanner){
        System.out.println("Nhập vào giá nhập của sản phẩm:");
        do{
            float importPrice = Float.parseFloat(scanner.nextLine());
            if (importPrice > 0){
                return importPrice;
            }else {
                System.err.println("Giá nhập phải lớn hơn 0, vui lòng nhập lại");
            }
        }while (true);
    }

    public float inputExportPrice(Scanner scanner){
        System.out.println("Nhập vào giá xuất của sản phẩm");
        do{
            float exportPrice = Float.parseFloat(scanner.nextLine());
            if(exportPrice >= 1.2*this.importPrice){
                return exportPrice;
            }else{
                System.err.println("Giá xuất phải lớn hơn ít nhất 20% so với giá nhập, vui lòng nhập lại");
            }
        }while (true);
    }

    public void calProfit(){
        this.profit = this.exportPrice - this.importPrice;
    }

    public int inputQuantity(Scanner scanner){
        System.out.println("Nhập vào số lượng sản phẩm");
        do{
            int quantity = Integer.parseInt(scanner.nextLine());

            if(quantity > 0){
                return quantity;
            }else{
                System.err.println("Số lượng sản phẩm phải lớn hơn 0, vui lòng nhập lại");
            }
        }while (true);
    }

    public String inputDescriptions(Scanner scanner){
        System.out.println("Vui lòng nhập mô tả sản phẩm:");
        String descriptions = scanner.nextLine();

        return descriptions;
    }

    public boolean inputStatus(Scanner scanner){
        System.out.println("Vui lòng nhập trạng thái sản phẩm");
        boolean status = Boolean.parseBoolean(scanner.nextLine());

        return status;
    }
}
