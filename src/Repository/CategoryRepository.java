package Repository;

import Model.Category;
import Model.Description;
import Utils.DbHandler;
import Utils.IdGenerator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;

public class CategoryRepository {

    private static CategoryRepository instance=null;


    public void addCategory (Category category) {
        String sql = "INSERT INTO category(category_name,description_id) VALUES ( ?,?)";

        try (
                Connection connection = DbHandler.getInstance().getDbConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
        ) {
            statement.setString(1, category.getName());
            statement.setString(2, category.getDescription().getId().toString());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public HashSet<Category> findCategories() {
        String sql = "SELECT * FROM category INNER JOIN description ON category.description_id = description.description_id";
        HashSet<Category> categories = new HashSet<>();

        try (
                Connection connection = DbHandler.getInstance().getDbConnection();
                PreparedStatement statement = connection.prepareStatement(sql);

        ) {
            ResultSet set = statement.executeQuery();

            while (set.next()){

                Description description = new Description(set.getInt("description_id"),set.getString("text"));
                Category category = new Category(
                        set.getInt("category_id"),
                        set.getString("category_name"),
                        description
                        //set.getInt("description_id")
                        //DescriptionRepository.getInstance().findDescriptionById(set.getInt("description_id"))
                );

                categories.add(category);
            }

            return categories;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }


    public Category findCategoryById(Integer id) {

        String sql = "SELECT * FROM category INNER JOIN description ON category.description_id = description.description_id WHERE category_id = ?";

        try (
                Connection connection = DbHandler.getInstance().getDbConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
        ) {
            statement.setString(1, id.toString());
            ResultSet set = statement.executeQuery();

            if (set.next()) {
                Description description = new Description(set.getInt("description_id"),set.getString("text"));
                return new Category(
                        set.getInt("category_id"),
                        set.getString("category_name"),
                        description
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;

    }

    public void deleteCategoryByName(String name) {

        String sql = "DELETE FROM category WHERE category_name = ?";

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

    public void updateCategory(Category category) {

        String sql = "UPDATE category SET category_name = ?, description_id=? WHERE category_id = ?";

        try (
                Connection connection = DbHandler.getInstance().getDbConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
        ) {
            statement.setString(1, category.getName());
            statement.setString(2, category.getDescription().getId().toString());
            statement.setInt(3,category.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static CategoryRepository getInstance() {
        if (instance == null)
            instance = new CategoryRepository();
        return instance;
    }


}