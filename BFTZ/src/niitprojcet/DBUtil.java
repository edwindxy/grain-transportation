package niitprojcet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBUtil {

    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String username = "root";
    private static final String password = "1234";//注意修改MySql密码。
    private static final String url = "jdbc:mysql://localhost:3306/BFTZ";

    static {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }
}