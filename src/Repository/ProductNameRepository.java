package Repository;

import Model.Description;
import Model.ProductName;
import Utils.DbHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;

public class ProductNameRepository {

    public static ProductNameRepository instance =null;

    public void addProductName(ProductName productName) {
        String sql = "INSERT INTO productname(company_name,product) VALUES ( ?,?)";

        try (
                Connection connection = DbHandler.getInstance().getDbConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
        ) {
            statement.setString(1, productName.getCompanyName());
            statement.setString(2, productName.getProduct());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public HashSet<ProductName> findProductNames() {
        String sql = "SELECT * FROM productname";
        HashSet<ProductName> productNames = new HashSet<>();

        try (
                Connection connection = DbHandler.getInstance().getDbConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
        ) {
            ResultSet set = statement.executeQuery();

            while(set.next()){
                ProductName productName = new ProductName(
                        set.getInt("productname_id"),
                        set.getString("company_name"),
                        set.getString("product")
                );
                productNames.add(productName);
            }

           return productNames;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public ProductName findProductNameById(Integer id) {
        String sql = "SELECT * FROM productname WHERE productname_id = ?";

        try (
                Connection connection = DbHandler.getInstance().getDbConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
        ) {
            statement.setString(1, id.toString());

            ResultSet set = statement.executeQuery();

            if (set.next()) {
                return new ProductName(
                        set.getInt("productname_id"),
                        set.getString("company_name"),
                        set.getString("product")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void deleteProductNameByName(String name) {

        String sql = "DELETE FROM productname WHERE product = ?";

        try (
                Connection connection = DbHandler.getInstance().getDbConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
        ) {
            statement.setString(1, name);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }



    public void updateProductName(ProductName productName) {

        String sql = "UPDATE productname SET product = ? WHERE productname_id = ?";

        try (
                Connection connection = DbHandler.getInstance().getDbConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
        ) {
            statement.setString(1, productName.getProduct());
            statement.setString(2, productName.getId().toString());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ProductNameRepository getInstance() {
        if (instance == null)
            instance = new ProductNameRepository();
        return instance;
    }



}
