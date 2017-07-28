package net.hemisoft.financial.calculator.library.utils

import static org.junit.Assert.*

import org.assertj.core.api.Assertions
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import org.junit.runners.Parameterized.Parameters

@RunWith(Parameterized.class)
class BasicCalculatorInterestOfAmountWithIntervalGoodCaseTest {
	double capital
	double interest
	int time
	int interval
	double expected
	
	
	public BasicCalculatorInterestOfAmountWithIntervalGoodCaseTest(double capital, double interest, int time, int interval, double expected) {
		this.capital = capital
		this.interest = interest
		this.time = time;
		this.interval = interval
		this.expected = expected
	}

	@Parameters static cases() {
		[
			/*
			 * INTEREST -10 ...
			 */
			
			// The capital doesnt change in t=0
			// CAPITAL	INTEREST	TIME	INTERVAL		EXPECTED
			[-100d, 	 -10, 		 0,			1,		      -100d],
		    [-1, 		 -10, 		 0,			1,		        -1d],
		    [0, 		 -10, 		 0,			1,   		     0d],
		    [1, 		 -10, 		 0,   		1,			     1d],
		    [100, 		 -10, 		 0,			1,		       100d],
			
			// Changing the inverval with t=0 doesnt change the result
			// CAPITAL	INTEREST	TIME	INTERVAL		EXPECTED
			[-100d, 	 -10, 		 0,			2,		      -100d],
			[-1, 		 -10, 		 0,			2,		        -1d],
			[0, 		 -10, 		 0,			2,   		     0d],
			[1, 		 -10, 		 0,   		2,			     1d],
			[100, 		 -10, 		 0,			2,		       100d],
			
			// Changing time t=1 with interval=1 will accumulate down for one year
			// CAPITAL	INTEREST	TIME	INTERVAL		EXPECTED
			[-100d, 	 -10, 		 1,			1,		       -90d],
			[-1, 		 -10, 		 1,			1,		      -0.9d],
			[0, 		 -10, 		 1,			1,   		     0d],
			[1, 		 -10, 		 1,   		1,			   0.9d],
			[100, 		 -10, 		 1,			1,		        90d],

			// Changing time t=5 with interval=1 will accumulate down for five years
			// CAPITAL	INTEREST	TIME	INTERVAL		EXPECTED
			[-100d, 	 -10, 		 5,			1,		   -59.049d],
			[-1, 		 -10, 		 5,			1,		    -0.590d],
			[0, 		 -10, 		 5,			1,   	         0d],
			[1, 		 -10, 		 5,   		1,		     0.590d],
			[100, 		 -10, 		 5,			1,		    59.049d],
			
			// Changing time t=-1 with interval=1 will accumulate up for one year
			// CAPITAL	INTEREST	TIME	INTERVAL		EXPECTED
			[-100d, 	 -10, 		-1,			1,		  -111.111d],
			[-1, 		 -10, 		-1,			1,		    -1.111d],
			[0, 		 -10, 		-1,			1,   		     0d],
			[1, 		 -10, 		-1,   		1,			 1.111d],
			[100, 		 -10, 		-1,			1,		   111.111d],

			// Changing time t=-1 with interval=1 will accumulate up for five year
			// CAPITAL	INTEREST	TIME	INTERVAL		EXPECTED
		    [-100d, 	 -10, 		-5,			1,		  -169.350d],
		    [-1, 		 -10, 		-5,			1,		    -1.693d],
		    [0, 		 -10, 		-5,			1,   		     0d],
		    [1, 		 -10, 		-5,   		1,		     1.693d],
		    [100, 		 -10, 		-5,			1,		   169.350d],
			
			/*
			 * ... INTEREST -10
			 */
			
			//
			
			/*
			 * INTEREST -1 ...
			 */
			
			// The capital doesnt change in t=0
			// CAPITAL	INTEREST	TIME	INTERVAL		EXPECTED
			[-100d, 	 -1, 		 0,			1,		      -100d],
			[-1, 		 -1, 		 0,			1,		        -1d],
			[0, 		 -1, 		 0,			1,   		     0d],
			[1, 		 -1, 		 0,   		1,			     1d],
			[100, 		 -1, 		 0,			1,		       100d],
			
			// Changing the inverval with t=0 doesnt change the result
			// CAPITAL	INTEREST	TIME	INTERVAL		EXPECTED
			[-100d, 	 -1, 		 0,			2,		      -100d],
			[-1, 		 -1, 		 0,			2,		        -1d],
			[0, 		 -1, 		 0,			2,   		     0d],
			[1, 		 -1, 		 0,   		2,			     1d],
			[100, 		 -1, 		 0,			2,		       100d],
			
			// Changing time t=1 with interval=1 will accumulate down for one year
			// CAPITAL	INTEREST	TIME	INTERVAL		EXPECTED
			[-100d, 	 -1, 		 1,			1,		       -99d],
			[-1, 		 -1, 		 1,			1,		     -0.99d],
			[0, 		 -1, 		 1,			1,   		     0d],
			[1, 		 -1, 		 1,   		1,			  0.99d],
			[100, 		 -1, 		 1,			1,		        99d],

			// Changing time t=5 with interval=1 will accumulate down for five years
			// CAPITAL	INTEREST	TIME	INTERVAL		EXPECTED
			[-100d, 	 -1, 		 5,			1,		   -95.099d],
			[-1, 		 -1, 		 5,			1,		    -0.950d],
			[0, 		 -1, 		 5,			1,   		     0d],
			[1, 		 -1, 		 5,   		1,			 0.950d],
			[100, 		 -1, 		 5,			1,		    95.099d],
			
			// Changing time t=-1 with interval=1 will accumulate up for one year
			// CAPITAL	INTEREST	TIME	INTERVAL		EXPECTED
			[-100d, 	 -1, 		-1,			1,		  -101.010d],
			[-1, 		 -1, 		-1,			1,		    -1.010d],
			[0, 		 -1, 		-1,			1,   		     0d],
			[1, 		 -1, 		-1,   		1,		  	 1.010d],
			[100, 		 -1, 		-1,			1,		   101.010d],

			// Changing time t=-1 with interval=1 will accumulate up for five year
			// CAPITAL	INTEREST	TIME	INTERVAL		EXPECTED
			[-100d, 	 -1, 		-5,			1,		  -105.153d],
			[-1, 		 -1, 		-5,			1,		    -1.051d],
			[0, 		 -1, 		-5,			1,   		     0d],
			[1, 		 -1, 		-5,   		1,			 1.051d],
			[100, 		 -1, 		-5,			1,		   105.153d],
			
			/*
			 * ... INTEREST -1
			 */
			
			//
			
			/*
			 * INTEREST 0 ...
			 */
			
			// The capital doesnt change in t=0
			// CAPITAL	INTEREST	TIME	INTERVAL		EXPECTED
			[-100d, 	 0, 		 0,			1,		      -100d],
			[-1, 		 0, 		 0,			1,		        -1d],
			[0, 		 0, 		 0,			1,   		     0d],
			[1, 		 0, 		 0,   		1,			     1d],
			[100, 		 0, 		 0,			1,		       100d],
			
			// Changing the inverval with t=0 doesnt change the result
			// CAPITAL	INTEREST	TIME	INTERVAL		EXPECTED
			[-100d, 	 0, 		 0,			2,		      -100d],
			[-1, 		 0, 		 0,			2,		        -1d],
			[0, 		 0, 		 0,			2,   		     0d],
			[1, 		 0, 		 0,   		2,			     1d],
			[100, 		 0, 		 0,			2,		       100d],
			
			// Changing time t=1 with interval=1 will accumulate down for one year
			// CAPITAL	INTEREST	TIME	INTERVAL		EXPECTED
			[-100d, 	 0, 		 1,			1,		      -100d],
			[-1, 		 0, 		 1,			1,		        -1d],
			[0, 		 0, 		 1,			1,   		     0d],
			[1, 		 0, 		 1,   		1,			     1d],
			[100, 		 0, 		 1,			1,		       100d],

			// Changing time t=5 with interval=1 will accumulate down for five years
			// CAPITAL	INTEREST	TIME	INTERVAL		EXPECTED
			[-100d, 	 0, 		 5,			1,		      -100d],
			[-1, 		 0, 		 5,			1,		        -1d],
			[0, 		 0, 		 5,			1,   		     0d],
			[1, 		 0, 		 5,   		1,			     1d],
			[100, 		 0, 		 5,			1,		       100d],
			
			// Changing time t=-1 with interval=1 will accumulate up for one year
			// CAPITAL	INTEREST	TIME	INTERVAL		EXPECTED
			[-100d, 	 0, 		-1,			1,		      -100d],
			[-1, 		 0, 		-1,			1,		        -1d],
			[0, 		 0, 		-1,			1,   		     0d],
			[1, 		 0, 		-1,   		1,			     1d],
			[100, 		 0, 		-1,			1,		       100d],

			// Changing time t=-1 with interval=1 will accumulate up for five year
			// CAPITAL	INTEREST	TIME	INTERVAL		EXPECTED
			[-100d, 	 0, 		-5,			1,		      -100d],
			[-1, 		 0, 		-5,			1,		        -1d],
			[0, 		 0, 		-5,			1,   		     0d],
			[1, 		 0, 		-5,   		1,			     1d],
			[100, 		 0, 		-5,			1,		       100d],
			
			/*
			 * ... INTEREST 0
			 */

			//
			
			/*
			 * INTEREST 1 ...
			 */
			
			// The capital doesnt change in t=0
			// CAPITAL	INTEREST	TIME	INTERVAL		EXPECTED
			[-100d, 	 1, 		 0,			1,		      -100d],
			[-1, 		 1, 		 0,			1,		        -1d],
			[0, 		 1, 		 0,			1,   		     0d],
			[1, 		 1, 		 0,   		1,			     1d],
			[100, 		 1, 		 0,			1,		       100d],
			
			// Changing the inverval with t=0 doesnt change the result
			// CAPITAL	INTEREST	TIME	INTERVAL		EXPECTED
			[-100d, 	 1, 		 0,			2,		      -100d],
			[-1, 		 1, 		 0,			2,		        -1d],
			[0, 		 1, 		 0,			2,   		     0d],
			[1, 		 1, 		 0,   		2,			     1d],
			[100, 		 1, 		 0,			2,		       100d],
			
			// Changing time t=1 with interval=1 will accumulate down for one year
			// CAPITAL	INTEREST	TIME	INTERVAL		EXPECTED
			[-100d, 	 1, 		 1,			1,		      -101d],
			[-1, 		 1, 		 1,			1,		     -1.01d],
			[0, 		 1, 		 1,			1,   		     0d],
			[1, 		 1, 		 1,   		1,			  1.01d],
			[100, 		 1, 		 1,			1,		       101d],

			// Changing time t=5 with interval=1 will accumulate down for five years
			// CAPITAL	INTEREST	TIME	INTERVAL		EXPECTED
			[-100d, 	 1, 		 5,			1,		  -105.101d],
			[-1, 		 1, 		 5,			1,		    -1.051d],
			[0, 		 1, 		 5,			1,   	         0d],
			[1, 		 1, 		 5,   		1,		     1.051d],
			[100, 		 1, 		 5,			1,		   105.101d],
			
			// Changing time t=-1 with interval=1 will accumulate up for one year
			// CAPITAL	INTEREST	TIME	INTERVAL		EXPECTED
			[-100d, 	 1, 		-1,			1,		   -99.009d],
			[-1, 		 1, 		-1,			1,		     -0.99d],
			[0, 		 1, 		-1,			1,   		     0d],
			[1, 		 1, 		-1,   		1,			  0.99d],
			[100, 		 1, 		-1,			1,		    99.009d],

			// Changing time t=-1 with interval=1 will accumulate up for five year
			// CAPITAL	INTEREST	TIME	INTERVAL		EXPECTED
			[-100d, 	 1, 		-5,			1,		   -95.146d],
			[-1, 		 1, 		-5,			1,		    -0.951d],
			[0, 		 1, 		-5,			1,   		     0d],
			[1, 		 1, 		-5,   		1,			 0.951d],
			[100, 		 1, 		-5,			1,		    95.146d],
			
			/*
			 * ... INTEREST 1
			 */
			
			//
			
			/*
			 * INTEREST 10 ...
			 */
			
			// The capital doesnt change in t=0
			// CAPITAL	INTEREST	TIME	INTERVAL		EXPECTED
			[-100d, 	 10, 		 0,			1,		      -100d],
			[-1, 		 10, 		 0,			1,		        -1d],
			[0, 		 10, 		 0,			1,   		     0d],
			[1, 		 10, 		 0,   		1,			     1d],
			[100, 		 10, 		 0,			1,		       100d],
			
			// Changing the inverval with t=0 doesnt change the result
			// CAPITAL	INTEREST	TIME	INTERVAL		EXPECTED
			[-100d, 	 10, 		 0,			2,		      -100d],
			[-1, 		 10, 		 0,			2,		        -1d],
			[0, 		 10, 		 0,			2,   		     0d],
			[1, 		 10, 		 0,   		2,			     1d],
			[100, 		 10, 		 0,			2,		       100d],
			
			// Changing time t=1 with interval=1 will accumulate down for one year
			// CAPITAL	INTEREST	TIME	INTERVAL		EXPECTED
			[-100d, 	 10, 		 1,			1,		      -110d],
			[-1, 		 10, 		 1,			1,		      -1.1d],
			[0, 		 10, 		 1,			1,   		     0d],
			[1, 		 10, 		 1,   		1,			   1.1d],
			[100, 		 10, 		 1,			1,		       110d],

			// Changing time t=5 with interval=1 will accumulate down for five years
			// CAPITAL	INTEREST	TIME	INTERVAL		EXPECTED
			[-100d, 	 10, 		 5,			1,		  -161.051d],
			[-1, 		 10, 		 5,			1,		    -1.610d],
			[0, 		 10, 		 5,			1,   		     0d],
			[1, 		 10, 		 5,   		1,			 1.610d],
			[100, 		 10, 		 5,			1,		   161.051d],
			
			// Changing time t=-1 with interval=1 will accumulate up for one year
			// CAPITAL	INTEREST	TIME	INTERVAL		EXPECTED
			[-100d, 	 10, 		-1,			1,		   -90.909d],
			[-1, 		 10, 		-1,			1,		    -0.909d],
			[0, 		 10, 		-1,			1,   		     0d],
			[1, 		 10, 		-1,   		1,			 0.909d],
			[100, 		 10, 		-1,			1,		    90.909d],

			// Changing time t=-1 with interval=1 will accumulate up for five year
			// CAPITAL	INTEREST	TIME	INTERVAL		EXPECTED
			[-100d, 	 10, 		-5,			1,		   -62.092d],
			[-1, 		 10, 		-5,			1,		    -0.620d],
			[0, 		 10, 		-5,			1,   		     0d],
			[1, 		 10, 		-5,   		1,			 0.620d],
			[100, 		 10, 		-5,			1,		    62.092d],
			
			/*
			 * ... INTEREST 10
			 */

		]*.toArray()
	}

	
	@Test
	public void testAccumulationFactorByYearsAndInterest() {
		double result = BasicCalculator.calculateInterestOfAmountWithInterval(capital, interest, time, interval)
		Assertions.assertThat(result).isCloseTo(expected, Assertions.offset(0.001d))
	}

}
