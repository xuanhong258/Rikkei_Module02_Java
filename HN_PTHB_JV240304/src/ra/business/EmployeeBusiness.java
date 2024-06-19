package ra.business;

import ra.entity.Employee;
import ra.util.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmployeeBusiness {
    public static List<Employee> findAllEmployee(){
        Connection conn = null;
        CallableStatement callSt = null;
        List<Employee> employeeList = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call proc_get_all_employee()}");
            ResultSet rs = callSt.executeQuery();
            employeeList = new ArrayList<>();
            while (rs.next()){
                Employee employee = new Employee();
                employee.setEmployeeId(rs.getInt("employee_id"));
                employee.setFirstName(rs.getString("first_name"));
                employee.setLastName(rs.getString("last_name"));
                employee.setDateOfBirth(rs.getDate("date_of_birth"));
                employee.setPhone(rs.getString("phone"));
                employee.setAddress(rs.getString("address"));
                employee.setSalary(rs.getDouble("salary"));
                employee.setCreateAt(rs.getDate("created_at"));
                employee.setUpdateAt(rs.getDate("update_at"));
                employee.setDelete(rs.getBoolean("is_deleted"));
                employee.setDepartmentId(rs.getString("department_id"));
                employeeList.add(employee);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn,callSt);
        }
        return employeeList;
    }

}
