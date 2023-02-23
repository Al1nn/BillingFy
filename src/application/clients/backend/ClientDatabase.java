package application.clients.backend;


import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import application.clients.Client;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class ClientDatabase {
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

	public void insertData(String clientName
			, String clientCUI
			, String clientTradeRegisterNumber
			, String clientEUID
			, String clientCountry
			, String clientCity
			, String clientCounty
			, String clientStreet
			, String clientNumber
			, String clientZipCode
			, String clientEmail
			, String clientPhoneNumber) throws ClassNotFoundException {
		String insert = "INSERT INTO Clients("
				+ "Client_Name,CUI"
				+ ",Trade_Register_Number"
				+ ",EUID"
				+ ",COUNTRY,CITY"
				+ ",COUNTY,STREET"
				+ ",NUMBER,ZIPCODE"
				+ ",EMAIL,PHONE_NUMBER) "
				+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(insert)){
			preparedStatement.setString(1, clientName);
			preparedStatement.setString(2, clientCUI);
			preparedStatement.setString(3, clientTradeRegisterNumber);
			preparedStatement.setString(4, clientEUID);
			preparedStatement.setString(5, clientCountry);
			preparedStatement.setString(6, clientCity);
			preparedStatement.setString(7, clientCounty);
			preparedStatement.setString(8, clientStreet);
			preparedStatement.setString(9, clientNumber);
			preparedStatement.setString(10, clientZipCode);
			preparedStatement.setString(11, clientEmail);
			preparedStatement.setString(12, clientPhoneNumber);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateData(String clientName, String clientCUI
    		, String clientTradeRegisterNumber, String clientEUID
    		, String clientCountry, String clientCity
    		, String clientCounty, String clientStreet
    		, String clientNumber, String clientZipcode
    		, String clientEmail, String clientPhoneNumber
    		,String oldClientName, String oldClientNumber) {
		String update = "UPDATE Clients SET " +
                "Client_Name = ?, " +
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
                "PHONE_NUMBER = ? " +
        		"WHERE Client_Name = ? " +
				"AND NUMBER = ?";
		try (Connection connection = getConnection();
			 PreparedStatement preparedStatement = connection.prepareStatement(update)){
			preparedStatement.setString(1, clientName);
			preparedStatement.setString(2, clientCUI);
			preparedStatement.setString(3, clientTradeRegisterNumber);
			preparedStatement.setString(4, clientEUID);
			preparedStatement.setString(5, clientCountry);
			preparedStatement.setString(6, clientCity);
			preparedStatement.setString(7, clientCounty);
			preparedStatement.setString(8, clientStreet);
			preparedStatement.setString(9, clientNumber);
			preparedStatement.setString(10, clientZipcode);
			preparedStatement.setString(11, clientEmail);
			preparedStatement.setString(12, clientPhoneNumber);
			preparedStatement.setString(13, oldClientName);
			preparedStatement.setString(14,oldClientNumber);
			int rowsUpdated = preparedStatement.executeUpdate();
			if(rowsUpdated > 0)
				System.out.println("Data updated succesfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteData(String clientName, String clientNumber) throws  ClassNotFoundException{
		String delete = "DELETE FROM Clients WHERE Client_Name = ? AND NUMBER = ?";
		try(Connection conn = getConnection();
			PreparedStatement preparedStatement = conn.prepareStatement(delete);
		){
			preparedStatement.setString(1,clientName);
			preparedStatement.setString(2,clientNumber);
			int rowsDelete = preparedStatement.executeUpdate();
			System.out.println("Rows deleted "+rowsDelete);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public ObservableList<Client> retrieveData() throws ClassNotFoundException{
		ObservableList<Client> clients = FXCollections.observableArrayList();
		String retrieve = "SELECT * FROM Clients";
		try (Connection connection = getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(retrieve)){
			while(resultSet.next()) {
				String clientName = resultSet.getString("Client_Name");
				String clientCUI = resultSet.getString("CUI");
				String clientTradeRegisterNumber = resultSet.getString("Trade_Register_Number");
				String clientEUID = resultSet.getString("EUID");
				String clientCountry = resultSet.getString("COUNTRY");
				String clientCity = resultSet.getString("CITY");
				String clientCounty = resultSet.getString("COUNTY");
				String clientStreet = resultSet.getString("STREET");
				String clientNumber = resultSet.getString("NUMBER");
				String clientZipCode = resultSet.getString("ZIPCODE");
				String clientEmail = resultSet.getString("EMAIL");
				String clientPhoneNumber = resultSet.getString("PHONE_NUMBER");
				Client client = new Client(clientName, clientCUI
						, clientTradeRegisterNumber, clientEUID
						, clientCountry, clientCity
						, clientCounty, clientStreet
						, clientNumber, clientZipCode
						, clientEmail, clientPhoneNumber);
				clients.add(client);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return clients;
	}
	
}
