package org.example.config;

import org.example.props.PropertyReader;

import java.sql.*;

public class Database {
    public static final Database INSTANCE = new Database();
    private Connection connection;
    private Database () {
        try { String connectionURL = PropertyReader.getConnectionUrl();
            this.connection = DriverManager.getConnection(connectionURL, "sa", "");
        } catch (SQLException e) {
            throw new RuntimeException("Create connection exception. Reason: " + e.getMessage());
        }
    }
    public static Database getInstance() { return INSTANCE; }
    public Connection getConnection() { return connection; }

    public int executeUpdate (String query) {
        try (Statement st = connection.createStatement()) {
            return st.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println(String.format("Exception. Reason: %s", e.getMessage()));
            throw new RuntimeException("Can not run query");
        }
    }

}
