import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class OracleBaseDao {
    private Connection connection;
    protected Connection getConnection(){
        Connection con = null;
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con= DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:xe","p1","123");
            connection = con;

            return con;
        }catch(Exception e){ System.out.println(e);}
        return con;
    }

    public void closeConnection() {
        try {
            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
