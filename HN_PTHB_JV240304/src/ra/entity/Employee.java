package ra.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Employee implements IEmployeeManagement{
    private int employeeId;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String phone;
    private String address;
    private double salary;
    private Date createAt;
    private Date updateAt;
    private boolean isDelete;
    private String departmentId;

    public Employee() {
    }

    public Employee(int employeeId, String firstName, String lastName, Date dateOfBirth, String phone, String address, double salary, Date createAt, Date updateAt, boolean isDelete, String departmentId) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.phone = phone;
        this.address = address;
        this.salary = salary;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.isDelete = isDelete;
        this.departmentId = departmentId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    @Override
    public void inputData(Scanner scanner) {
        System.out.println("Nhập vào tên & tên đệm nhân viên");
        this.firstName = scanner.nextLine();
        System.out.println("Nhập vào họ nhân viên");
        this.lastName = scanner.nextLine();
        System.out.println("Nhập vào ngày sinh");
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            this.dateOfBirth = sf.parse(scanner.nextLine());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Nhập vào số điện thoại");
        this.phone = scanner.nextLine();
        System.out.println("Nhập vào địa chỉ");
        this.address = scanner.nextLine();
        System.out.println("Nhập vào lương nhân viên");
        this.salary = Double.parseDouble(scanner.nextLine());
        System.out.println("Nhập vào ngày tạo");
        try {
            this.createAt = sf.parse(scanner.nextLine());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Nhập vào ngày cập nhật");
        try {
            this.updateAt = sf.parse(scanner.nextLine());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Nhập vào trạng thái nhân viên");
        this.isDelete = Boolean.parseBoolean(scanner.nextLine());
        System.out.println("Nhập vào mã phòng ban");
        this.departmentId = scanner.nextLine();
    }

    @Override
    public void displayData() {
        System.out.printf("ID: %d - Tên: %s - Họ: %s - Ngày sinh: %s - SDT: %s - Address: %s", this.employeeId, this.firstName, this.lastName, this.dateOfBirth, this.phone, this.address);
        System.out.printf(" - Lương: %.3f - Ngày tạo: %s - Ngày cập nhật: %s - Trạng thái: %s - Mã phòng ban: %s", this.salary, this.createAt, this.updateAt, this.isDelete?"Hoạt động":"Nghỉ việc", this.departmentId);
        System.out.print("\n");
    }
}
