package net.hemisoft.financial.calculator.web

import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

import net.hemisoft.financial.calculator.service.DeprecationService

@RestController
@RequestMapping("api")
class DeprecationApi {
	DeprecationService service
	
	DeprecationApi(DeprecationService service) {
		this.service = service;
	}
	
	@RequestMapping("/{id}")
	def deprecationChart(@PathVariable long id) {
		def returnList = []
		Deprecation d = service.findOne(id)

		if(null != d) {
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

	@RequestMapping("/interestToYear/{interest}")
	BigDecimal interestToYear(@PathVariable double interest) {
		service.calculateYear(interest);
	}
	
	@RequestMapping("/yearToInterest/{year}")
	BigDecimal interestToYear(@PathVariable int year) {
		service.calculateInterest(year);
	}
}
