package net.hemisoft.financial.calculator.library.utils

import static org.junit.Assert.*

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import org.junit.runners.Parameterized.Parameters

@RunWith(Parameterized.class)
class BasicCalculatorCalculateYearToInterestTest {
	def year, expected
	
	public BasicCalculatorCalculateYearToInterestTest(year, expected) {
		this.year = year
		this.expected = expected
	}

	@Parameters static cases() {
		[
		    [-5, 	   -20],
			[-1, 	  -100],
		    [0, 	  null], 
		    [1, 	   100],
		    [5, 		20],
		]*.toArray()
	}

	@Test
	public void testYearToInterest() {
		if(expected == null) {
			try {
				BasicCalculator.calculateYearToInterest(year)
				Assert.fail("IllegalArgumentException expected.")
			} catch(IllegalArgumentException e) {
				assert e != null
			}
		} else {
			assert BasicCalculator.calculateYearToInterest(year) == expected
		}
	}
}
