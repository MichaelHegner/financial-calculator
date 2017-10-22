package net.hemisoft.financial.calculator.api

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

import net.hemisoft.financial.calculator.library.utils.BasicCalculator

@RestController
class BasicApi {
	
	@GetMapping("/basic/interest2year/{interest}")
	public def interest2year(@PathVariable double interest) {
		BasicCalculator.calculateInverse(interest)
	}
	
	@GetMapping("/basic/year2interest/{year}")
	public def year2interest(@PathVariable int year) {
		BasicCalculator.calculateYearToInterest(year)
	}
}
