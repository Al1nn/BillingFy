USE BillingFy;

CREATE TABLE Business(
	Business_Name VARCHAR(150),
	CUI varchar(8),
    Trade_Register_Number varchar(50),
    EUID varchar(75),
    COUNTRY varchar(100),
    CITY varchar(100),
    COUNTY varchar(100),
	STREET varchar(100),
    NUMBER varchar(100),
    ZIPCODE varchar(6),
    EMAIL varchar(200),
    PHONE_NUMBER varchar(100),
    BANK varchar(100),
    BENEFICIARY varchar(100),
    IBAN varchar(34),
    SWIFT varchar(11),
    REFERENCE varchar(30),
    EXCHANGE BIGINT,
    CURRENCY varchar(3)
);

INSERT INTO Business VALUES ('SC COMPANY NAME','1234567','J4/1202/2022','ROONRC.J4/1202/2022','Romania','Arad','Timis','Str.Margaritarilor','1','152425','company@gmail.com','0745235352','BRD','SC COMPANY NAME','IBAN CODE','SWIFT CODE','REFERENCE CODE','5000','EUR');
SELECT * FROM Business;
UPDATE Business SET Business_Name = 'SC COM' WHERE Business_Name = 'SC COMPANY NAME';