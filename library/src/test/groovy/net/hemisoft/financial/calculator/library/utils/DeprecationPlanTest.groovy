package net.hemisoft.financial.calculator.library.utils

import static org.junit.Assert.*
import groovy.time.*
import java.time.*

import javax.imageio.ImageIO.ContainsFilter

import org.junit.Test

class DeprecationPlanTest {
	private static final String YEAR = DeprecationPlan.YEAR
	private static final String DECLINING_BALANCE_BEGIN_OF_YEAR = DeprecationPlan.DECLINING_BALANCE_BEGIN_OF_YEAR
	private static final String DEPRECATION = DeprecationPlan.DEPRECATION
	private static final String DECLINING_BALANCE_END_OF_YEAR = DeprecationPlan.DECLINING_BALANCE_END_OF_YEAR
	
	@Test
	public void testLinearDeprecatonWithEvenNumbers() {
		def capital = 100_000, interest = 20;
		def plan 		= DeprecationPlan.generateLinearDeprecationPlanByInterest(capital, interest)
		def deprecation = DeprecationCalculator.calculateLinearDeprecationByInterest(capital, interest)
		
		def expectedSize = 5 + 1
		assert plan.size() == expectedSize
		assertInitalYear(plan, capital)
		assertYears(plan, expectedSize, capital, deprecation)
	}
	
	public void assertInitalYear(plan, capital) {
		def yearToday = LocalDate.now().year
		def planOfMapYear = plan.get(0)
		assert planOfMapYear.YEAR == yearToday - 1
		assert planOfMapYear.DECLINING_BALANCE_BEGIN_OF_YEAR == 0
		assert planOfMapYear.DEPRECATION == 0
		assert planOfMapYear.DECLINING_BALANCE_END_OF_YEAR == capital
	}
	
	public void assertYears(plan, expectedSize, capital, deprecation) {
		def yearToday = LocalDate.now().year
		1.upto(expectedSize - 1, {
			def timeIndex = it - 1
			def mapYear = yearToday + timeIndex
			def planOfMapYear = plan.get(it)
			
			assert planOfMapYear.YEAR == mapYear
			assert planOfMapYear.DECLINING_BALANCE_BEGIN_OF_YEAR == capital - deprecation * timeIndex
			assert planOfMapYear.DEPRECATION == deprecation
			assert planOfMapYear.DECLINING_BALANCE_END_OF_YEAR == capital - deprecation * (timeIndex + 1)
		} )
	}

}
