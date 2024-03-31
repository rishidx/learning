package in.rajarshi.strategypattern.service.impl;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;

import in.rajarshi.strategypattern.config.ConfigReader;
import in.rajarshi.strategypattern.dto.Accounts;
import in.rajarshi.strategypattern.dto.BankUserProfile;
import in.rajarshi.strategypattern.service.IBankService;
import in.rajarshi.strategypattern.service.accounts.AccountServiceContext;
import in.rajarshi.strategypattern.service.accounts.AccountType;
import in.rajarshi.strategypattern.service.accounts.dto.AccountDetails;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class BankService implements IBankService {

	private final AccountServiceContext accountServiceContext;
	private final ConfigReader configReader;

	private static final String PROPERTY_ACCOUNT_TYPE = "account.type";

	@Override
	public BankUserProfile getBankUserProfile(String name, String bankName, String countryCode) {

		log.info("in getBankUserProfile");

		AccountDetails accountDetails = null;

		try {
			accountDetails = accountServiceContext.getAccountDetails(name, bankName, countryCode,
					AccountType.valueOf(configReader.getProperty(bankName, countryCode, PROPERTY_ACCOUNT_TYPE)));
		} catch (IOException e) {
			log.error("Failed : {}", e);
		}

		return mapToBankUserProfile(accountDetails, countryCode);
	}

	BankUserProfile mapToBankUserProfile(AccountDetails accountDetails, String countryCode) {

		Accounts accounts = Accounts.builder().accountType(accountDetails.getAccountType()).totalAmount(accountDetails.getCurrentAmount())
				.build();
		return BankUserProfile.builder().bankLocation(countryCode).name(accountDetails.getName())
				.userAccounts(List.of(accounts)).build();
	}
}
