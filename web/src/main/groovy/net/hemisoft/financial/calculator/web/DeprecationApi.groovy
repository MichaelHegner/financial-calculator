package net.hemisoft.financial.calculator.web

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

import net.hemisoft.financial.calculator.service.DeprecationService

@RestController
@RequestMapping("api")
class DeprecationApi {
	DeprecationService service
	
	
	@Autowired
	DeprecationApi(DeprecationService service) {
		this.service = service;
	}

	@RequestMapping
	def deprecationChart() {
		def returnList = []
		def deprecationIterator = service.findAll().iterator()

		if(deprecationIterator.hasNext()) {
			Deprecation d = deprecationIterator.next()
			def plan = service.calculatePlan(d)
			
			plan.each{ value ->
				def map = [:]
				map.date = value.YEAR
				map.value = value.DECLINING_BALANCE_END_OF_YEAR
				returnList.add(map)
			}
		}
		returnList
	}
}
