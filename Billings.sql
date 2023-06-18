CREATE TABLE Billings(
	Billing_ID VARCHAR(5),
    Issuer_Name VARCHAR(150),
    Issuer_CUI VARCHAR(8),
    Issuer_Trade_Register_Number varchar(50),
    Issuer_EUID varchar(75),
    Issuer_Country varchar(100),
    Issuer_City varchar(100),
    Issuer_County varchar(100),
    Issuer_Street varchar(100),
    Issuer_Number varchar(100),
    Issuer_Zipcode varchar(6),
    Issuer_Email varchar(100),
    Issuer_Phone_Number varchar(15),
    Client_Name varchar(150),
    Client_CUI varchar(8),
    Client_Trade_Register_Number varchar(50),
    Client_EUID varchar(75),
    Client_Country varchar(100),
    Client_City varchar(100),
    Client_County varchar(100),
    Client_Street varchar(100),
    Client_Number varchar(100),
    Client_Zipcode varchar(6),
    Client_Email varchar(100),
    Client_Phone_Number varchar(10),
    Service_Currency varchar(3),
    Payment_Bank varchar(100),
    Payment_Beneficiary varchar(100),
    Payment_IBAN varchar(34),
    Payment_Swift varchar(11),
    Payment_Reference varchar(30),
    Payment_Exchange double,
    Payment_Issue_Date varchar(20),
    Payment_Due_Date varchar(20),
    Payment_Currency varchar(3),
    Payment_Status varchar(50),
    Calculation_Subtotal varchar(100),
    Calculation_Tax varchar(100),
    Calculation_Total varchar(100)
);

CREATE TABLE BillingsService(
	Service_ID varchar(5),
    Service_Name varchar(100),
    Service_Amount BIGINT,
    Service_Price varchar(100),
    Service_Description varchar(100)
);

CREATE TABLE BillingsDiscount(
	Discount_ID varchar(5),
    Discount_Name varchar(100),
    Discount_Percentage bigint
);

CREATE TABLE BillingsTax(
	Tax_ID varchar(5),
    Tax_Name varchar(100),
    Tax_Value double
);

SELECT * FROM Billings;
SELECT * FROM BillingsService;
SELECT * FROM BillingsDiscount;
SELECT * FROM BillingsTax;
