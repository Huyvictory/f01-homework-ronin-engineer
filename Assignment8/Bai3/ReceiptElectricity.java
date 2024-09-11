package Assignment8.Bai3;

public class ReceiptElectricity {
    private final HomeUsage homeUsage;
    private final double OldElectricityCounter;
    private final double NewElectricityCounter;

    public HomeUsage getHomeUsage() {
        return homeUsage;
    }

    public double getOldElectricityCounter() {
        return OldElectricityCounter;
    }

    public double getNewElectricityCounter() {
        return NewElectricityCounter;
    }

    public ReceiptElectricity(HomeUsage homeUsage, double OldElectricityCounter, double NewElectricityCounter) {
        this.homeUsage = homeUsage;
        this.OldElectricityCounter = OldElectricityCounter;
        this.NewElectricityCounter = NewElectricityCounter;

    }

    public void CalculateMoneySpent() {
        double moneySpent = (this.NewElectricityCounter - this.OldElectricityCounter) * 5;
        System.out.printf("Money Spent: %.2f\n", moneySpent);
    }
}
