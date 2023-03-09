package application.billings;

public class BillingService {
    private String serviceID;
    private String billingServiceName;
    private int billingServiceAmount;
    private double billingServicePrice;
    private String billingServiceDescription;

    public BillingService(String serviceID, String billingServiceName, int billingServiceAmount, double billingServicePrice, String billingServiceDescription){
        this.serviceID = serviceID;
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

    public String getServiceID() {
        return serviceID;
    }

    public void setServiceID(String serviceID) {
        this.serviceID = serviceID;
    }
}
