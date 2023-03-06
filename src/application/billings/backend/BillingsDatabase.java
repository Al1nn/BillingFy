package application.billings.backend;

import application.billings.Billing;
import application.billings.BillingDiscount;
import application.billings.BillingService;
import application.billings.BillingTax;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

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

    public ObservableList<Billing> retrieveData() throws ClassNotFoundException{
        ObservableList<Billing> billings = FXCollections.observableArrayList();
        ObservableList<BillingService> billingServices = FXCollections.observableArrayList();
        ObservableList<BillingDiscount> billingDiscounts = FXCollections.observableArrayList() ;
        ObservableList<BillingTax> billingTaxes = FXCollections.observableArrayList();

        String retrieveBilling = "SELECT * FROM Billings";
        String retrieveService = "SELECT * FROM BillingsService";
        String retrieveDiscount = "SELECT * FROM BillingsDiscount";
        String retrieveTax = "SELECT * FROM BillingsTax";

        try(Connection connection = getConnection();
            Statement statement = connection.createStatement();
            ResultSet servicesSet = statement.executeQuery(retrieveService);
        ){
            while (servicesSet.next()){
                String serviceName = servicesSet.getString("Service_Name");
                int serviceAmount = servicesSet.getInt("Service_Amount");
                double servicePrice = servicesSet.getDouble("Service_Price");
                String serviceDescription = servicesSet.getString("Service_Description");
                BillingService billingService = new BillingService(serviceName,serviceAmount,servicePrice,serviceDescription);
                billingServices.add(billingService);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        try (Connection connection = getConnection();
            Statement statement = connection.createStatement();
             ResultSet discountsSet = statement.executeQuery(retrieveDiscount);
            ){
            while (discountsSet.next()){
                String discountName = discountsSet.getString("Discount_Name");
                int discountPercentage = discountsSet.getInt("Discount_Percentage");
                BillingDiscount billingDiscount = new BillingDiscount(discountName,discountPercentage);
                billingDiscounts.add(billingDiscount);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        try (Connection connection = getConnection();
            Statement statement = connection.createStatement();
             ResultSet taxesSet = statement.executeQuery(retrieveTax)
        ){
            while (taxesSet.next()){
                String taxName = taxesSet.getString("Tax_Name");
                double taxValue = taxesSet.getDouble("Tax_Value");
                BillingTax billingTax = new BillingTax(taxName,taxValue);
                billingTaxes.add(billingTax);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet billingsSet = statement.executeQuery(retrieveBilling);
             ){
            while (billingsSet.next()){
                String issuerName = billingsSet.getString("Issuer_Name");
                String issuerCUI = billingsSet.getString("Issuer_CUI");
                String issuerTradeRegisterNumber = billingsSet.getString("Issuer_Trade_Register_Number");
                String issuerEUID = billingsSet.getString("Issuer_EUID");
                String issuerCountry = billingsSet.getString("Issuer_Country");
                String issuerCity = billingsSet.getString("Issuer_City");
                String issuerCounty = billingsSet.getString("Issuer_County");
                String issuerStreet = billingsSet.getString("Issuer_Street");
                String issuerNumber = billingsSet.getString("Issuer_Number");
                String issuerZipCode = billingsSet.getString("Issuer_Zipcode");
                String issuerEmail = billingsSet.getString("Issuer_Email");
                String issuerPhoneNumber = billingsSet.getString("Issuer_Phone_Number");
                String clientName = billingsSet.getString("Client_Name");
                String clientCUI = billingsSet.getString("Client_CUI");
                String clientTradeRegisterNumber = billingsSet.getString("Client_Trade_Register_Number");
                String clientEUID = billingsSet.getString("Client_EUID");
                String clientCountry = billingsSet.getString("Client_Country");
                String clientCity = billingsSet.getString("Client_City");
                String clientCounty = billingsSet.getString("Client_County");
                String clientStreet = billingsSet.getString("Client_Street");
                String clientNumber = billingsSet.getString("Client_Number");
                String clientZipCode = billingsSet.getString("Client_Zipcode");
                String clientEmail = billingsSet.getString("Client_Email");
                String clientPhoneNumber = billingsSet.getString("Client_Phone_Number");
                String serviceCurrency = billingsSet.getString("Service_Currency");
                String paymentBank = billingsSet.getString("Payment_Bank");
                String paymentBeneficiary = billingsSet.getString("Payment_Beneficiary");
                String paymentIBAN = billingsSet.getString("Payment_IBAN");
                String paymentSwift = billingsSet.getString("Payment_Swift");
                String paymentReference = billingsSet.getString("Payment_Reference");
                double paymentExchange = billingsSet.getDouble("Payment_Exchange");
                String paymentIssueDate = billingsSet.getString("Payment_Issue_Date");
                String paymentDueDate = billingsSet.getString("Payment_Due_Date");
                String paymentCurrency = billingsSet.getString("Payment_Currency");
                String paymentStatus = billingsSet.getString("Payment_Status");
                String calculationSubtotal = billingsSet.getString("Calculation_Subtotal");
                String calculationTax = billingsSet.getString("Calculation_Tax");
                String calculationTotal = billingsSet.getString("Calculation_Total");
                Billing billing = new Billing(issuerName,issuerCUI,issuerTradeRegisterNumber,issuerEUID,issuerCountry,issuerCity,issuerCounty,issuerStreet,issuerNumber,issuerZipCode,issuerEmail,issuerPhoneNumber
                                            ,clientName,clientCUI,clientTradeRegisterNumber,clientEUID,clientCountry,clientCity,clientCounty,clientStreet,clientNumber,clientZipCode,clientEmail,clientPhoneNumber
                                            ,serviceCurrency
                                            ,billingServices
                                            ,billingDiscounts
                                            ,billingTaxes
                                            ,paymentBank,paymentBeneficiary,paymentIBAN,paymentSwift,paymentReference,Double.valueOf(paymentExchange),paymentIssueDate,paymentDueDate,paymentCurrency,paymentStatus
                                            ,calculationSubtotal,calculationTax,calculationTotal);
                billings.add(billing);

            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return billings;
    }

}
