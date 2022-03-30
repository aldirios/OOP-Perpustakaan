package perpus;

import java.sql.Date;
import java.sql.ResultSet; // digunakan saat kita menggunakan statement select ke database
import java.sql.SQLException;
//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;

public class TransaksiBuku extends Denda implements Crud {

    private static final String TABEL = "transaksi_buku";
    private int id;
    private String peminjam;
    private String buku;
    private String denda;
    private java.sql.Date tanggal_pinjam;
    private java.sql.Date batas_kembali;
    private java.sql.Date tanggal_kembali;
    private String sts_pengembalian;

    public String getDenda() {
        return denda;
    }

    public void setDenda(String denda) {
        this.denda = denda;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPeminjam() {
        return peminjam;
    }

    public void setPeminjam(String peminjam) {
        this.peminjam = peminjam;
    }

    public String getBuku() {
        return buku;
    }

    public void setBuku(String buku) {
        this.buku = buku;
    }

    public Date getTanggal_pinjam() {
        return tanggal_pinjam;
    }

    public void setTanggal_pinjam(Date tanggal_pinjam) {
        this.tanggal_pinjam = tanggal_pinjam;
    }

    public Date getBatas_kembali() {
        return batas_kembali;
    }

    public void setBatas_kembali(Date batas_kembali) {
        this.batas_kembali = batas_kembali;
    }

    public Date getTanggal_kembali() {
        return tanggal_kembali;
    }

    public void setTanggal_kembali(Date tanggal_kembali) {
        this.tanggal_kembali = tanggal_kembali;
    }

    public String getSts_pengembalian() {
        return sts_pengembalian;
    }

    public void setSts_pengembalian(String sts_pengembalian) {
        this.sts_pengembalian = sts_pengembalian;
    }

    public TransaksiBuku() {
    }

    public TransaksiBuku(int id, String peminjam, String buku, Date tanggal_pinjam, Date batas_kembali, Date tanggal_kembali, String sts_pengembalian, String denda) {
        this.id = id;
        this.peminjam = peminjam;
        this.buku = buku;
        this.tanggal_pinjam = tanggal_pinjam;
        this.batas_kembali = batas_kembali;
        this.tanggal_kembali = tanggal_kembali;
        this.sts_pengembalian = sts_pengembalian;
        this.denda = denda;
    }

    @Override
    public void create() {
        LocalDate tanggalPinjam;
        LocalDate batasKembali;
        String status = "'Belum Kembali'";
        tanggalPinjam = java.time.LocalDate.now();
        batasKembali = tanggalPinjam.plusDays(7);
        String denda = "'Rp 0'";
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("buku", String.valueOf(buku));
        hashMap.put("peminjam", String.valueOf(peminjam));
        hashMap.put("tangga_pinjam", String.format("'%s'", tanggalPinjam));
        hashMap.put("batas_kembali", String.format("'%s'", batasKembali));
        hashMap.put("sts_pengembalian", status);
        hashMap.put("denda", String.valueOf(denda));
        DBHelper.insert(TABEL, hashMap);
    }

    @Override
    public void update() {
        LocalDate tanggalKembali;
        LocalDate tanggalPinjam;
        tanggalKembali = java.time.LocalDate.now();
        tanggalPinjam = tanggalKembali.minusDays(7);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("tangga_kembali", String.format("'%s'", tanggalKembali));
        hashMap.put("sts_pengembalian", "'Sudah Kembali'");
        hashMap.put("denda", lambat());
        String params = String.format("peminjam = %s and buku = %s", peminjam, buku);
        DBHelper.update(TABEL, hashMap, params);
    }

    @Override
    public void delete() {
    }

    @Override
    public ArrayList<TransaksiBuku> read() throws SQLException {
        String[] col = {"t.id", "p.nama", "b.judul_buku", "t.tangga_pinjam", "t.batas_kembali", "t.tangga_kembali", "t.sts_pengembalian", "t.denda"};
        String join = TABEL + " t join buku b on t.buku=b.id join person p on t.peminjam = p.id";
        ResultSet resultSet = DBHelper.selectColumn(join, col);
        return getTransaksiBukus(resultSet);
    }

    public ArrayList<TransaksiBuku> read(String nama) throws SQLException {
        String[] col = {"t.id", "p.nama", "b.judul_buku", "t.tangga_pinjam", "t.batas_kembali", "t.tangga_kembali", "t.sts_pengembalian", "t.denda"};
        String join = TABEL + " t join buku b on t.buku=b.id join person p on t.peminjam = p.id";
        String requirment = "nama LIKE '%" + nama + "%'";
        ResultSet resultSet = DBHelper.selectColumn(join, col, requirment);
        return getTransaksiBukus(resultSet);
    }

    public ArrayList<TransaksiBuku> read(int idpeminjam, String status) throws SQLException {
        String[] col = {"t.id", "p.nama", "b.judul_buku", "t.tangga_pinjam", "t.batas_kembali", "t.tangga_kembali", "t.sts_pengembalian", "t.denda"};
        String join = TABEL + " t join buku b on t.buku=b.id join person p on t.peminjam = p.id";
        String requirment = "peminjam='" + idpeminjam + "' and sts_pengembalian='" + status + "'";
        ResultSet resultSet = DBHelper.selectColumn(join, col, requirment);
        return getTransaksiBukus(resultSet);
    }

    public boolean cekTransaksi(int idpeminjam, int idbuku) throws SQLException {
        String[] col = {"t.id", "p.nama", "b.judul_buku", "t.tangga_pinjam", "t.batas_kembali", "t.tangga_kembali", "t.sts_pengembalian", "t.denda"};
        String join = TABEL + " t join buku b on t.buku=b.id join person p on t.peminjam = p.id";
        String requirment = "peminjam='" + idpeminjam + "' and buku='" + idbuku + "' and sts_pengembalian='Belum Kembali'";
        ResultSet resultSet = DBHelper.selectColumn(join, col, requirment);
        if (resultSet.next()) {
            return false;
        } else {
            return true;
        }
    }

    private ArrayList<TransaksiBuku> getTransaksiBukus(ResultSet resultSet) throws SQLException {
        TransaksiBuku transaksiBuku;
        ArrayList<TransaksiBuku> allTransaksi = new ArrayList<>();
        while (resultSet.next()) {
            transaksiBuku = new TransaksiBuku();
            transaksiBuku.setId(resultSet.getInt("id"));
            transaksiBuku.setPeminjam(resultSet.getString("nama"));
            transaksiBuku.setBuku(resultSet.getString("judul_buku"));
            transaksiBuku.setTanggal_pinjam(resultSet.getDate("tangga_pinjam"));
            transaksiBuku.setBatas_kembali(resultSet.getDate("batas_kembali"));
            transaksiBuku.setTanggal_kembali(resultSet.getDate("tangga_kembali"));
            transaksiBuku.setSts_pengembalian(resultSet.getString("sts_pengembalian"));
            allTransaksi.add(transaksiBuku);
        }
        return allTransaksi;
    }

    @Override
    public String lambat() {
        //int lambat = 1000;
        return null;

        /*try {
            DateFormat format = new SimpleDateFormat("dd MMMM yyyy");
            Date tanggalPinjam = format.parse(pinjam);
            Date tanggalkembali = format.parse(tanggalKembali);
            long tanggalpinjam1 = tanggalpinjam.getTime();
            long tanggalkembali1 = tanggalkembali.getTime();
            long diff = tanggalkembali1 - tanggalpinjam1;
            long lama = diff / (24 * 60 * 60 * 1000);
            lamapinjam.setText(Long.toString(lama) + "");
        } catch (Exception e) {
            System.out.println("" + e.getMessage());
        }*/
    }

    @Override
    public String pinjam() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String kembali() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
