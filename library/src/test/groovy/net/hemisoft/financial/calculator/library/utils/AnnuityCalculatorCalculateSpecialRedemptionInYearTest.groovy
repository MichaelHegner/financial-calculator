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
class AnnuityCalculatorCalculateSpecialRedemptionInYearTest {
	def capital, specialRedemption, expected
	
	
	public AnnuityCalculatorCalculateSpecialRedemptionInYearTest(capital, specialRedemption, expected) {
		this.capital = capital
		this.specialRedemption = specialRedemption
		this.expected = expected
	}

	@Parameters static cases() {
		[
		    // CAPITAL	SPECIALREDEMPTATION		EXPECTED
		    [-100d, 	  -10d, 				10d],
		    [-1, 		   -10, 			   0.1d],
		    [0, 		   -10, 			     0d],
		    [1, 		   -10, 			  -0.1d],
		    [100, 		   -10, 			   -10d],
		    [-100, 		    -1, 			   1.0d],
		    [-1, 		    -1, 			  0.01d],
		    [0, 		    -1, 			     0d],
		    [1, 		    -1, 			 -0.01d],
		    [100, 		    -1, 			     -1],
		    [-100, 		     0, 			     0d],
		    [-1, 		     0, 			     0d],
		    [0, 		     0, 		      	 0d],
		    [1, 		     0, 			     0d],
		    [100, 		     0, 			     0d],
		    [-100, 		     null, 			     0d],
		    [-1, 		     null, 			     0d],
		    [0, 		     null, 		      	 0d],
		    [1, 		     null, 			     0d],
		    [100, 		     null, 			     0d],
		    [-100, 		     1, 			    -1d],
		    [-1, 		     1, 			 -0.01d],
		    [0, 		     1, 			     0d],
		    [1, 		     1, 			  0.01d],
		    [100, 		     1, 			     1d],
		    [-100, 		    10, 			   -10d],
		    [-1, 		    10, 			  -0.1d],
		    [0, 	 	    10, 			     0d],
		    [1, 		    10, 			   0.1d],
		    [100, 		    10, 			    10d],
		]*.toArray()
	}

	@Test
	public void testInterestToQuote() {
		def interest
		if(null == specialRedemption)
			interest = AnnuityCalculator.calculateSpecialRedemptionOfFirstYear(capital)
		else
			interest = AnnuityCalculator.calculateSpecialRedemptionOfFirstYear(capital, specialRedemption)
			
		assertThat(interest).isCloseTo(expected, offset(0.001d))
	}
}
