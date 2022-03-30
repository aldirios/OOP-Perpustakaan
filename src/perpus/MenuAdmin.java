package perpus;

public class MenuAdmin extends javax.swing.JFrame {

    public MenuAdmin() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        B_pustaka = new javax.swing.JButton();
        B_buku = new javax.swing.JButton();
        B_logout = new javax.swing.JButton();
        B_transaksi = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        B_pustaka.setText("Kelola Data Pustakawan");
        B_pustaka.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_pustakaActionPerformed(evt);
            }
        });
        getContentPane().add(B_pustaka);
        B_pustaka.setBounds(109, 83, 207, 25);

        B_buku.setText("Kelola Data Buku");
        B_buku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_bukuActionPerformed(evt);
            }
        });
        getContentPane().add(B_buku);
        B_buku.setBounds(109, 121, 207, 25);

        B_logout.setText("Log Out");
        B_logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_logoutActionPerformed(evt);
            }
        });
        getContentPane().add(B_logout);
        B_logout.setBounds(109, 197, 207, 25);

        B_transaksi.setText("Menampikan Record Transaksi");
        B_transaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_transaksiActionPerformed(evt);
            }
        });
        getContentPane().add(B_transaksi);
        B_transaksi.setBounds(109, 159, 207, 25);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Selamat Datang Di Menu Admin");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(74, 43, 286, 22);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/depositphotos_461747180-stock-illustration-bookshelf-a-large-bookcase-in.jpg"))); // NOI18N
        jLabel3.setBorder(javax.swing.BorderFactory.createMatteBorder(20, 0, 20, 0, new java.awt.Color(0, 153, 51)));
        getContentPane().add(jLabel3);
        jLabel3.setBounds(-20, 0, 460, 270);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void B_logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_logoutActionPerformed
        this.setVisible(false);
        MainMenu mainmenu = new MainMenu();
        // mengatur ukuran form
        mainmenu.setSize(435, 390);
        // mengatur form di posisi tengah
        mainmenu.setLocationRelativeTo(null);
        // menampilkan form
        mainmenu.setVisible(true);
    }//GEN-LAST:event_B_logoutActionPerformed

    private void B_transaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_transaksiActionPerformed
        this.setVisible(false);
        ViewDataTransaksi transaksi = new ViewDataTransaksi();
        // mengatur ukuran form
        transaksi.setSize(645, 395);
        // mengatur form di posisi tengah
        transaksi.setLocationRelativeTo(null);
        // menampilkan form
        transaksi.setVisible(true);
    }//GEN-LAST:event_B_transaksiActionPerformed

    private void B_bukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_bukuActionPerformed
        this.setVisible(false);
        KelolaBuku kelolabuku = new KelolaBuku();
        // mengatur ukuran form
        kelolabuku.setSize(768, 415);
        // mengatur form di posisi tengah
        kelolabuku.setLocationRelativeTo(null);
        // menampilkan form
        kelolabuku.setVisible(true);
    }//GEN-LAST:event_B_bukuActionPerformed

    private void B_pustakaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_pustakaActionPerformed
        this.setVisible(false);
        KelolaPustakawan kelolapustakawan = new KelolaPustakawan();
        // mengatur ukuran form
        kelolapustakawan.setSize(765, 360);
        // mengatur form di posisi tengah
        kelolapustakawan.setLocationRelativeTo(null);
        // menampilkan form
        kelolapustakawan.setVisible(true);
    }//GEN-LAST:event_B_pustakaActionPerformed

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
            java.util.logging.Logger.getLogger(MenuAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton B_buku;
    private javax.swing.JButton B_logout;
    private javax.swing.JButton B_pustaka;
    private javax.swing.JButton B_transaksi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
