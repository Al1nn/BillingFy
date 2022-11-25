package application.billings;

public class Billing {
	private String billingNumber;
	private String billingClient;
	private String billingIssueDate;
	private String billingDueDate;
	private String billingSum;
	private String billingTax;
	private String billingTotal;
	private String billingStatus;
	private String billingFunctions;
	
	public Billing(String billingNumber, String billingClient
			, String billingIssueDate, String billingDueDate
			, String billingSum, String billingTax
			, String billingTotal, String billingStatus
			, String billingFunctions) {
		this.billingNumber = billingNumber;
		this.billingClient = billingClient;
		this.billingIssueDate = billingIssueDate;
		this.billingDueDate = billingDueDate;
		this.billingSum = billingSum;
		this.billingTax = billingTax;
		this.billingTotal = billingTotal;
		this.billingStatus = billingStatus;
		this.billingFunctions = billingFunctions;
	}

	

	public String getBillingNumber() {
		return billingNumber;
	}

	public void setBillingNumber(String billingNumber) {
		this.billingNumber = billingNumber;
	}
	
	public String getBillingClient() {
		return billingClient;
	}

	public void setBillingClient(String billingClient) {
		this.billingClient = billingClient;
	}



	public String getBillingIssueDate() {
		return billingIssueDate;
	}



	public void setBillingIssueDate(String billingIssueDate) {
		this.billingIssueDate = billingIssueDate;
	}



	public String getBillingDueDate() {
		return billingDueDate;
	}



	public void setBillingDueDate(String billingDueDate) {
		this.billingDueDate = billingDueDate;
	}



	public String getBillingSum() {
		return billingSum;
	}



	public void setBillingSum(String billingSum) {
		this.billingSum = billingSum;
	}



	public String getBillingTax() {
		return billingTax;
	}



	public void setBillingTax(String billingTax) {
		this.billingTax = billingTax;
	}



	public String getBillingTotal() {
		return billingTotal;
	}



	public void setBillingTotal(String billingTotal) {
		this.billingTotal = billingTotal;
	}



	public String getBillingStatus() {
		return billingStatus;
	}



	public void setBillingStatus(String billingStatus) {
		this.billingStatus = billingStatus;
	}



	public String getBillingFunctions() {
		return billingFunctions;
	}



	public void setBillingFunctions(String billingFunctions) {
		this.billingFunctions = billingFunctions;
	}
	
}
