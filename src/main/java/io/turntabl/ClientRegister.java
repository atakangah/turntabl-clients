package io.turntabl;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ClientRegister {
	private final List<Client> clientList;

	public ClientRegister(List<Client> clientList) {
		this.clientList = clientList;
	}

	public List<Client> getClientList() {
		return this.clientList;
	}

	public List<String> getGoldClientsContactNames() {
		return this.clientList.stream().filter(aClient -> aClient.getClientServiceLevel() == ServiceLevel.GOLD)
				.map(Client::getContactName).toList();
	}

	public Optional<String> getClientNameById(String clientId) {
		return this.clientList.stream().filter(aClient -> aClient.getClientId().equals(clientId))
				.map(Client::getClientName).findFirst();
	}

	public Map<ServiceLevel, Long> countAllClientsByServiceLevel() {
		return this.clientList.stream().map(Client::getClientServiceLevel)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
	}
	
	public long countClientsOf(ServiceLevel serviceLevel) {
		return this.clientList.stream().filter(aClient -> aClient.getClientServiceLevel() == serviceLevel).count();
	}

}
