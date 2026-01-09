import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;


public class SelectionOperation {
    public static void main(String[] args) {
        selectInfo();
    }
    public static void selectInfo (                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   )
    {

        try {
            Class.forName(PropertryLoader.driver);
            Connection con = DriverManager.getConnection(PropertryLoader.url, PropertryLoader.user, PropertryLoader.password);
            PreparedStatement stmt1= con.prepareStatement("select * from student");
            ResultSet rs = stmt1.executeQuery();
            while(rs.next()) {
                System.out.print(rs.getInt("Id") + "\t");
                System.out.print(rs.getString("Name") + "\t");
                System.out.print(rs.getString("Age") + "\t");
                System.out.print(rs.getString("Marks") + "\n");
            }
            con.close();
            System.out.println("Student Information is inserted successfully...");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
}
}
