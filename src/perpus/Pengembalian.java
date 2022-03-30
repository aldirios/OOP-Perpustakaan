package perpus;

import java.awt.Color;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Pengembalian extends javax.swing.JFrame {

    private DefaultTableModel tabmode;

    private void tampil_user(String sql) {
        Object[] baris = {"Id", "Nama", "Username"};
        tabmode = new DefaultTableModel(null, baris);
        tabel1.setModel(tabmode);
        try {
            Connection konek = new DBConection().getConnection();
            Statement stat = konek.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()) {
                int id = hasil.getInt("id");
                String nama = hasil.getString("nama");
                String username = hasil.getString("username");
                Object[] data = {id, nama, username};
                tabmode.addRow(data);
            }
            konek.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Menampilkan data GAGAL", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void tampil_buku(String sql) {
        Object[] baris = {"Id", "Judul Buku", "Pengarang", "Penerbit", "Jumlah"};
        tabmode = new DefaultTableModel(null, baris);
        tabel2.setModel(tabmode);
        try {
            Connection konek = new DBConection().getConnection();
            Statement stat = konek.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()) {
                int id = hasil.getInt("id");
                String judul = hasil.getString("judul_buku");
                String pengarang = hasil.getString("pengarang");
                String penerbit = hasil.getString("penerbit");
                int jumlah = hasil.getInt("ketersediaan");
                Object[] data = {id, judul, pengarang, penerbit, jumlah};
                tabmode.addRow(data);
            }
            konek.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Menampilkan data GAGAL", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void refresh() {                                        
        String sql = "SELECT * FROM buku";
        tampil_buku(sql);
    }
    
    public Pengembalian() {
        initComponents();
        String sql = "select * from person where role ='0' order by id asc";
        tampil_user(sql);
        String sql1 = "select * from buku order by id asc";
        tampil_buku(sql1);
        jPanel1.setBackground(new Color(255, 255, 255, 200)); // mengatur warna JPanel1 agar transparan   
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        b_back = new javax.swing.JButton();
        b_kembali = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabel1 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabel2 = new javax.swing.JTable();
        kunci1 = new javax.swing.JComboBox<>();
        cari1 = new javax.swing.JTextField();
        b_cari1 = new javax.swing.JButton();
        kunci2 = new javax.swing.JComboBox<>();
        cari2 = new javax.swing.JTextField();
        b_cari2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        idpeminjam = new javax.swing.JTextField();
        idbuku = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setText("Id Peminjam");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(12, 85, 72, 16);

        jLabel3.setText("Id Buku");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(12, 135, 42, 16);

        b_back.setText("Kembali");
        b_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_backActionPerformed(evt);
            }
        });
        getContentPane().add(b_back);
        b_back.setBounds(12, 333, 77, 25);

        b_kembali.setText("Pengembalian");
        b_kembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_kembaliActionPerformed(evt);
            }
        });
        getContentPane().add(b_kembali);
        b_kembali.setBounds(107, 333, 113, 25);

        tabel1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabel1);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(234, 82, 452, 110);

        tabel2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel2MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tabel2);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(230, 248, 452, 110);

        kunci1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "nama", "username" }));
        getContentPane().add(kunci1);
        kunci1.setBounds(234, 40, 84, 22);
        getContentPane().add(cari1);
        cari1.setBounds(336, 40, 103, 22);

        b_cari1.setText("Cari");
        b_cari1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_cari1ActionPerformed(evt);
            }
        });
        getContentPane().add(b_cari1);
        b_cari1.setBounds(451, 39, 55, 25);

        kunci2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "id", "judul_buku", "pengarang", "penerbit" }));
        kunci2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kunci2ActionPerformed(evt);
            }
        });
        getContentPane().add(kunci2);
        kunci2.setBounds(234, 206, 89, 22);

        cari2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cari2ActionPerformed(evt);
            }
        });
        getContentPane().add(cari2);
        cari2.setBounds(341, 206, 102, 22);

        b_cari2.setText("Cari");
        b_cari2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_cari2ActionPerformed(evt);
            }
        });
        getContentPane().add(b_cari2);
        b_cari2.setBounds(461, 205, 55, 25);

        idpeminjam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idpeminjamActionPerformed(evt);
            }
        });

        jLabel2.setText("Pengembalian");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(64, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(idpeminjam, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(idbuku, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(idpeminjam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(idbuku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(168, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(10, 40, 210, 280);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/a.png"))); // NOI18N
        jLabel5.setBorder(javax.swing.BorderFactory.createMatteBorder(20, 0, 20, 0, new java.awt.Color(0, 153, 51)));
        getContentPane().add(jLabel5);
        jLabel5.setBounds(-140, 0, 1020, 400);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel1MouseClicked
        int tabelUser = tabel1.getSelectedRow();
        idpeminjam.setText(tabel1.getValueAt(tabelUser, 0).toString());
    }//GEN-LAST:event_tabel1MouseClicked

    private void tabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel2MouseClicked
        int tabelBarang = tabel2.getSelectedRow();
        idbuku.setText(tabel2.getValueAt(tabelBarang, 0).toString());
    }//GEN-LAST:event_tabel2MouseClicked

    private void b_cari1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_cari1ActionPerformed
        String sql = "SELECT * FROM person WHERE " + kunci1.getSelectedItem().toString() + " LIKE '%" + cari1.getText() + "%'";
        tampil_user(sql);
    }//GEN-LAST:event_b_cari1ActionPerformed

    private void b_cari2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_cari2ActionPerformed
        String sql = "SELECT * FROM buku WHERE " + kunci2.getSelectedItem().toString() + " LIKE '%" + cari2.getText() + "%'";
        tampil_buku(sql);
    }//GEN-LAST:event_b_cari2ActionPerformed

    private void b_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_backActionPerformed
        this.setVisible(false);
        MenuPustakawan menupustakawan = new MenuPustakawan();
        // mengatur ukuran form
        menupustakawan.setSize(528, 437);
        // mengatur form di posisi tengah
        menupustakawan.setLocationRelativeTo(null);
        // menampilkan form
        menupustakawan.setVisible(true);
    }//GEN-LAST:event_b_backActionPerformed

    private void b_kembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_kembaliActionPerformed
        User anggota = new User();                    
        Buku buku = new Buku();
        TransaksiBuku transaksiBuku = new TransaksiBuku();
            try {
                int idpjm = Integer.parseInt(idpeminjam.getText());
                int idbk = Integer.parseInt(idbuku.getText());
                anggota.setIdPerson(idpjm);
                if (!transaksiBuku.cekTransaksi(idpjm,idbk ) && anggota.cekAnggota(idpjm)) {
                    boolean cek = buku.getBukuById(idbk);
                    if(cek){
                        buku.setKetersediaan(buku.getKetersediaan() + 1);
                        buku.update();
                        transaksiBuku.setPeminjam(String.valueOf(idpjm));
                        transaksiBuku.setBuku(String.valueOf(idbk));
                        transaksiBuku.update();                    
                        JOptionPane.showMessageDialog(null, "Buku Telah Dikembalikan", "Informasi", JOptionPane.INFORMATION_MESSAGE);
                        refresh();
                    }
                    else{                        
                        JOptionPane.showMessageDialog(null, "Id Tidak Sesuai Atau User Sudah Meminjam Buku Ini", "Informasi", JOptionPane.INFORMATION_MESSAGE);
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Id Tidak Sesuai Atau Buku Sudah Dikembalikan", "Informasi", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Id Tidak Sesuai", "Informasi", JOptionPane.INFORMATION_MESSAGE);
            }
    }//GEN-LAST:event_b_kembaliActionPerformed

    private void kunci2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kunci2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kunci2ActionPerformed

    private void idpeminjamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idpeminjamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idpeminjamActionPerformed

    private void cari2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cari2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cari2ActionPerformed

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
            java.util.logging.Logger.getLogger(Pengembalian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pengembalian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pengembalian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pengembalian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pengembalian().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_back;
    private javax.swing.JButton b_cari1;
    private javax.swing.JButton b_cari2;
    private javax.swing.JButton b_kembali;
    private javax.swing.JTextField cari1;
    private javax.swing.JTextField cari2;
    private javax.swing.JTextField idbuku;
    private javax.swing.JTextField idpeminjam;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox<String> kunci1;
    private javax.swing.JComboBox<String> kunci2;
    private javax.swing.JTable tabel1;
    private javax.swing.JTable tabel2;
    // End of variables declaration//GEN-END:variables
}
