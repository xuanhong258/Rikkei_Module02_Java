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
        arrCategories[index].setCatalogId(index);
        this.catalogId = inputCatalogId(arrCategories, index) + 1;
        this.catalogName = inputCatalogName(scanner, arrCategories, index);
        this.descriptions = inputDescriptions(scanner);
        this.catalogStatus = inputCatalogStatus(scanner);
    }

    public void displayData(){

    }

    public int inputCatalogId(Categories[] arrCategories, int index) {
        return arrCategories[index].getCatalogId();
    }

    public String inputCatalogName(Scanner scanner, Categories[] arrCategories, int index) {
        System.out.println("Nhập vào tên đồ uống:");
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
                if (catalogName.length() >= 4 && catalogName.length() <= 50) {
                    return catalogName;
                } else {
                    System.err.println("Độ dài tên đồ uống vượt quá 50 ký tự, vui lòng nhập lại");
                }
            } else {
                System.err.println("Tên đồ uống đã tồn tại, vui lòng nhập lại");
            }

        } while (true);
    }

    public String inputDescriptions(Scanner scanner) {
        System.out.println("Vui lòng nhập mô tả sản phẩm");
        do {
            String descriptions = scanner.nextLine();
            if (descriptions.length() != 0) {
                return descriptions;
            } else {
                System.err.println("Vui lòng không để trống phần mô tả sản phẩm, vui lòng nhập lại");
            }
        } while (true);
    }

    public boolean inputCatalogStatus(Scanner scanner) {
        System.out.println("Vui lòng nhập trạng thái của sản phẩm");
        boolean catalogStatus = Boolean.parseBoolean(scanner.nextLine());
        return catalogStatus;
    }
}
