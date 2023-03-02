package application.billings;

public class BillingService {
    private String billingServiceName;
    private int billingServiceAmount;
    private double billingServicePrice;
    private String billingServiceDescription;

    public BillingService(String billingServiceName, int billingServiceAmount, double billingServicePrice, String billingServiceDescription){
        this.billingServiceName = billingServiceName;
        this.billingServiceAmount = billingServiceAmount;
        this.billingServicePrice = billingServicePrice;
        this.billingServiceDescription = billingServiceDescription;
    }

    public String getBillingServiceName() {
        return billingServiceName;
    }

    public void setBillingServiceName(String billingServiceName) {
        this.billingServiceName = billingServiceName;
    }

    public int getBillingServiceAmount() {
        return billingServiceAmount;
    }

    public void setBillingServiceAmount(int billingServiceAmount) {
        this.billingServiceAmount = billingServiceAmount;
    }

    public double getBillingServicePrice() {
        return billingServicePrice;
    }

    public void setBillingServicePrice(double billingServicePrice) {
        this.billingServicePrice = billingServicePrice;
    }

    public String getBillingServiceDescription() {
        return billingServiceDescription;
    }

    public void setBillingServiceDescription(String billingServiceDescription) {
        this.billingServiceDescription = billingServiceDescription;
    }
}
