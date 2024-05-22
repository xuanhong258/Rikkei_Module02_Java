package OOP_3.ra.entity;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Product {
    private String productId;
    private String productName;
    private float price;
    private String descriptions;
    private String created;
    private int catalogId;
    private int productStatus;

    public Product() {}

    public Product(String productId, String productName, float price, String descriptions, String created, int catalogId, int productStatus) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.descriptions = descriptions;
        this.created = created;
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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public int getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(int productStatus) {
        this.productStatus = productStatus;
    }

    public void inputData(Scanner scanner, Product[] arrProduct, int indexProduct, Categories[] categories, int indexCategorie){
        this.productId = inputProductId(scanner, arrProduct, indexProduct);
        this.productName = inputProductName(scanner, arrProduct, indexProduct);
        this.price = inputPrice(scanner);
        this.descriptions = inputDescriptions(scanner);
        this.created = inputCreated(scanner);
        this.catalogId = inputCatalogId(scanner, categories, indexCategorie);
        this.productStatus = inputProductStatus(scanner);
    }

    public void displayData(){
        System.out.printf("Mã sản phẩm: %s - Tên sản phẩm: %s - Giá sản phẩm: %.3f - Mô tả: %s", this.productId, this.productName, this.price, this.descriptions);
        System.out.printf(" - Ngày nhập: %s - Mã danh mục: %d", this.created, this.catalogId);
        switch (this.productStatus){
            case 0:
                System.out.print(" - Trạng thái: Đang bán");
                break;
            case 1:
                System.out.print(" - Trạng thái: Hết hàng");
                break;
            case 2:
                System.out.print(" - Trạng thái: Không bán");
                break;
            default:
                break;
        }
    }

    public String inputProductId(Scanner scanner, Product[] arrProduct, int indexProduct){
        System.out.println("Nhập vào mã sản phẩm:");
        do {
            boolean isProductIdCheck = false;
            boolean flag = false;
            String productId = scanner.nextLine();
            if(productId.length() == 4){
                if (productId.startsWith("C") || productId.startsWith("S") || productId.startsWith("A")) {
                    isProductIdCheck = true;
                }else {
                    System.err.println("Mã sản phẩm phải bắt đầu là 1 trong 3 ký tự C,S hoặc A, vui lòng nhập lại");
                }
            }else{
                System.err.println("Mã sản phẩm phải gồm 4 ký tự, vui lòng nhập lại");
            }
            if(isProductIdCheck){
                for (int i = 0; i < indexProduct; i++) {
                    if(arrProduct[i].getProductId().equals(productId)){
                        flag = true;
                        break;
                    }
                }
                if (flag){
                    System.err.println("Mã sản phẩm bị trùng, vui lòng nhập lại");
                }else {
                    return productId;
                }
            }
        }while (true);
    }

    public String inputProductName(Scanner scanner, Product[] arrProduct, int indexProduct){
        System.out.println("Nhập vào tên sản phẩm");
        do {
            String productName = scanner.nextLine();
            boolean isChecklength = false;
            boolean flag = false;
            if(productName.length() >= 10 && productName.length() <= 50){
                isChecklength = true;
            }else {
                System.err.println("Độ dài sản phẩm phải từ 10 -> 50, vui lòng nhập lại");
            }
            if(isChecklength){
                for (int i = 0; i < indexProduct; i++) {
                    if(arrProduct[i].getProductName().equals(productName)){
                        flag = true;
                        break;
                    }
                }
                if (flag){
                    System.err.println("Tên sản phẩm đã bị trùng, vui lòng nhập lại");
                }else {
                    return productName;
                }
            }

        }while (true);
    }

    public float inputPrice(Scanner scanner){
        System.out.println("Vui lòng nhập vào giá sản phẩm");
        do {
            float price = Float.parseFloat(scanner.nextLine());
            if (price > 0){
                return price;
            }else {
                System.err.println("Giá sản phẩm phải lớn hơn 0, vui lòng nhập lại");
            }
        }while (true);
    }

    public String inputDescriptions(Scanner scanner){
        System.out.println("Vui lòng nhập mô tả sản phẩm:");
        String description = scanner.nextLine();
        return  description;
    }

    public String inputCreated(Scanner scanner){
        System.out.println("Vui lòng nhập vào ngày tạo sản phẩm");
        do {
            String created = scanner.nextLine();
            String dateRegex = "([12][0-9]|3[01]|0?[1-9])/(0?[1-9]|1[012])/((?:19|20)\\d\\d)";

            if (Pattern.matches(dateRegex,created)){
                return created;
            }else {
                System.err.println("Định dạng ngày tạo chưa thỏa mãn dạng dd/mm/YYYY, vui lòng nhập lại");
            }
        }while (true);
    }

    public int inputCatalogId(Scanner scanner, Categories[] categories, int indexCategorie){
        do {
            System.out.println("Danh mục hiện có tại cửa hàng là: ");
            for (int i = 0; i < indexCategorie; i++) {
                System.out.printf("Danh mục thứ: %d", categories[i].getCatalogId());
                System.out.printf("\n");
            }
            System.out.println("Vui lòng chọn danh mục cho sản phẩm: ");
            boolean flag = false;
            int catalogId = Integer.parseInt(scanner.nextLine());
            for (int i = 0; i < indexCategorie; i++) {
                if(categories[i].getCatalogId() == catalogId){
                    flag = true;
                    break;
                }
            }
            if (flag){
                return catalogId;
            }else {
                System.err.println("Danh mục cho sản phẩm chưa chính xác, vui lòng nhập lại");
            }
        }while (true);
    }

    public int inputProductStatus(Scanner scanner){
        System.out.println("Vui lòng nhập trạng thái sản phẩm");
        do {
            int productStatus = Integer.parseInt(scanner.nextLine());
            if (productStatus == 0 || productStatus == 1 || productStatus == 2){
                return productStatus;
            }else {
                System.err.println("Trạng thái sản phẩm chỉ nhận 1 trong các trạng thái 0, 1, hoặc 2, vui lòng nhập lại");
            }
        }while (true);
    }
}
