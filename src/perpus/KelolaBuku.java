package perpus;

import java.awt.Color;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class KelolaBuku extends javax.swing.JFrame {

    private DefaultTableModel tabmode;

    private void tampil_buku(String sql) {
        Object[] baris = {"Id", "Judul Buku", "Pengarang", "Penerbit", "Jumlah", "Tahun Terbit"};
        tabmode = new DefaultTableModel(null, baris);
        table.setModel(tabmode);
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
                int tahun = hasil.getInt("tahun_terbit");
                Object[] data = {id, judul, pengarang, penerbit, jumlah, tahun};
                tabmode.addRow(data);
            }
            konek.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Menampilkan data GAGAL", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public KelolaBuku() {
        initComponents();
        jPanel1.setBackground(new Color(255, 255, 255, 200)); // mengatur warna JPanel1 agar transparan
        String sql = "select * from buku order by id asc";
        tampil_buku(sql);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        b_tambah = new javax.swing.JButton();
        b_hapus = new javax.swing.JButton();
        b_edit = new javax.swing.JButton();
        b_reset = new javax.swing.JButton();
        t_id = new javax.swing.JTextField();
        t_judul = new javax.swing.JTextField();
        t_pengarang = new javax.swing.JTextField();
        t_penerbit = new javax.swing.JTextField();
        t_jumlah = new javax.swing.JTextField();
        t_tahun = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        kunci = new javax.swing.JComboBox<>();
        cari = new javax.swing.JTextField();
        b_cari = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        refresh = new javax.swing.JButton();
        b_back = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel2.setText("Judul");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(19, 90, 80, 16);

        jLabel3.setText("Pengarang");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(21, 130, 80, 16);

        jLabel5.setText("Jumlah");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(20, 210, 80, 16);

        jLabel8.setText("Tahun Terbit");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(20, 250, 74, 16);

        b_tambah.setText("Tambah");
        b_tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_tambahActionPerformed(evt);
            }
        });
        getContentPane().add(b_tambah);
        b_tambah.setBounds(10, 300, 79, 25);

        b_hapus.setText("Hapus");
        b_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_hapusActionPerformed(evt);
            }
        });
        getContentPane().add(b_hapus);
        b_hapus.setBounds(110, 300, 67, 25);

        b_edit.setText("Update");
        b_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_editActionPerformed(evt);
            }
        });
        getContentPane().add(b_edit);
        b_edit.setBounds(190, 300, 73, 25);

        b_reset.setText("Reset");
        b_reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_resetActionPerformed(evt);
            }
        });
        getContentPane().add(b_reset);
        b_reset.setBounds(280, 300, 65, 25);

        t_id.setEditable(false);
        getContentPane().add(t_id);
        t_id.setBounds(110, 50, 150, 22);
        getContentPane().add(t_judul);
        t_judul.setBounds(110, 90, 150, 22);
        getContentPane().add(t_pengarang);
        t_pengarang.setBounds(110, 130, 150, 22);
        getContentPane().add(t_penerbit);
        t_penerbit.setBounds(110, 170, 150, 22);
        getContentPane().add(t_jumlah);
        t_jumlah.setBounds(110, 210, 150, 22);

        t_tahun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_tahunActionPerformed(evt);
            }
        });
        getContentPane().add(t_tahun);
        t_tahun.setBounds(110, 250, 150, 22);

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Cari Berdasar");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(280, 50, 78, 16);

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Kata Kunci");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(300, 80, 60, 16);

        jLabel4.setText("Penerbit");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(17, 170, 80, 16);

        kunci.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "judul_buku", "pengarang", "penerbit" }));
        getContentPane().add(kunci);
        kunci.setBounds(370, 50, 89, 22);
        getContentPane().add(cari);
        cari.setBounds(370, 80, 89, 22);

        b_cari.setText("Search");
        b_cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_cariActionPerformed(evt);
            }
        });
        getContentPane().add(b_cari);
        b_cari.setBounds(480, 80, 73, 25);

        table.setModel(new javax.swing.table.DefaultTableModel(
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
        table.setRequestFocusEnabled(false);
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(280, 130, 452, 142);

        refresh.setText("Refresh Tabel");
        refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshActionPerformed(evt);
            }
        });
        getContentPane().add(refresh);
        refresh.setBounds(620, 80, 113, 25);

        b_back.setText("back");
        b_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_backActionPerformed(evt);
            }
        });
        getContentPane().add(b_back);
        b_back.setBounds(670, 300, 59, 25);

        jLabel1.setText("Id");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(21, 50, 80, 16);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 260, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 240, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(10, 40, 260, 240);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/library-750x350.png"))); // NOI18N
        jLabel9.setBorder(javax.swing.BorderFactory.createMatteBorder(20, 0, 20, 0, new java.awt.Color(0, 153, 51)));
        getContentPane().add(jLabel9);
        jLabel9.setBounds(0, 0, 750, 370);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void refresh() {
        String sql = "select * from buku order by id asc";
        tampil_buku(sql);
    }

    private void b_tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_tambahActionPerformed
        try {
            int id = 0;
            String judul = t_judul.getText();
            String pengarang = t_pengarang.getText();
            String penerbit = t_penerbit.getText();
            int jumlah = Integer.parseInt(t_jumlah.getText());
            int tahun = Integer.parseInt(t_tahun.getText());

            Buku buku = new Buku(id, judul, pengarang, penerbit, jumlah, tahun);
            buku.create();
            reset();
            refresh();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Menyimpan data GAGAL", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_b_tambahActionPerformed

    private void b_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_hapusActionPerformed
        try {
            int id = Integer.parseInt(t_id.getText());
            String judul = t_judul.getText();
            String pengarang = t_pengarang.getText();
            String penerbit = t_penerbit.getText();
            int jumlah = Integer.parseInt(t_jumlah.getText());
            int tahun = Integer.parseInt(t_tahun.getText());

            Buku buku = new Buku(id, judul, pengarang, penerbit, jumlah, tahun);
            buku.delete();
            reset();
            refresh();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Menghapus data GAGAL", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_b_hapusActionPerformed

    private void b_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_editActionPerformed
        try {
            int id = Integer.parseInt(t_id.getText());
            String judul = t_judul.getText();
            String pengarang = t_pengarang.getText();
            String penerbit = t_penerbit.getText();
            int jumlah = Integer.parseInt(t_jumlah.getText());
            int tahun = Integer.parseInt(t_tahun.getText());

            Buku buku = new Buku(id, judul, pengarang, penerbit, jumlah, tahun);
            buku.update();
            reset();
            refresh();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Update data GAGAL", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_b_editActionPerformed

    private void b_resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_resetActionPerformed
        reset();
    }//GEN-LAST:event_b_resetActionPerformed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        int tabelBarang = table.getSelectedRow();
        t_id.setText(table.getValueAt(tabelBarang, 0).toString());
        t_judul.setText(table.getValueAt(tabelBarang, 1).toString());
        t_pengarang.setText(table.getValueAt(tabelBarang, 2).toString());
        t_penerbit.setText(table.getValueAt(tabelBarang, 3).toString());
        t_jumlah.setText(table.getValueAt(tabelBarang, 4).toString());
        t_tahun.setText(table.getValueAt(tabelBarang, 5).toString());
    }//GEN-LAST:event_tableMouseClicked

    private void b_cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_cariActionPerformed
        String sql = "SELECT * FROM buku WHERE " + kunci.getSelectedItem().toString() + " LIKE '%" + cari.getText() + "%'";
        tampil_buku(sql);
    }//GEN-LAST:event_b_cariActionPerformed

    private void refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshActionPerformed
        refresh();
    }//GEN-LAST:event_refreshActionPerformed

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

    private void t_tahunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_tahunActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_tahunActionPerformed

    private void reset() {
        t_id.setText("");
        t_judul.setText("");
        t_pengarang.setText("");
        t_penerbit.setText("");
        t_jumlah.setText("");
        t_tahun.setText("");
    }

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
            java.util.logging.Logger.getLogger(KelolaBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KelolaBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KelolaBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KelolaBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new KelolaBuku().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_back;
    private javax.swing.JButton b_cari;
    private javax.swing.JButton b_edit;
    private javax.swing.JButton b_hapus;
    private javax.swing.JButton b_reset;
    private javax.swing.JButton b_tambah;
    private javax.swing.JTextField cari;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> kunci;
    private javax.swing.JButton refresh;
    private javax.swing.JTextField t_id;
    private javax.swing.JTextField t_judul;
    private javax.swing.JTextField t_jumlah;
    private javax.swing.JTextField t_penerbit;
    private javax.swing.JTextField t_pengarang;
    private javax.swing.JTextField t_tahun;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
