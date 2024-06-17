package ra.presentation;

import ra.business.CategoriesBusiness;
import ra.entity.Categories;

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
}
