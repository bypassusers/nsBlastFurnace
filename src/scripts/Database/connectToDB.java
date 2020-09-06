package scripts.Database;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class connectToDB {
    public connectToDB() {
        try (
                Connection connection = DBCreds.getDBCreds();
                Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                ResultSet results = statement.executeQuery("SELECT * FROM Accounts");

        ) {
            results.last();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
