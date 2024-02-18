package in.rajarshi.strategypattern.config;

import java.util.Optional;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class ConfigReader {

	private final Environment environment;

	public String getProperty(String bankName, String country, String propertyName) {
		return Optional.ofNullable(environment.getProperty(String.format("%s.%s.%s", bankName, country, propertyName)))
				.orElseThrow();
	}
}
