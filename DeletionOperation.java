import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class DeletionOperation {
    public static void main(String arg[]) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the Id of student to be deleted: ");
        int id = scan.nextInt();
        scan.close();
        deletetInfo(id);
    }
    public static void deletetInfo ( int id)
    {

        try {
            Class.forName(PropertryLoader.driver);
            Connection con = DriverManager.getConnection(PropertryLoader.url, PropertryLoader.user, PropertryLoader.password);
            PreparedStatement stmt1= con.prepareStatement("Delete from student where id=?");
            stmt1.setInt(1,id);
            int count = stmt1.executeUpdate();
            con.close();
            System.out.println("Student information is deleted...");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}