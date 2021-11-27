package mx.uv.db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    public String database = "cuestionarios";
    public String hostname = "localhost";
    public String port = "3306";
    public String url = "jdbc:mysql://" + hostname + ":" + port + "/" + database + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private String username = "root";
    private String password = "root";
    private String driverName = "com.mysql.jdbc.Driver";
    private Connection conn = null;

    public Connection getConnection() {
        try {
            Class.forName(driverName);
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("Se estableció la conexión!");
        } catch (SQLException e) {
            System.out.println("Falló");
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println("Falló la carga de la clase del JDBC");
            e.printStackTrace();
        }
        
        return conn;
    }
}
