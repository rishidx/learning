package in.rajarshi.strategypattern.service.accounts;

import java.io.IOException;

import in.rajarshi.strategypattern.service.accounts.dto.AccountDetails;

public interface IAccountService {

	AccountDetails getAccountInfo(String name, String bankName, String countryCode) throws IOException;
	
	AccountType accountType();
}
