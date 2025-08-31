CREATE TABLE Clients(
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
    Client_Phone_Number varchar(10)
);


SELECT * FROM Clients;
SELECT COUNT(*) FROM Clients;
SELECT Client_Name , COUNT(*) as Appearance_Count
FROM Clients GROUP BY Client_Name;
