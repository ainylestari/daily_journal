package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Koneksi {
    private static Connection koneksi;
    public static Statement statement;

    public static Connection getKoneksi() {
        try {
            if (koneksi == null || koneksi.isClosed()) {
                String url = "jdbc:mysql://localhost/daily_journal";
                String user = "root";
                String password = "";
                Class.forName("com.mysql.cj.jdbc.Driver");
                koneksi = DriverManager.getConnection(url, user, password);
                statement = koneksi.createStatement();
                System.out.println("Koneksi Berhasil");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("Koneksi Gagal: " + e.getMessage());
        }
        return koneksi;
    }
}
