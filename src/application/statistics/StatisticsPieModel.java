package application.statistics;

public class StatisticsPieModel {
    private String statisticsName;
    private int statisticsAppearance;

    public StatisticsPieModel(String statisticsName, int statisticsAppearance){
        this.statisticsName = statisticsName;
        this.statisticsAppearance = statisticsAppearance;
    }
    public String getStatisticsName() {
        return statisticsName;
    }

    public void setStatisticsName(String statisticsName) {
        this.statisticsName = statisticsName;
    }

    public int getStatisticsAppearance() {
        return statisticsAppearance;
    }

    public void setStatisticsAppearance(int statisticsAppearance) {
        this.statisticsAppearance = statisticsAppearance;
    }
}
