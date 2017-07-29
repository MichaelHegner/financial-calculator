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
class AnnuityCalculatorCalculateAnnuityInYearTest {
	def capital, interest, redemption, expected
	
	
	public AnnuityCalculatorCalculateAnnuityInYearTest(capital, interest, redemption, expected) {
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
			[-100d, 	 -10, 		 	0,		        10d],
		    [-1, 		 -10, 		 	0,		       0.1d],
		    [0, 		 -10, 		 	0,			     0d],
		    [1, 		 -10, 		 	0, 			  -0.1d],
		    [100, 		 -10, 		 	0,		       -10d],
			
			// CAPITAL	INTEREST	REDEMPTION		EXPECTED
			[-100d, 	 -10, 		 	1,		         9d],
			[-1, 		 -10, 		 	1,		      0.09d],
			[0, 		 -10, 		 	1,			     0d],
			[1, 		 -10, 		 	1, 			 -0.09d],
			[100, 		 -10, 		 	1,		        -9d],

			// CAPITAL	INTEREST	REDEMPTION		EXPECTED
			[-100d, 	 -10, 		 	5,		   		 5d],
			[-1, 		 -10, 		 	5,		     0.050d],
			[0, 		 -10, 		 	5,		         0d],
			[1, 		 -10, 		 	5, 		    -0.050d],
			[100, 		 -10, 		 	5,		        -5d],
			
			// Changing time t=-1 with interval=1 will accumulate up for one year
			// CAPITAL	INTEREST	REDEMPTION		EXPECTED
			[-100d, 	 -10, 			-1,		        11d],
			[-1, 		 -10, 			-1,		      0.11d],
			[0, 		 -10, 			-1,			     0d],
			[1, 		 -10, 			-1,			 -0.11d],
			[100, 		 -10, 			-1,		   	   -11d],

			// Changing time t=-1 with interval=1 will accumulate up for five year
			// CAPITAL	INTEREST	REDEMPTION		EXPECTED
		    [-100d, 	 -10, 			-5,		  		15d],
		    [-1, 		 -10, 			-5,		     0.150d],
		    [0, 		 -10, 			-5,			     0d],
		    [1, 		 -10, 			-5,		    -0.150d],
		    [100, 		 -10, 			-5,		   	   -15d],
			
			/*
			 * ... INTEREST -10
			 */
			
			//
			
			/*
			 * INTEREST -1 ...
			 */
			
			// The capital doesnt change in t=0
			// CAPITAL	INTEREST	REDEMPTION		EXPECTED
			[-100d, 	 -1, 		 0,			      	 1d],
			[-1, 		 -1, 		 0,			      0.01d],
			[0, 		 -1, 		 0,				     0d],
			[1, 		 -1, 		 0,				 -0.01d],
			[100, 		 -1, 		 0,			        -1d],
			
			// CAPITAL	INTEREST	REDEMPTION		EXPECTED
			[-100d, 	 -1, 		 1,			         0d],
			[-1, 		 -1, 		 1,			     	 0d],
			[0, 		 -1, 		 1,		   		     0d],
			[1, 		 -1, 		 1,				  	 0d],
			[100, 		 -1, 		 1,			         0d],

			// CAPITAL	INTEREST	REDEMPTION		EXPECTED
			[-100d, 	 -1, 		 5,			        -4d],
			[-1, 		 -1, 		 5,			    -0.040d],
			[0, 		 -1, 		 5, 	  		     0d],
			[1, 		 -1, 		 5,				 0.040d],
			[100, 		 -1, 		 5,			      	 4d],
			
			// CAPITAL	INTEREST	REDEMPTION		EXPECTED
			[-100d, 	 -1, 		-1,	  		  		 2d],
			[-1, 		 -1, 		-1,		    	 0.020d],
			[0, 		 -1, 		-1,  		  	     0d],
			[1, 		 -1, 		-1,			  	-0.020d],
			[100, 		 -1, 		-1,			   		-2d],

			// CAPITAL	INTEREST	REDEMPTION		EXPECTED
			[-100d, 	 -1, 		-5,			  		 6d],
			[-1, 		 -1, 		-5,			     0.060d],
			[0, 		 -1, 		-5,				     0d],
			[1, 		 -1, 		-5,				-0.060d],
			[100, 		 -1, 		-5,			 	  	-6d],
			
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
			[-100d, 	 1, 		 0,			      	-1d],
			[-1, 		 1, 		 0, 		     -0.01d],
			[0, 		 1, 		 0,		  		  	 0d],
			[1, 		 1, 		 0,				  0.01d],
			[100, 		 1, 		 0,	 		         1d],
			
			// CAPITAL	INTEREST	REDEMPTION		EXPECTED
			[-100d, 	 1, 		 1,			      	-2d],
			[-1, 		 1, 		 1,			     -0.02d],
			[0, 		 1, 		 1,				     0d],
			[1, 		 1, 		 1,				  0.02d],
			[100, 		 1, 		 1,	    		  	 2d],

			// CAPITAL	INTEREST	REDEMPTION		EXPECTED
			[-100d, 	 1, 		 5,			     	-6d],
			[-1, 		 1, 		 5,			     -0.06d],
			[0, 		 1, 		 5,			         0d],
			[1, 		 1, 		 5,			      0.06d],
			[100, 		 1, 		 5,			      	 6d],
			
			// CAPITAL	INTEREST	REDEMPTION		EXPECTED
			[-100d, 	 1, 		-1,			     	 0d],
			[-1, 		 1, 		-1, 		         0d],
			[0, 		 1, 		-1,				     0d],
			[1, 		 1, 		-1,				     0d],
			[100, 		 1, 		-1,			     	 0d],

			// CAPITAL	INTEREST	REDEMPTION		EXPECTED
			[-100d, 	 1, 		-5,			     	 4d],
			[-1, 		 1, 		-5, 		      0.04d],
			[0, 		 1, 		-5,   			     0d],
			[1, 		 1, 		-5, 			 -0.04d],
			[100, 		 1, 		-5,			      	-4d],
			
			/*
			 * ... INTEREST 1
			 */
			
			//
			
			/*
			 * INTEREST 10 ...
			 */
			
			// CAPITAL	INTEREST	REDEMPTION		EXPECTED
			[-100d, 	 10, 		 0,			       -10d],
			[-1, 		 10, 		 0,			       -0.1d],
			[0, 		 10, 		 0, 	  		     0d],
			[1, 		 10, 		 0,				   0.1d],
			[100, 		 10, 		 0,			       	10d],
			
			// CAPITAL	INTEREST	REDEMPTION		EXPECTED
			[-100d, 	 10, 		 1,			       -11d],
			[-1, 		 10, 		 1,			     -0.11d],
			[0, 		 10, 		 1,		   		     0d],
			[1, 		 10, 		 1,				  0.11d],
			[100, 		 10, 		 1,			       	11d],

			// CAPITAL	INTEREST	REDEMPTION		EXPECTED
			[-100d, 	 10, 		 5,			   	   -15d],
			[-1, 		 10, 		 5,			     -0.15d],
			[0, 		 10, 		 5,		   		     0d],
			[1, 		 10, 		 5,				  0.15d],
			[100, 		 10, 		 5,			     	15d],
			
			// CAPITAL	INTEREST	REDEMPTION		EXPECTED
			[-100d, 	 10, 		-1,			    	-9d],
			[-1, 		 10, 		-1,			     -0.09d],
			[0, 		 10, 		-1, 	  		     0d],
			[1, 		 10, 		-1,				  0.09d],
			[100, 		 10, 		-1,			     	 9d],

			// CAPITAL	INTEREST	REDEMPTION		EXPECTED
			[-100d, 	 10, 		-5,			    	-5d],
			[-1, 		 10, 		-5,			     -0.05d],
			[0, 		 10, 		-5,		   		     0d],
			[1, 		 10, 		-5,				  0.05d],
			[100, 		 10, 		-5,			      	 5d],
			
			/*
			 * ... INTEREST 10
			 */

		]*.toArray()
	}

	
	@Test
	public void testAccumulationFactorByYearsAndInterest() {
		assertThat(AnnuityCalculator.calculateAnnuityInYear(capital, interest, redemption)).isCloseTo(expected, offset(0.001d))
	}

}
