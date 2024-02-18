package in.rajarshi.strategypattern.integrationtest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import in.rajarshi.strategypattern.dto.Accounts;
import in.rajarshi.strategypattern.dto.BankUserProfile;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class HttpRequestTest {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@ParameterizedTest
	@MethodSource("provideHeaderValues")
	@DisplayName("accountLookup should return user details for valid request and headers")
	void testAccountLookupShouldReturnUserDetails(String name, String bankName, String country, BankUserProfile expectedResult) {

		HttpHeaders headers = new HttpHeaders();
		headers.set("bank-name", bankName);
		headers.set("country-code", country);
		
		String url = "http://localhost:" + port + "/user/" + name;

		HttpEntity<Void> requestEntity = new HttpEntity<Void>(headers);
		ResponseEntity<BankUserProfile> actualResult = this.restTemplate.exchange(url, HttpMethod.GET, requestEntity, BankUserProfile.class);
		
		assertFalse(actualResult.getStatusCode().is5xxServerError());
		assertTrue(actualResult.getStatusCode().is2xxSuccessful());
		assertNotNull(actualResult.getBody());
		
		BankUserProfile result = actualResult.getBody();
		assertThat(result).usingRecursiveComparison().isEqualTo(expectedResult);
	}

	private static Stream<Arguments> provideHeaderValues() {

		BankUserProfile expectedProfile1 = BankUserProfile.builder().bankLocation("IND").name("RAJARSHI")
				.userAccounts(List.of(Accounts.builder().accountType("DEMAT").totalAmount("INR 3100").build())).build();

		BankUserProfile expectedProfile2 = BankUserProfile.builder().bankLocation("USA").name("RAJARSHI")
				.userAccounts(List.of(Accounts.builder().accountType("SAVINGS").totalAmount("INR 2000").build()))
				.build();

		BankUserProfile expectedProfile3 = BankUserProfile.builder().bankLocation("ENG").name("RISHI")
				.userAccounts(List.of(Accounts.builder().accountType("DEMAT").totalAmount("INR 1400").build())).build();

		return Stream.of(Arguments.of("RAJARSHI", "SBI", "IND", expectedProfile1),
				Arguments.of("RAJARSHI", "SBI", "USA", expectedProfile2),
				Arguments.of("RISHI", "BOE", "ENG", expectedProfile3));
	}

}
