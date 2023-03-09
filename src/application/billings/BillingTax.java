package application.billings;

public class BillingTax {
    private String taxID;
    private String billingTaxName;
    private double billingTaxValue;

    public BillingTax(String taxID, String billingTaxName, double billingTaxValue){
        this.taxID = taxID;
        this.billingTaxName = billingTaxName;
        this.billingTaxValue = billingTaxValue;
    }

    public String getBillingTaxName() {
        return billingTaxName;
    }

    public void setBillingTaxName(String billingTaxName) {
        this.billingTaxName = billingTaxName;
    }

    public double getBillingTaxValue() {
        return billingTaxValue;
    }

    public void setBillingTaxValue(int billingTaxValue) {
        this.billingTaxValue = billingTaxValue;
    }

    public String getTaxID() {
        return taxID;
    }

    public void setTaxID(String taxID) {
        this.taxID = taxID;
    }
}
