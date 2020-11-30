import java.sql.*;

public class conn {
    
    public Connection c;
    public Statement s;
 
    public conn() throws SQLException{
        try{
            
            Class.forName("org.sqlite.JDBC");
            c=DriverManager.getConnection("jdbc:sqlite:payroll.db");
            s = c.createStatement();
            
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}