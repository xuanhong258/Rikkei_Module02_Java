package ra.entity;

import ra.IShop;
import ra.run.ShopManagement;

import java.util.Scanner;

public class Categories implements IShop {
    private int catalogId;
    private String catalogName;
    private boolean status;
    Scanner scanner = new Scanner(System.in);

    public Categories() {
    }

    public Categories(int catalogId, String catalogName, boolean status) {
        this.catalogId = catalogId;
        this.catalogName = catalogName;
        this.status = status;
    }

    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }


    @Override
    public void inputData(Scanner scanner) {
        this.catalogId = inputCatalogId(scanner);
        this.catalogName = inputCatalogName(scanner);
        this.status = inputStatus(scanner);
    }

    @Override
    public void displayData() {
        System.out.printf("Id: %d - Name: %s - Status: %b", this.catalogId, this.catalogName, this.status);
        System.out.printf("\n");
    }

    public int inputCatalogId(Scanner scanner) {
        System.out.println("Nhập vào mã danh mục");
        do {
            int catalogId = Integer.parseInt(scanner.nextLine());
            boolean isCheckUnique = false;
            boolean isCheckLanger = false;
            for (Categories categories : ShopManagement.categoriesList) {
                if (categories.getCatalogId() == catalogId) {
                    isCheckUnique = true;
                    break;
                }
                if (categories.getCatalogId() > catalogId){
                    isCheckLanger = true;
                    break;
                }
            }
            if (isCheckUnique) {
                System.err.println("Mã danh mục bị trùng , vui lòng nhập lại");
            } else if(isCheckLanger){
                System.err.println("Mã danh mục nhỏ hơn mã danh mục trước, vui lòng nhập lại");
            }else {
                return catalogId;
            }
        } while (true);
    }

    public String inputCatalogName(Scanner scanner) {
        System.out.println("Nhập vào tên danh mục");
        do {
            String catalogName = scanner.nextLine();
            boolean isCheck = false;
            for (Categories categories : ShopManagement.categoriesList) {
                if (categories.getCatalogName().equals(catalogName)) {
                    isCheck = true;
                    break;
                }
            }
            if (isCheck) {
                System.err.println("Tên danh mục bị trùng, vui lòng nhập lại");
            } else {
                return catalogName;
            }
        } while (true);
    }

    public boolean inputStatus(Scanner scanner) {
        System.out.println("Nhập vào trạng thái danh mục");
        do {
            String status = scanner.nextLine();
            if (status.equals("true") || status.equals("false")) {
                return Boolean.parseBoolean(status);
            } else {
                System.err.println("Trạng thái danh mục chỉ nhận giá trị true hoặc false, vui lòng nhập lại");
            }
        } while (true);
    }
}
