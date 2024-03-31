package in.rajarshi.profiles.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@ActiveProfiles({"test"})
@AutoConfigureMockMvc
class ProfilesControllerTest {

	
	@Autowired
	MockMvc mockMvc;
	
	@Test
	void testPrintStatus() throws Exception {
		mockMvc.perform(get("/hello")
			      .contentType(MediaType.APPLICATION_JSON))
			      .andExpect(status().isOk());
//			      .andExpect(content()
//			      .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
//			      .andExpect(jsonPath("$[0].name", is("bob")));
	}

}
