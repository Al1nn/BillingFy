package application.statistics.backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class StatisticsDatabase {
    public Connection databaseLink;

    public Connection getConnection() throws ClassNotFoundException {
        String databaseName = "BillingFy";
        String databaseUser = "root";
        String databasePassword = "FRES-123";
        String url = "jdbc:mysql://localhost:3306/" + databaseName;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaseLink = DriverManager.getConnection(url,databaseUser,databasePassword);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return databaseLink;
    }

    
}
