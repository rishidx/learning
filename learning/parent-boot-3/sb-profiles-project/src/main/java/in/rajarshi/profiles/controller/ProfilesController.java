package in.rajarshi.profiles.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import in.rajarshi.profiles.service.ProfilesService;

@RestController
public class ProfilesController {

	@Autowired
	private ProfilesService profilesService;
	
	@GetMapping("/hello")
	public String printStatus() {
		return profilesService.doPrintAndReturn();
	}
}
