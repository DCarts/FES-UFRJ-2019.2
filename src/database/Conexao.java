package database;
/**
 *
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author EDS
 *
 */
public class Conexao {
  private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
  private static final String DB_HOSTNAME = "localhost";
  private static final String DB_PORT = "3306";
  private static final String DB_NAME = "scoadb";
  private static final String DB_CONNECTION = String.format("jdbc:mysql://%s:%s/%s?useTimezone=true&serverTimezone=UTC&useSSL=false", DB_HOSTNAME, DB_PORT, DB_NAME);
  private static final String DB_USER = "root";
  private static final String DB_PASSWORD = "admin";
  public static Connection getConnection() throws SQLException {
        try {
          Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException exception) {
          System.out.println("[Error] Conexao");
        }
        try {
          return DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
        } catch (SQLException e) {
          e.printStackTrace();
          System.out.println("[Error] Conexao method: getConnection");
          throw new SQLException(e);
        }
    }

}