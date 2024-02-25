package org.example.config;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabasePopulateService {
    public static void main(String[] args) {
        Connection conn = Database.getInstance().getConnection();
        String filePath = "src/SQL/2_populate_db.sql";
        try (Statement st = conn.createStatement()) {
            String content = new String(Files.readAllBytes(Paths.get(filePath)));
            st.executeUpdate(content);
        } catch (SQLException e) {
            System.out.println(String.format("Exception. Reason: %s", e.getMessage()));
            throw new RuntimeException("Can not run query");
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
