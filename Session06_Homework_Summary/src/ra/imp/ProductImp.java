package ra.imp;

import ra.entity.Product;

import java.util.Scanner;

public class ProductImp {
    Product[] arrProduct = new Product[100];
    int currentIndex = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProductImp product = new ProductImp();
        do {
            System.out.println("************MENU**************");
            System.out.println("1. Nhập thông tin n sản phẩm");
            System.out.println("2. Hiển thị thông tin sản phẩm");
            System.out.println("3. Tính lợi nhuận của các sản phẩm");
            System.out.println("4. Sắp xếp các sản phẩm theo lợi nhuận giảm dần");
            System.out.println("5. Thống kê các sản phẩm theo giá");
            System.out.println("6. Tìm các sản phẩm theo tên sản phẩm");
            System.out.println("7. Nhập sản phẩm");
            System.out.println("8. Bán sản phẩm");
            System.out.println("9. Cập nhật trạng thái sản phẩm");
            System.out.println("10. Thoát");

            System.out.print("Lựa chọn của bạn là: ");

            int choose = Integer.parseInt(scanner.nextLine());

            switch (choose) {
                case 1:
                    product.inputProductInfo(scanner);
                    System.out.printf("\n");
                    break;
                case 2:
                    product.displayProductInfo();
                    System.out.printf("\n");
                    break;
                case 3:
                    product.profitEachProduct();
                    System.out.printf("\n");
                    break;
                case 4:
                    product.sortByProfit();
                    System.out.printf("\n");
                    break;
                case 5:
                    product.quantityOfProductByImportPrice(scanner);
                    System.out.printf("\n");
                    break;
                case 6:
                    product.findByProductName(scanner);
                    System.out.printf("\n");
                    break;
                case 7:
                    product.updateProduct(scanner);
                    System.out.printf("\n");
                    break;
                case 8:
                    product.deleteProduct(scanner);
                    System.out.printf("\n");
                    break;
                case 9:
                    product.updateStatusProduct(scanner);
                    break;
                case 10:
                    System.exit(0);
                    break;
                default:
                    System.err.println("Vui lòng chọn từ 1->9");
            }
        } while (true);
    }

    public void inputProductInfo(Scanner scanner) {
        System.out.println("Nhập vào thông tin n sản phẩm");
        int quantity = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < quantity; i++) {
            arrProduct[currentIndex] = new Product();
            arrProduct[currentIndex].inputData(scanner, arrProduct, currentIndex);
            currentIndex++;
        }
    }

    public void displayProductInfo(){
        System.out.println("DANH SÁCH SẢN PHẨM LÀ: ");
        for (int i = 0; i < currentIndex; i++) {
            arrProduct[i].displayData();
        }
    }

    public void profitEachProduct(){
        for (int i = 0; i < currentIndex; i++) {
            arrProduct[i].calProfit();
        }
    }

    public void sortByProfit(){
        for (int i = 0; i < currentIndex - 1; i++) {
            for (int j = i + 1; j < currentIndex; j++) {
                if (arrProduct[i].getProfit() < arrProduct[j].getProfit()){
                    Product tmp = arrProduct[i];
                    arrProduct[i] = arrProduct[j];
                    arrProduct[j] = tmp;
                }
            }
        }
    }

    public void quantityOfProductByImportPrice(Scanner scanner){
        System.out.println("Vui lòng nhập vào giá nhập sản phẩm");
        float importPrice = Float.parseFloat(scanner.nextLine());
        int count = 0;
        for (int i = 0; i < currentIndex; i++) {
            if(arrProduct[i].getImportPrice() == importPrice){
                count++;
            }
        }

        if(count > 0){
            System.out.printf("Số lượng sản phẩm có giá nhập %.3f là: %d", importPrice, count);
        }else{
            System.err.printf("Không có sản phẩm nào có giá nhập %.3f", importPrice);
        }
    }

    public void findByProductName(Scanner scanner){
        System.out.println("Vui lòng nhập tên sản phẩm muốn tìm");
        String productName = scanner.nextLine();
        boolean checkProductName = false;
        for (int i = 0; i < currentIndex; i++) {
            if(arrProduct[i].getProductName().equals(productName)){
                checkProductName = true;
                arrProduct[i].displayData();
            }
        }
        if(!checkProductName){
            System.err.printf("Không có sản phẩm nào có tên là %s", productName);
        }
    }


    public int findIndexById(String productId){
        int index = -1;
        for (int i = 0; i < currentIndex; i++) {
            if(arrProduct[i].getProductId().equals(productId)){
                index = i;
            }
        }
        return index;
    }

    public void updateProduct(Scanner scanner){
        System.out.println("Vui lòng nhập id sản phẩm muốn nhập");
        boolean resultFound = true;
        do{
            String productId = scanner.nextLine();

            int indexProductUpdate = findIndexById(productId);

            if(indexProductUpdate >= 0){
                if (productId.length() == 4){
                    System.out.println("Vui lòng nhập vào số lượng sản phẩm cần nhập");
                    int quantityUpdate = Integer.parseInt(scanner.nextLine());
                    arrProduct[indexProductUpdate].setQuantity(arrProduct[indexProductUpdate].getQuantity() + quantityUpdate);
                    resultFound = false;
                }else{
                    System.err.println("Mã sản phẩm gồm 4 ký tự, vui lòng nhập lại");
                }
            }else{
                System.err.println("Mã sản phẩm không tồn tại, vui lòng nhập lại");
            }
        }while (resultFound);
    }

    public void deleteProduct(Scanner scanner){
        System.out.println("Vui lòng nhập tên sản phẩm muốn bán");
        boolean resultFound = true;
        do{
            String productName = scanner.nextLine();
            int indexProductSale = findIndexById(productName);

            if(indexProductSale>= 0){
                if (productName.length() == 4){
                    System.out.println("Vui lòng nhập vào số lượng sản phẩm cần nhập");
                    int quantitySale = Integer.parseInt(scanner.nextLine());
                    if(quantitySale <= arrProduct[indexProductSale].getQuantity()){
                        arrProduct[indexProductSale].setQuantity(arrProduct[indexProductSale].getQuantity() - quantitySale);
                        resultFound = false;
                    }else {
                        System.err.println("Số lượng sản phẩm bán vượt quá số lượng của sản phẩm hiện tại, vui lòng nhập lại");
                    }
                }else{
                    System.err.println("Mã sản phẩm gồm 4 ký tự, vui lòng nhập lại");
                }
            }else{
                System.err.println("Mã sản phẩm không tồn tại, vui lòng nhập lại");
            }
        }while (resultFound);
    }

    public void updateStatusProduct(Scanner scanner){
        System.out.println("Vui lòng nhập id sản phẩm muốn cập nhật trạng thái");
        boolean resultFound = true;
        do{
            String productId = scanner.nextLine();
            int indexProductStatusUpdate = findIndexById(productId);

            if(indexProductStatusUpdate >= 0){
                if (productId.length() == 4){
                    arrProduct[indexProductStatusUpdate].setStatus(!arrProduct[indexProductStatusUpdate].isStatus());
                    resultFound = false;
                }else{
                    System.err.println("Mã sản phẩm gồm 4 ký tự, vui lòng nhập lại");
                }
            }else{
                System.err.println("Mã sản phẩm không tồn tại, vui lòng nhập lại");
            }
        }while (resultFound);
    }
}
