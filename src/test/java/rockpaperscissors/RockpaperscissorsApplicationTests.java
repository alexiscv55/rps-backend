package rockpaperscissors;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import rockpaperscissors.ws.RockPaperScissorsApi;

@SpringBootTest
class RockpaperscissorsApplicationTests {

	@Autowired
	private RockPaperScissorsApi rockPaperScissorsApi;

	@Test
	void contextLoads() {
		assertNotNull(rockPaperScissorsApi);
	}

}
