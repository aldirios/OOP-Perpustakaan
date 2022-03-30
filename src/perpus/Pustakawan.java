package perpus;

import java.sql.Connection;
import java.sql.ResultSet; 
import java.sql.SQLException;
import java.sql.Statement; // membaca bahwa kode tersebut adalah bahasa SQL dan mengantarkan bahasa tersebut ke dalam database
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;

public class Pustakawan extends Person implements Crud {

    private static final String TABEL = "person";
    
    public Pustakawan() {
    }
    
    public Pustakawan(int idPerson, String nama, String username, String password, int role) {
        super(idPerson, nama, username, password, role);
    }

    @Override
    public void create() {
        HashMap<String, String> map = new HashMap<>();
        map.put("nama",String.format("'%s'",getNama()));
        map.put("username", String.format("'%s'",getUsername()));
        map.put("password",String.format("'%s'",getPassword()));
        map.put("role","1");

        boolean isSuccess = DBHelper.insert(getTABEL(),map);

        if (isSuccess){
            JOptionPane.showMessageDialog(null, "Data Pustakawan Berhasil Ditambah", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null, "Data Pustakawan Gagal Ditambahkan", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    @Override
    public void update() {

    }

    @Override
    public void delete() {
        String clause = "id="+super.getIdPerson();
        boolean isSuccess = DBHelper.delete(TABEL,clause);
        if (isSuccess){
            JOptionPane.showMessageDialog(null, "Data Pustakawan Berhasil Dihapus", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null, "Data Pustakawan Gagal Dihapus, mungkin id yang anda masukan salah", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    @Override
    public ArrayList read(){
        ResultSet resultSet = DBHelper.selectAll(getTABEL(),"role =1");
        ArrayList<Pustakawan> allpustakawan = new ArrayList<>();
        while (true) {
            try {
                if (resultSet.next()) {
                    Pustakawan pustakawan = new Pustakawan();
                    pustakawan.setNama(resultSet.getString("nama"));
                    pustakawan.setIdPerson(resultSet.getInt("id"));
                    pustakawan.setUsername(resultSet.getString("username"));
                    pustakawan.setPassword(resultSet.getString("password"));
                    pustakawan.setRole(resultSet.getInt("role"));
                    allpustakawan.add(pustakawan);
                } else {
                    break;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return allpustakawan;
    }
    
    public boolean cekUsername(String username) throws SQLException {
        String sql = "select * from person where username='"+username+"'";
        Connection konek = new DBConection().getConnection();
        Statement stat = konek.createStatement();
        ResultSet resultSet = stat.executeQuery(sql);
        if (resultSet.next()){
            return false;
        }else {
            return true;
        }
    }
}