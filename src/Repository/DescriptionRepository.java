package Repository;

import Model.Category;
import Model.Company;
import Model.Description;
import Utils.DbHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;

public class DescriptionRepository {


    public static DescriptionRepository instance = null;

    public void addDescription(Description description) {
        String sql = "INSERT INTO description(text) VALUES (?)";

        try (
                Connection connection = DbHandler.getInstance().getDbConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
        ) {
            statement.setString(1, description.getName());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public HashSet<Description> findDescriptions() {
        String sql = "SELECT * FROM description";
        HashSet<Description> descriptions = new HashSet<>();

        try (
                Connection connection = DbHandler.getInstance().getDbConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
        ) {
            ResultSet set = statement.executeQuery();

            while(set.next()){
                Description description = new Description(
                        set.getInt("description_id"),
                        set.getString("text")

                );
                descriptions.add(description);
            }

            return descriptions;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;

    }

    public Description findDescriptionById(Integer id) {

        String sql = "SELECT * FROM description WHERE description_id = ?";

        try (
                Connection connection = DbHandler.getInstance().getDbConnection();
                PreparedStatement statement_desc = connection.prepareStatement(sql);
        ) {
            statement_desc.setString(1, id.toString());

            ResultSet set_desc = statement_desc.executeQuery();

            if (set_desc.next()) {
                return new Description(
                        set_desc.getInt("description_id"),
                        set_desc.getString("text")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void deleteDescriptionByName(String name) {

        String sql = "DELETE FROM description WHERE text = ?";

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

    public void updateDescription(Description description) {

        String sql = "UPDATE description SET text = ? WHERE description_id = ?";

        try (
                Connection connection = DbHandler.getInstance().getDbConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
        ) {
            statement.setString(1, description.getName());
            statement.setString(2, description.getId().toString());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static DescriptionRepository getInstance() {
        if (instance == null)
            instance = new DescriptionRepository();
        return instance;
    }



}
