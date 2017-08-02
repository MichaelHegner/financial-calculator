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
		def yearToday = LocalDate.now().year
		def capital = 100_000, interest = 20;
		def plan = DeprecationPlan.generateLinearDeprecationPlanByInterest(capital, interest)
		
		def expectedSize = 5
		def deprecation = DeprecationCalculator.calculateLinearDeprecationByInterest(capital, interest)
		assert plan.size() == expectedSize
		0.upto(expectedSize - 1, { 
			def mapYear = yearToday + it
			def planOfMapYear = plan.get(it)
			
			assert planOfMapYear.YEAR == mapYear
			assert planOfMapYear.DECLINING_BALANCE_BEGIN_OF_YEAR == capital - deprecation * it 
			assert planOfMapYear.DEPRECATION == deprecation
			assert planOfMapYear.DECLINING_BALANCE_END_OF_YEAR == capital - deprecation * (it + 1)
		} )
		
	}

}
