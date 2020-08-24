package scripts.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBCreds {
    private static final String DBUSER = "smile";
    private static final String DBPASS = "<Change this>";
    private static final String CONNECTOR = "jdbc:mysql://192.168.1.230/Accounts";


    public static Connection getDBCreds() throws SQLException {

        return DriverManager.getConnection(CONNECTOR, DBUSER, DBPASS);

    }
}
