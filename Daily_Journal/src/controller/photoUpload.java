package controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import javax.swing.*;

public class photoUpload {
    public static String uploadPhoto(JFrame parentFrame) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Pilih Foto");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setAcceptAllFileFilterUsed(false);
        fileChooser.addChoosableFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Gambar (*.jpg, *.png)", "jpg", "png"));

        int result = fileChooser.showOpenDialog(parentFrame);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();

            File destDir = new File("photos");
            if (!destDir.exists()) {
                destDir.mkdirs();
            }

            File destFile = new File(destDir, selectedFile.getName());

            try {
                Files.copy(selectedFile.toPath(), destFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                JOptionPane.showMessageDialog(parentFrame, "Foto berhasil diunggah!");
                return destFile.getAbsolutePath();
            } catch (IOException e) {
                JOptionPane.showMessageDialog(parentFrame, "Gagal menyimpan foto: " + e.getMessage());
            }
        }

        return null;
    }
}
