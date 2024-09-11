package Assignment8.Bai3;

public class HomeUsage {
    private String HomeName;
    private int HomeNumber;
    private String IdPowerTracker;

    public String getHomeName() {
        return HomeName;
    }

    public int getHomeNumber() {
        return HomeNumber;
    }

    public String getIdPowerTracker() {
        return IdPowerTracker;
    }

    public HomeUsage(String HomeName, int HomeNumber, String IdPowerTracker) {
        this.HomeName = HomeName;
        this.HomeNumber = HomeNumber;
        this.IdPowerTracker = IdPowerTracker;
    }

    public void UpdateHomeUsage(String HomeName, int HomeNumber, String IdPowerTracker) {
        this.HomeName = HomeName;
        this.HomeNumber = HomeNumber;
        this.IdPowerTracker = IdPowerTracker;
    }

    public void DeleteHomeUsage() {
        this.HomeName = null;
        this.HomeNumber = 0;
        this.IdPowerTracker = null;
    }

    public void PrintDetails() {
        System.out.printf("Home Name: %s, Home Number: %d, Id Power Tracker: %s\n", HomeName, HomeNumber, IdPowerTracker);
    }
}
