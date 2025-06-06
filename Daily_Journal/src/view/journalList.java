package view;

import controller.journalController;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Image;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import model.journal;

public class journalList extends javax.swing.JFrame {
    
    private javax.swing.JPanel jPanelGrid;

    public journalList() {
        initComponents();

        jPanelGrid = new javax.swing.JPanel();
        jPanelGrid.setLayout(new java.awt.GridLayout(0, 3, 10, 10));

        JScrollPane scrollPane = new javax.swing.JScrollPane(jPanelGrid);
        scrollPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        // Masukkan scroll ke jPanelContent yang sudah ada di NetBeans GUI
        jPanelContent.setLayout(new java.awt.BorderLayout());
        jPanelContent.add(scrollPane, java.awt.BorderLayout.CENTER);

        tampilkanSemuaJournal();
        setLocationRelativeTo(null);
    }

    private void tampilkanSemuaJournal() {
        List<journal> dataList = journalController.getJournal();

        for (journal data : dataList) {
            JPanel panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
            panel.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));

            // FOTO
            if (data.getFoto() != null) {
                ImageIcon icon = new ImageIcon(data.getFoto());
                Image img = icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                JLabel lblFoto = new JLabel(new ImageIcon(img));
                lblFoto.setAlignmentX(JLabel.CENTER_ALIGNMENT);
                panel.add(lblFoto);
            } else {
                JLabel noImg = new JLabel("No Image");
                noImg.setAlignmentX(JLabel.CENTER_ALIGNMENT);
                panel.add(noImg);
            }

            // JUDUL
            JLabel lblJudul = new JLabel(data.getJudul());
            lblJudul.setAlignmentX(JLabel.CENTER_ALIGNMENT);
            lblJudul.setHorizontalAlignment(SwingConstants.CENTER);
            lblJudul.setFont(new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 14));
            panel.add(lblJudul);

            // TANGGAL
            JLabel lblTanggal = new JLabel(data.getTanggal().toString());
            lblTanggal.setAlignmentX(JLabel.CENTER_ALIGNMENT);
            lblTanggal.setHorizontalAlignment(SwingConstants.CENTER);
            lblTanggal.setFont(new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 10));
            lblTanggal.setForeground(java.awt.Color.GRAY);
            panel.add(lblTanggal);
            
            panel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); // Biar kelihatan bisa diklik
                panel.addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                        new detailJournal(data, journalList.this).setVisible(true);
                    }
                });

            jPanelGrid.add(panel);
        }

        jPanelGrid.revalidate();
        jPanelGrid.repaint();
    }
    
    public void refreshList() {
        jPanelGrid.removeAll();
        tampilkanSemuaJournal();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanelContent = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Daily Journal");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(123, 123, 123))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jButton1.setText("kembali");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelContentLayout = new javax.swing.GroupLayout(jPanelContent);
        jPanelContent.setLayout(jPanelContentLayout);
        jPanelContentLayout.setHorizontalGroup(
            jPanelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 405, Short.MAX_VALUE)
        );
        jPanelContentLayout.setVerticalGroup(
            jPanelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 406, Short.MAX_VALUE)
        );

        jButton4.setText("tambah journal");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton4)
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton4))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new menuUtama().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        new newJournal().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private javax.swing.JLabel jLabelFoto2;
    private javax.swing.JLabel jLabelJudul;
    private javax.swing.JLabel jLabelTanggal;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelContent;
    // End of variables declaration//GEN-END:variables
}
