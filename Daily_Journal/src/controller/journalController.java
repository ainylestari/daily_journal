package controller;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import model.journal; // Perbaiki nama class agar konsisten

public class journalController {

    public void simpanJournal(journal j) {
        String sql = "INSERT INTO journal (judul, isi, tanggal, foto, user_id) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = Koneksi.getKoneksi();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, j.getJudul());
            ps.setString(2, j.getIsi());
            ps.setDate(3, Date.valueOf(j.getTanggal()));
            ps.setBytes(4, j.getFoto());
            ps.setInt(5, j.getUser_id());

            ps.executeUpdate();
            System.out.println("Berhasil disimpan.");
        } catch (Exception e) {
            System.err.println("Gagal menyimpan: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static List<journal> getJournal() {
        List<journal> list = new ArrayList<>();
        String sql = "SELECT * FROM journal";

        try (Connection conn = Koneksi.getKoneksi();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id_journal");
                String judul = rs.getString("judul");
                String isi = rs.getString("isi");
                LocalDate tanggal = rs.getDate("tanggal").toLocalDate();
                byte[] foto = rs.getBytes("foto");

                journal j = new journal(id, judul, isi, foto, tanggal, 0);
                list.add(j);
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
