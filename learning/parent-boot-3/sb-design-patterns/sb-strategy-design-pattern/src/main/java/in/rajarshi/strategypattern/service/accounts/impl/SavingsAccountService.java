package in.rajarshi.strategypattern.service.accounts.impl;

import java.io.IOException;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import in.rajarshi.strategypattern.service.accounts.AccountType;
import in.rajarshi.strategypattern.service.accounts.IAccountService;
import in.rajarshi.strategypattern.service.accounts.dto.AccountDetails;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Component
public class SavingsAccountService implements IAccountService {
	
	private final ObjectMapper mapper;

	@Override
	public AccountDetails getAccountInfo(String name, String bankName, String countryCode) throws IOException {
		log.info("In Savings accounts");

		AccountDetails accountDetails = null;

		Resource resource = new ClassPathResource("data/all-account-details.json");
		JsonNode root = mapper.readTree(resource.getFile());

		JsonNode userDetails = root.findValue(bankName).findValue(countryCode);
		for (JsonNode node : userDetails) {
			if (name.equalsIgnoreCase(node.at("/name").asText())
					&& "SAVINGS".equalsIgnoreCase(node.at("/accountType").asText())) {
				log.info("savings node: {}", node);
				accountDetails = mapper.treeToValue(node, AccountDetails.class);
			}
		}

		return accountDetails;
	}

	@Override
	public AccountType accountType() {
		return AccountType.SAVINGS;
	}

}
