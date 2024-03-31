package in.rajarshi.profiles.service.impl;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import in.rajarshi.profiles.service.ProfilesService;

@Service
@Profile({"!local & !test"})
public class ServerProfileServiceImpl implements ProfilesService {

	@Override
	public String doPrintAndReturn() {
		System.out.println("Hello from server");
		return "Hello from server";
	}

}
