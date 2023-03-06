package application.billings.backend;

import application.billings.BillingDiscount;
import application.billings.BillingService;
import application.billings.BillingTax;
import javafx.collections.ObservableList;

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

    public void insertBillingData(String issuerName, String issuerCUI, String issuerTradeRegisterNumber, String issuerEUID, String issuerCountry, String issuerCity, String issuerCounty, String issuerStreet, String issuerNumber, String issuerZipCode, String issuerEmail, String issuerPhoneNumber
            , String clientName, String clientCUI, String clientTradeRegisterNumber, String clientEUID, String clientCountry, String clientCity, String clientCounty, String clientStreet, String clientNumber, String clientZipCode, String clientEmail, String clientPhoneNumber
            , String serviceCurrency
            , String paymentBank, String paymentBeneficiary, String paymentIBAN, String paymentSwift, String paymentReference, double paymentExchange, String paymentIssueDate, String paymentDueDate, String paymentCurrency, String paymentStatus
            , String calculationSubtotal, String calculationTax, String calculationTotal) throws ClassNotFoundException {
        String insertBilling = "INSERT INTO Billings(" +
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
                " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try (Connection connection = getConnection();
             PreparedStatement billingStatement = connection.prepareStatement(insertBilling);
          ) {
            billingStatement.setString(1,issuerName);
            billingStatement.setString(2,issuerCUI);
            billingStatement.setString(3,issuerTradeRegisterNumber);
            billingStatement.setString(4,issuerEUID);
            billingStatement.setString(5,issuerCountry);
            billingStatement.setString(6,issuerCity);
            billingStatement.setString(7,issuerCounty);
            billingStatement.setString(8,issuerStreet);
            billingStatement.setString(9,issuerNumber);
            billingStatement.setString(10,issuerZipCode);
            billingStatement.setString(11,issuerEmail);
            billingStatement.setString(12,issuerPhoneNumber);
            billingStatement.setString(13,clientName);
            billingStatement.setString(14,clientCUI);
            billingStatement.setString(15,clientTradeRegisterNumber);
            billingStatement.setString(16,clientEUID);
            billingStatement.setString(17,clientCountry);
            billingStatement.setString(18,clientCity);
            billingStatement.setString(19,clientCounty);
            billingStatement.setString(20,clientStreet);
            billingStatement.setString(21,clientNumber);
            billingStatement.setString(22,clientZipCode);
            billingStatement.setString(23,clientEmail);
            billingStatement.setString(24,clientPhoneNumber);
            billingStatement.setString(25,serviceCurrency);
            billingStatement.setString(26,paymentBank);
            billingStatement.setString(27,paymentBeneficiary);
            billingStatement.setString(28,paymentIBAN);
            billingStatement.setString(29,paymentSwift);
            billingStatement.setString(30,paymentReference);
            billingStatement.setDouble(31,paymentExchange);
            billingStatement.setString(32,paymentIssueDate);
            billingStatement.setString(33,paymentDueDate);
            billingStatement.setString(34,paymentCurrency);
            billingStatement.setString(35,paymentStatus);
            billingStatement.setString(36,calculationSubtotal);
            billingStatement.setString(37,calculationTax);
            billingStatement.setString(38,calculationTotal);
            billingStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void insertServiceData(String billingServiceName, int billingServiceAmount, double billingServicePrice, String billingServiceDescription) throws ClassNotFoundException {
        String insert = "INSERT INTO BillingsService(" +
                "Service_Name" +
                ", Service_Amount" +
                ", Service_Price" +
                ", Service_Description)" +
                " VALUES (?,?,?,?)";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(insert)) {
            statement.setString(1,billingServiceName);
            statement.setInt(2,billingServiceAmount);
            statement.setDouble(3,billingServicePrice);
            statement.setString(4,billingServiceDescription);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void insertDiscountData(String billingDiscountName, int billingDiscountPercentage) throws  ClassNotFoundException{
        String insert = "INSERT INTO BillingsDiscount(" +
                "Discount_Name" +
                ", Discount_Percentage" +
                ") VALUES(?,?)";
        try (Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(insert)){
            statement.setString(1,billingDiscountName);
            statement.setInt(2,billingDiscountPercentage);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void insertTaxData(String billingTaxName, double billingTaxValue) throws ClassNotFoundException{
        String insert = "INSERT INTO BillingsTax(" +
                "Tax_Name" +
                ", Tax_Value" +
                ") VALUES(?,?)";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(insert)){
            statement.setString(1,billingTaxName);
            statement.setDouble(2,billingTaxValue);
            statement.executeUpdate();
        } catch (SQLException e){

        }
    }
}
