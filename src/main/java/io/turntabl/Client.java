package io.turntabl;

public abstract class Client {
    private String clientName;
    private String clientId;
    protected String contactName;
	private ServiceLevel clientServiceLevel;


    public Client(String clientName, String clientId, ServiceLevel clientServiceLevel) {
    	this(clientName, clientId, clientServiceLevel, null);
    }
    
    public Client(String clientName, String clientId, ServiceLevel clientServiceLevel, String contactName) {
        this.clientName = clientName;
        this.clientId = clientId;
        this.clientServiceLevel = clientServiceLevel;
        this.contactName = contactName;
    }
    
    public String getContactName() {
		return contactName;
	}

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public ServiceLevel getClientServiceLevel() {
        return clientServiceLevel;
    }

    public void setClientServiceLevel(ServiceLevel clientServiceLevel) {
        this.clientServiceLevel = clientServiceLevel;
    }
}
