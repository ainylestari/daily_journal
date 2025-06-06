package controller;

import controller.Koneksi;
import java.sql.*;
import javax.swing.JOptionPane;
import model.Session;

public class ModelLogin {

    public boolean isLogin(String username, String password) {
        String sql = "SELECT * FROM user WHERE username = ? AND password = ?";
        try (Connection conn = Koneksi.getKoneksi();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            return rs.next(); // Jika ada baris = login berhasil
        } catch (Exception e) {
            System.out.println("Login Error: " + e.getMessage());
            return false;
        }
    }

    public void setUserSession(String username) {
        String sql = "SELECT id_user, username FROM user WHERE username = ?";
        try (Connection conn = Koneksi.getKoneksi();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Session.set_id_user(rs.getString("id_user"));
                Session.set_username(rs.getString("username"));
            }
        } catch (Exception e) {
            System.out.println("setUserSession Error: " + e.getMessage());
        }
    }

    public boolean isRegister(String username, String password) {
        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Username dan Password tidak boleh kosong!");
            return false;
        }

        String checkQuery = "SELECT * FROM user WHERE username = ?";
        String insertQuery = "INSERT INTO user (username, password) VALUES (?, ?)";

        try (Connection conn = Koneksi.getKoneksi();
             PreparedStatement checkStmt = conn.prepareStatement(checkQuery);
             PreparedStatement insertStmt = conn.prepareStatement(insertQuery)) {

            checkStmt.setString(1, username);
            ResultSet rs = checkStmt.executeQuery();

            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Username sudah digunakan. Silakan gunakan username lain.");
                return false;
            }

            insertStmt.setString(1, username);
            insertStmt.setString(2, password);
            insertStmt.executeUpdate();
            return true;

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan saat register: " + ex.getMessage());
            return false;
        }
    }
}
