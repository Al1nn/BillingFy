package application.billings.backend;

import application.billings.Billing;
import application.billings.BillingDiscount;
import application.billings.BillingService;
import application.billings.BillingTax;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.swing.plaf.nimbus.State;
import java.sql.*;

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

    public void insertBillingData(String billingID,String issuerName, String issuerCUI, String issuerTradeRegisterNumber, String issuerEUID, String issuerCountry, String issuerCity, String issuerCounty, String issuerStreet, String issuerNumber, String issuerZipCode, String issuerEmail, String issuerPhoneNumber
            , String clientName, String clientCUI, String clientTradeRegisterNumber, String clientEUID, String clientCountry, String clientCity, String clientCounty, String clientStreet, String clientNumber, String clientZipCode, String clientEmail, String clientPhoneNumber
            , String serviceCurrency
            , String paymentBank, String paymentBeneficiary, String paymentIBAN, String paymentSwift, String paymentReference, double paymentExchange, String paymentIssueDate, String paymentDueDate, String paymentCurrency, String paymentStatus
            , String calculationSubtotal, String calculationTax, String calculationTotal) throws ClassNotFoundException {
        String insert = "INSERT INTO Billings(" +
                "Billing_ID" +
                ", Issuer_Name" +
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
                " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insert)){
            preparedStatement.setString(1,billingID);
            preparedStatement.setString(2,issuerName);
            preparedStatement.setString(3,issuerCUI);
            preparedStatement.setString(4,issuerTradeRegisterNumber);
            preparedStatement.setString(5,issuerEUID);
            preparedStatement.setString(6,issuerCountry);
            preparedStatement.setString(7,issuerCity);
            preparedStatement.setString(8,issuerCounty);
            preparedStatement.setString(9,issuerStreet);
            preparedStatement.setString(10,issuerNumber);
            preparedStatement.setString(11,issuerZipCode);
            preparedStatement.setString(12,issuerEmail);
            preparedStatement.setString(13,issuerPhoneNumber);
            preparedStatement.setString(14,clientName);
            preparedStatement.setString(15,clientCUI);
            preparedStatement.setString(16,clientTradeRegisterNumber);
            preparedStatement.setString(17,clientEUID);
            preparedStatement.setString(18,clientCountry);
            preparedStatement.setString(19,clientCity);
            preparedStatement.setString(20,clientCounty);
            preparedStatement.setString(21,clientStreet);
            preparedStatement.setString(22,clientNumber);
            preparedStatement.setString(23,clientZipCode);
            preparedStatement.setString(24,clientEmail);
            preparedStatement.setString(25,clientPhoneNumber);
            preparedStatement.setString(26,serviceCurrency);
            preparedStatement.setString(27,paymentBank);
            preparedStatement.setString(28,paymentBeneficiary);
            preparedStatement.setString(29,paymentIBAN);
            preparedStatement.setString(30,paymentSwift);
            preparedStatement.setString(31,paymentReference);
            preparedStatement.setDouble(32,paymentExchange);
            preparedStatement.setString(33,paymentIssueDate);
            preparedStatement.setString(34,paymentDueDate);
            preparedStatement.setString(35,paymentCurrency);
            preparedStatement.setString(36,paymentStatus);
            preparedStatement.setString(37,calculationSubtotal);
            preparedStatement.setString(38,calculationTax);
            preparedStatement.setString(39,calculationTotal);
            preparedStatement.executeUpdate();
        }catch (SQLException e){

        }
    }

    public ObservableList<BillingService> retrieveServiceData(String serviceID) throws ClassNotFoundException {
        String select = "SELECT * FROM BillingsService WHERE Service_ID = ?";
        ObservableList<BillingService> billingServices = FXCollections.observableArrayList();
        try(Connection connection = getConnection()
        )
        {
            PreparedStatement preparedStatement = connection.prepareStatement(select);
            preparedStatement.setString(1,serviceID);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String billingServiceID = resultSet.getString("Service_ID");
                String billingServiceName = resultSet.getString("Service_Name");
                int billingServiceAmount = resultSet.getInt("Service_Amount");
                double billingServicePrice = resultSet.getDouble("Service_Price");
                String billingServiceDescription = resultSet.getString("Service_Description");
                BillingService billingService = new BillingService(billingServiceID,billingServiceName,billingServiceAmount,billingServicePrice,billingServiceDescription);
                billingServices.add(billingService);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return billingServices;
    }

    public ObservableList<BillingDiscount> retrieveDiscountData(String discountID) throws ClassNotFoundException{
        String select = "SELECT * FROM BillingsDiscount WHERE Discount_ID = ?";
        ObservableList<BillingDiscount> billingDiscounts = FXCollections.observableArrayList();
        try (Connection connection = getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(select);
            preparedStatement.setString(1,discountID);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String billingDiscountID = resultSet.getString("Discount_ID");
                String billingDiscountName = resultSet.getString("Discount_Name");
                int billingDiscountPercentage = resultSet.getInt("Discount_Percentage");
                BillingDiscount billingDiscount = new BillingDiscount(billingDiscountID,billingDiscountName,billingDiscountPercentage);
                billingDiscounts.add(billingDiscount);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return billingDiscounts;
    }

    public ObservableList<BillingTax> retrieveTaxData(String taxID) throws ClassNotFoundException{
        String select = "SELECT * FROM BillingsTax WHERE Tax_ID = ?";
        ObservableList<BillingTax> billingTaxes = FXCollections.observableArrayList();
        try (Connection connection = getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(select);
            preparedStatement.setString(1,taxID);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String billingTaxID = resultSet.getString("Tax_ID");
                String billingTaxName = resultSet.getString("Tax_Name");
                double billingTaxValue = resultSet.getInt("Tax_Value");
                BillingTax billingTax = new BillingTax(billingTaxID,billingTaxName,billingTaxValue);
                billingTaxes.add(billingTax);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return billingTaxes;
    }

    public ObservableList<Billing> retrieveData() throws ClassNotFoundException{
        ObservableList<Billing> billings = FXCollections.observableArrayList();
        String retrieve = "SELECT * FROM Billings";
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(retrieve))
        {
            while(resultSet.next()){
                String billingID = resultSet.getString("Billing_ID");
                String issuerName = resultSet.getString("Issuer_Name");
                String issuerCUI = resultSet.getString("Issuer_CUI");
                String issuerTradeRegisterNumber = resultSet.getString("Issuer_Trade_Register_Number");
                String issuerEUID = resultSet.getString("Issuer_EUID");
                String issuerCountry = resultSet.getString("Issuer_Country");
                String issuerCity = resultSet.getString("Issuer_City");
                String issuerCounty = resultSet.getString("Issuer_County");
                String issuerStreet = resultSet.getString("Issuer_Street");
                String issuerNumber = resultSet.getString("Issuer_Number");
                String issuerZipCode = resultSet.getString("Issuer_Zipcode");
                String issuerEmail = resultSet.getString("Issuer_Email");
                String issuerPhoneNumber = resultSet.getString("Issuer_Phone_Number");
                String clientName = resultSet.getString("Client_Name");
                String clientCUI = resultSet.getString("Client_CUI");
                String clientTradeRegisterNumber = resultSet.getString("Client_Trade_Register_Number");
                String clientEUID = resultSet.getString("Client_EUID");
                String clientCountry = resultSet.getString("Client_Country");
                String clientCity = resultSet.getString("Client_City");
                String clientCounty = resultSet.getString("Client_County");
                String clientStreet = resultSet.getString("Client_Street");
                String clientNumber = resultSet.getString("Client_Number");
                String clientZipcode = resultSet.getString("Client_Zipcode");
                String clientEmail = resultSet.getString("Client_Email");
                String clientPhoneNumber = resultSet.getString("Client_Phone_Number");
                String serviceCurrency = resultSet.getString("Service_Currency");
                String paymentBank = resultSet.getString("Payment_Bank");
                String paymentBeneficiary = resultSet.getString("Payment_Beneficiary");
                String paymentIBAN = resultSet.getString("Payment_IBAN");
                String paymentSwift = resultSet.getString("Payment_Swift");
                String paymentReference = resultSet.getString("Payment_Reference");
                double paymentExchange = resultSet.getDouble("Payment_Exchange");
                String paymentIssueDate = resultSet.getString("Payment_Issue_Date");
                String paymentDueDate = resultSet.getString("Payment_Due_Date");
                String paymentCurrency = resultSet.getString("Payment_Currency");
                String paymentStatus = resultSet.getString("Payment_Status");
                String calculationSubtotal = resultSet.getString("Calculation_Subtotal");
                String calculationTax = resultSet.getString("Calculation_Tax");
                String calculationTotal = resultSet.getString("Calculation_Total");
                Billing billing = new Billing(billingID,issuerName,issuerCUI,issuerTradeRegisterNumber,issuerEUID,issuerCountry,issuerCity,issuerCounty,issuerStreet,issuerNumber,issuerZipCode,issuerEmail,issuerPhoneNumber
                        ,clientName,clientCUI,clientTradeRegisterNumber,clientEUID,clientCountry,clientCity,clientCounty,clientStreet,clientNumber,clientZipcode,clientEmail,clientPhoneNumber
                        ,serviceCurrency
                        ,paymentBank,paymentBeneficiary,paymentIBAN,paymentSwift,paymentReference,paymentExchange,paymentIssueDate,paymentDueDate,paymentCurrency,paymentStatus
                        ,calculationSubtotal,calculationTax,calculationTotal);
                billings.add(billing);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return billings;
    }
}
