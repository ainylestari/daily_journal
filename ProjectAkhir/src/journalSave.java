import java.awt.Image;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;

public class journalSave {
    public static void saveJournal(JFrame parentFrame, String title, String content, Date selectedDate, String fotoPath) {
        if (title.isEmpty() || content.isEmpty() || selectedDate == null) {
            JOptionPane.showMessageDialog(parentFrame, "Please fill all fields!", "Missing Info", JOptionPane.WARNING_MESSAGE);
            return;
        }

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String dateString = sdf.format(selectedDate);

        if (fotoPath != null) {
            ImageIcon imageIcon = new ImageIcon(fotoPath);
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
}
