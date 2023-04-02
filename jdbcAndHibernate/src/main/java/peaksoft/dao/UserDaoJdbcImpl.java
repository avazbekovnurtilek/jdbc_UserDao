package peaksoft.dao;

import peaksoft.model.User;
import peaksoft.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJdbcImpl implements UserDao {

    public UserDaoJdbcImpl() {

    }

    public void createUsersTable() {
        String SQL = "CREATE TABLE IF NOT EXISTS users("+
                "id SERIAL PRIMARY KEY,"+
                "name VARCHAR(50) NOT NULL,"+
                "lastName VARCHAR(50) NOT NULL,"+
                "age SMALLINT);";
        try (Connection connection = Util.connection();
             Statement statement = connection.createStatement()){
            statement.executeUpdate(SQL);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void dropUsersTable() {
        String SQl = "DROP TABLE IF EXISTS users";
        try(Connection connection = Util.connection();
        Statement statement = connection.createStatement()){
            statement.executeUpdate(SQl);
            System.out.println("Таблица удалена!");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        String SQl = "INSERT INTO users(name,lastName,age)"+
                "VALUES(?,?,?)";
        try(Connection connection = Util.connection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQl)){
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,lastName);
            preparedStatement.setByte(3,age);
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void removeUserById(long id) {
        String SQL = "DELETE FROM users WHERE id = ?";
        try(Connection connection = Util.connection();
        PreparedStatement preparedStatement = connection.prepareStatement(SQL)){
            preparedStatement.setLong(1,id);
            preparedStatement.executeUpdate();
            System.out.println("Удален пользователь: "+id);
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    public List<User> getAllUsers() {
        String SQL = "SELECT * FROM users";
        List<User> users = new ArrayList<>();
        try (Connection connection = Util.connection();
        Statement statement = connection.createStatement()){
            ResultSet resultSet = statement.executeQuery(SQL);
            while (resultSet.next()){
                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setLastName(resultSet.getString("lastName"));
                user.setAge(resultSet.getByte("age"));
                users.add(user);
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        } return users;
    }

    public void cleanUsersTable() {
        String SQL = "TRUNCATE TABLE users";
        try (Connection con = Util.connection();
             Statement statement = con.createStatement()) {
            statement.executeUpdate(SQL);
           

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}