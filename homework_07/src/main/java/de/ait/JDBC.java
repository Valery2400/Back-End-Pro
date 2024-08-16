package de.ait;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class JDBC {
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
            Connection conn = DriverManager.getConnection(URL + DB, USERNAME, PASSWORD);
            return conn;
        } catch (SQLException e) {
            throw new RuntimeException("Get connection error: " + e.getMessage());
        }
    }
    public static List<Book> getAllBooks() {
        String sql = "SELECT * FROM t_book";

        try (Connection conn = getConnection()) {
          if (conn == null) {
              throw new SQLException("Connection error: ");
          }
          Statement statement = conn.createStatement();
          ResultSet resultSet = statement.executeQuery(sql);

          List<Book> books = new ArrayList<>();
          while (resultSet.next()) {
              Long id = resultSet.getLong("id");
              String title = resultSet.getString("title");
              String author = resultSet.getString("author");

              books.add(new Book(id, title, author));
          }
          return books;

        } catch (SQLException e) {
            throw new RuntimeException("Get connection error: " + e.getMessage());
        }
    }

}