import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class UpdateOperation {
    public static void main(String ar[]){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your Id: ");
        int id = scan.nextInt();
        System.out.println("Enter your Marks: ");
        int marks  = scan.nextInt();
        scan.close();
        updateInfo(id,marks);
    }
    public static void updateInfo ( int id,int marks)
    {

        try {
            Class.forName(PropertryLoader.driver);
            Connection con = DriverManager.getConnection(PropertryLoader.url, PropertryLoader.user, PropertryLoader.password);
            PreparedStatement stmt1= con.prepareStatement("Update student set marks=? where id=?");
            stmt1.setInt(2,id);
            stmt1.setInt(1,marks);
            int count = stmt1.executeUpdate();
            System.out.println( "Your Marks are updated successfully");
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

