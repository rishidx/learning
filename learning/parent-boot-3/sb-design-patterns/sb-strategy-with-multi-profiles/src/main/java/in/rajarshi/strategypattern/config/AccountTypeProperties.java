package in.rajarshi.strategypattern.config;

import java.util.Map;

import lombok.Data;

@Data
public class AccountTypeProperties {

	Map<String, Map<String, String>> countryWiseProperties; 
}
