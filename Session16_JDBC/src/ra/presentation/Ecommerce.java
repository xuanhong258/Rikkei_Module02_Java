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
            System.out.println("6. Thoát");
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
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
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

        }else {
            System.err.println("Mã danh mục không tồn tại");
        }
    }
}
