package net.hemisoft.financial.calculator.service;

import net.hemisoft.financial.calculator.web.Deprecation
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate

@Service
public class DeprecationServiceImpl implements DeprecationService {
	@Value('${api.port}') apiPort
	
	def rest = new RestTemplate()

	@Override 
	public def calculatePlan(Deprecation deprecation) {
		def capital = deprecation.capital
		def interest = deprecation.interest
		def url = "http://localhost:$apiPort/deprecation/capital/$capital/interest/$interest"
		rest.getForObject(url, List.class)
	}
	
}
