package in.rajarshi.strategypattern.service.accounts.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AccountDetails {

	private String name;
	private String accountType;
	private String accountStatus;
	private String currentAmount;
	private String lastTxnDate;
}
