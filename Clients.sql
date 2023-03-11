SELECT * FROM Clients;
SELECT COUNT(*) FROM Clients;
SELECT Client_Name , COUNT(*) as Appearance_Count
FROM Clients GROUP BY Client_Name;
