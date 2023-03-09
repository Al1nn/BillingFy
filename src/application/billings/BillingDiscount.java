package application.billings;

public class BillingDiscount {
    private String discountID;
    private String billingDiscountName;
    private int billingDiscountPercentage;

    public BillingDiscount(String discountID, String billingDiscountName, int billingDiscountPercentage){
        this.discountID = discountID;
        this.billingDiscountName = billingDiscountName;
        this.billingDiscountPercentage = billingDiscountPercentage;
    }

    public String getBillingDiscountName() {
        return billingDiscountName;
    }

    public void setBillingDiscountName(String billingDiscountName) {
        this.billingDiscountName = billingDiscountName;
    }

    public int getBillingDiscountPercentage() {
        return billingDiscountPercentage;
    }

    public void setBillingDiscountPercentage(int billingDiscountPercentage) {
        this.billingDiscountPercentage = billingDiscountPercentage;
    }

    public String getDiscountID() {
        return discountID;
    }

    public void setDiscountID(String discountID) {
        this.discountID = discountID;
    }
}
