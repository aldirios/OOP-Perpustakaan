package perpus;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;

public class User extends Person implements Crud {
    
    private static final String TABEL = "person";
   
    public User() {
    }
    
    public User(int idPerson, String nama, String username, String password, int role) {
        super(idPerson, nama, username, password, role);
    }

    @Override
    public void create() {
        HashMap<String, String> map = new HashMap<>();
        map.put("nama",String.format("'%s'",getNama()));
        map.put("username", String.format("'%s'",getUsername()));
        map.put("password",String.format("'%s'",getPassword()));
        map.put("role","0");

        boolean isSuccess = DBHelper.insert(getTABEL(),map);

        if (isSuccess){
            JOptionPane.showMessageDialog(null, "Data User Berhasil Ditambahkan", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null, "Data User Gagal Ditambahkan", "Informasi", JOptionPane.INFORMATION_MESSAGE);
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
            JOptionPane.showMessageDialog(null, "Data User Berhasil Dihapus", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null, "Data User Gagal Dihapus, mungkin id yang anda masukan salah", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    @Override
    public ArrayList read() {
        ResultSet resultSet = DBHelper.selectAll(getTABEL(),"role = 0");
        ArrayList<User> allAdministrator = new ArrayList<>();
        while (true) {
            try {
                if (resultSet.next()) {
                    User pustakawan = new User();
                    pustakawan.setNama(resultSet.getString("nama"));
                    pustakawan.setIdPerson(resultSet.getInt("id"));
                    pustakawan.setUsername(resultSet.getString("username"));
                    pustakawan.setPassword(resultSet.getString("password"));
                    pustakawan.setRole(resultSet.getInt("role"));
                    allAdministrator.add(pustakawan);
                } else {
                    break;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return allAdministrator;
    }

    public String read(int idPerson) throws SQLException {
        String nama = "";
        String query = "id = "+idPerson;
        ResultSet resultSet = DBHelper.selectAll(getTABEL(),query);
        while (resultSet.next()) nama = resultSet.getString("nama");
        return nama;
    }

    public boolean cekAnggota(int idpeminjam) throws SQLException {
        String requirment = "id='"+idpeminjam+"' and role='0'";
        ResultSet resultSet = DBHelper.selectAll(TABEL, requirment);
        if (resultSet.next()){
            return true;
        }else {
            return false;
        }
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
