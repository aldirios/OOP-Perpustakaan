package perpus;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ViewPeminjaman extends javax.swing.JFrame {

    
    private final static String status = "Belum Kembali";
    private DefaultTableModel tabmode;
    
    private void tampil_transaksi(int idpeminjam,String status){
        TransaksiBuku transaksiBuku = new TransaksiBuku();
        ArrayList<TransaksiBuku> allTransaksi = new ArrayList<>();
        try {
            allTransaksi = transaksiBuku.read(idpeminjam,status);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Object[] baris = {"No","Buku", "Tgl Pinjam", "Batas Kembali"};
        tabmode = new DefaultTableModel(null, baris);
        tabel.setModel(tabmode);
        try {
            int i = 1;
            for (TransaksiBuku transaksi : allTransaksi) {
                String buku = transaksi.getBuku();
                Date pinjam = transaksi.getTanggal_pinjam();
                Date batas = transaksi.getBatas_kembali();
                Object[] data = {i, buku, pinjam, batas};
                i++;
                tabmode.addRow(data);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Menampilkan data GAGAL", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public ViewPeminjaman() {
        initComponents();
        ViewDataUserLogin log = new ViewDataUserLogin();
        int idpeminjam = log.getIdPerson();
        tampil_transaksi(idpeminjam,status);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        b_back = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        tabel.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabel);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(12, 84, 661, 179);

        b_back.setText("Kembali");
        b_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_backActionPerformed(evt);
            }
        });
        getContentPane().add(b_back);
        b_back.setBounds(12, 281, 77, 25);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Data Buku Yang Belum Dikembalikan");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(100, 40, 480, 29);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/library-750x350.png"))); // NOI18N
        jLabel9.setBorder(javax.swing.BorderFactory.createMatteBorder(20, 0, 20, 0, new java.awt.Color(0, 153, 51)));
        getContentPane().add(jLabel9);
        jLabel9.setBounds(0, 0, 690, 340);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void b_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_backActionPerformed
        this.setVisible(false);
        MenuUser menuuser = new MenuUser();
        // mengatur ukuran form
        menuuser.setSize(604, 385);
        // mengatur form di posisi tengah
        menuuser.setLocationRelativeTo(null);
        // menampilkan form
        menuuser.setVisible(true);
    }//GEN-LAST:event_b_backActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewPeminjaman().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_back;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabel;
    // End of variables declaration//GEN-END:variables
}
