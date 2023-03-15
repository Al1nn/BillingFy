import json
from Calculation import Calculation
from Discount import Discount
from Service import Service
from Tax import Tax


with open('../Billings.json','r') as f:
    data = json.load(f)
#Mapped Services
for item in data['services']:
    service = Service(item['serviceName'],item['serviceAmount'],item['servicePrice'],item['serviceDescription'])
    print(service.serviceName)
    print(service.serviceAmount)
    print(service.servicePrice)
    print(service.serviceDescription)
print("")
    
#Mapped Discounts
for item in data['discounts']:
    discount = Discount(item['discountName'],item['discountPercentage'])
    print(discount.discountName)
    print(discount.discountPercentage)
print("")
    
#Mapped Taxes
for item in data['taxes']:
    tax = Tax(item['taxName'],item['taxValue'])
    print(tax.taxName)
    print(tax.taxValue)
print("")

#Mapped Calculation
calculation = Calculation(data['calculationSubtotal'],data['calculationTax'],data['calculationTotal'])
    


print(calculation.calculationSubtotal)
print(calculation.calculationTax)
print(calculation.calculationTotal)
print("")
