package application.billings;

public class BillingDiscount {
    private String billingDiscountName;
    private int billingDiscountPercentage;

    public BillingDiscount(String billingDiscountName, int billingDiscountPercentage){
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
}
