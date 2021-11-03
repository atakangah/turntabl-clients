package io.turntabl;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ClientRegisterTests {

	ClientRegister clientRegister;

	@BeforeEach
	void setUp() throws Exception {
		this.clientRegister = new ClientRegister(
				List.of(new CorporateClient("John Doe", "123", ServiceLevel.GOLD, "Michael Scott"),
						new CorporateClient("John Doe", "124", ServiceLevel.PREMIUM, "Akufo Addo"),
						new PrivateClient("John Doe", "125", ServiceLevel.PLATINUM),
						new CorporateClient("James Doe", "126", ServiceLevel.GOLD, "George Bush")));
	}

	@AfterEach
	void tearDown() throws Exception {
		this.clientRegister = null;
	}

	@Test
	void testGoldClientsContactNames() {
		assertEquals("Michael Scott", this.clientRegister.getGoldClientsContactNames().get(0),
				"First gold client is not John Doe");
		assertEquals(2, this.clientRegister.getGoldClientsContactNames().size(), "Gold clients are more than 2");
	}

	@Test
	void testGetClientNameById() {
		assertEquals("James Doe", this.clientRegister.getClientNameById("126").get(),
				"James Doe is not the client with ID 126");
	}

	@Test
	void testCountsAllClientsByServiceLevel() {
		assertEquals(2, this.clientRegister.countAllClientsByServiceLevel().get(ServiceLevel.GOLD),
				"The count of gold clients is not 2");
		assertEquals(3, this.clientRegister.countAllClientsByServiceLevel().size(),
				"The total sets of service level counts is not 3");
	}
}
