package perpus;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Buku implements Crud {

    private static final String TABEL = "buku";
    private int idBuku;
    private String judulBuku;
    private String pengarang;
    private String penerbit;
    private int ketersediaan;
    private int tahun;

    public int getIdBuku() {
        return idBuku;
    }

    public void setIdBuku(int idBuku) {
        this.idBuku = idBuku;
    }

    public int getTahun() {
        return tahun;
    }

    public void setTahun(int tahun) {
        this.tahun = tahun;
    }

    public String getJudulBuku() {
        return judulBuku;
    }

    public void setJudulBuku(String judulBuku) {
        this.judulBuku = judulBuku;
    }

    public String getPengarang() {
        return pengarang;
    }

    public void setPengarang(String pengarang) {
        this.pengarang = pengarang;
    }

    public String getPenerbit() {
        return penerbit;
    }

    public void setPenerbit(String penerbit) {
        this.penerbit = penerbit;
    }

    public int getKetersediaan() {
        return ketersediaan;
    }

    public void setKetersediaan(int ketersediaan) {
        this.ketersediaan = ketersediaan;
    }

    public Buku() {
    }

    public Buku(int idBuku, String judulBuku, String pengarang, String penerbit, int ketersediaan, int tahun) {
        this.idBuku = idBuku;
        this.judulBuku = judulBuku;
        this.pengarang = pengarang;
        this.penerbit = penerbit;
        this.ketersediaan = ketersediaan;
        this.tahun = tahun;
    }

    @Override
    public void create() {
        HashMap<String, String> map = new HashMap<>();
        map.put("judul_buku", String.format("'%s'", judulBuku));
        map.put("pengarang", String.format("'%s'", pengarang));
        map.put("penerbit", String.format("'%s'", penerbit));
        map.put("ketersediaan", Integer.toString(ketersediaan));
        map.put("tahun_terbit", Integer.toString(tahun));

        boolean isSuccess = DBHelper.insert("buku", map);

        if (isSuccess) {
            JOptionPane.showMessageDialog(null, "Buku Berhasil Ditambahkan", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Buku Gagal Ditambahkan", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    @Override
    public void update() {
        HashMap<String, String> map = new HashMap<>();
        map.put("judul_buku", "'" + judulBuku + "'");
        map.put("pengarang", "'" + pengarang + "'");
        map.put("penerbit", "'" + penerbit + "'");
        map.put("ketersediaan", Integer.toString(ketersediaan));
        map.put("tahun_terbit", Integer.toString(tahun));

        String clause = String.format("id = %s", idBuku);

        boolean isSuccess = DBHelper.update(TABEL, map, clause);
    }

    @Override
    public void delete() {
        try {
            if (cekBuku()) {
                String clause = "id=" + idBuku;
                boolean isSuccess = DBHelper.delete(TABEL, clause);
                if (isSuccess) {
                    JOptionPane.showMessageDialog(null, "Buku Berhasil Dihapus", "Informasi", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Buku Gagal Dihapus, mungkin id yang anda masukan salah", "Informasi", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Buku Sedang Dipinjam", "Informasi", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Buku.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ArrayList<Buku> read() {
        ResultSet resultSet = DBHelper.selectAll(TABEL);
        ArrayList<Buku> allbuku = new ArrayList<>();
        while (true) {
            try {
                if (resultSet.next()) {
                    Buku buku = new Buku();
                    buku.setIdBuku(resultSet.getInt("id"));
                    buku.setJudulBuku(resultSet.getString("judul_buku"));
                    buku.setPengarang(resultSet.getString("pengarang"));
                    buku.setPenerbit(resultSet.getString("penerbit"));
                    buku.setKetersediaan(resultSet.getInt("ketersediaan"));
                    buku.setTahun(resultSet.getInt("tahun_terbit"));
                    allbuku.add(buku);
                } else {
                    break;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return allbuku;
    }

    public ArrayList<Buku> read(String type, String search) throws SQLException {
        ArrayList<Buku> allBuku = new ArrayList<>();
        Buku buku;
        String query = type + " like '%" + search + "%'";
        ResultSet resultSet = DBHelper.selectAll(TABEL, query);
        while (resultSet.next()) {
            buku = new Buku();
            buku.setJudulBuku(resultSet.getString("judul_buku"));
            buku.setPengarang(resultSet.getString("pengarang"));
            buku.setPenerbit(resultSet.getString("penerbit"));
            buku.setKetersediaan(resultSet.getInt("ketersediaan"));
            buku.setTahun(resultSet.getInt("tahun_terbit"));
            buku.setIdBuku(resultSet.getInt("id"));
            allBuku.add(buku);
        }
        return allBuku;
    }

    public boolean getBukuById(int idBuku) throws SQLException {
        String query = "id = " + idBuku;
        ResultSet resultSet = DBHelper.selectAll(TABEL, query);
        if (resultSet.next()) {
            setIdBuku(resultSet.getInt("id"));
            setJudulBuku(resultSet.getString("judul_buku"));
            setPengarang(resultSet.getString("pengarang"));
            setPenerbit(resultSet.getString("penerbit"));
            setKetersediaan(resultSet.getInt("ketersediaan"));
            setTahun(resultSet.getInt("tahun_terbit"));
            return true;
        } else {
            System.out.println("Buku Tidak ditemukan");
            return false;
        }
    }

    public boolean cekBuku() throws SQLException {
        String requirment = "buku='" + idBuku + "'";
        ResultSet resultSet = DBHelper.selectAll("transaksi_buku", requirment);
        if (resultSet.next()) {
            return false;
        } else {
            return true;
        }
    }

}