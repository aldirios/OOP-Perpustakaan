package perpus;

import java.sql.DriverManager; // memanggil driver JDBC ke memori, dan dapat juga digunakan untuk membuka koneksi ke sumber data.
import java.sql.Connection; // mempresentasikan suatu koneksi dengan suatu data source
import java.sql.SQLException; // suatu class exception yang membungkus kesalahan (error) pengaksesan database.
import javax.swing.JOptionPane; //memperoleh tampilan sebuah dialog box sederhana berisikan suatu informasi.

public class DBConection {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver"; // nama driver dari database driver MySQL
    static final String DB_URL = "jdbc:mysql://localhost:3306/perpus"; // Mendefinisikan URL untuk Koneksi Database
    static final String USER = "root";
    static final String PASS = "";
    
    static Connection mySqlConection;
    
    public static Connection getConnection(){ 
        try{ // penanganan kesalahan jika driver jdbc tidak ditemukan
            Class.forName(JDBC_DRIVER);
            mySqlConection = DriverManager.getConnection(DB_URL,USER,PASS);
        }catch(ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, "Koneksi ke database GAGAl", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        }
        return mySqlConection;
    }
    Connection getConnection;
}

