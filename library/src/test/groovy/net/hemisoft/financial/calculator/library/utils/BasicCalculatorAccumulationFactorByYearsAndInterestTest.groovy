package net.hemisoft.financial.calculator.library.utils

import static org.junit.Assert.*

import org.assertj.core.api.Assertions
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import org.junit.runners.Parameterized.Parameters

@RunWith(Parameterized.class)
class BasicCalculatorAccumulationFactorByYearsAndInterestTest {
	int years
	double interest
	double expected
	
	
	public BasicCalculatorAccumulationFactorByYearsAndInterestTest(int years, double interest, double expected) {
		this.years = years
		this.interest = interest
		this.expected = expected
	}

	@Parameters static cases() {
		[
			// YEAR		INTEREST	EXPECTED
		    [-100, 		 -10, 		37648.619d],
		    [-1, 		 -10, 		    1.111d],
		    [0, 		 -10, 		    1.000d],
		    [1, 		 -10, 		    0.900d],
		    [100, 		 -10, 		    0.000d],
		    [-100, 		  -1, 		    2.731d],
		    [-1, 		  -1, 		    1.010d],
		    [0, 		  -1, 		    1.000d],
		    [1, 		  -1, 		    0.990d],
		    [100, 		  -1, 		    0.366d],
		    [-100, 		   0, 		    1.000d],
		    [-1, 		   0, 		    1.000d],
		    [0, 		   0, 		    1.000d],
		    [1, 		   0, 		    1.000d],
		    [100, 		   0, 		    1.000d],
		    [-100, 		   1, 		    0.369d],
		    [-1, 		   1, 		    0.990d],
		    [0, 		   1, 		    1.000d],
		    [1, 		   1, 		    1.010d],
		    [100, 		   1, 		    2.704d],
		    [-100, 		  10, 		    0.000d],
		    [-1, 		  10, 		    0.909d],
		    [0, 		  10, 		    1.000d],
		    [1, 		  10, 		    1.100d],
		    [100, 		  10, 		13780.612d],
		]*.toArray()
	}

	
	@Test
	public void testAccumulationFactorByYearsAndInterest() {
		double result = BasicCalculator.accumulationFactorByYearsAndInterest(years, interest)
		Assertions.assertThat(result).isCloseTo(expected, Assertions.offset(0.001d))
	}

}
