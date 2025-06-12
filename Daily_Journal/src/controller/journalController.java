package controller;

import model.Koneksi;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import model.Session;
import model.journal; // Perbaiki nama class agar konsisten

public class journalController {

    public static List<journal> getJournal() {
        List<journal> list = new ArrayList<>();
        String sql = "SELECT * FROM journal WHERE user_id = ?";
        int user_id = Integer.parseInt(Session.get_id_user());

        try (Connection conn = Koneksi.getKoneksi();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, user_id);

            try (ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {
                    int id = rs.getInt("id_journal");
                    String judul = rs.getString("judul");
                    String isi = rs.getString("isi");
                    LocalDate tanggal = rs.getDate("tanggal").toLocalDate();
                    byte[] foto = rs.getBytes("foto");

                    journal j = new journal(id, judul, isi, foto, tanggal, user_id);
                    list.add(j);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }



    public void hapusJournal(int id) {
        String sql = "DELETE FROM journal WHERE id_journal = ?";
        try (Connection conn = Koneksi.getKoneksi();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Journal berhasil dihapus.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateJournal(int id, String judul, String isi, byte[] foto) {
        String sql = "UPDATE journal SET judul = ?, isi = ?, foto = ? WHERE id_journal = ?";
        try (Connection conn = Koneksi.getKoneksi();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, judul);
            ps.setString(2, isi);
            ps.setBytes(3, foto);
            ps.setInt(4, id);

            ps.executeUpdate();
            System.out.println("Journal berhasil diupdate.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
