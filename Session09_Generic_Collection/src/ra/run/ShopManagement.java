package ra.run;

import ra.entity.Categories;
import ra.entity.Product;

import java.util.*;

public class ShopManagement {
    public static List<Categories> categoriesList = new ArrayList<>();
    public static List<Product> productList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("***********SHOP MANAGEMENT**************");
            System.out.println("1. Quản lý danh mục");
            System.out.println("2. Quản lý sản phẩm");
            System.out.println("3. Thoát");
            System.out.print("Lựa chọn của bạn là: ");

            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    boolean isExit = true;
                    do {
                        System.out.println("***********CATALOG MANAGEMENT**************");
                        System.out.println("1. Thêm mới danh mục");
                        System.out.println("2. Hiển thị thông tin các danh mục");
                        System.out.println("3. Cập nhật thông tin theo mã danh mục");
                        System.out.println("4. Xóa danh mục theo mã danh mục (Danh mục chưa chứa sản phẩm)");
                        System.out.println("5. Thoát (Quay lại Shop Management)");

                        System.out.print("Lựa chọn của bạn là: ");
                        int yourChoice = Integer.parseInt(scanner.nextLine());

                        switch (yourChoice) {
                            case 1:
                                inputNewCatalog(scanner);
                                break;
                            case 2:
                                displayListCatalog();
                                break;
                            case 3:
                                updateCatalogName(scanner);
                                break;
                            case 4:
                                deleteCatalog(scanner);
                                break;
                            case 5:
                                isExit = false;
                                break;
                            default:
                                System.err.println("Vui lòng lựa chọn từ 1 -> 5");
                                break;
                        }
                    } while (isExit);
                    break;
                case 2:
                    boolean isOut = true;
                    do {
                        System.out.println("***********PRODUCT MANAGEMENT**************");
                        System.out.println("1. Thêm mới sản phẩm (Khi thêm cho phép chọn danh mục sản phẩm mà sản phẩm thuộc về)");
                        System.out.println("2. Hiển thị thông tin sản phẩm");
                        System.out.println("3. Cập nhật giá sản phẩm theo mã sản phẩm");
                        System.out.println("4. Xóa sản phẩm theo mã sản phẩm");
                        System.out.println("5. Sắp xếp sản phẩm theo giá sản phẩm tăng dần");
                        System.out.println("6. Sắp xếp sản phẩm theo tên tăng dần");
                        System.out.println("7. Thống kê số lượng sản phẩm theo danh mục sản phẩm");
                        System.out.println("8. Tìm kiếm sản phẩm theo tên sản phẩm");
                        System.out.println("9. Thoát (Quay lại Shop Management)");

                        System.out.print("Lựa chọn của bạn là: ");
                        int yourChoice = Integer.parseInt(scanner.nextLine());

                        switch (yourChoice) {
                            case 1:
                                inputNewProduct(scanner);
                                break;
                            case 2:
                                displayListProduct();
                                break;
                            case 3:
                                updatePriceByProductId(scanner);
                                break;
                            case 4:
                                deleteProductById(scanner);
                                break;
                            case 5:
                                sortProductByPrice();
                                break;
                            case 6:
                                sortProductByName();
                                break;
                            case 7:
                                summaryQuantityByProductId(scanner);
                                break;
                            case 8:
                                break;
                            case 9:
                                searchProductByName(scanner);
                                isOut = false;
                                break;
                            default:
                                System.err.println("Vui lòng lựa chọn từ 1 -> 9");
                                break;
                        }
                    } while (isOut);
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.err.println("Vui lòng chọn từ 1 -> 3");
                    break;
            }
        } while (true);

    }

    public static void inputNewCatalog(Scanner scanner) {
        Categories categories = new Categories();
        categories.inputData(scanner);
        categoriesList.add(categories);
    }

    public static void displayListCatalog() {
        for (Categories category : categoriesList) {
            category.displayData();
        }
    }

    public static void displayCatalogCurrent() {
        System.out.println("Danh mục đang quản lý là: ");
        for (Categories categories : categoriesList) {
            System.out.printf("%d. %s\n", categories.getCatalogId(), categories.getCatalogName());
        }
    }

    public static void updateCatalogName(Scanner scanner) {
        displayCatalogCurrent();
        System.out.println("Nhập vào mã danh mục cần cập nhật");
        int catalogId = Integer.parseInt(scanner.nextLine());
        boolean isCheck = false;
        for (Categories category : categoriesList) {
            if (category.getCatalogId() == catalogId) {
                isCheck = true;
                break;
            }
        }
        if (isCheck) {
            System.out.println("Nhập vào tên danh mục mới");
            String newProductName = scanner.nextLine();
            for (Categories category : categoriesList) {
                if (category.getCatalogId() == catalogId) {
                    category.setCatalogName(newProductName);
                    break;
                }
            }
        } else {
            System.err.println("Mã danh mục không tồn tại, vui lòng nhập lại");
        }
    }

    public static void deleteCatalog(Scanner scanner) {
        displayCatalogCurrent();
        System.out.println("Nhập vào mã danh mục cần xóa");
        int catalogId = Integer.parseInt(scanner.nextLine());
        boolean isCheck = false;
        Categories tmp = null;
        for (Categories category : categoriesList) {
            if (category.getCatalogId() == catalogId) {
                tmp = category;
                break;
            }
        }
        if (tmp != null) {
            for (Product product : productList) {
                if (product.getCatalogId() != catalogId) {
                    isCheck = true;
                    categoriesList.remove(tmp);
                    break;
                }
            }
            if (isCheck) {
                System.out.println("Xóa danh mục thành công");
            } else {
                System.err.println("Không thể xóa danh mục đang chứa sản phẩm");
            }
        } else {
            System.err.println("Mã danh mục không tồn tại, vui lòng nhập lại");
        }
    }

    public static void inputNewProduct(Scanner scanner) {
        Product product = new Product();
        product.inputData(scanner);
        productList.add(product);
    }

    public static void displayListProduct() {
        for (Product product : productList) {
            product.displayData();
        }
    }

    public static void displayProductIdCurrent() {
        System.out.println("Mã sản phẩm đang quản lý là: ");
        for (Product product : productList) {
            System.out.printf("%s. %s\n", product.getProductId(), product.getProductName());
        }
    }

    public static void updatePriceByProductId(Scanner scanner) {
        displayProductIdCurrent();
        System.out.println("Nhập vào mã sản phẩm muốn cập nhật:");
        String productId = scanner.nextLine();
        boolean isCheck = false;
        for (Product product : productList) {
            if (product.getProductId().equals(productId)) {
                isCheck = true;
                break;
            }
        }
        if (isCheck) {
            System.out.println("Nhập vào giá mới của sản phẩm");
            float newProductPrice = Float.parseFloat(scanner.nextLine());
            for (Product product : productList) {
                if (product.getProductId().equals(productId)) {
                    product.setPrice(newProductPrice);
                    break;
                }
            }
        } else {
            System.err.println("Mã sản phẩm không tồn tại, vui lòng nhập lại");
        }
    }

    public static void deleteProductById(Scanner scanner) {
        displayProductIdCurrent();
        System.out.println("Nhập vào mã sản phẩm cần xóa");
        String productId = scanner.nextLine();
        boolean isCheck = false;
        for (Product product : productList) {
            if (product.getProductId().equals(productId)) {
                isCheck = true;
                productList.remove(product);
                break;
            }
        }
        if (isCheck) {
            System.out.println("Xóa sản phẩm thành công");
        } else {
            System.err.println("Mã sản phẩm không tồn tại, vui lòng nhập lại");
        }
    }

    public static void sortProductByPrice() {
        Collections.sort(productList, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                if (o1.getPrice() > o2.getPrice()) {
                    return 1;
                } else if (o1.getPrice() < o2.getPrice()) {
                    return 0;
                } else {
                    return -1;
                }
            }
        });
    }

    public static void sortProductByName() {
        Collections.sort(productList, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                if (o1.getProductName().compareTo(o2.getProductName()) > 0) {
                    return 1;
                } else if (o1.getProductName().compareTo(o2.getProductName()) < 0) {
                    return 0;
                } else {
                    return -1;
                }
            }
        });
    }

    public static void summaryQuantityByProductId(Scanner scanner) {
        displayCatalogCurrent();
        System.out.println("Nhập vào mã danh mục cần thống kê số lượng");
        int catalogId = Integer.parseInt(scanner.nextLine());
        boolean isCheck = false;
        int sum = 0;
        for (Product product : productList) {
            if (product.getCatalogId() == catalogId) {
                isCheck = true;
                sum++;
            }
        }
        if (!isCheck) {
            System.err.println("Mã sản phẩm không tồn tại, vui lòng nhập lại");
        }else {
            System.out.printf("Số lượng sản phẩm theo danh mục %d là %d :", catalogId, sum);
        }
        System.out.printf("\n");
    }

    public static void searchProductByName(Scanner scanner){
        System.out.println("Nhập vào tên sản phẩm cần tìm");
        String productName = scanner.nextLine();
        boolean isCheck = false;
        for (Product product : productList) {
            if (product.getProductName().equals(productName)) {
                isCheck = true;
                product.displayData();
                break;
            }
        }
        if (isCheck) {
            System.err.println("Tên sản phẩm không tồn tại, vui lòng nhập lại");
        }

    }
}
