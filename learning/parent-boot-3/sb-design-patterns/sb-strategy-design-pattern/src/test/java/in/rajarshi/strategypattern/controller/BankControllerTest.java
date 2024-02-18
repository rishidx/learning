package in.rajarshi.strategypattern.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import in.rajarshi.strategypattern.service.IBankService;

@SpringBootTest
@AutoConfigureMockMvc
class BankControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private IBankService bankService;
	
	@Test
	void test() {
		fail("Not yet implemented");
	}

}
