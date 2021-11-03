package io.turntabl;

public class PrivateClient extends Client {

	public PrivateClient(String clientName, String clientId, ServiceLevel clientServiceLevel) {
		super(clientName, clientId, clientServiceLevel, clientName);
	}
}
