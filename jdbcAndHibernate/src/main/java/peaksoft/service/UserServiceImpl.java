package peaksoft.service;

import peaksoft.dao.UserDaoJdbcImpl;
import peaksoft.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {
    UserDaoJdbcImpl userDaoJdbc = new UserDaoJdbcImpl();

    public void createUsersTable() {
        userDaoJdbc.createUsersTable();
    }

    public void dropUsersTable() {
        userDaoJdbc.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
        userDaoJdbc.saveUser("Sadyr","Zhaparov",(byte)49);
        userDaoJdbc.saveUser("Vladimir","Putin",(byte)60);
        userDaoJdbc.saveUser("Joe","Baiden",(byte)82);
        userDaoJdbc.saveUser("Xi","Jinping",(byte)76);
    }

    public void removeUserById(long id) {
        userDaoJdbc.removeUserById(3);
    }

    public List<User> getAllUsers() {
        return userDaoJdbc.getAllUsers();
    }

    public void cleanUsersTable() {
        userDaoJdbc.cleanUsersTable();
    }
}
