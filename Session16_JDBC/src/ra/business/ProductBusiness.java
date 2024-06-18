package ra.business;

import com.mysql.cj.util.StringUtils;
import ra.entity.Product;
import ra.entity.StatisticProduct;
import ra.util.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class ProductBusiness {

    public static List<Product> getAllProduct(){
        Connection conn = null;
        CallableStatement callSt = null;
        List<Product> productList = null;
        try {
            productList = new ArrayList<>();
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call get_all_product()}");

            ResultSet rs = callSt.executeQuery();
            while (rs.next()){
                Product product = new Product();
                product.setProductId(rs.getString("product_id"));
                product.setProductName(rs.getString("product_name"));
                product.setProductPrice(rs.getFloat("price"));
                product.setProductTitle(rs.getString("title"));
                product.setCatalogId(rs.getInt("catalog_id"));
                product.setProductStatus(rs.getBoolean("product_status"));

                productList.add(product);
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return productList;
    }

    public static boolean createProduct(Product product){
        Connection conn = null;
        CallableStatement calLSt = null;
        boolean result = false;
        try {
            conn = ConnectionDB.openConnection();
            calLSt = conn.prepareCall("{call create_product(?,?,?,?,?,?)}");

            calLSt.setString(1, product.getProductId());
            calLSt.setString(2, product.getProductName());
            calLSt.setFloat(3, product.getProductPrice());
            calLSt.setString(4, product.getProductTitle());
            calLSt.setInt(5, product.getCatalogId());
            calLSt.setBoolean(6, product.isProductStatus());

            calLSt.executeUpdate();
            result = true;
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn, calLSt);
        }
        return result;
    }

    public static boolean isExistProductId(String productId){
        Connection conn = null;
        CallableStatement calLSt = null;
        try {
            conn = ConnectionDB.openConnection();
            calLSt = conn.prepareCall("{call is_exist_product(?,?)}");
            calLSt.setString(1, productId);
            calLSt.registerOutParameter(2, Types.INTEGER);
            calLSt.execute();
            boolean result = calLSt.getBoolean(2);
            return result;
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn, calLSt);
        }
        return false;
    }

    public static boolean updateProduct(Product product){
        Connection conn = null;
        CallableStatement calLSt = null;
        boolean result = false;
        try {
            conn = ConnectionDB.openConnection();
            calLSt = conn.prepareCall("{call update_product(?,?,?,?,?,?)}");
            calLSt.setString(1,product.getProductId());
            calLSt.setString(2, product.getProductName());
            calLSt.setFloat(3, product.getProductPrice());
            calLSt.setString(4, product.getProductTitle());
            calLSt.setInt(5, product.getCatalogId());
            calLSt.setBoolean(6, product.isProductStatus());
            calLSt.executeUpdate();

            result = true;
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn, calLSt);
        }

        return result;
    }

    public static Product getProductById(String productId){
        Connection conn = null;
        CallableStatement calLSt = null;
        Product product = null;
        try {
            product = new Product();
            conn = ConnectionDB.openConnection();
            calLSt = conn.prepareCall("{call get_product_by_id(?)}");
            calLSt.setString(1,productId);
            ResultSet rs = calLSt.executeQuery();

            if (rs.next()){
                product.setProductId(rs.getString("product_id"));
                product.setProductName(rs.getString("product_name"));
                product.setProductPrice(rs.getFloat("price"));
                product.setProductTitle(rs.getString("title"));
                product.setCatalogId(rs.getInt("catalog_id"));
                product.setProductStatus(rs.getBoolean("product_status"));
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn, calLSt);
        }
        return product;
    }

    public static boolean deleteProduct(String productId){
        Connection conn = null;
        CallableStatement callSt = null;
        boolean result = false;

        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call delete_product(?)}");
            callSt.setString(1, productId);
            callSt.executeUpdate();
            result = true;
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return result;
    }

    public static List<Product> findProducts(String stringInput){
        Connection conn = null;
        CallableStatement callSt = null;
        List<Product> productList = null;
        try {
            productList = new ArrayList<>();
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call find_product(?)}");
            callSt.setString(1,stringInput);
            ResultSet rs = callSt.executeQuery();

            while (rs.next()){
                Product product = new Product();
                product.setProductId(rs.getString("product_id"));
                product.setProductName(rs.getString("product_name"));
                product.setProductPrice(rs.getFloat("price"));
                product.setProductTitle(rs.getString("title"));
                product.setCatalogId(rs.getInt("catalog_id"));
                product.setProductStatus(rs.getBoolean("product_status"));

                productList.add(product);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn,callSt);
        }
        return productList;
    }

    public static List<StatisticProduct> statisticProductList(){
        Connection conn = null;
        CallableStatement callSt = null;
        List<StatisticProduct> statisticProductList = null;
        try {
            statisticProductList = new ArrayList<>();
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call statistic_product_by_catalog_id()}");

            ResultSet rs = callSt.executeQuery();

            while (rs.next()){
                StatisticProduct statisticProduct = new StatisticProduct();

                statisticProduct.setCatalogId(rs.getInt("catalog_id"));
                statisticProduct.setCatalogName(rs.getString("catalog_name"));
                statisticProduct.setCountProduct(rs.getInt("product_count"));

                statisticProductList.add(statisticProduct);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn,callSt);
        }
        return statisticProductList;
    }
}
