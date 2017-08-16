package net.hemisoft.financial.calculator.api

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

import net.hemisoft.financial.calculator.library.utils.DeprecationPlan

@RestController
class DeprecationApi {

	@GetMapping("/deprecation/capital/{capital}/interest/{interest}")
	public def deprecation(@PathVariable double capital, @PathVariable double interest) {
		return DeprecationPlan.generateLinearDeprecationPlanByInterest(120000d, 5d);
	} 
	
}
