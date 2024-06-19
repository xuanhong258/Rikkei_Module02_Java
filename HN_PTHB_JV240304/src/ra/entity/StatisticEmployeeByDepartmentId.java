package ra.entity;

public class StatisticEmployeeByDepartmentId {
    private String departmentId;
    private String departmentName;
    private int employeeNumber;

    public StatisticEmployeeByDepartmentId() {
    }

    public StatisticEmployeeByDepartmentId(String departmentId, String departmentName, int employeeNumber) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.employeeNumber = employeeNumber;
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

    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(int employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public void displayData(){
        System.out.printf("Mã phòng ban: %s - Tên phòng ban: %s - Số lượng nhân viên: %d", this.departmentId, this.departmentName, this.employeeNumber);
        System.out.print("\n");
    }
}
