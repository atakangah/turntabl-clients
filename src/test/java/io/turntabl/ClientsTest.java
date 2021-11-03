package io.turntabl;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ClientsTest {
	CorporateClient corporateClient;
	PrivateClient privateClient;
	ClientRegister clientList;

	@BeforeEach
	void setUp() {
		this.corporateClient = new CorporateClient("Corporate", "123", ServiceLevel.GOLD);
		this.privateClient = new PrivateClient("Private", "123", ServiceLevel.PREMIUM);
		this.clientList = new ClientRegister(List.of(this.corporateClient, this.privateClient));
	}

	@AfterEach
	void tearDown() {
		this.corporateClient = null;
		this.privateClient = null;
		this.clientList = null;
	}

	@Test
	void testInstances() {
		assertTrue(this.corporateClient instanceof Client, "CorporateClient is not a Client");
		assertTrue(this.privateClient instanceof Client, "PrivateClient is not a Client");
	}

	@Test
	void testContactNameIsDifferentFromClientNameForCorporateClient() {
		this.corporateClient.setAccountManager("Donald Trump");
		assertNotEquals("Corporate", this.corporateClient.getContactName(),
				"Corporate contact name is the same as client name");
	}

	@Test
	void testContactNameIsTheSameAsClientNameForPrivateClient() {
		assertEquals("Private", this.privateClient.getContactName(),
				"Private contact name is not the same as client name");
	}

	@Test
	void testClientListContainsClients() {
		assertTrue(this.clientList.getClientList().get(0) instanceof Client,
				"Client list does not contain clients of type Client");
	}
}
