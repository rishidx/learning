package in.rajarshi.strategypattern.config;

import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@ConfigurationPropertiesBinding
public class CustomCountryWiseAccountConverter implements Converter<String, AccountTypeProperties> {

	@Override
	public AccountTypeProperties convert(String source) {
		
		System.out.println(source);
		
		
		return null;
	}

	
}
