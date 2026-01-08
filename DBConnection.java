import java.sql.Connection;
import java.sql.DriverManager;
//Task 1:

public class DBConnection {
    public static void main(String[] args){
        String mysqlDriver="com.mysql.cj.jdbc.Driver";
        String mysqlUrl="jdbc:mysql://localhost:3306/Table_collection";
        String userName="root";
        String password="latika#275";
        try{
            Class.forName(mysqlDriver);
            Connection con= DriverManager.getConnection(mysqlUrl,userName,password);
            System.out.println("Connection Successful");
            con.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
