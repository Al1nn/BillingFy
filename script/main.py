import json
import os
from Calculation import Calculation
from Discount import Discount
from Service import Service
from Tax import Tax
from Issuer import Issuer
from Client import Client
from Payment import Payment
from jinja2 import Environment, FileSystemLoader

with open('../Billings.json','r') as f:
    data = json.load(f)
    
template_dir = os.path.join(os.path.dirname(__file__), 'templates')
file_loader = FileSystemLoader(template_dir)
env = Environment(loader=file_loader)


#Mapped Issuer
issuer = Issuer(data['issuerName'],data['issuerCUI'],data['issuerTradeRegisterNumber'],data['issuerEUID'],data['issuerCountry'],data['issuerCity'],data['issuerCounty'],data['issuerStreet'],data['issuerNumber'],data['issuerZipCode'],data['issuerEmail'],data['issuerPhoneNumber'])

subdirectory = 'templates'
image_filename = 'logo.jpg'
cwd = os.getcwd()
image_path = os.path.join(cwd,subdirectory,image_filename)

print(image_path)




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
services = data['services']
#Mapped Services

for item in services:
    service = Service(item['serviceName'], item['serviceAmount'], data['serviceCurrency'], item['servicePrice'], item['serviceDescription'])
    print(service.serviceName)
    print(service.serviceAmount)
    print(service.serviceCurrency)
    print(service.servicePrice)
    print(service.serviceDescription)
print("")
    
#Mapped Discounts
discounts = data['discounts']
for item in discounts:
    discount = Discount(item['discountName'],item['discountPercentage'])
    print(discount.discountName)
    print(discount.discountPercentage)
print("")
    
#Mapped Taxes
taxes = data['taxes']
for item in taxes:
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


template_vars = {
    'issuer' : issuer ,
    'image_path' : image_path ,
    'client' : client,
    'payment' : payment,
    'calculation' : calculation,
    'services' : services,
    'taxes' : taxes,
    'discounts' : discounts
}

template = env.get_template('billingfy_invoice.html')
output = template.render(template_vars)

desktop_path = os.path.join(os.path.expanduser("~"), "Desktop")
file_path = os.path.join(desktop_path, 'generated_invoice.html')

with open(file_path,'w') as f:
    f.write(output)



