package OOP_3.ra.entity;

import java.util.Scanner;

public class Categories {
    private int catalogId;
    private String catalogName;
    private String descriptions;
    private boolean catalogStatus;

    public Categories() {
    }

    public Categories(int catalogId, String catalogName, String descriptions, boolean catalogStatus) {
        this.catalogId = catalogId;
        this.catalogName = catalogName;
        this.descriptions = descriptions;
        this.catalogStatus = catalogStatus;
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

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public boolean isCatalogStatus() {
        return catalogStatus;
    }

    public void setCatalogStatus(boolean catalogStatus) {
        this.catalogStatus = catalogStatus;
    }

    public void inputData(Scanner scanner, Categories[] arrCategories, int index) {
        this.catalogId = generateIdIdentity(arrCategories, index);
        this.catalogName = inputCatalogName(scanner, arrCategories, index);
        this.descriptions = inputDescriptions(scanner);
        this.catalogStatus = inputCatalogStatus(scanner);
    }

    public void displayData(){
        System.out.printf("Id: %d - Name: %s - Description: %s - Status: %s", this.catalogId, this.catalogName, this.descriptions, this.catalogStatus?"hoạt động":"không hoạt động");
    }

    public int generateIdIdentity(Categories[] arrCategories, int index){
        if(index == 0){
            return 1;
        }else {
            int max = arrCategories[0].getCatalogId();
            for (int i = 1; i < index; i++) {
                if(max < arrCategories[i].getCatalogId()){
                    max = arrCategories[i].getCatalogId();
                }
            }
            return max + 1;
        }
    }
    public String inputCatalogName(Scanner scanner, Categories[] arrCategories, int index) {
        System.out.println("Nhập vào tên danh mục:");
        do {
            String catalogName = scanner.nextLine();
            boolean isCatalogNameCheck = false;
            for (int i = 0; i < index; i++) {
                if (arrCategories[i].getCatalogName().equals(catalogName)) {
                    isCatalogNameCheck = true;
                    break;
                }
            }
            if (!isCatalogNameCheck) {
                if (catalogName.length() <= 50) {
                    return catalogName;
                } else {
                    System.err.println("Độ dài tên danh mục quá 50 ký tự, vui lòng nhập lại");
                }
            } else {
                System.err.println("Tên danh mục đã tồn tại, vui lòng nhập lại");
            }

        } while (true);
    }

    public String inputDescriptions(Scanner scanner) {
        System.out.println("Vui lòng nhập mô tả danh mục");
        do {
            String descriptions = scanner.nextLine();
            if (descriptions.length() != 0) {
                return descriptions;
            } else {
                System.err.println("Vui lòng không để trống phần mô tả danh mục, vui lòng nhập lại");
            }
        } while (true);
    }

    public boolean inputCatalogStatus(Scanner scanner) {
        System.out.println("Vui lòng nhập trạng thái của danh mục true or false");
        boolean catalogStatus = Boolean.parseBoolean(scanner.nextLine());
        return catalogStatus;
    }
}
