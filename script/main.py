import json

with open('../Billings.json','r') as f:
    data = json.load(f)

for item in data['taxes'] :
    print(item['taxName'])
    print(item['taxValue'])

print(data['taxes'])
