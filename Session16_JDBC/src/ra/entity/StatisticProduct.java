package ra.entity;

public class StatisticProduct {
    private int catalogId;
    private String catalogName;
    private int countProduct;

    public StatisticProduct() {
    }

    public StatisticProduct(int catalogId, String catalogName, int countProduct) {
        this.catalogId = catalogId;
        this.catalogName = catalogName;
        this.countProduct = countProduct;
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

    public int getCountProduct() {
        return countProduct;
    }

    public void setCountProduct(int countProduct) {
        this.countProduct = countProduct;
    }

    public void displayData(){
        System.out.printf("Mã danh mục: %d - Tên danh mục: %s - Số lượng sản phẩm: %d", this.catalogId, this.catalogName, this.countProduct);
        System.out.print("\n");
    }
}
