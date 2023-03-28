package application.register.backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.mindrot.jbcrypt.BCrypt;
public class LoginDatabase {
	public Connection databaseLink;
	public Connection getConnection() throws ClassNotFoundException {
		String databaseName = "sql8609226";
		String databaseUser = "sql8609226";
		String databasePassword = "kgLt77sjJF";
		String url = "jdbc:mysql://sql8.freesqldatabase.com:3306/" + databaseName;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			databaseLink = DriverManager.getConnection(url,databaseUser,databasePassword);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return databaseLink;
	}
	
	public void insertData(String registerUsername
			, String registerEmail, String registerPassword) throws ClassNotFoundException {
		String insert = "INSERT INTO Users(USERNAME,EMAIL,PASSWORD) VALUES (?,?,?);";
		String hashedRegisterPassword = BCrypt.hashpw(registerPassword, BCrypt.gensalt());
		try (Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(insert)
				){
			preparedStatement.setString(1, registerUsername);
			preparedStatement.setString(2, registerEmail);
			preparedStatement.setString(3, hashedRegisterPassword);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public String getUsername(String registerUsername) throws ClassNotFoundException {
		String select = "SELECT USERNAME FROM Users WHERE USERNAME = ?";
		String responseUsername = null;
		try (Connection connection = getConnection();
			 PreparedStatement preparedStatement = connection.prepareStatement(select);
				){
			preparedStatement.setString(1, registerUsername);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				responseUsername = resultSet.getString("USERNAME");
			}else {
				responseUsername = "";
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return responseUsername;
	}
	
	public String getEmail(String registerEmail) throws ClassNotFoundException {
		String select = "SELECT EMAIL FROM Users WHERE EMAIL = ?";
		String responseEmail = null;
		try(Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(select))
		{
			preparedStatement.setString(1, registerEmail);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				responseEmail = resultSet.getString("EMAIL");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return responseEmail;
	}
	
	public String getHashedPassword(String registerUsernameOrEmail) throws ClassNotFoundException {
		String select = "SELECT PASSWORD FROM Users WHERE USERNAME = ? OR EMAIL = ?";
		String hashedPassword = null;
		try (Connection connection = getConnection();
			 PreparedStatement preparedStatement = connection.prepareStatement(select))
		{
			preparedStatement.setString(1, registerUsernameOrEmail);
			preparedStatement.setString(2, registerUsernameOrEmail);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				hashedPassword = resultSet.getString("PASSWORD");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return hashedPassword;
	}
	
}
