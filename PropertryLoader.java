import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertryLoader {
    public static final String driver;
    public static final String url;
    public static final String user;
    public static final String password;

    static {//static block not method
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("resources/db.properties"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        driver = properties.getProperty("db.driver");
        url = properties.getProperty("db.url");
        user = properties.getProperty("db.user");
        password = properties.getProperty("db.password");
    }
}