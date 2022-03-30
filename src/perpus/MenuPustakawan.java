package perpus;

public class MenuPustakawan extends javax.swing.JFrame {

    public MenuPustakawan() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        B_buku = new javax.swing.JButton();
        B_pinjam = new javax.swing.JButton();
        B_kembali = new javax.swing.JButton();
        B_anggota = new javax.swing.JButton();
        B_peminjaman = new javax.swing.JButton();
        logout = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(432, 357));
        getContentPane().setLayout(null);

        B_buku.setText("Kelola Buku");
        B_buku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_bukuActionPerformed(evt);
            }
        });
        getContentPane().add(B_buku);
        B_buku.setBounds(160, 90, 185, 25);

        B_pinjam.setText("Peminjaman");
        B_pinjam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_pinjamActionPerformed(evt);
            }
        });
        getContentPane().add(B_pinjam);
        B_pinjam.setBounds(160, 130, 185, 25);

        B_kembali.setText("Pengembalian");
        B_kembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_kembaliActionPerformed(evt);
            }
        });
        getContentPane().add(B_kembali);
        B_kembali.setBounds(160, 170, 185, 25);

        B_anggota.setText("Kelola Anggota");
        B_anggota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_anggotaActionPerformed(evt);
            }
        });
        getContentPane().add(B_anggota);
        B_anggota.setBounds(160, 210, 185, 25);

        B_peminjaman.setText("Lihat Record Transaksi");
        B_peminjaman.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_peminjamanActionPerformed(evt);
            }
        });
        getContentPane().add(B_peminjaman);
        B_peminjaman.setBounds(160, 250, 185, 25);

        logout.setText("Log Out");
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });
        getContentPane().add(logout);
        logout.setBounds(160, 290, 185, 25);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Selamat Datang Di Menu Pustakawan");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(70, 50, 360, 30);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/depositphotos_461747180-stock-illustration-bookshelf-a-large-bookcase-in.jpg"))); // NOI18N
        jLabel3.setBorder(javax.swing.BorderFactory.createMatteBorder(20, 0, 20, 0, new java.awt.Color(0, 153, 51)));
        getContentPane().add(jLabel3);
        jLabel3.setBounds(-20, 0, 530, 390);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void B_bukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_bukuActionPerformed
        this.setVisible(false);
        KelolaBuku kelolabuku = new KelolaBuku();
        // mengatur ukuran form
        kelolabuku.setSize(760, 415);
        // mengatur form di posisi tengah
        kelolabuku.setLocationRelativeTo(null);
        // menampilkan form
        kelolabuku.setVisible(true);
    }//GEN-LAST:event_B_bukuActionPerformed

    private void B_anggotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_anggotaActionPerformed
        this.setVisible(false);
        KelolaUser kelolauser = new KelolaUser();
        // mengatur ukuran form
        kelolauser.setSize(760, 335);
        // mengatur form di posisi tengah
        kelolauser.setLocationRelativeTo(null);
        // menampilkan form
        kelolauser.setVisible(true);
    }//GEN-LAST:event_B_anggotaActionPerformed

    private void B_pinjamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_pinjamActionPerformed
        this.setVisible(false);
        Peminjaman peminjaman = new Peminjaman();
        // mengatur ukuran form
        peminjaman.setSize(720, 447);
        // mengatur form di posisi tengah
        peminjaman.setLocationRelativeTo(null);
        // menampilkan form
        peminjaman.setVisible(true);
    }//GEN-LAST:event_B_pinjamActionPerformed

    private void B_kembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_kembaliActionPerformed
        this.setVisible(false);
        Pengembalian pengembalian = new Pengembalian();
        // mengatur ukuran form
        pengembalian.setSize(720, 447);
        // mengatur form di posisi tengah
        pengembalian.setLocationRelativeTo(null);
        // menampilkan form
        pengembalian.setVisible(true);
    }//GEN-LAST:event_B_kembaliActionPerformed

    private void B_peminjamanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_peminjamanActionPerformed
        this.setVisible(false);
        ViewDataTransaksi transaksi = new ViewDataTransaksi();
        // mengatur ukuran form
        transaksi.setSize(645, 395);
        // mengatur form di posisi tengah
        transaksi.setLocationRelativeTo(null);
        // menampilkan form
        transaksi.setVisible(true);
    }//GEN-LAST:event_B_peminjamanActionPerformed

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
        this.setVisible(false);
        MainMenu mainmenu = new MainMenu();
        // mengatur ukuran form
        mainmenu.setSize(435, 390);
        // mengatur form di posisi tengah
        mainmenu.setLocationRelativeTo(null);
        // menampilkan form
        mainmenu.setVisible(true);
    }//GEN-LAST:event_logoutActionPerformed

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
            java.util.logging.Logger.getLogger(MenuPustakawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPustakawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPustakawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPustakawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new MenuPustakawan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton B_anggota;
    private javax.swing.JButton B_buku;
    private javax.swing.JButton B_kembali;
    private javax.swing.JButton B_peminjaman;
    private javax.swing.JButton B_pinjam;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton logout;
    // End of variables declaration//GEN-END:variables
}
