package io.turntabl;

public class CorporateClient extends Client {
	public CorporateClient(String clientName, String clientId, ServiceLevel clientServiceLevel) {
        super(clientName, clientId, clientServiceLevel);
    }
    
    public CorporateClient(String clientName, String clientId, ServiceLevel clientServiceLevel, String contactName) {
        super(clientName, clientId, clientServiceLevel, contactName);
    }
    
    public String getAccountManager() {
		return this.contactName;
	}

	public void setAccountManager(String accountManager) {
		this.contactName = accountManager;
	}
}
