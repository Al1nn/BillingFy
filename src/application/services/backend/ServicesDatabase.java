package application.services.backend;

import application.services.Service;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.swing.plaf.nimbus.State;
import java.sql.*;

public class ServicesDatabase {
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

    public void insertData(String serviceName, String serviceAmount
            , String servicePrice, String serviceCurrency
            , String serviceDescription, String serviceNumber) throws ClassNotFoundException{
        String insert = "INSERT INTO Services(" +
                "Service_Name" +
                ",AMOUNT" +
                ",PRICE" +
                ",CURRENCY" +
                ",DESCRIPTION" +
                ",NUMBER) " +
                "VALUES (?,?,?,?,?,?)";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insert)){
            preparedStatement.setString(1,serviceName);
            preparedStatement.setInt(2,Integer.valueOf(serviceAmount));
            preparedStatement.setDouble(3,Double.valueOf(servicePrice));
            preparedStatement.setString(4,serviceCurrency);
            preparedStatement.setString(5,serviceDescription);
            preparedStatement.setString(6,serviceNumber);
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void updateData(String serviceName, String serviceAmount
            , String servicePrice, String serviceCurrency
            , String serviceDescription, String serviceNumber
            , String oldServiceName, String oldServiceNumber){
        String update = "UPDATE Services SET " +
                "Service_Name = ?, " +
                "AMOUNT = ?, " +
                "PRICE = ?, " +
                "CURRENCY = ?, " +
                "DESCRIPTION = ?, " +
                "NUMBER = ? " +
                "WHERE Service_Name = ? " +
                "AND NUMBER = ?";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(update)){
            preparedStatement.setString(1,serviceName);
            preparedStatement.setInt(2,Integer.valueOf(serviceAmount));
            preparedStatement.setDouble(3,Double.valueOf(servicePrice));
            preparedStatement.setString(4,serviceCurrency);
            preparedStatement.setString(5,serviceDescription);
            preparedStatement.setString(6,serviceNumber);
            preparedStatement.setString(7,oldServiceName);
            preparedStatement.setString(8,oldServiceNumber);
            int rowsUpdated = preparedStatement.executeUpdate();
            if(rowsUpdated > 0){
                System.out.println("Services Data Updated Succesfully");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void deleteData(String serviceName, String servicenNumber) throws ClassNotFoundException {
        String delete = "DELETE FROM Services WHERE Service_Name = ? AND NUMBER = ?";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(delete)){
            preparedStatement.setString(1,serviceName);
            preparedStatement.setString(2,servicenNumber);
            int rowsDelete = preparedStatement.executeUpdate();
            System.out.println("Service Rows Delete " +rowsDelete);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public ObservableList<Service> retrieveData() throws ClassNotFoundException{
        ObservableList<Service> services = FXCollections.observableArrayList();
        String retrieve = "SELECT * FROM Services";
        try(Connection connection = getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(retrieve)){
            while(resultSet.next()){
                String serviceName = resultSet.getString("Service_Name");
                String serviceAmount = String.valueOf(resultSet.getInt("AMOUNT"));
                String servicePrice = String.valueOf(resultSet.getDouble("PRICE"));
                String serviceCurrency = resultSet.getString("CURRENCY");
                String serviceDescription = resultSet.getString("DESCRIPTION");
                String serviceNumber = resultSet.getString("NUMBER");
                Service service = new Service(serviceName,serviceAmount,servicePrice,serviceCurrency,serviceDescription,serviceNumber);
                services.add(service);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return services;
    }
}
