package ra.entity;

import java.util.Scanner;

public class Categories {
    private int catalogId;
    private String catalogName;
    private String description;
    private boolean status;

    public Categories() {
    }

    public Categories(int catalogId, String catalogName, String description, boolean status) {
        this.catalogId = catalogId;
        this.catalogName = catalogName;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String toString(){
        return "Catalog ID: " + this.catalogId + " - Catalog Name: " + this.catalogName + " - Description: " + this.description
                + " - Status: " + (this.status? "Active" : "Inactive");
    }

    public void inputData(Scanner scanner){
        System.out.println("Nhập vào tên danh mục: ");
        this.catalogName = scanner.nextLine();
        System.out.println("Nhập vào mô tả danh mục");
        this.description = scanner.nextLine();
        System.out.println("Nhập vào trạng thái danh mục");
        this.status = Boolean.parseBoolean(scanner.nextLine());
    }
}
