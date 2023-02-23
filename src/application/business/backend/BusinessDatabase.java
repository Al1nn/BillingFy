package application.business.backend;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import application.clients.Client;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class BusinessDatabase {
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

    public void insertData(String businessName, String businessCUI
            , String businessTradeRegisterNumber, String businessEUID
            , String businessCountry, String businessCity
            , String businessCounty, String businessStreet
            , String businessNumber, String businessZipCode
            , String businessEmail, String businessPhoneNumber
            , String businessPaymentBank, String businessPaymentBeneficiary
            , String businessPaymentIBAN, String businessPaymentSwift
            , String businessPaymentReference, String businessPaymentExchange
            , String businessPaymentCurrency) throws ClassNotFoundException {
        String insert = "INSERT INTO Business(" +
                "Business_Name" +
                ", CUI" +
                ", Trade_Register_Number" +
                ", EUID" +
                ", COUNTRY" +
                ", CITY" +
                ", COUNTY" +
                ", STREET" +
                ", NUMBER" +
                ", ZIPCODE" +
                ", EMAIL" +
                ", PHONE_NUMBER" +
                ", BANK" +
                ", BENEFICIARY" +
                ", IBAN" +
                ", SWIFT" +
                ", REFERENCE" +
                ", EXCHANGE" +
                ", CURRENCY)" +
                "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insert)){
            preparedStatement.setString(1,businessName);
            preparedStatement.setString(2,businessCUI);
            preparedStatement.setString(3,businessTradeRegisterNumber);
            preparedStatement.setString(4,businessEUID);
            preparedStatement.setString(5,businessCountry);
            preparedStatement.setString(6,businessCity);
            preparedStatement.setString(7,businessCounty);
            preparedStatement.setString(8,businessStreet);
            preparedStatement.setString(9,businessNumber);
            preparedStatement.setString(10,businessZipCode);
            preparedStatement.setString(11,businessEmail);
            preparedStatement.setString(12,businessPhoneNumber);
            preparedStatement.setString(13,businessPaymentBank);
            preparedStatement.setString(14,businessPaymentBeneficiary);
            preparedStatement.setString(15,businessPaymentIBAN);
            preparedStatement.setString(16,businessPaymentSwift);
            preparedStatement.setString(17,businessPaymentReference);
            preparedStatement.setString(18,businessPaymentExchange);
            preparedStatement.setString(19,businessPaymentCurrency);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
