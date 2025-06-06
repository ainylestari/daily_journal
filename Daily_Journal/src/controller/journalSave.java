package controller;

import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;

public class journalSave {
    public static void saveJournal(JFrame parentFrame, String title, String content, Date selectedDate, byte[] fotoData, int userId) {
        if (title.isEmpty() || content.isEmpty() || selectedDate == null) {
            JOptionPane.showMessageDialog(parentFrame, "Please fill all fields!", "Missing Info", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Simpan ke database
        saveToDatabase(title, content, selectedDate, fotoData, userId);

        // Feedback UI
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String dateString = sdf.format(selectedDate);

        if (fotoData != null) {
            ImageIcon imageIcon = new ImageIcon(fotoData);
            Image scaledImage = imageIcon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
            ImageIcon resizedIcon = new ImageIcon(scaledImage);

            JOptionPane.showMessageDialog(parentFrame,
                "Judul: " + title + "\nIsi: " + content + "\nTanggal: " + dateString,
                "Sukses",
                JOptionPane.INFORMATION_MESSAGE,
                resizedIcon
            );
        } else {
            JOptionPane.showMessageDialog(parentFrame, "Journal saved, but no photo was uploaded.", "Saved", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    
    
    public static void saveToDatabase(String title, String content, Date selectedDate, byte[] fotoData, int userId) {
        String sql = "INSERT INTO journal (judul, isi, tanggal, foto, user_id) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = Koneksi.getKoneksi();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, title);
            ps.setString(2, content);
            ps.setDate(3, new java.sql.Date(selectedDate.getTime()));
            ps.setBytes(4, fotoData);
            ps.setInt(5, userId); // tambahkan user_id di sini

            ps.executeUpdate();

            System.out.println("Berhasil disimpan ke database.");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Gagal menyimpan ke database: " + e.getMessage());
        }
}


}
