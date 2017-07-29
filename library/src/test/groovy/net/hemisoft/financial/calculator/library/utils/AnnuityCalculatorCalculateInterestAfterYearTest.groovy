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
class AnnuityCalculatorCalculateInterestAfterYearTest {
	def capital, interest, time, timeN, expected
	
	
	public AnnuityCalculatorCalculateInterestAfterYearTest(capital, interest, time, timeN, expected) {
		this.capital = capital
		this.interest = interest
		this.time = time;
		this.timeN = timeN
		this.expected = expected
	}

	@Parameters static cases() {
		[
			// CAPITAL	INTEREST	TIME	TIME_N	EXPECTED
			[-100.0d,	  1.0,		   0,		 0,		  0.0d],
			[-100.0d,	  1.0,		   0,		 1,		  0.0d],
			[-100.0d,	  1.0,		   0,		 10,		  0.0d],
			
			// CAPITAL	INTEREST	TIME	TIME_N	EXPECTED
			[-100.0d,	  1.0,		   1,		 1,		  0.0d],
			[-100.0d,	  1.0,		   1,		 10,		  0.0d],
			
			// CAPITAL	INTEREST	TIME	TIME_N	EXPECTED
			[-100.0d,	  1.0,		   10,		 10,		  0.0d],
			
			// CAPITAL	INTEREST	TIME	TIME_N	EXPECTED
			[-100.0d,	  10.0,		   0,		 0,		  0.0d],
			[-100.0d,	  10.0,		   0,		 1,		  0.0d],
			[-100.0d,	  10.0,		   0,		 10,		  0.0d],
			
			// CAPITAL	INTEREST	TIME	TIME_N	EXPECTED
			[-100.0d,	  10.0,		   1,		 1,		  0.0d],
			[-100.0d,	  10.0,		   1,		 10,		  0.0d],
			
			// CAPITAL	INTEREST	TIME	TIME_N	EXPECTED
			[-100.0d,	  10.0,		   10,		 10,		  0.0d],
			
			// CAPITAL	INTEREST	TIME	TIME_N	EXPECTED
			[-1.0d,	  1.0,		   0,		 0,		  0.0d],
			[-1.0d,	  1.0,		   0,		 1,		  0.0d],
			[-1.0d,	  1.0,		   0,		 10,		  0.0d],
			
			// CAPITAL	INTEREST	TIME	TIME_N	EXPECTED
			[-1.0d,	  1.0,		   1,		 1,		  0.0d],
			[-1.0d,	  1.0,		   1,		 10,		  0.0d],
			
			// CAPITAL	INTEREST	TIME	TIME_N	EXPECTED
			[-1.0d,	  1.0,		   10,		 10,		  0.0d],
			
			// CAPITAL	INTEREST	TIME	TIME_N	EXPECTED
			[-1.0d,	  10.0,		   0,		 0,		  0.0d],
			[-1.0d,	  10.0,		   0,		 1,		  0.0d],
			[-1.0d,	  10.0,		   0,		 10,		  0.0d],
			
			// CAPITAL	INTEREST	TIME	TIME_N	EXPECTED
			[-1.0d,	  10.0,		   1,		 1,		  0.0d],
			[-1.0d,	  10.0,		   1,		 10,		  0.0d],
			
			// CAPITAL	INTEREST	TIME	TIME_N	EXPECTED
			[-1.0d,	  10.0,		   10,		 10,		  0.0d],
			
			// CAPITAL	INTEREST	TIME	TIME_N	EXPECTED
			[0.0d,	  1.0,		   0,		 0,		  0.0d],
			[0.0d,	  1.0,		   0,		 1,		  0.0d],
			[0.0d,	  1.0,		   0,		 10,		  0.0d],
			
			// CAPITAL	INTEREST	TIME	TIME_N	EXPECTED
			[0.0d,	  1.0,		   1,		 1,		  0.0d],
			[0.0d,	  1.0,		   1,		 10,		  0.0d],
			
			// CAPITAL	INTEREST	TIME	TIME_N	EXPECTED
			[0.0d,	  1.0,		   10,		 10,		  0.0d],
			
			// CAPITAL	INTEREST	TIME	TIME_N	EXPECTED
			[0.0d,	  10.0,		   0,		 0,		  0.0d],
			[0.0d,	  10.0,		   0,		 1,		  0.0d],
			[0.0d,	  10.0,		   0,		 10,		  0.0d],
			
			// CAPITAL	INTEREST	TIME	TIME_N	EXPECTED
			[0.0d,	  10.0,		   1,		 1,		  0.0d],
			[0.0d,	  10.0,		   1,		 10,		  0.0d],
			
			// CAPITAL	INTEREST	TIME	TIME_N	EXPECTED
			[0.0d,	  10.0,		   10,		 10,		  0.0d],
			
			// CAPITAL	INTEREST	TIME	TIME_N	EXPECTED
			[1.0d,	  1.0,		   0,		 0,		  0.010000000000000009d],
			[1.0d,	  1.0,		   0,		 1,		  0.010000000000000009d],
			[1.0d,	  1.0,		   0,		 10,		  0.010000000000000009d],
			
			// CAPITAL	INTEREST	TIME	TIME_N	EXPECTED
			[1.0d,	  1.0,		   1,		 1,		  0.005024875621890549d],
			[1.0d,	  1.0,		   1,		 10,		  0.009135459242887368d],
			
			// CAPITAL	INTEREST	TIME	TIME_N	EXPECTED
			[1.0d,	  1.0,		   10,		 10,		  9.549908486263752E-4d],
			
			// CAPITAL	INTEREST	TIME	TIME_N	EXPECTED
			[1.0d,	  10.0,		   0,		 0,		  0.10000000000000009d],
			[1.0d,	  10.0,		   0,		 1,		  0.10000000000000009d],
			[1.0d,	  10.0,		   0,		 10,		  0.10000000000000009d],
			
			// CAPITAL	INTEREST	TIME	TIME_N	EXPECTED
			[1.0d,	  10.0,		   1,		 1,		  0.05238095238095243d],
			[1.0d,	  10.0,		   1,		 10,		  0.09460368579753863d],
			
			// CAPITAL	INTEREST	TIME	TIME_N	EXPECTED
			[1.0d,	  10.0,		   10,		 10,		  0.013996649274964969d],
			
			// CAPITAL	INTEREST	TIME	TIME_N	EXPECTED
			[100.0d,	  1.0,		   0,		 0,		  1.0000000000000009d],
			[100.0d,	  1.0,		   0,		 1,		  1.0000000000000009d],
			[100.0d,	  1.0,		   0,		 10,		  1.0000000000000009d],
			
			// CAPITAL	INTEREST	TIME	TIME_N	EXPECTED
			[100.0d,	  1.0,		   1,		 1,		  0.5024875621890549d],
			[100.0d,	  1.0,		   1,		 10,		  0.9135459242887368d],
			
			// CAPITAL	INTEREST	TIME	TIME_N	EXPECTED
			[100.0d,	  1.0,		   10,		 10,		  0.09549908486263753d],
			
			// CAPITAL	INTEREST	TIME	TIME_N	EXPECTED
			[100.0d,	  10.0,		   0,		 0,		  10.000000000000009d],
			[100.0d,	  10.0,		   0,		 1,		  10.000000000000009d],
			[100.0d,	  10.0,		   0,		 10,		  10.000000000000007d],
			
			// CAPITAL	INTEREST	TIME	TIME_N	EXPECTED
			[100.0d,	  10.0,		   1,		 1,		  5.2380952380952435d],
			[100.0d,	  10.0,		   1,		 10,		  9.460368579753862d],
			
			// CAPITAL	INTEREST	TIME	TIME_N	EXPECTED
			[100.0d,	  10.0,		   10,		 10,		  1.399664927496497d],
		]*.toArray()
	}

	
	@Test
	public void testAccumulationFactorByYearsAndInterest() {
		assertThat(AnnuityCalculator.calculateInterestAfterYear(capital, interest, time, timeN)).isCloseTo(expected, offset(0.001d))
	}

}
