import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author PY7
 */
public class konektor {
    public static Connection koneksi;
    public static Statement statement;
    
    public static Connection getKoneksi(){
        if (koneksi == null) {
            try {
                String url = "jdbc:mysql://localhost/daily_journal";
                String user = "root";
                String password = "";
                DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
                koneksi = DriverManager.getConnection(url, user, password);
                statement = koneksi.createStatement();
                System.out.println("Berhasil");
            } catch (Exception e) {
                System.out.println("Error");
            }
        }
        return koneksi;
    } 
}
