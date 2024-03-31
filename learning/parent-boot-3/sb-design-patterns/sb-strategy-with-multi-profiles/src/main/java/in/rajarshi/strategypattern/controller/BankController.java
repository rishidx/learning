package in.rajarshi.strategypattern.controller;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import in.rajarshi.strategypattern.dto.BankUserProfile;
import in.rajarshi.strategypattern.service.IBankService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
public class BankController {

	private final IBankService bankService;

	@GetMapping("/user/{name}")
	public ResponseEntity<BankUserProfile> accountLookup(@PathVariable("name") String name,
			@RequestHeader(required = true, name = "bank-name") String bankName,
			@RequestHeader(required = true, name = "country-code") String countryCode) {

		log.info("in profile lookup");

		Assert.notNull(name, "No name present in request");

		BankUserProfile bankUserProfile = Optional
				.ofNullable(bankService.getBankUserProfile(name, bankName, countryCode)).orElseThrow();
		log.info("Received employee profile : {}", bankUserProfile);

		return ResponseEntity.ok(bankUserProfile);
	}
}
