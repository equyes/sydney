package utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;

public class SqlConnector {
    public static String dBName = ReadConfigFiles.getPropertyValues("DbName");
    private static final String Url = "jdbc:postgresql://localhost:5432/" + dBName;
    private static final String User = ReadConfigFiles.getPropertyValues("DbUser");
    private static final String Password = ReadConfigFiles.getPropertyValues("DbPassword");

    public static final Logger LOGGER = LogManager.getLogger(SqlConnector.class);

    private static Connection Connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(Url, User, Password);
            LOGGER.info("Successfully connected to the Database");
        } catch (SQLException e) {
            LOGGER.error("SQL Connection Exception: " + e.getMessage());
        }
        return conn;
    }

    public static ResultSet readData(String SQL) throws SQLException {
        ResultSet rs = null;
        Connection conn = null;
        try {
          conn = Connect();
          LOGGER.debug("Connection Object Value: "+ conn);

            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery(SQL);
        }catch (SQLException e) {
            LOGGER.error("SQL Result Set Exception is: " + e.getMessage());
        } finally {
            conn.close();
        }
        return rs;
    }

}
