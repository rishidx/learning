package in.rajarshi.strategypattern.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BankUserProfile {

	private String name;
	private String bankLocation;
	private List<Accounts> userAccounts;
}
