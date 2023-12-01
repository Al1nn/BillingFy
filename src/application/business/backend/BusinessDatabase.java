package application.business.backend;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import application.business.Business;
import application.clients.Client;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class BusinessDatabase {
    public Connection databaseLink;

    public Connection getConnection() throws ClassNotFoundException {
        String databaseName = "BillingFy";
        String databaseUser = "root";
        String databasePassword = "your_password";
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

    public void updateData(String businessName, String businessCUI
            ,String businessTradeRegisterNumber,String businessEUID
            ,String businessCountry, String businessCity
            , String businessCounty, String businessStreet
            , String businessNumber, String businessZipCode
            , String businessEmail, String businessPhoneNumber
            , String businessPaymentBank, String businessPaymentBeneficiary
            , String businessPaymentIBAN, String businessPaymentSwift
            , String businessPaymentReference, String businessPaymentExchange
            , String businessPaymentCurrency
            , String oldBusinessName, String oldBusinessNumber){
        String update = "UPDATE Business SET " +
                "Business_Name = ?, " +
                "CUI = ?, " +
                "Trade_Register_Number = ?, " +
                "EUID = ?, " +
                "COUNTRY = ?, " +
                "CITY = ?, " +
                "COUNTY = ?, " +
                "STREET = ?, " +
                "NUMBER = ?, " +
                "ZIPCODE = ?, " +
                "EMAIL = ?, " +
                "PHONE_NUMBER = ?, " +
                "BANK = ?, " +
                "BENEFICIARY = ?, " +
                "IBAN = ?, " +
                "SWIFT = ?, " +
                "REFERENCE = ?, " +
                "EXCHANGE = ?, " +
                "CURRENCY = ? " +
                "WHERE Business_Name = ? " +
                "AND NUMBER = ?";
        try (Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(update)){
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
            preparedStatement.setString(20,oldBusinessName);
            preparedStatement.setString(21,oldBusinessNumber);
            preparedStatement.executeUpdate();
        }catch(SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public void deleteData(String businessName, String businessNumber) throws ClassNotFoundException{
        String delete = "DELETE FROM Business WHERE Business_Name = ? AND NUMBER = ?";
        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(delete)
        ){
            preparedStatement.setString(1,businessName);
            preparedStatement.setString(2,businessNumber);
            int rowsDelete = preparedStatement.executeUpdate();
            System.out.println("Business Rows Deleted : " + rowsDelete);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public ObservableList<Business> retrieveData() throws ClassNotFoundException {
        ObservableList<Business> businesses = FXCollections.observableArrayList();
        String retrieve = "SELECT * FROM Business";
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(retrieve)){
            while (resultSet.next()){
                String businessName = resultSet.getString("Business_Name");
                String businessCUI = resultSet.getString("CUI");
                String businessTradeRegisterNumber = resultSet.getString("Trade_Register_Number");
                String businessEUID = resultSet.getString("EUID");
                String businessCountry = resultSet.getString("COUNTRY");
                String businessCity = resultSet.getString("CITY");
                String businessCounty = resultSet.getString("COUNTY");
                String businessStreet = resultSet.getString("STREET");
                String businessNumber = resultSet.getString("NUMBER");
                String businessZipCode = resultSet.getString("ZIPCODE");
                String businessEmail = resultSet.getString("EMAIL");
                String businessPhoneNumber = resultSet.getString("PHONE_NUMBER");
                String businessPaymentBank = resultSet.getString("BANK");
                String businessPaymentBeneficiary = resultSet.getString("BENEFICIARY");
                String businessPaymentIBAN = resultSet.getString("IBAN");
                String businessPaymentSwift = resultSet.getString("SWIFT");
                String businessPaymentReference = resultSet.getString("REFERENCE");
                String businessPaymentExchange = resultSet.getString("EXCHANGE");
                String businessPaymentCurrency = resultSet.getString("CURRENCY");
                Business business = new Business(
                        businessName,businessCUI
                        ,businessTradeRegisterNumber
                        ,businessEUID, businessCountry
                        ,businessCity, businessCounty
                        ,businessStreet, businessNumber
                        ,businessZipCode, businessEmail
                        ,businessPhoneNumber
                        ,businessPaymentBank, businessPaymentBeneficiary
                        ,businessPaymentIBAN, businessPaymentSwift
                        ,businessPaymentReference, businessPaymentExchange
                        ,businessPaymentCurrency);
                businesses.add(business);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return businesses;
    }

}
