class Discount:
    def __init__(self,discountName, discountPercentage):
        self.discountName = discountName
        self.discountPercentage = discountPercentage
    
    def get_discountName(self):
        return self.discountName
    
    def get_discountPercentage(self):
        return self.discountPercentage
        
