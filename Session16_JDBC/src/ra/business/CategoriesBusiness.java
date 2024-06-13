package ra.business;

import ra.entity.Categories;
import ra.util.ConnectionDB;

import java.lang.reflect.Type;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class CategoriesBusiness {
    public static List<Categories> findAll(){
        Connection conn = null;
        CallableStatement callSt = null;
        List<Categories> categoriesList = null;

        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call get_all_category()}");
            ResultSet rs = callSt.executeQuery();
            categoriesList = new ArrayList<>();
            while (rs.next()){
                Categories catalog = new Categories();
                catalog.setCatalogId(rs.getInt("catalog_id"));
                catalog.setCatalogName(rs.getString("catalog_name"));
                catalog.setDescription(rs.getString("description"));
                catalog.setStatus(rs.getBoolean("catalog_status"));
                categoriesList.add(catalog);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn,callSt);
        }
        return categoriesList;
    }

    public static boolean create(Categories categories){
        Connection conn = null;
        CallableStatement callSt = null;
        boolean result = false;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call create_catalog(?,?,?)}");
            callSt.setString(1, categories.getCatalogName());
            callSt.setString(2,categories.getDescription());
            callSt.setBoolean(3, categories.isStatus());
            callSt.executeUpdate();
            result = true;
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn,callSt);
        }
        return result;
    }

    public static boolean updateCatalog(Categories categories){
        Connection conn = null;
        CallableStatement callSt = null;
        boolean result = false;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call update_catalog(?,?,?,?)}");
            callSt.setInt(1, categories.getCatalogId());
            callSt.setString(2, categories.getCatalogName());
            callSt.setString(3, categories.getDescription());
            callSt.setBoolean(4, categories.isStatus());
            callSt.executeUpdate();
            result = true;
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return result;
    }

    public static boolean isExistCatalog(int catalogId){
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call is_exist_catalog(?,?)}");
            callSt.setInt(1, catalogId);
            callSt.registerOutParameter(2, Types.INTEGER);
            callSt.execute();
            boolean result = callSt.getBoolean(2);
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return false;
    }

    public static Categories getCatalogById(int catalogId){
        Connection conn = null;
        CallableStatement callSt = null;
        Categories catalog = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call get_catalog_by_id(?)}");
            callSt.setInt(1, catalogId);
            ResultSet rs = callSt.executeQuery();
            catalog = new Categories();
            if(rs.next()){
                catalog.setCatalogId(rs.getInt("catalog_id"));
                catalog.setCatalogName(rs.getString("catalog_name"));
                catalog.setDescription(rs.getString("description"));
                catalog.setStatus(rs.getBoolean("catalog_status"));
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return catalog;
    }
}
