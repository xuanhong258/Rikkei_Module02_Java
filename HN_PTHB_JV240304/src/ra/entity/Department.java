package ra.entity;

import java.util.Scanner;

public class Department implements IEmployeeManagement{
    private String departmentId;
    private String departmentName;
    private String description;
    private boolean is_deleted;

    public Department() {
    }

    public Department(String departmentId, String departmentName, String description, boolean is_deleted) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.description = description;
        this.is_deleted = is_deleted;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isIs_deleted() {
        return is_deleted;
    }

    public void setIs_deleted(boolean is_deleted) {
        this.is_deleted = is_deleted;
    }

    @Override
    public void inputData(Scanner scanner) {
        System.out.println("Nhập vảo mã phòng ban");
        this.departmentId = scanner.nextLine();
        System.out.println("Nhập vào tên phòng ban");
        this.departmentName = scanner.nextLine();
        System.out.println("Nhập vào mô tả phòng ban");
        this.description = scanner.nextLine();
        System.out.println("Nhập vào trạng thái phòng ban");
        this.is_deleted = Boolean.parseBoolean(scanner.nextLine());
    }

    @Override
    public void displayData() {
        System.out.printf("ID phòng ban: %s - Tên phòng ban: %s - Mô tả: %s - Trạng thái: %s", this.departmentId, this.departmentName, this.description, this.is_deleted?"Hoạt động":"Đã xóa");
        System.out.print("\n");
    }
}
