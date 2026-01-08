import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class InsertionOperation {
    public static void main(String arg[]) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the Id of student");
        int id = scan.nextInt();
        System.out.println("Enter the Name of student");
        String name = scan.next();
        System.out.println("Enter the Age of student");
        int age = scan.nextInt();
        scan.close();
        insertInfo(id,name,age);
    }
        public static void insertInfo ( int id, String name,int age)
        {

            try {
                Class.forName(PropertryLoader.driver);
                 Connection con = DriverManager.getConnection(PropertryLoader.url, PropertryLoader.user, PropertryLoader.password);
                PreparedStatement stmt1= con.prepareStatement("Insert into Student(id,name,age) values(?,?,?)");
                stmt1.setInt(1,id);
                stmt1.setString(2,name);
                stmt1.setInt(3,age);
                int count = stmt1.executeUpdate();
                con.close();
                System.out.println("Student Information is inserted successfully...");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }