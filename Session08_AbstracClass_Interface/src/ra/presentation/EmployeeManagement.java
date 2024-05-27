package ra.presentation;

import ra.businessImp.Employee;

import java.util.Scanner;

public class EmployeeManagement {
    static int currentIndex = 0;
    static Employee[] arrEmployee = new Employee[1000];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("**************MENU****************");
            System.out.println("1. Nhập thông tin cho n nhân viên");
            System.out.println("2. Hiển thị thông tin nhân viên");
            System.out.println("3. Tính lương cho các nhân viên");
            System.out.println("4. Tìm kiếm nhân viên theo tên nhân viên");
            System.out.println("5. Cập nhật thông tin nhân viên");
            System.out.println("6. Xóa nhân viên theo mã nhân viên");
            System.out.println("7. Sắp xếp nhân viên theo lương tăng dần");
            System.out.println("8. Sắp xếp nhân viên theo tên nhân viên giảm dần");
            System.out.println("9. Thoát");
            System.out.println("Lựa chọn của bạn là:");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice){
                case 1:
                    inputListEmployee(scanner);
                    break;
                case 2:
                    displayListEmployee();
                    break;
                case 3:
                    calListEmployee();
                    break;
                case 4:
                    searchEmployeeByName(scanner);
                    break;
                case 5:
                    updateEmployeeById(scanner);
                    break;
                case 6:
                    deleteEmployeeById(scanner);
                    break;
                case 7:
                    sortEmployeeBySalary();
                    break;
                case 8:
                    sortEmployeeByName();
                    break;
                case 9:
                    System.exit(0);
                    break;
                default:
                    System.err.println("Vui lòng nhập từ 1 -> 9");
            }
        }while (true);
    }

    public static void inputListEmployee(Scanner scanner){
        System.out.println("Nhập vào số lượng nhân viên muốn nhập thông tin");
        int numbers = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numbers; i++) {
            arrEmployee[currentIndex] = new Employee();
            arrEmployee[currentIndex].inputData(scanner);
            currentIndex++;
        }
    }

    public static void displayListEmployee(){
        for (int i = 0; i < currentIndex; i++) {
            arrEmployee[i].displayData();
            System.out.printf("\n");
        }
    }

    public static void calListEmployee(){
        for (int i = 0; i < currentIndex; i++) {
            arrEmployee[i].calSalary();
        }
    }

    public static int searchEmployee(String input, String searchType){
        int index = -1;
        switch (searchType){
            case "id":
                for (int i = 0; i < currentIndex; i++) {
                    if (arrEmployee[i].getId().equals(input)){
                        index = i;
                    }
                }
                break;
            case "name":
                for (int i = 0; i < currentIndex; i++) {
                    if (arrEmployee[i].getName().equals(input)){
                        index = i;
                    }
                }
                break;
            default:
                break;
        }
        return index;
    }

    public static void searchEmployeeByName(Scanner scanner){
        System.out.println("Nhập vào tên nhân viên muốn tìm kiếm");
        String name = scanner.nextLine();
        int index = searchEmployee(name, "name");
        if(index >= 0){
            arrEmployee[index].displayData();
        }else {
            System.err.println("Tên nhân viên không tồn tại, vui lòng nhập lại");
        }
    }
    public static void updateEmployeeById(Scanner scanner){
        System.out.println("Nhập vào id của nhân viên cần cập nhật thông tin");
        String id = scanner.nextLine();
        int index = searchEmployee(id, "id");
        if(index >= 0){
            boolean isExit = true;
            do {
                System.out.println("Nhập thông tin muốn cập nhật:");
                System.out.println("1. Tên nhân viên");
                System.out.println("2. Năm sinh nhân viên");
                System.out.println("3. Hệ số lương");
                System.out.println("4. Hoa hồng nhân viên");
                System.out.println("5. Trạng thái nhân viên");
                System.out.println("6. Thoát");

                System.out.println("Vui lòng nhập vào sự lụa chọn của ban");
                int yourChoice = Integer.parseInt(scanner.nextLine());
                switch (yourChoice){
                    case 1:
                        arrEmployee[index].setName(updateName(scanner));
                        break;
                    case 2:
                        arrEmployee[index].setYear(updateYear(scanner));
                        break;
                    case 3:
                        arrEmployee[index].setRate(updateRate(scanner));
                        break;
                    case 4:
                        arrEmployee[index].setCommission(updateCommission(scanner));
                        break;
                    case 5:
                        arrEmployee[index].setStatus(updateStatus(scanner));
                        break;
                    case 6:
                        isExit = false;
                        break;
                    default:
                        System.err.println("Vui lòng lựa chọn từ 1 -> 6");
                        break;
                }
            }while (isExit);
        }else {
            System.err.println("Id nhân viên không tồn tại, vui lòng nhập lại");
        }
    }

    public static String updateName(Scanner scanner){
        System.out.println("Nhập tên mới của nhân viên: ");
        return scanner.nextLine();
    }

    public static int updateYear(Scanner scanner){
        System.out.println("Nhập năm sinh mới của nhân viên");
        return Integer.parseInt(scanner.nextLine());
    }
    public static float updateRate(Scanner scanner){
        System.out.println("Nhập vào hệ số lương mới cho nhân viên");
        return Float.parseFloat(scanner.nextLine());
    }

    public static float updateCommission(Scanner scanner){
        System.out.println("Nhập vào hoa hồng mới cho nhân viên");
        return Float.parseFloat(scanner.nextLine());
    }

    public static boolean updateStatus(Scanner scanner){
        System.out.println("Nhập vào trạng thái mới cho nhân viên true or false");
        return Boolean.parseBoolean(scanner.nextLine());
    }

    public static void deleteEmployeeById(Scanner scanner){
        System.out.println("Nhập vào id của nhân viên cần xóa");
        String id = scanner.nextLine();
        int index = searchEmployee(id, "id");
        if(index >= 0){
            for (int i = index; i < currentIndex; i++) {
                arrEmployee[i] = arrEmployee[i + 1];
            }
            currentIndex--;
        }else{
            System.err.println("Mã nhân viên không tồn tại, vui lòng nhập lại");
        }
    }

    public static void sortEmployeeBySalary(){
        for (int i = 0; i < currentIndex - 1; i++) {
            for (int j = i + 1; j < currentIndex; j++) {
                if (arrEmployee[i].getSalary() > arrEmployee[j].getSalary()){
                    Employee tmp = arrEmployee[i];
                    arrEmployee[i] = arrEmployee[j];
                    arrEmployee[j] = tmp;
                }
            }
        }
    }

    public static void sortEmployeeByName(){
        for (int i = 0; i < currentIndex - 1; i++) {
            for (int j = i + 1; j < currentIndex; j++) {
                if (arrEmployee[i].getName().compareToIgnoreCase(arrEmployee[j].getName()) <= 0){
                    Employee tmp = arrEmployee[i];
                    arrEmployee[i] = arrEmployee[j];
                    arrEmployee[j] = tmp;
                }
            }
        }
    }
}
