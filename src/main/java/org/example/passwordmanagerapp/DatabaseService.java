package org.example.passwordmanagerapp;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseService {
    private static final String URL = "jdbc:postgresql://localhost:5432/password";
    private static final String USER = "postgres";
    private static final String PASSWORD = "leyla@2006";

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static List<PasswordEntry> loadPasswords() {
        List<PasswordEntry> list = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT website, username, encrypted_password FROM passwords")) {

            while (rs.next()) {
                list.add(new PasswordEntry(
                        rs.getString("website"),
                        rs.getString("username"),
                        rs.getString("encrypted_password")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void savePassword(PasswordEntry entry) {
        String sql = "INSERT INTO passwords (website, username, encrypted_password) VALUES (?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, entry.getWebsite());
            pstmt.setString(2, entry.getUsername());
            pstmt.setString(3, entry.getEncryptedPassword());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
