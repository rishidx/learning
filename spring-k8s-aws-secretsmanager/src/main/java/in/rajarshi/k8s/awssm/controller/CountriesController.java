package in.rajarshi.k8s.awssm.controller;

import java.util.List;

import org.apache.commons.collections4.IterableUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import in.rajarshi.k8s.awssm.model.Countries;
import in.rajarshi.k8s.awssm.repository.CountriesRepository;

@RestController
public class CountriesController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CountriesController.class);

	@Autowired
	private CountriesRepository countriesRepository;
	
	@Value("${custom.data.config1}")
	private String config1;
	
	@Value("${custom.data.config2}")
	private String config2;
	
	@GetMapping("/show-all")
	public ResponseEntity<List<Countries>> getAllCountries() {
		
		LOGGER.info("config1: {}", config1);
		LOGGER.info("config2: {}", config2);
		
		return ResponseEntity.ok(IterableUtils.toList(countriesRepository.findAll()));
	}
}
