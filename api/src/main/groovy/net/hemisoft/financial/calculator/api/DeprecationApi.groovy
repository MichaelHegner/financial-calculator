package net.hemisoft.financial.calculator.api

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

import net.hemisoft.financial.calculator.library.utils.DeprecationPlan

@RestController
class DeprecationApi {

	@GetMapping("/deprecation")
	public def deprecation(@RequestParam double capital, @RequestParam double interest) {
		return DeprecationPlan.generateLinearDeprecationPlanByInterest(120000d, 5d);
	} 
	
}
