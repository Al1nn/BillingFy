import json
from Calculation import Calculation
from Discount import Discount
from Service import Service
from Tax import Tax
from Issuer import Issuer
from Client import Client
from Payment import Payment

with open('../Billings.json','r') as f:
    data = json.load(f)
    
#Mapped Issuer
issuer = Issuer(data['issuerName'],data['issuerCUI'],data['issuerTradeRegisterNumber'],data['issuerEUID'],data['issuerCountry'],data['issuerCity'],data['issuerCounty'],data['issuerStreet'],data['issuerNumber'],data['issuerZipCode'],data['issuerEmail'],data['issuerPhoneNumber'])
print(issuer.issuerName)
print(issuer.issuerCUI)
print(issuer.issuerTradeRegisterNumber)
print(issuer.issuerEUID)
print(issuer.issuerCountry)
print(issuer.issuerCity)
print(issuer.issuerCounty)
print(issuer.issuerStreet)
print(issuer.issuerNumber)
print(issuer.issuerZipcode)
print(issuer.issuerEmail)
print(issuer.issuerPhoneNumber)
print("")

#Mapped Client
client = Client(data['clientName'],data['clientCUI'],data['clientTradeRegisterNumber'],data['clientEUID'],data['clientCountry'],data['clientCity'],data['clientCounty'],data['clientStreet'],data['clientNumber'],data['clientZipCode'],data['clientEmail'],data['clientPhoneNumber'])

print(client.clientName)
print(client.clientCUI)
print(client.clientTradeRegisterNumber)
print(client.clientEUID)
print(client.clientCountry)
print(client.clientCity)
print(client.clientCounty)
print(client.clientStreet)
print(client.clientNumber)
print(client.clientZipcode)
print(client.clientEmail)
print(client.clientPhoneNumber)
print("")

#Mapped Services
for item in data['services']:
    service = Service(item['serviceName'],item['serviceAmount'],data['serviceCurrency'],item['servicePrice'],item['serviceDescription'])
    print(service.serviceName)
    print(service.serviceAmount)
    print(service.serviceCurrency)
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

#Mapped Payment
payment = Payment(data['paymentBank'],data['paymentBeneficiary'],data['paymentIBAN'],data['paymentSwift'],data['paymentReference'],data['paymentExchange'],data['paymentIssueDate'],data['paymentDueDate'],data['paymentCurrency'],data['paymentStatus'])

print(payment.paymentBank)
print(payment.paymentBeneficiary)
print(payment.paymentIBAN)
print(payment.paymentSwift)
print(payment.paymentReference)
print(payment.paymentExchange)
print(payment.paymentIssueDate)
print(payment.paymentDueDate)
print(payment.paymentCurrency)
print(payment.paymentStatus)
print("")

#Mapped Calculation
calculation = Calculation(data['calculationSubtotal'],data['calculationTax'],data['calculationTotal'])
    


print(calculation.calculationSubtotal)
print(calculation.calculationTax)
print(calculation.calculationTotal)
print("")
