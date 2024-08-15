package de.ait.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCDemo {
    static String DRIVER = "org.postgresql.Driver";
    static String URL = "jdbc:postgresql://localhost:5432/";
    static String DB = "app_43";
    static String USERNAME = "postgres";
    static String PASSWORD = "qwerty007";

    public static void loadDriver() {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Load driver error: " + DRIVER);

        }
    }

    public static Connection getConnection() {
        try {
            Connection connection = DriverManager.getConnection(URL + DB, USERNAME, PASSWORD);
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException("Create connection fail!");
        }
    }

    public static List<User> getAll() {
        String query = "SELECT * FROM t_user";

        try (Connection connection = getConnection()) {  //try-with-resources
            if (connection == null) {
                throw new SQLException("Connection fail!");
            }
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            List<User> result = new ArrayList<>();
            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");

                result.add(new User(id, name, email, password));

            }
            return result;

        } catch (SQLException e) {
throw new RuntimeException("Get all fail!");
        }


    }
}