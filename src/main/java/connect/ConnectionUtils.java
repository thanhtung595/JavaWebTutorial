package connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtils {
    public static Connection getMySQLConnection() throws SQLException, ClassNotFoundException {
        String hostName = "localhost";
        String dbName = "lab04jspservletjdbc";
        String userName = "root";
        String password = "";
        String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName;

        // Load the JDBC driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Establish the connection
        Connection conn = DriverManager.getConnection(connectionURL, userName, password);

        return conn;
    }
}
