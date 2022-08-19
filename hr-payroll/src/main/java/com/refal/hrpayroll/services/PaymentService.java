package com.refal.hrpayroll.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.refal.hrpayroll.entities.Payment;
import com.refal.hrpayroll.entities.Worker;

@Service
public class PaymentService {
	
	
	@Value("${hr-worker.host}")
	private String hrWorkerHost;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public Payment getPayment(long workerId, Integer days) {
		
		Map<String, String> uriVariables = new HashMap<>();
		
		uriVariables.put("id", ""+workerId);
		
		Worker worker = restTemplate.getForObject(hrWorkerHost + "/workers/{id}", Worker.class, uriVariables);
		
		return new Payment(worker.getName(), worker.getDailyIncome(), days);
		
	}

}
