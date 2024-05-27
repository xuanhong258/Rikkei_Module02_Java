package ra.businessImp;

import ra.business.IEmployee;

import java.util.Scanner;

public class Employee implements IEmployee {
    private String id;
    private String name;
    private int year;
    private float rate;
    private float commission;
    private float salary;
    private boolean status;

    public Employee() {
    }

    public Employee(String id, String name, int year, float rate, float commission, float salary, boolean status) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.rate = rate;
        this.commission = commission;
        this.salary = salary;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public float getCommission() {
        return commission;
    }

    public void setCommission(float commission) {
        this.commission = commission;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public void inputData(Scanner scanner) {
        this.id = inputId(scanner);
        this.name = inputName(scanner);
        this.year = inputYear(scanner);
        this.rate = inputRate(scanner);
        this.commission = inputCommission(scanner);
        this.status = inputStatus(scanner);
    }


    @Override
    public void displayData() {
        System.out.printf("Id: %s - Tên: %s - Năm sinh: %d - Hệ số lương: %.3f - Hoa hồng: %.3f", this.id, this. name, this.year, this.rate, this.commission);
        System.out.printf(" - Lương: %.3f - Status: %s", this.salary, this.status?"Đang làm việc":"Nghỉ việc");
        System.out.printf("\n");
    }

    public String inputId(Scanner scanner){
        System.out.println("Nhập vào Id nhân viên");
        return scanner.nextLine();
    }

    public String inputName(Scanner scanner){
        System.out.println("Nhập vào tên nhân viên");
        return scanner.nextLine();
    }

    public int inputYear(Scanner scanner){
        System.out.println("Nhập vào năm sinh nhân viên");
        return Integer.parseInt(scanner.nextLine());
    }

    public float inputRate(Scanner scanner){
        System.out.println("Nhập vào hệ số lương của nhân viên");
        return Float.parseFloat(scanner.nextLine());
    }

    public float inputCommission(Scanner scanner){
        System.out.println("Nhập vào hoa hồng của nhân viên hàng tháng:");
        return Float.parseFloat(scanner.nextLine());
    }

    public boolean inputStatus(Scanner scanner){
        System.out.println("Nhập vào trạng thái nhân viên");
        return Boolean.parseBoolean(scanner.nextLine());
    }

    public void calSalary(){
        this.salary = this.rate * BASIC_SALARY + this.commission;
    }
}
