package Exercise02;

import java.util.Scanner;

public class Employee {
    private String employeeId;
    private String employeeName;
    private int age;
    private boolean gen;
    private float rate;
    private float slary;

    public Employee() {
    }
    public Employee(String employeeId, String employeeName, int age, boolean gen, float rate, float slary) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.age = age;
        this.gen = gen;
        this.rate = rate;
        this.slary = slary;
    }

    public void inputData(Scanner scanner){
        System.out.println("Nhập vào mã nhân viên: ");
        this.employeeId = scanner.nextLine();
        System.out.println("Nhập vào tên nhân viên: ");
        this.employeeName = scanner.nextLine();
        System.out.println("Nhập vào tuổi nhân viên: ");
        this.age = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập vào giới tính nhân viên: ");
        this.gen = Boolean.parseBoolean(scanner.nextLine());
        System.out.println("Nhập vào hệ số lương nhân viên: ");
        this.rate = Float.parseFloat(scanner.nextLine());
    }

    public void displayData(){
        System.out.printf("Mã nhân viên: %s - Tên nhân viên: %s - Tuổi: %d - Giới tính: %s", this.employeeId, this.employeeName, this.age, this.gen?"Nam":"Nữ");
        System.out.printf("Hệ số lương: %.2f - Lương: %.2f", this.rate, this.calSalary());
    }

    public float  calSalary(){
        return this.rate * 1300000;
    }
}
