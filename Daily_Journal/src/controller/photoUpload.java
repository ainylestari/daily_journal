package controller;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class photoUpload {
    public static byte[] uploadPhoto(JFrame parentFrame) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Pilih Foto");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setAcceptAllFileFilterUsed(false);
        fileChooser.addChoosableFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Gambar (*.jpg, *.png)", "jpg", "png"));

        int result = fileChooser.showOpenDialog(parentFrame);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();

            try {
                return Files.readAllBytes(selectedFile.toPath());
            } catch (IOException e) {
                JOptionPane.showMessageDialog(parentFrame, "Gagal membaca foto: " + e.getMessage());
            }
        }
        return null;
    }
}
