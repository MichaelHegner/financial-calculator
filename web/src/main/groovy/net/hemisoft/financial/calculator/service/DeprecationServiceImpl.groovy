package net.hemisoft.financial.calculator.service;

import net.hemisoft.financial.calculator.repository.DeprecationRepository
import net.hemisoft.financial.calculator.web.Deprecation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate

@Service
public class DeprecationServiceImpl implements DeprecationService {
	@Value('${api.port}') apiPort
	
	final DeprecationRepository repository
	final RestTemplate rest
	
	
	@Autowired
	public DeprecationServiceImpl(DeprecationRepository repository) {
		this.repository = repository
		this.rest = new RestTemplate()
	}

	@Override 
	public def calculatePlan(Deprecation deprecation) {
		def capital = deprecation.capital
		def interest = deprecation.interest
		def url = "http://localhost:$apiPort/deprecation/capital/$capital/interest/$interest"
		rest.getForObject(url, List.class)
	}

	@Override
	public def save(Deprecation d) {
		repository.save(d);
	}

	@Override
	public def findAll() {
		repository.findAll()
	}

	@Override
	public def findOne(id) {
		repository.findOne(id)
	}
}
