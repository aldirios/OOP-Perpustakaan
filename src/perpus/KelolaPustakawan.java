package perpus;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class KelolaPustakawan extends javax.swing.JFrame {

    private DefaultTableModel tabmode;

    private void tampil_pustakawan() {
        Pustakawan pustakawan = new Pustakawan();
        ArrayList<Pustakawan> allpustakawan = new ArrayList<>(pustakawan.read());
        Object[] baris = {"No", "Id", "Nama", "Username", "Password"};
        tabmode = new DefaultTableModel(null, baris);
        table.setModel(tabmode);
        try {
            int i = 1;
            for (Pustakawan pustakawan1 : allpustakawan) {
                int id = pustakawan1.getIdPerson();
                String nama = pustakawan1.getNama();
                String username = pustakawan1.getUsername();
                String password = pustakawan1.getPassword();
                Object[] data = {i, id, nama, username, password};
                i++;
                tabmode.addRow(data);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Menampilkan data GAGAL", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public KelolaPustakawan() {
        initComponents();
        jPanel1.setBackground(new Color(255, 255, 255, 200)); // mengatur warna JPanel1 agar transparan
        tampil_pustakawan();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        b_tambah = new javax.swing.JButton();
        t_nama = new javax.swing.JTextField();
        t_username = new javax.swing.JTextField();
        t_password = new javax.swing.JTextField();
        b_reset = new javax.swing.JButton();
        b_hapus = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        b_back = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        t_id = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel3.setText("Username");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(20, 120, 70, 16);

        jLabel4.setText("Password");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(20, 160, 58, 16);

        b_tambah.setText("Tambah");
        b_tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_tambahActionPerformed(evt);
            }
        });
        getContentPane().add(b_tambah);
        b_tambah.setBounds(20, 190, 79, 25);
        getContentPane().add(t_nama);
        t_nama.setBounds(100, 80, 150, 22);
        getContentPane().add(t_username);
        t_username.setBounds(100, 120, 150, 22);

        t_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_passwordActionPerformed(evt);
            }
        });
        getContentPane().add(t_password);
        t_password.setBounds(100, 160, 150, 22);

        b_reset.setText("Reset");
        b_reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_resetActionPerformed(evt);
            }
        });
        getContentPane().add(b_reset);
        b_reset.setBounds(107, 190, 65, 25);

        b_hapus.setText("Hapus");
        b_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_hapusActionPerformed(evt);
            }
        });
        getContentPane().add(b_hapus);
        b_hapus.setBounds(180, 190, 67, 25);

        table.setModel(new javax.swing.table.DefaultTableModel(
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
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(270, 50, 452, 213);

        b_back.setText("back");
        b_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_backActionPerformed(evt);
            }
        });
        getContentPane().add(b_back);
        b_back.setBounds(20, 240, 59, 25);

        jLabel1.setText("Id");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(20, 50, 58, 16);

        t_id.setEditable(false);
        getContentPane().add(t_id);
        t_id.setBounds(100, 50, 150, 22);

        jLabel2.setText("Nama");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(658, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel2)
                .addContainerGap(181, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(10, 40, 720, 240);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/a.png"))); // NOI18N
        jLabel5.setBorder(javax.swing.BorderFactory.createMatteBorder(20, 0, 20, 0, new java.awt.Color(0, 153, 51)));
        getContentPane().add(jLabel5);
        jLabel5.setBounds(-150, 0, 930, 320);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void refresh() {
        String sql = "select * from person where role = '1' order by id asc";
        tampil_pustakawan();
    }

    private void b_tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_tambahActionPerformed
        try {
            int id = 0;
            String nama = t_nama.getText();
            String username = t_username.getText();
            String password = t_password.getText();
            Pustakawan pustakawan1 = new Pustakawan();
            if (pustakawan1.cekUsername(username)){
                Pustakawan pustakawan = new Pustakawan(id, nama, username, password, 1);
                pustakawan.create();
                reset();
                refresh();            
            }else{
                JOptionPane.showMessageDialog(null, "Username Sudah Dipakai", "Informasi", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Menambah data GAGAL", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_b_tambahActionPerformed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        int tabelBarang = table.getSelectedRow();
        t_id.setText(table.getValueAt(tabelBarang, 1).toString());
        t_nama.setText(table.getValueAt(tabelBarang, 2).toString());
        t_username.setText(table.getValueAt(tabelBarang, 3).toString());
        t_password.setText(table.getValueAt(tabelBarang, 4).toString());
    }//GEN-LAST:event_tableMouseClicked

    private void b_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_backActionPerformed
        this.setVisible(false);
        MenuAdmin menuadmin = new MenuAdmin();
        // mengatur ukuran form
        menuadmin.setSize(458, 317);
        // mengatur form di posisi tengah
        menuadmin.setLocationRelativeTo(null);
        // menampilkan form
        menuadmin.setVisible(true);
    }//GEN-LAST:event_b_backActionPerformed

    private void t_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_passwordActionPerformed

    private void b_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_hapusActionPerformed
        try {
            int id = Integer.parseInt(t_id.getText());
            String nama = t_nama.getText();
            String username = t_username.getText();
            String password = t_password.getText();

            Pustakawan pustakawan = new Pustakawan(id, nama, username, password, 1);
            pustakawan.delete();
            reset();
            refresh();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Menghapus data GAGAL", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_b_hapusActionPerformed

    private void b_resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_resetActionPerformed
        // TODO add your handling code here:
        reset();
    }//GEN-LAST:event_b_resetActionPerformed

    private void reset() {
        t_id.setText("");
        t_nama.setText("");
        t_username.setText("");
        t_password.setText("");
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
            java.util.logging.Logger.getLogger(KelolaPustakawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KelolaPustakawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KelolaPustakawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KelolaPustakawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new KelolaPustakawan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_back;
    private javax.swing.JButton b_hapus;
    private javax.swing.JButton b_reset;
    private javax.swing.JButton b_tambah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField t_id;
    private javax.swing.JTextField t_nama;
    private javax.swing.JTextField t_password;
    private javax.swing.JTextField t_username;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}