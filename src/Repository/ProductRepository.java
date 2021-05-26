package Repository;

import Model.*;
import Utils.DbHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;

public class ProductRepository {


    public static ProductRepository instance = null;

    public void addProduct(Product product) {
        String sql = "INSERT INTO product(productname_id,stock_id,description_id,quantity) VALUES ( ?,?,?,?)";

        try (
                Connection connection = DbHandler.getInstance().getDbConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
        ) {
            statement.setString(1, product.getName().getId().toString());
            statement.setString(2, product.getStock().getId().toString());
            statement.setString(3,product.getDescription().getId().toString());
            statement.setString(4,product.getQuantity());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public HashSet<Product> findProducts() {
        String sql = "SELECT * FROM product INNER JOIN productname,stock,description ON product.productname_id = productname.productname_id,product.stock_id = stock.stock_id,product.description_id = description.description_id";
        HashSet<Product> products = new HashSet<>();

        try (
                Connection connection = DbHandler.getInstance().getDbConnection();
                PreparedStatement statement = connection.prepareStatement(sql);

        ) {
            ResultSet set = statement.executeQuery();

            while (set.next()){
                ProductName productName = new ProductName(set.getInt("productname_id"),set.getString("company_name"),set.getString("product"));
                Stock stock = new Stock(set.getInt("stock_id"),set.getInt("stock_marketcap"),set.getInt("stock_number"));
                Description description = new Description(set.getInt("description_id"),set.getString("text"));
                Product product = new Product(
                        set.getInt("product_id"),
                        productName,
                        stock,
                        description,
                        set.getString("quantity")
                        //set.getInt("description_id")
                        //DescriptionRepository.getInstance().findDescriptionById(set.getInt("description_id"))
                );

                products.add(product);
            }

            return products;

        } catch (SQLException e) {
            e.printStackTrace();
        }
    return null;

    }
/*
    public Product findProductById(Integer id) {
        return products.get(id);
    }

    public void deleteProductByName(String name) {

        for(int i=0 ; i<products.size();i++)
        {
            if(products.get(i).getName().getCompanyName()==name)
            {
                products.remove(i);
            }

        }

    }
*/
   /* public void updateProduct(Product product) {

        for(int i=0 ; i<products.size();i++){
            if(products.get(i)==product)
            {
                products.set(i,product);

            }

        }
    }

    */

    public static ProductRepository getInstance() {
        if (instance == null)
            instance = new ProductRepository();
        return instance;
    }


}
