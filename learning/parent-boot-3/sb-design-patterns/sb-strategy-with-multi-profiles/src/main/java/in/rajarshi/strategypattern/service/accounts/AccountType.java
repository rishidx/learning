package in.rajarshi.strategypattern.service.accounts;

public enum AccountType {

	SAVINGS("SAVINGS"),
	DEMAT("DEMAT"),
	CURRENT("CURRENT");
	
	public final String label;
	
	private AccountType(String label) {
		this.label = label;
	}
}
