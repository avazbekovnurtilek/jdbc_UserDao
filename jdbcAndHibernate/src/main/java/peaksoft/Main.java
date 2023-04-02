package peaksoft;

import peaksoft.model.User;
import peaksoft.service.UserServiceImpl;
import peaksoft.util.Util;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        System.out.println(Util.connection());
        UserServiceImpl userService = new UserServiceImpl();
        userService.createUsersTable();
        userService.dropUsersTable();
        userService.saveUser("Nurti","Avazbekov",(byte) 23);
        userService.removeUserById(3);
        for (User allUser : userService.getAllUsers()) {
            System.out.println(allUser);
        }
        userService.cleanUsersTable();
    }
}
