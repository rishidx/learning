package in.rajarshi.strategypattern.integrationtest;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import in.rajarshi.strategypattern.controller.BankController;

@SpringBootTest
class SmokeTest {

	@Autowired
	private BankController bankController;
	
	@Test 
	void contextLoad() {
		assertThat(bankController).isNotNull();
	}
}
