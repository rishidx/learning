package in.rajarshi.strategypattern.config;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import in.rajarshi.strategypattern.service.accounts.AccountType;
import in.rajarshi.strategypattern.service.accounts.IAccountService;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class AccountsServiceStrategyConfig {

	private final List<IAccountService> accountServices;

	@Bean
	Map<AccountType, IAccountService> accountServiceByType() {
		Map<AccountType, IAccountService> accountServiceByType = new EnumMap<AccountType, IAccountService>(
				AccountType.class);

		accountServices
				.forEach(accountService -> accountServiceByType.put(accountService.accountType(), accountService));
		return accountServiceByType;
	}
}
