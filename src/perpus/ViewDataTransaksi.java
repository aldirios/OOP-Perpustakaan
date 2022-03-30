package perpus;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ViewDataTransaksi extends javax.swing.JFrame {

    private DefaultTableModel tabmode;

    private void tampil_transaksi(String nama) {
        TransaksiBuku transaksiBuku = new TransaksiBuku();
        ArrayList<TransaksiBuku> allTransaksi = new ArrayList<>();
        try {
            allTransaksi = transaksiBuku.read(nama);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Object[] baris = {"No", "Peminjam", "Buku", "Tgl Pinjam", "Batas Kembali", "Tgl Kembali", "Status","Denda"};
        tabmode = new DefaultTableModel(null, baris);
        tabel.setModel(tabmode);
        try {
            int i = 1;
            for (TransaksiBuku transaksi : allTransaksi) {
                String peminjam = transaksi.getPeminjam();
                String buku = transaksi.getBuku();
                Date pinjam = transaksi.getTanggal_pinjam();
                Date kembali = transaksi.getTanggal_kembali();
                String status = transaksi.getSts_pengembalian();
                Date batas = transaksi.getBatas_kembali();
                String telat = transaksi.getDenda();
                Object[] data = {i, peminjam, buku, pinjam, batas, kembali, status, telat};
                i++;
                tabmode.addRow(data);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Menampilkan data GAGAL", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void tampil_transaksi() {
        try {
            TransaksiBuku transaksiBuku = new TransaksiBuku();
            ArrayList<TransaksiBuku> allTransaksi = transaksiBuku.read();           
            Object[] baris = {"No", "Peminjam", "Buku", "Tgl Pinjam", "Batas Kembali", "Tgl Kembali", "Status","Denda"};
            tabmode = new DefaultTableModel(null, baris);
            tabel.setModel(tabmode);
            try {
                int i = 1;
                for (TransaksiBuku transaksi : allTransaksi) {
                    String peminjam = transaksi.getPeminjam();
                    String buku = transaksi.getBuku();
                    Date pinjam = transaksi.getTanggal_pinjam();
                    Date kembali = transaksi.getTanggal_kembali();
                    String status = transaksi.getSts_pengembalian();
                    Date batas = transaksi.getBatas_kembali();
                    String telat = transaksi.getDenda();
                    Object[] data = {i, peminjam, buku, pinjam, batas, kembali, status, telat};
                    i++;
                    tabmode.addRow(data);            
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Menampilkan data GAGAL", "Informasi", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Menampilkan data GAGAL", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public ViewDataTransaksi() {
        initComponents();
        tampil_transaksi();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        b_back = new javax.swing.JButton();
        nama = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        b_cari = new javax.swing.JToggleButton();
        refresh = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        tabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6"
            }
        ));
        jScrollPane1.setViewportView(tabel);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(12, 82, 598, 194);

        b_back.setText("Kembali");
        b_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_backActionPerformed(evt);
            }
        });
        getContentPane().add(b_back);
        b_back.setBounds(10, 290, 77, 25);
        getContentPane().add(nama);
        nama.setBounds(132, 40, 120, 22);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Masukkan Nama");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(12, 43, 110, 16);

        b_cari.setText("Cari");
        b_cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_cariActionPerformed(evt);
            }
        });
        getContentPane().add(b_cari);
        b_cari.setBounds(260, 40, 55, 25);

        refresh.setText("Refresh Tabel");
        refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshActionPerformed(evt);
            }
        });
        getContentPane().add(refresh);
        refresh.setBounds(497, 39, 113, 25);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/library-750x350.png"))); // NOI18N
        jLabel9.setBorder(javax.swing.BorderFactory.createMatteBorder(20, 0, 20, 0, new java.awt.Color(0, 153, 51)));
        getContentPane().add(jLabel9);
        jLabel9.setBounds(0, 0, 630, 350);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void b_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_backActionPerformed
        this.setVisible(false);
        ViewDataUserLogin log = new ViewDataUserLogin();
        if (log.getRole() == 1) {
            MenuPustakawan menupustakawan = new MenuPustakawan();
            // mengatur ukuran form
            menupustakawan.setSize(528, 437);
            // mengatur form di posisi tengah
            menupustakawan.setLocationRelativeTo(null);
            // menampilkan form
            menupustakawan.setVisible(true);
        } else if (log.getRole() == 2) {
            MenuAdmin menuadmin = new MenuAdmin();
            // mengatur ukuran form
            menuadmin.setSize(458, 317);
            // mengatur form di posisi tengah
            menuadmin.setLocationRelativeTo(null);
            // menampilkan form
            menuadmin.setVisible(true);
        }
    }//GEN-LAST:event_b_backActionPerformed

    private void b_cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_cariActionPerformed
        tampil_transaksi(nama.getText());
    }//GEN-LAST:event_b_cariActionPerformed

    private void refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshActionPerformed
        tampil_transaksi();
    }//GEN-LAST:event_refreshActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewDataTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewDataTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewDataTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewDataTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewDataTransaksi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_back;
    private javax.swing.JToggleButton b_cari;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nama;
    private javax.swing.JButton refresh;
    private javax.swing.JTable tabel;
    // End of variables declaration//GEN-END:variables
}