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
class AnnuityCalculatorCalculateRedemptionAmountOfFirstYearTest {
	def capital, interest, redemption, expected
	
	
	public AnnuityCalculatorCalculateRedemptionAmountOfFirstYearTest(capital, interest, redemption, expected) {
		this.capital = capital
		this.interest = interest
		this.redemption = redemption;
		this.expected = expected
	}

	@Parameters static cases() {
		[
			/*
			 * INTEREST -10 ...
			 */
			
			// CAPITAL	INTEREST	REDEMPTION		EXPECTED
			[-100d, 	 -10, 		 	0,		         0d],
		    [-1, 		 -10, 		 	0,		         0d],
		    [0, 		 -10, 		 	0,			     0d],
		    [1, 		 -10, 		 	0, 			     0d],
		    [100, 		 -10, 		 	0,		       	 0d],
			
			// CAPITAL	INTEREST	REDEMPTION		EXPECTED
			[-100d, 	 -10, 		 	1,		        -1d],
			[-1, 		 -10, 		 	1,		     -0.01d],
			[0, 		 -10, 		 	1,			     0d],
			[1, 		 -10, 		 	1, 			  0.01d],
			[100, 		 -10, 		 	1,		        1d],

			// CAPITAL	INTEREST	REDEMPTION		EXPECTED
			[-100d, 	 -10, 		 	5,		   		-5d],
			[-1, 		 -10, 		 	5,		    -0.050d],
			[0, 		 -10, 		 	5,		         0d],
			[1, 		 -10, 		 	5, 		     0.050d],
			[100, 		 -10, 		 	5,		         5d],
			
			// Changing time t=-1 with interval=1 will accumulate up for one year
			// CAPITAL	INTEREST	REDEMPTION		EXPECTED
			[-100d, 	 -10, 			-1,		         1d],
			[-1, 		 -10, 			-1,		      0.01d],
			[0, 		 -10, 			-1,			     0d],
			[1, 		 -10, 			-1,			 -0.01d],
			[100, 		 -10, 			-1,		    	-1d],

			// Changing time t=-1 with interval=1 will accumulate up for five year
			// CAPITAL	INTEREST	REDEMPTION		EXPECTED
		    [-100d, 	 -10, 			-5,		  		 5d],
		    [-1, 		 -10, 			-5,		     0.050d],
		    [0, 		 -10, 			-5,			     0d],
		    [1, 		 -10, 			-5,		    -0.049d],
		    [100, 		 -10, 			-5,		   	 	-5d],
			
			/*
			 * ... INTEREST -10
			 */
			
			//
			
			/*
			 * INTEREST -1 ...
			 */
			
			// The capital doesnt change in t=0
			// CAPITAL	INTEREST	REDEMPTION		EXPECTED
			[-100d, 	 -1, 		 0,			      	 0d],
			[-1, 		 -1, 		 0,			         0d],
			[0, 		 -1, 		 0,				     0d],
			[1, 		 -1, 		 0,				     0d],
			[100, 		 -1, 		 0,			         0d],
			
			// CAPITAL	INTEREST	REDEMPTION		EXPECTED
			[-100d, 	 -1, 		 1,			        -1d],
			[-1, 		 -1, 		 1,			     -0.01d],
			[0, 		 -1, 		 1,		   		     0d],
			[1, 		 -1, 		 1,				  0.01d],
			[100, 		 -1, 		 1,			         1d],

			// CAPITAL	INTEREST	REDEMPTION		EXPECTED
			[-100d, 	 -1, 		 5,			        -5d],
			[-1, 		 -1, 		 5,			    -0.050d],
			[0, 		 -1, 		 5, 	  		     0d],
			[1, 		 -1, 		 5,				 0.050d],
			[100, 		 -1, 		 5,			      	 5d],
			
			// CAPITAL	INTEREST	REDEMPTION		EXPECTED
			[-100d, 	 -1, 		-1,	  		  		 1d],
			[-1, 		 -1, 		-1,		    	 0.010d],
			[0, 		 -1, 		-1,  		  	     0d],
			[1, 		 -1, 		-1,			  	-0.010d],
			[100, 		 -1, 		-1,			   		-1d],

			// CAPITAL	INTEREST	REDEMPTION		EXPECTED
			[-100d, 	 -1, 		-5,			  		 5d],
			[-1, 		 -1, 		-5,			     0.050d],
			[0, 		 -1, 		-5,				     0d],
			[1, 		 -1, 		-5,				-0.050d],
			[100, 		 -1, 		-5,			 	  	-5d],
			
			/*
			 * ... INTEREST -1
			 */
			
			//
			
			/*
			 * INTEREST 0 ...
			 */
			
			// The capital doesnt change in t=0
			// CAPITAL	INTEREST	REDEMPTION		EXPECTED
			[-100d, 	 0, 		 0,			      	 0d],
			[-1, 		 0, 		 0,			         0d],
			[0, 		 0, 		 0,				     0d],
			[1, 		 0, 		 0,				     0d],
			[100, 		 0, 		 0,			       	 0d],
			
			// CAPITAL	INTEREST	REDEMPTION		EXPECTED
			[-100d, 	 0, 		 1,			      	-1d],
			[-1, 		 0, 		 1,			     -0.01d],
			[0, 		 0, 		 1,				     0d],
			[1, 		 0, 		 1,				  0.01d],
			[100, 		 0, 		 1,			      	 1d],

			// CAPITAL	INTEREST	REDEMPTION		EXPECTED
			[-100d, 	 0, 		 5,			        -5d],
			[-1, 		 0, 		 5,			     -0.05d],
			[0, 		 0, 		 5,				     0d],
			[1, 		 0, 		 5,				  0.05d],
			[100, 		 0, 		 5,			       	 5d],
			
			// CAPITAL	INTEREST	REDEMPTION		EXPECTED
			[-100d, 	 0, 		-1,			      	 1d],
			[-1, 		 0, 		-1,			      0.01d],
			[0, 		 0, 		-1,		 		     0d],
			[1, 		 0, 		-1,				 -0.01d],
			[100, 		 0, 		-1,			     	-1d],

			// CAPITAL	INTEREST	REDEMPTION		EXPECTED
			[-100d, 	 0, 		-5,			      	 5d],
			[-1, 		 0, 		-5,			      0.05d],
			[0, 		 0, 		-5,		   		     0d],
			[1, 		 0, 		-5,				 -0.05d],
			[100, 		 0, 		-5,			      	-5d],
			
			/*
			 * ... INTEREST 0
			 */

			//
			
			/*
			 * INTEREST 1 ...
			 */
			
			// CAPITAL	INTEREST	REDEMPTION		EXPECTED
			[-100d, 	 1, 		 0,			      	 0d],
			[-1, 		 1, 		 0, 		      	 0d],
			[0, 		 1, 		 0,		  		  	 0d],
			[1, 		 1, 		 0,				     0d],
			[100, 		 1, 		 0,	 		         0d],
			
			// CAPITAL	INTEREST	REDEMPTION		EXPECTED
			[-100d, 	 1, 		 1,			      	-1d],
			[-1, 		 1, 		 1,			     -0.01d],
			[0, 		 1, 		 1,				     0d],
			[1, 		 1, 		 1,				  0.01d],
			[100, 		 1, 		 1,	    		  	 1d],

			// CAPITAL	INTEREST	REDEMPTION		EXPECTED
			[-100d, 	 1, 		 5,			     	-5d],
			[-1, 		 1, 		 5,			     -0.05d],
			[0, 		 1, 		 5,			         0d],
			[1, 		 1, 		 5,			      0.05d],
			[100, 		 1, 		 5,			      	 5d],
			
			// CAPITAL	INTEREST	REDEMPTION		EXPECTED
			[-100d, 	 1, 		-1,			     	 1d],
			[-1, 		 1, 		-1, 		      0.01d],
			[0, 		 1, 		-1,				     0d],
			[1, 		 1, 		-1,				 -0.01d],
			[100, 		 1, 		-1,			     	-1d],

			// CAPITAL	INTEREST	REDEMPTION		EXPECTED
			[-100d, 	 1, 		-5,			     	 5d],
			[-1, 		 1, 		-5, 		      0.05d],
			[0, 		 1, 		-5,   			     0d],
			[1, 		 1, 		-5, 			 -0.05d],
			[100, 		 1, 		-5,			      	-5d],
			
			/*
			 * ... INTEREST 1
			 */
			
			//
			
			/*
			 * INTEREST 10 ...
			 */
			
			// CAPITAL	INTEREST	REDEMPTION		EXPECTED
			[-100d, 	 10, 		 0,			      	 0d],
			[-1, 		 10, 		 0,			         0d],
			[0, 		 10, 		 0, 	  		     0d],
			[1, 		 10, 		 0,				     0d],
			[100, 		 10, 		 0,			       	 0d],
			
			// CAPITAL	INTEREST	REDEMPTION		EXPECTED
			[-100d, 	 10, 		 1,			      	-1d],
			[-1, 		 10, 		 1,			     -0.01d],
			[0, 		 10, 		 1,		   		     0d],
			[1, 		 10, 		 1,				  0.01d],
			[100, 		 10, 		 1,			       	 1d],

			// CAPITAL	INTEREST	REDEMPTION		EXPECTED
			[-100d, 	 10, 		 5,			   		-5d],
			[-1, 		 10, 		 5,			     -0.05d],
			[0, 		 10, 		 5,		   		     0d],
			[1, 		 10, 		 5,				  0.05d],
			[100, 		 10, 		 5,			     	 5d],
			
			// CAPITAL	INTEREST	REDEMPTION		EXPECTED
			[-100d, 	 10, 		-1,			    	 1d],
			[-1, 		 10, 		-1,			      0.01d],
			[0, 		 10, 		-1, 	  		     0d],
			[1, 		 10, 		-1,				 -0.01d],
			[100, 		 10, 		-1,			     	-1d],

			// CAPITAL	INTEREST	REDEMPTION		EXPECTED
			[-100d, 	 10, 		-5,			    	 5d],
			[-1, 		 10, 		-5,			      0.05d],
			[0, 		 10, 		-5,		   		     0d],
			[1, 		 10, 		-5,				 -0.05d],
			[100, 		 10, 		-5,			      	-5d],
			
			/*
			 * ... INTEREST 10
			 */

		]*.toArray()
	}

	
	@Test
	public void testAccumulationFactorByYearsAndInterest() {
		def result = AnnuityCalculator.calculateRedemptionAmountOfFirstYear(capital, interest, redemption)
		assertThat(result).isCloseTo(expected, offset(0.001d))
	}

}
