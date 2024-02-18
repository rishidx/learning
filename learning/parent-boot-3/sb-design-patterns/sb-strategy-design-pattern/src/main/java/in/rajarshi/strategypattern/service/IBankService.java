package in.rajarshi.strategypattern.service;

import in.rajarshi.strategypattern.dto.BankUserProfile;

public interface IBankService {

	BankUserProfile getBankUserProfile(String name, String bankName, String countryCode);

}
