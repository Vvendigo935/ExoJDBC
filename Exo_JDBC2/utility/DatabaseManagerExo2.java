package org.example.Exo_JDBC2.utility;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DatabaseManagerExo2 {
    private final String URI = "jdbc:mysql://localhost:3306/exo_jdbc2";
    private final String USER = "root";
    private final String PASSWORD = "test";

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URI,USER,PASSWORD);
    }
}