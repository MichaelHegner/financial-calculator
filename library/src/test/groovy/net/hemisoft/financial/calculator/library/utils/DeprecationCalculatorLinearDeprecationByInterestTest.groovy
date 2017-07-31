package net.hemisoft.financial.calculator.library.utils

import static org.assertj.core.api.Assertions.assertThat
import static org.assertj.core.api.Assertions.offset
import static org.junit.Assert.*

import org.assertj.core.api.Assertions
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import org.junit.runners.Parameterized.Parameters

@RunWith(Parameterized.class)
class DeprecationCalculatorLinearDeprecationByInterestTest {
	def capital, interest, expected
	
	
	public DeprecationCalculatorLinearDeprecationByInterestTest(capital, interest, expected) {
		this.capital = capital
		this.interest = interest
		this.expected = expected
	}

	@Parameters static cases() {
		[
			// CAPITAL	INTEREST	EXPECTED
		    [-100d, 	  - 10, 		10d],
		    [-1, 		   -10, 	   0.1d],
		    [0, 		   -10, 	     0d],
		    [1, 		   -10, 	  -0.1d],
		    [100, 		   -10, 	   -10d],
		    [-100, 		    -1, 	   1.0d],
		    [-1, 		    -1, 	  0.01d],
		    [0, 		    -1, 	     0d],
		    [1, 		    -1, 	 -0.01d],
		    [100, 		    -1, 	     -1],
		    [-100, 		     0, 	     0d],
		    [-1, 		     0, 	     0d],
		    [0, 		     0,			 0d],
		    [1, 		     0, 		 0d],
		    [100, 		     0, 		 0d],
		    [-100, 		     1, 	    -1d],
		    [-1, 		     1, 	 -0.01d],
		    [0, 		     1, 	     0d],
		    [1, 		     1, 	  0.01d],
		    [100, 		     1, 	     1d],
		    [-100, 		    10, 	   -10d],
		    [-1, 		    10, 	  -0.1d],
		    [0, 	 	    10, 	     0d],
		    [1, 		    10, 	   0.1d],
		    [100, 		    10, 	    10d],
		]*.toArray()
	}

	
	@Test
	public void testInterestOfAmount() {
		def result = DeprecationCalculator.calculateLinearDeprecationByInterest(capital, interest)
		assertThat(result).isCloseTo(expected, offset(0.001d))
	}

}
