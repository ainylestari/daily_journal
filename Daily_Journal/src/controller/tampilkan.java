package controller;

import java.sql.*;
import java.time.LocalDate;
import model.journal;

public class tampilkan {
    public static journal getJournalDataById(int id, int width, int height) {
        journal data = null;
        String sql = "SELECT judul, tanggal, foto FROM journal WHERE id_journal = ?";

        try (Connection conn = Koneksi.getKoneksi();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String judul = rs.getString("judul");
                LocalDate tanggal = rs.getDate("tanggal").toLocalDate();
                byte[] foto = rs.getBytes("foto");

                data = new journal(0, judul, "", foto, tanggal, 0);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }
}
