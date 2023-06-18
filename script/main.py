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

template_loader = FileSystemLoader(searchpath="./templates")
env = Environment(loader=template_loader)

with open('../Billings.json','r') as f:
    data = json.load(f)

issuer = Issuer(data['issuerName'],data['issuerCUI'],data['issuerTradeRegisterNumber'],data['issuerEUID'],data['issuerCountry'],data['issuerCity'],data['issuerCounty'],data['issuerStreet'],data['issuerNumber'],data['issuerZipCode'],data['issuerEmail'],data['issuerPhoneNumber'])
client = Client(data['clientName'],data['clientCUI'],data['clientTradeRegisterNumber'],data['clientEUID'],data['clientCountry'],data['clientCity'],data['clientCounty'],data['clientStreet'],data['clientNumber'],data['clientZipCode'],data['clientEmail'],data['clientPhoneNumber'])
discounts = data['discounts']
services = data['services']
taxes = data['taxes']
payment = Payment(data['paymentBank'],data['paymentBeneficiary'],data['paymentIBAN'],data['paymentSwift'],data['paymentReference'],data['paymentExchange'],data['paymentIssueDate'],data['paymentDueDate'],data['paymentCurrency'],data['paymentStatus'])
calculation = Calculation(data['calculationSubtotal'],data['calculationTax'],data['calculationTotal'])
#image_filename = 'templates/logo.jpg'
template = env.get_template('billingfy_invoice.html')
html = template.render(issuer=issuer, client=client, discounts=discounts, services=services, taxes=taxes, payment=payment, calculation=calculation)

output_path = os.path.join(os.path.expanduser("~"), 'Desktop', client.get_clientName()+" "+payment.get_paymentReference()+ ".html" )

#pdf_path = os.path.join(os.path.expanduser("~"), 'Desktop', client.get_clientName()+" "+payment.get_paymentReference()+ ".pdf" )

with open(output_path, 'w') as f:
    f.write(html)


print(f"Invoice generated: {output_path}")



























