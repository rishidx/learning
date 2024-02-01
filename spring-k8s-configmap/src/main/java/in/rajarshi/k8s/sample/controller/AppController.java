package in.rajarshi.k8s.sample.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import in.rajarshi.k8s.sample.config.AppConfig;
import in.rajarshi.k8s.sample.config.SampleConfig;

@RestController
public class AppController {

	@Autowired
	private SampleConfig sampleConfig;
	
	@Autowired
	private AppConfig appConfig;
	
	@GetMapping("/api/config/all")
	public ResponseEntity<Map<String, String>> getConfigValues() {
		
		Map<String, String> configs = new HashMap<>();
		configs.put("message", sampleConfig.getMessage());
		configs.put("data1", appConfig.getData1());
		configs.put("data2", appConfig.getData2());
		
		return ResponseEntity.ok(configs);
		
	}
}
