package in.rajarshi.strategypattern.service.accounts;

import java.io.IOException;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import in.rajarshi.strategypattern.service.accounts.dto.AccountDetails;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class AccountServiceContext {

	private final Map<AccountType, IAccountService> accountServiceByType;
	
	public AccountDetails getAccountDetails(String name, String bankName, String countryCode, AccountType accountType) throws IOException {
		IAccountService accountService = accountServiceByType.getOrDefault(accountType, null);
		
		Assert.notNull(accountService, "No implementtion found for configured accountType");
		return accountService.getAccountInfo(name, bankName, countryCode);
	}
}
