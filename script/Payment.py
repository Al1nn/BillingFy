class Payment:
    def __init__(self, paymentBank, paymentBeneficiary, paymentIBAN, paymentSwift, paymentReference, paymentExchange, paymentIssueDate, paymentDueDate, paymentCurrency, paymentStatus):
        self.paymentBank = paymentBank
        self.paymentBeneficiary = paymentBeneficiary
        self.paymentIBAN = paymentIBAN
        self.paymentSwift = paymentSwift
        self.paymentReference = paymentReference
        self.paymentExchange = paymentExchange
        self.paymentIssueDate = paymentIssueDate
        self.paymentDueDate = paymentDueDate
        self.paymentCurrency = paymentCurrency
        self.paymentStatus = paymentStatus
        
    def get_paymentBank(self):
        return self.paymentBank
        
    def get_paymentBeneficiary(self):
        return self.paymentBeneficiary
        
    def get_paymentIBAN(self):
        return self.paymentIBAN
        
    def get_paymentSwift(self):
        return self.paymentSwift
        
    def get_paymentReference(self):
        return self.paymentReference
        
    def get_paymentExchange(self):
        return self.paymentExchange
    
    def get_paymentIssueDate(self):
        return self.paymentIssueDate
        
    def get_paymentDueDate(self):
        return self.paymentDueDate
        
    def get_paymentCurrency(self):
        return self.paymentCurrency
        
    def get_paymentStatus(self):
        return self.paymentStatus
        
