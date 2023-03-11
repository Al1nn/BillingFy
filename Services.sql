CREATE TABLE Services(
	Service_Name varchar(100),
    AMOUNT bigint,
    PRICE double,
    CURRENCY varchar(3),
    DESCRIPTION varchar(200),
    NUMBER varchar(100)
);
SELECT * FROM Services;
SELECT Service_Name, SUM(AMOUNT) as Total_Amount, SUM(PRICE) as Total_Income
FROM Services
GROUP BY Service_Name;