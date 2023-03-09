package application.billings.backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BillingsDatabase {
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

    public void insertServiceData(String serviceID, String billingServiceName, int billingServiceAmount, double billingServicePrice, String billingServiceDescription) throws ClassNotFoundException {
        String insert = "INSERT INTO BillingsService(" +
                "Service_ID" +
                ", Service_Name" +
                ", Service_Amount" +
                ", Service_Price" +
                ", Service_Description)" +
                " VALUES(?,?,?,?,?)";
        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(insert)){
            preparedStatement.setString(1,serviceID);
            preparedStatement.setString(2,billingServiceName);
            preparedStatement.setInt(3,billingServiceAmount);
            preparedStatement.setDouble(4,billingServicePrice);
            preparedStatement.setString(5,billingServiceDescription);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void insertDiscountData(String discountID, String billingDiscountName, int billingDiscountPercentage) throws ClassNotFoundException {
        String insert = "INSERT INTO BillingsDiscount(" +
                "Discount_ID" +
                ", Discount_Name" +
                ", Discount_Percentage)" +
                " VALUES(?,?,?)";
        try (Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(insert)){
            preparedStatement.setString(1,discountID);
            preparedStatement.setString(2,billingDiscountName);
            preparedStatement.setInt(3,billingDiscountPercentage);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void insertTaxData(String taxID, String billingTaxName, double billingTaxValue) throws ClassNotFoundException {
        String insert = "INSERT INTO BillingsTax(" +
                "Tax_ID" +
                ", Tax_Name" +
                ", Tax_Value)" +
                " VALUES(?,?,?)";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insert)){
            preparedStatement.setString(1,taxID);
            preparedStatement.setString(2,billingTaxName);
            preparedStatement.setDouble(3,billingTaxValue);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void insertBillingData(String issuerName, String issuerCUI, String issuerTradeRegisterNumber, String issuerEUID, String issuerCountry, String issuerCity, String issuerCounty, String issuerStreet, String issuerNumber, String issuerZipCode, String issuerEmail, String issuerPhoneNumber
            , String clientName, String clientCUI, String clientTradeRegisterNumber, String clientEUID, String clientCountry, String clientCity, String clientCounty, String clientStreet, String clientNumber, String clientZipCode, String clientEmail, String clientPhoneNumber
            , String serviceCurrency
            , String paymentBank, String paymentBeneficiary, String paymentIBAN, String paymentSwift, String paymentReference, double paymentExchange, String paymentIssueDate, String paymentDueDate, String paymentCurrency, String paymentStatus
            , String calculationSubtotal, String calculationTax, String calculationTotal) throws ClassNotFoundException {
        String insert = "INSERT INTO Billings(" +
                "Issuer_Name" +
                ", Issuer_CUI" +
                ", Issuer_Trade_Register_Number" +
                ", Issuer_EUID" +
                ", Issuer_Country" +
                ", Issuer_City" +
                ", Issuer_County" +
                ", Issuer_Street" +
                ", Issuer_Number" +
                ", Issuer_Zipcode" +
                ", Issuer_Email" +
                ", Issuer_Phone_Number" +
                ", Client_Name" +
                ", Client_CUI" +
                ", Client_Trade_Register_Number" +
                ", Client_EUID" +
                ", Client_Country" +
                ", Client_City" +
                ", Client_County" +
                ", Client_Street" +
                ", Client_Number" +
                ", Client_Zipcode" +
                ", Client_Email" +
                ", Client_Phone_Number" +
                ", Service_Currency" +
                ", Payment_Bank" +
                ", Payment_Beneficiary" +
                ", Payment_IBAN" +
                ", Payment_Swift" +
                ", Payment_Reference" +
                ", Payment_Exchange" +
                ", Payment_Issue_Date" +
                ", Payment_Due_Date" +
                ", Payment_Currency" +
                ", Payment_Status" +
                ", Calculation_Subtotal" +
                ", Calculation_Tax" +
                ", Calculation_Total)" +
                " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insert)){
            preparedStatement.setString(1,issuerName);
            preparedStatement.setString(2,issuerCUI);
            preparedStatement.setString(3,issuerTradeRegisterNumber);
            preparedStatement.setString(4,issuerEUID);
            preparedStatement.setString(5,issuerCountry);
            preparedStatement.setString(6,issuerCity);
            preparedStatement.setString(7,issuerCounty);
            preparedStatement.setString(8,issuerStreet);
            preparedStatement.setString(9,issuerNumber);
            preparedStatement.setString(10,issuerZipCode);
            preparedStatement.setString(11,issuerEmail);
            preparedStatement.setString(12,issuerPhoneNumber);
            preparedStatement.setString(13,clientName);
            preparedStatement.setString(14,clientCUI);
            preparedStatement.setString(15,clientTradeRegisterNumber);
            preparedStatement.setString(16,clientEUID);
            preparedStatement.setString(17,clientCountry);
            preparedStatement.setString(18,clientCity);
            preparedStatement.setString(19,clientCounty);
            preparedStatement.setString(20,clientStreet);
            preparedStatement.setString(21,clientNumber);
            preparedStatement.setString(22,clientZipCode);
            preparedStatement.setString(23,clientEmail);
            preparedStatement.setString(24,clientPhoneNumber);
            preparedStatement.setString(25,serviceCurrency);
            preparedStatement.setString(26,paymentBank);
            preparedStatement.setString(27,paymentBeneficiary);
            preparedStatement.setString(28,paymentIBAN);
            preparedStatement.setString(29,paymentSwift);
            preparedStatement.setString(30,paymentReference);
            preparedStatement.setDouble(31,paymentExchange);
            preparedStatement.setString(32,paymentIssueDate);
            preparedStatement.setString(33,paymentDueDate);
            preparedStatement.setString(34,paymentCurrency);
            preparedStatement.setString(35,paymentStatus);
            preparedStatement.setString(36,calculationSubtotal);
            preparedStatement.setString(37,calculationTax);
            preparedStatement.setString(38,calculationTotal);
            preparedStatement.executeUpdate();
        }catch (SQLException e){

        }
    }
}
