package ra.presentation;

import ra.business.CategoriesBusiness;
import ra.business.ProductBusiness;
import ra.entity.Categories;
import ra.entity.Product;
import ra.entity.StatisticProduct;

import java.util.List;
import java.util.Scanner;

public class Ecommerce {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("-----------ECOMMERCE------------");
            System.out.println("1. Quản lý danh mục");
            System.out.println("2. Quản lý sản phẩm");
            System.out.println("3. Thoát");
            System.out.print("Lựa chọn của bạn là: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice){
                case 1:
                    Ecommerce.displayCategoryMenu(scanner);
                    break;
                case 2:
                    Ecommerce.displayProductMenu(scanner);
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.err.println("Vui lòng lựa chọn từ 1->3");
            }
        }while (true);
    }

    public static void displayCategoryMenu(Scanner scanner){
        boolean isExist = true;
        do {
            System.out.println("------------CATEGORY MANAGEMENT-----------");
            System.out.println("1. Danh sách danh mục");
            System.out.println("2. Thêm mới danh mục");
            System.out.println("3. Cập nhật danh mục");
            System.out.println("4. Xóa danh mục");
            System.out.println("5. Hiển thị danh mục theo mã danh mục");
            System.out.println("6. Sắp xếp danh mục theo tên giảm dần");
            System.out.println("7. Hiển thị danh mục theo tên danh mục");
            System.out.println("8. Thoát");
            System.out.print("Lựa chọn của bạn là: ");

            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    Ecommerce.displayListCategories();
                    break;
                case 2:
                    Ecommerce.createCatalog(scanner);
                    break;
                case 3:
                    Ecommerce.updateCatalog(scanner);
                    break;
                case 4:
                    Ecommerce.deleteCatalogById(scanner);
                    break;
                case 5:
                    Ecommerce.displayCatalogById(scanner);
                    break;
                case 6:
                    Ecommerce.sortCatalogByName();
                    break;
                case 7:
                    Ecommerce.getCatalogByName(scanner);
                    break;
                case 8:
                    isExist = false;
                    break;
                default:
                    System.err.println("Vui lòng chọn từ 1->6");
            }
        }while (isExist);
    }

    public static void displayListCategories(){
        List<Categories> categoriesList = CategoriesBusiness.findAll();

        categoriesList.stream().forEach(System.out::println);
    }

    public static void createCatalog(Scanner scanner){
        Categories catalogNew = new Categories();
        catalogNew.inputData(scanner);
        boolean result = CategoriesBusiness.create(catalogNew);
        if(result){
            System.out.println("Thêm mới danh mục thành công");
        }else {
            System.err.println("Thêm mới danh mục thất bại");
        }
    }

    public static void updateCatalog(Scanner scanner){
        System.out.println("Nhập vào mã danh mục cần cập nhật");
        int catalogId = Integer.parseInt(scanner.nextLine());
        if (CategoriesBusiness.isExistCatalog(catalogId)){
            Categories catalogUpdate = CategoriesBusiness.getCatalogById(catalogId);
            boolean isExist = true;
            do {
                System.out.println("1. Cập nhật tên danh mục");
                System.out.println("2. Cập nhật mô tả danh mục");
                System.out.println("3. Cập nhật trạng thái danh mục");
                System.out.println("4. Thoát");
                System.out.print("Lựa chọn của bạn là: ");
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice){
                    case 1:
                        System.out.println("Nhập vào tên danh mục cần cập nhật");
                        catalogUpdate.setCatalogName(scanner.nextLine());
                        break;
                    case 2:
                        System.out.println("Nhập vào mô tả cần cập nhật");
                        catalogUpdate.setDescription(scanner.nextLine());
                        break;
                    case 3:
                        System.out.println("Nhập vào trạng thái cần cập nhật");
                        catalogUpdate.setStatus(Boolean.parseBoolean(scanner.nextLine()));
                        break;
                    default:
                        isExist = false;
                }
            }while (isExist);
            boolean result = CategoriesBusiness.updateCatalog(catalogUpdate);
            if (result){
                System.out.println("Cập nhật danh mục thành công");
            }else {
                System.err.println("Cập nhật danh mục thất bại");
            }
        }else {
            System.err.println("Mã danh mục không tồn tại");
        }
    }

    public static void deleteCatalogById(Scanner scanner){
        System.out.println("Nhập vào mã danh mục cần xóa");
        int catalogId = Integer.parseInt(scanner.nextLine());
        boolean isExist = CategoriesBusiness.isExistCatalog(catalogId);
        if(isExist){
            boolean result = CategoriesBusiness.deleteCatalogById(catalogId);
            if (result){
                System.out.println("Xóa danh mục thành công");
            }else {
                System.err.println("Xóa danh mục thất bại");
            }
        }else {
            System.err.println("Mã danh mục không tồn tại, vui lòng nhập lại");
        }
    }

    public static void displayCatalogById(Scanner scanner){
        System.out.println("Nhập vào mã danh mục cần hiển thị");
        int catalogId = Integer.parseInt(scanner.nextLine());
        if(CategoriesBusiness.isExistCatalog(catalogId)){
            Categories categories = CategoriesBusiness.getCatalogById(catalogId);
            System.out.println(categories);
        }else {
            System.err.println("Mã danh mục không tồn tại, vui lòng nhập lại");
        }
    }

    public static void sortCatalogByName(){
        System.out.println("Mã danh mục sắp xếp theo tên giảm dần là:");
        List<Categories> categoriesList = CategoriesBusiness.sortCatalogByName();
        categoriesList.stream().forEach(System.out::println);
    }

    public static void getCatalogByName(Scanner scanner){
        System.out.println("Nhập vào tên danh mục muốn tìm kiếm");
        String catalogName = scanner.nextLine();
        if (CategoriesBusiness.isExistCatalogName(catalogName)){
            System.out.println("Mã danh mục tìm thấy là:");
            Categories categories = CategoriesBusiness.findCatalogByName(catalogName);
            System.out.println(categories);
        }else {
            System.err.println("Tên danh mục không tìm thấy, vui lòng nhập lại");
        }
    }

    public static void displayProductMenu(Scanner scanner){
        boolean isExist = true;
        do {
            System.out.println("------------PRODUCT MANAGEMENT-----------");
            System.out.println("1. Danh sách sản phẩm");
            System.out.println("2. Thêm mới sản phẩm");
            System.out.println("3. Cập nhật sản phẩm");
            System.out.println("4. Xóa sản phẩm");
            System.out.println("5. Tìm kiếm sản phẩm theo tên sản phẩm hoặc tiêu đề sản phẩm");
            System.out.println("6. Thống kê sản phẩm theo danh mục sản phẩm");
            System.out.println("7. Thoát");
            System.out.print("Lựa chọn của bạn là: ");

            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    Ecommerce.displayListProduct();
                    break;
                case 2:
                    Ecommerce.createProduct(scanner);
                    break;
                case 3:
                    Ecommerce.updateProduct(scanner);
                    break;
                case 4:
                    Ecommerce.deleteProduct(scanner);
                    break;
                case 5:
                    Ecommerce.findProduct(scanner);
                    break;
                case 6:
                    Ecommerce.statisticProduct();
                    break;
                case 7:
                    isExist = false;
                    break;
                default:
                    System.err.println("Vui lòng chọn từ 1->6");
            }
        }while (isExist);
    }

    public static void displayListProduct(){
        System.out.println("DANH SÁCH SẢN PHẨM LÀ:");
        List<Product> productList = ProductBusiness.getAllProduct();

        productList.forEach(product -> product.displayData());
    }


    public static void createProduct(Scanner scanner){
        Product productNew = new Product();
        productNew.inputData(scanner);

        boolean result =  ProductBusiness.createProduct(productNew);
        if (result){
            System.out.println("Tạo mới sản phẩm thành công");
        }else {
            System.err.println("Tạo mới sản phẩm thất bại");
        }
    }

    public static void updateProduct(Scanner scanner){
        System.out.println("Nhập vào mã sản phẩm cần cập nhật");
        String productId = scanner.nextLine();

        if (ProductBusiness.isExistProductId(productId)){
            boolean isExist = true;
            Product productUpdate = ProductBusiness.getProductById(productId);
            do {
                System.out.println("1. Cập nhật tên sản phẩm");
                System.out.println("2. Cập nhật giá sản phẩm");
                System.out.println("3. Cập nhật tiêu đề sản phẩm");
                System.out.println("4. Cập nhật mã danh mục của sản phẩm");
                System.out.println("5. Cập nhật trạng thái sản phẩm");
                System.out.println("6. Thoát");
                System.out.print("Lựa chọn của bạn là: ");

                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice){
                    case 1:
                        System.out.println("Nhập vào tên mới của sản phẩm");
                        productUpdate.setProductName(scanner.nextLine());
                        break;
                    case 2:
                        System.out.println("Nhập vào giá mới của sản phẩm");
                        productUpdate.setProductPrice(Float.parseFloat(scanner.nextLine()));
                        break;
                    case 3:
                        System.out.println("Nhập va tiêu đề mới của sản phẩm");
                        productUpdate.setProductTitle(scanner.nextLine());
                        break;
                    case 4:
                        System.out.println("Nhập vào mã danh mục mới của sản phẩm");
                        productUpdate.setCatalogId(Integer.parseInt(scanner.nextLine()));
                        break;
                    case 5:
                        System.out.println("Nhập vào trạng thái mới của sản phẩm");
                        productUpdate.setProductStatus(Boolean.parseBoolean(scanner.nextLine()));
                        break;
                    case 6:
                        isExist = false;
                        break;
                    default:
                        System.err.println("Vui lòng chọn từ 1->6");
                }
                boolean result = ProductBusiness.updateProduct(productUpdate);
                if (result){
                    System.out.println("Cập nhật sản phẩm thành công");
                }else {
                    System.err.println("Cập nhật sản phẩm thất bại");
                }
            }while(isExist);
        }else{
            System.err.println("Mã sản phẩm không tồn tại, vui lòng nhập lại");
        }
    }

    public static void deleteProduct(Scanner scanner){
        System.out.println("Nhập vào mã sản phẩm muốn cập nhật");
        String productId = scanner.nextLine();

        boolean isExist = ProductBusiness.isExistProductId(productId);

        if(isExist){
            boolean result = ProductBusiness.deleteProduct(productId);
            if (result){
                System.out.println("Xóa sản phẩm thành công");
            }else {
                System.err.println("Xóa sản phẩm thất bại");
            }
        }else {
            System.err.println("Mã danh mục không tồn tại, vui lòng nhập lại");
        }

    }

    public static void findProduct(Scanner scanner){
        System.out.println("Nhập vào tên sản phẩm hoặc tiêu đề sản phẩm muốn tìm kiếm");
        String inputString = scanner.nextLine();

        List<Product> productList = ProductBusiness.findProducts(inputString);
        System.out.println("Danh sách sản phẩm tìm thấy là: ");
        productList.forEach(product -> product.displayData());
    }

    public static void statisticProduct(){
        System.out.println("Số lượng sản phẩm theo mã danh mục là:");
        List<StatisticProduct> statisticProductList = ProductBusiness.statisticProductList();
        statisticProductList.forEach(statisticProduct -> statisticProduct.displayData());
    }
}
