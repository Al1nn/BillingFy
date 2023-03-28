package application.statistics.backend;

import application.statistics.StatisticsBarChartModel;
import application.statistics.StatisticsPieModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class StatisticsDatabase {
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

    public ObservableList<StatisticsPieModel> retrievePieData() throws ClassNotFoundException {
        String select = "SELECT Client_Name , COUNT(*) as Appearance_Count " +
                "FROM Clients GROUP BY Client_Name";
        ObservableList<StatisticsPieModel> models = FXCollections.observableArrayList();
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(select)){
             while (resultSet.next()){
                 String statisticsName = resultSet.getString("Client_Name");
                 int statisticsAppearance = resultSet.getInt("Appearance_Count");
                 StatisticsPieModel model = new StatisticsPieModel(statisticsName,statisticsAppearance);
                 models.add(model);
             }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return models;
    }

    public ObservableList<StatisticsBarChartModel> retrieveBarChartData() throws ClassNotFoundException {
        String select = "SELECT Service_Name, SUM(AMOUNT) as Total_Amount, SUM(PRICE) as Total_Income " +
                "FROM Services " +
                "GROUP BY Service_Name";
        ObservableList<StatisticsBarChartModel> models = FXCollections.observableArrayList();
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(select)){
            while (resultSet.next()){
                String statisticsName = resultSet.getString("Service_Name");
                int statisticsAmount = resultSet.getInt("Total_Amount");
                double statisticsPrice = resultSet.getDouble("Total_Income");
                StatisticsBarChartModel model = new StatisticsBarChartModel(statisticsName,statisticsAmount,statisticsPrice);
                models.add(model);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return models;
    }
}
