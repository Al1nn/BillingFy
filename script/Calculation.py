class Calculation :
    def __init__(self,calculationSubtotal, calculationTax, calculationTotal):
        self.calculationSubtotal = calculationSubtotal
        self.calculationTax = calculationTax
        self.calculationTotal = calculationTotal
    
    def get_calculationSubtotal(self):
        return self.calculationSubtotal
        
    def get_calculationTax(self):
        return self.calculationTax
        
    def get_calculationTotal(self):
        return self.calculationTotal
