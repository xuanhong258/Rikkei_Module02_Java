package ra.presentation;

import ra.business.DepartmentBusiness;
import ra.business.EmployeeBusiness;
import ra.entity.Department;
import ra.entity.Employee;
import ra.entity.StatisticEmployeeByDepartmentId;

import java.util.List;
import java.util.Scanner;

public class EmployeeManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("EMPLOYEE_MANAGEMENT");
            System.out.println("1. Quản lý phòng ban");
            System.out.println("2. Quản lý nhân viên");
            System.out.println("3. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    EmployeeManagement.departmentMenu(scanner);
                    break;
                case 2:
                    EmployeeManagement.employeeMenu(scanner);
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.err.println("Vui lòng nhập từ 1->3");
            }
        }while (true);
    }

    public static void departmentMenu(Scanner scanner){
        boolean isExist = true;
        do {
            System.out.println("1. Danh sách phòng ban");
            System.out.println("2. Tạo mới phòng ban");
            System.out.println("3. Cập nhật phòng ban");
            System.out.println("4. Xóa phòng ban");
            System.out.println("5. Thống kê số lương nhân viên theo mã phòng ban");
            System.out.println("6. Thoát");
            System.out.print("Lựa chọn của bạn: ");

            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    EmployeeManagement.findAllDepartment();
                    break;
                case 2:
                    EmployeeManagement.createDepartment(scanner);
                    break;
                case 3:
                    EmployeeManagement.updateDepartment(scanner);
                    break;
                case 4:
                    EmployeeManagement.deleteDepartment(scanner);
                    break;
                case 5:
                    EmployeeManagement.statisticEmployee();
                    break;
                case 6:
                    isExist = false;
                    break;
                default:
                    System.err.println("Vui lòng chọn từ 1-6");
            }

        }while (isExist);
    }

    public static void findAllDepartment(){
        List<Department> departmentList = DepartmentBusiness.findAllDepartment();

        departmentList.forEach(department -> department.displayData());
    }

    public static void createDepartment(Scanner scanner){
        Department departmentNew = new Department();
        departmentNew.inputData(scanner);
        boolean result = DepartmentBusiness.createDepartment(departmentNew);
        if (result){
            System.out.println("Thêm mới phòng ban thành công");
        }else {
            System.err.println("Thêm mới phòng ban thất bại");
        }
    }

    public static void updateDepartment(Scanner scanner){
        System.out.println("Nhập vào mã phòng ban cần cập nhật");
        String departmentId = scanner.nextLine();
        boolean result = DepartmentBusiness.isExistDepartment(departmentId);
        if (result){
            Department departmentUpdate = DepartmentBusiness.getDepartmentById(departmentId);
            boolean isExist = true;
            do {
                System.out.println("1. Cập nhật tên phòng ban");
                System.out.println("2. Cập nhật mô tả phòng ban");
                System.out.println("3. Cập nhật trạng thái phòng ban");
                System.out.println("4. Thoát");
                System.out.print("Lựa chon của bạn là: ");
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice){
                    case 1:
                        System.out.println("Nhập vào tên mới của phòng ban");
                        departmentUpdate.setDepartmentName(scanner.nextLine());
                        break;
                    case 2:
                        System.out.println("Nhập vào mô tả mới của phòng ban");
                        departmentUpdate.setDescription(scanner.nextLine());
                        break;
                    case 3:
                        System.out.println("Nhập vào trạng thái mới của phòng ban");
                        departmentUpdate.setIs_deleted(Boolean.parseBoolean(scanner.nextLine()));
                        break;
                    case 4:
                        isExist = false;
                        break;
                    default:
                        System.err.println("Vui lòng nhập từ 1->4");
                }
            }while (isExist);
            boolean resultUpdate = DepartmentBusiness.updateDepartment(departmentUpdate);
            if (resultUpdate){
                System.out.println("Cập nhật thành công");
            }else {
                System.err.println("Cập nhật thất bại");
            }
        }else {
            System.err.println("Mã phòng ban không tồn tại, vui lòng nhập lại ");
        }
    }

    public static void deleteDepartment(Scanner scanner){
        System.out.println("Nhập mã phòng ban muốn xóa");
        String departmentId = scanner.nextLine();
        boolean isExist = DepartmentBusiness.isExistDepartment(departmentId);
        if (isExist){
            if (DepartmentBusiness.deleteDepartment(departmentId)){
                System.out.println("Xóa phòng ban thành công");
            }else {
                System.err.println("Xóa phòng ban thất bại");
            }
        }else {
            System.err.println("Mã phòng ban không tồn tại, vui lòng nhập lại");
        }
    }

    public static void statisticEmployee(){
        List<StatisticEmployeeByDepartmentId> statisticEmployeeByList = DepartmentBusiness.statisticEmployee();

        statisticEmployeeByList.forEach(statisticEmployeeByDepartmentId -> statisticEmployeeByDepartmentId.displayData());
    }

    public static void employeeMenu(Scanner scanner){
        boolean isExist = true;
        do {
            System.out.println("1. Danh sách nhân viên");
            System.out.println("2. Tạo mới nhân viên");
            System.out.println("3. Cập nhật nhân viên");
            System.out.println("4. Xóa nhân viên");
            System.out.println("5. Hiển thị danh sách nhân viên theo tuổi giảm dần");
            System.out.println("6. Tìm kếm nhân viên theo họ hoặc tên");
            System.out.println("7. Thống kê số lượng nhân viên theo độ tuổi");
            System.out.print("Lựa chọn của bạn là: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    EmployeeManagement.getAllEmployee();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    isExist = false;
                    break;
                default:
                    System.err.println("Vui lòng nhập từ 1->7");
            }
        }while (isExist);
    }

    public static void getAllEmployee(){
        List<Employee> employeeList = EmployeeBusiness.findAllEmployee();
        employeeList.forEach(employee -> employee.displayData());
    }
}
