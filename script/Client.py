
class Client:
    def __init__(self, clientName, clientCUI, clientTradeRegisterNumber, clientEUID, clientCountry, clientCity, clientCounty, clientStreet, clientNumber, clientZipcode, clientEmail, clientPhoneNumber):
        self.clientName = clientName
        self.clientCUI = clientCUI
        self.clientTradeRegisterNumber = clientTradeRegisterNumber
        self.clientEUID = clientEUID
        self.clientCountry = clientCountry
        self.clientCity = clientCity
        self.clientCounty = clientCounty
        self.clientStreet = clientStreet
        self.clientNumber = clientNumber
        self.clientZipcode = clientZipcode
        self.clientEmail = clientEmail
        self.clientPhoneNumber = clientPhoneNumber
        
    def get_clientName(self):
        return self.clientName
    
    def get_clientCUI(self):
        return self.clientCUI
        
    def get_clientTradeRegisterNumber(self):
        return self.clientTradeRegisterNumber
        
    def get_clientEUID(self):
        return self.clientEUID
        
    def get_clientCountry(self):
        return self.clientCountry
        
    def get_clientCity(self):
        return self.clientCity
        
    def get_clientCounty(self):
        return self.clientCounty
        
    def get_clientStreet(self):
        return self.clientStreet
    
    def get_clientNumber(self):
        return self.clientNumber
        
    def get_clientZipcode(self):
        return self.clientZipcode
        
    def get_clientEmail(self):
        return self.clientEmail
        
    def get_clientPhoneNumber(self):
        return self.clientPhoneNumber
