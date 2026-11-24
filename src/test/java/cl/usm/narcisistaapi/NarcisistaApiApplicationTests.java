package cl.usm.narcisistaapi;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import cl.usm.narcisistaapi.controllers.NarcisistaController;

@SpringBootTest
class NarcisistaApiApplicationTests {

	@Autowired
	private NarcisistaController narcisistaController;

	@Test
	void contextLoads() {
		assertNotNull(narcisistaController);
	}

}
