package Repository;

import Model.ProductName;
import Model.Stock;
import Utils.DbHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;

public class StockRepository {

    public static StockRepository instance =null;

    public void addStock(Stock stock) {
        String sql = "INSERT INTO stock(stock_marketcap,stock_number) VALUES ( ?,?)";

        try (
                Connection connection = DbHandler.getInstance().getDbConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
        ) {
            statement.setInt(1, stock.getMarketCap());
            statement.setInt(2, stock.getNumber());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public HashSet<Stock> findStocks() {
        String sql = "SELECT * FROM stock";
        HashSet<Stock> stocks = new HashSet<>();

        try (
                Connection connection = DbHandler.getInstance().getDbConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
        ) {
            ResultSet set = statement.executeQuery();

            while(set.next()){
                Stock stock = new Stock(
                        set.getInt("stock_id"),
                        set.getInt("stock_marketcap"),
                        set.getInt("stock_number")
                );
                stocks.add(stock);
            }

            return stocks;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;

    }

    public Stock findStockById(Integer id) {

        String sql = "SELECT * FROM stocks WHERE stock_id = ?";

        try (
                Connection connection = DbHandler.getInstance().getDbConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
        ) {
            statement.setString(1, id.toString());

            ResultSet set = statement.executeQuery();

            if (set.next()) {
                return new Stock(
                        set.getInt("stock_id"),
                        set.getInt("stock_marketcap"),
                        set.getInt("stock_number")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void deleteStockByMarketCap(Integer marketCap) {
        String sql = "DELETE FROM stock WHERE stock_marketcap = ?";

        try (
                Connection connection = DbHandler.getInstance().getDbConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
        ) {
            statement.setInt(1, marketCap);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateStocks(Stock stock) {

        String sql = "UPDATE stock SET stock_marketcap = ?,stock_number = ? WHERE stock_id = ?";

        try (
                Connection connection = DbHandler.getInstance().getDbConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
        ) {
            statement.setInt(1, stock.getMarketCap());
            statement.setInt(1, stock.getMarketCap());
            statement.setInt(2, stock.getNumber());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static StockRepository getInstance() {
        if (instance == null)
            instance = new StockRepository();
        return instance;
    }

}
