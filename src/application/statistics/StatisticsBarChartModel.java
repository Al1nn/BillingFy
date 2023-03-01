package application.statistics;

public class StatisticsBarChartModel {
        private String statisticsName;
        private int statisticsAmount;
        private double statisticsPrice;

        public StatisticsBarChartModel(String statisticsName, int statisticsAmount, double statisticsPrice){
            this.statisticsName = statisticsName;
            this.statisticsAmount = statisticsAmount;
            this.statisticsPrice = statisticsPrice;
        }
    public String getStatisticsName() {
        return statisticsName;
    }

    public void setStatisticsName(String statisticsName) {
        this.statisticsName = statisticsName;
    }

    public int getStatisticsAmount() {
        return statisticsAmount;
    }

    public void setStatisticsAmount(int statisticsAmount) {
        this.statisticsAmount = statisticsAmount;
    }

    public double getStatisticsPrice() {
        return statisticsPrice;
    }

    public void setStatisticsPrice(double statisticsPrice) {
        this.statisticsPrice = statisticsPrice;
    }
}
