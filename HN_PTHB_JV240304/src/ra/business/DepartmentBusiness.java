package ra.business;

import ra.entity.Department;
import ra.entity.StatisticEmployeeByDepartmentId;
import ra.util.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class DepartmentBusiness {

    public static List<Department> findAllDepartment(){
        Connection conn = null;
        CallableStatement callSt = null;
        List<Department> departmentList = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call proc_find_all_department()}");
            ResultSet rs = callSt.executeQuery();
            departmentList = new ArrayList<>();
            while (rs.next()){
                Department department = new Department();
                department.setDepartmentId(rs.getString("department_id"));
                department.setDepartmentName(rs.getString("department_name"));
                department.setDescription(rs.getString("description"));
                department.setIs_deleted(rs.getBoolean("is_deleted"));

                departmentList.add(department);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn,callSt);
        }
        return departmentList;
    }

    public static boolean createDepartment(Department department){
        Connection conn = null;
        CallableStatement callSt = null;
        boolean result = false;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call proc_create_department(?,?,?,?)}");
            callSt.setString(1,department.getDepartmentId());
            callSt.setString(2, department.getDepartmentName());
            callSt.setString(3, department.getDescription());
            callSt.setBoolean(4, department.isIs_deleted());

            callSt.executeUpdate();
            result = true;
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn,callSt);
        }
        return  result;
    }

    public static Department getDepartmentById(String departmentId){
        Connection conn = null;
        CallableStatement callSt = null;
        Department department = new Department();
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call proc_get_department_by_id(?)}");
            callSt.setString(1, departmentId);
            ResultSet rs = callSt.executeQuery();
            if(rs.next()){
                department.setDepartmentId(rs.getString("department_id"));
                department.setDepartmentName(rs.getString("department_name"));
                department.setDescription(rs.getString("description"));
                department.setIs_deleted(rs.getBoolean("is_deleted"));
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn,callSt);
        }
        return department;
    }

    public static boolean isExistDepartment(String departmentId){
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call proc_is_exist_department(?,?)}");
            callSt.setString(1, departmentId);
            callSt.registerOutParameter(2, Types.INTEGER);
            callSt.executeUpdate();
            boolean result = callSt.getBoolean(2);
            return result;
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn,callSt);
        }
        return false;
    }
    public static boolean updateDepartment(Department department){
        Connection conn = null;
        CallableStatement callSt = null;
        boolean result = false;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call proc_update_department(?,?,?,?)}");
            callSt.setString(1,department.getDepartmentId());
            callSt.setString(2, department.getDepartmentName());
            callSt.setString(3, department.getDescription());
            callSt.setBoolean(4, department.isIs_deleted());

            callSt.executeUpdate();
            result = true;
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn,callSt);
        }
        return result;
    }

    public static boolean deleteDepartment(String departmentId) {
        Connection conn = null;
        CallableStatement callSt = null;
        boolean result = false;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call proc_delete_department(?)}");
            callSt.setString(1,departmentId);
            callSt.executeUpdate();
            result = true;
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn,callSt);
        }
        return result;
    }

    public static List<StatisticEmployeeByDepartmentId> statisticEmployee(){
        Connection conn = null;
        CallableStatement callSt = null;
        List<StatisticEmployeeByDepartmentId> statisticEmployeeList = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call proc_statistic_employee_by_department_id()}");
            ResultSet rs = callSt.executeQuery();
            statisticEmployeeList = new ArrayList<>();
            while (rs.next()){
                StatisticEmployeeByDepartmentId statisticEmployee = new StatisticEmployeeByDepartmentId();
                statisticEmployee.setDepartmentId(rs.getString("department_id"));
                statisticEmployee.setDepartmentName(rs.getString("department_name"));
                statisticEmployee.setEmployeeNumber(rs.getInt("employeeNumber"));
                statisticEmployeeList.add(statisticEmployee);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn,callSt);
        }
        return statisticEmployeeList;
    }
}
