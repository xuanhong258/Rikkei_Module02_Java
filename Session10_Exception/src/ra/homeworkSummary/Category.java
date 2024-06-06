package ra.homeworkSummary;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Category implements IEntity{
    private int id;
    private String name;
    private boolean status;

    public Category() {
    }

    public Category(int id, String name, boolean status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public void input(Scanner scanner) {
        this.id = inputId(scanner);
        this. name = inputName(scanner);
        this.status = inputStatus(scanner);
    }

    @Override
    public void output() {
        System.out.printf("ID: %d - Name: %s - Status: %s", this.id, this.name, this.status?"Hoạt động": "Không hoạt động");
        System.out.printf("\n");
    }

    public int inputId(Scanner scanner){
        System.out.println("Nhập vào id sản phẩm");
        do {
            try {
                int id = Integer.parseInt(scanner.nextLine());
                boolean isCheck = false;
                if(id > 0){
                    for (Category category : Library.categoryList){
                        if (id == category.getId()){
                            isCheck = true;
                            break;
                        }
                    }
                    if (isCheck){
                        System.err.println("Mã danh mục đã tồn tại, vui lòng nhập lại");
                    }else {
                        return id;
                    }
                }else {
                    System.err.println("Mã danh mục phải lớn hơn 0, vui lòng nhập lại");
                }
            }catch (NumberFormatException ae){
                System.err.println("Id sản phẩm phải là số nguyên, vui lòng nhập lại");
            }
        }while (true);
    }

    public String inputName(Scanner scanner){
        System.out.println("Nhập vào tên danh mục");
        do {
            try {
                String name = scanner.nextLine();
                String nameRegex = "[\\w[\\s]]{6,30}";
                if (Pattern.matches(nameRegex, name)){
                    boolean isCheck = false;
                    for (Category category : Library.categoryList){
                        if(category.getName().equals(name)){
                            isCheck = true;
                            break;
                        }
                    }
                    if(isCheck){
                        System.err.println("Tên danh mục đã tồn tại, vui lòng nhập lại");
                    }else {
                        return name;
                    }
                }else {
                    System.err.println("Tên danh mục phải dài từ 6-30 kí tự, vui lòng nhập lại");
                }
            }catch (Exception ex){
                System.err.println("Không được để trống tên danh mục, vui lòng nhập lại");
            }
        }while (true);
    }

    public boolean inputStatus(Scanner scanner){
        System.out.println("Vui lòng nhập vào trạng thái của danh mục");
        do {
            try {
                String status = scanner.nextLine();
                if(status.equals("true") || status.equals("false")){
                    return Boolean.parseBoolean(status);
                }else {
                    System.err.println("Trạng thái của danh mục phải là true hoặc false, vui lòng nhập lại");
                }
            }catch (Exception ex){
                System.err.println("Không được để trống trạng thái danh mục, vui lòng nhập lại");
            }
        }while (true);
    }

    public String toString(){
        if(this.status){
            return "ID: " + this.id + " - Name: " + this.name + " - Status: Hoạt động";
        }else {
            return "ID: " + this.id + " - Name: " + this.name + " - Status: Không hoạt động";
        }
    }
}
