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
class AnnuityCalculatorCalculateRestLoanInYearTest {
	def capital, interest, redemption, specialRedemption, endOfYear, expected
	
	
	public AnnuityCalculatorCalculateRestLoanInYearTest(capital, interest, redemption, specialRedemption, endOfYear, expected) {
		this.capital = capital
		this.interest = interest
		this.redemption = redemption;
		this.specialRedemption = specialRedemption
		this.endOfYear = endOfYear
		this.expected = expected
	}

	@Parameters static cases() {
		[
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[-100.0d,	  1.0,		   0.0,		 0.0,		  0,		  0.0d],
			[-100.0d,	  1.0,		   0.0,		 0.0,		  1,		  0.0d],
			[-100.0d,	  1.0,		   0.0,		 0.0,		  10,		  0.0d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[-100.0d,	  1.0,		   0.0,		 1.0,		  0,		  0.0d],
			[-100.0d,	  1.0,		   0.0,		 1.0,		  1,		  0.0d],
			[-100.0d,	  1.0,		   0.0,		 1.0,		  10,		  0.0d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[-100.0d,	  1.0,		   0.0,		 10.0,		  0,		  0.0d],
			[-100.0d,	  1.0,		   0.0,		 10.0,		  1,		  0.0d],
			[-100.0d,	  1.0,		   0.0,		 10.0,		  10,		  0.0d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[-100.0d,	  1.0,		   1.0,		 0.0,		  0,		  0.0d],
			[-100.0d,	  1.0,		   1.0,		 0.0,		  1,		  0.0d],
			[-100.0d,	  1.0,		   1.0,		 0.0,		  10,		  0.0d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[-100.0d,	  1.0,		   1.0,		 1.0,		  0,		  0.0d],
			[-100.0d,	  1.0,		   1.0,		 1.0,		  1,		  0.0d],
			[-100.0d,	  1.0,		   1.0,		 1.0,		  10,		  0.0d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[-100.0d,	  1.0,		   1.0,		 10.0,		  0,		  0.0d],
			[-100.0d,	  1.0,		   1.0,		 10.0,		  1,		  0.0d],
			[-100.0d,	  1.0,		   1.0,		 10.0,		  10,		  0.0d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[-100.0d,	  1.0,		   10.0,		 0.0,		  0,		  0.0d],
			[-100.0d,	  1.0,		   10.0,		 0.0,		  1,		  0.0d],
			[-100.0d,	  1.0,		   10.0,		 0.0,		  10,		  0.0d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[-100.0d,	  1.0,		   10.0,		 1.0,		  0,		  0.0d],
			[-100.0d,	  1.0,		   10.0,		 1.0,		  1,		  0.0d],
			[-100.0d,	  1.0,		   10.0,		 1.0,		  10,		  0.0d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[-100.0d,	  1.0,		   10.0,		 10.0,		  0,		  0.0d],
			[-100.0d,	  1.0,		   10.0,		 10.0,		  1,		  0.0d],
			[-100.0d,	  1.0,		   10.0,		 10.0,		  10,		  0.0d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[-100.0d,	  10.0,		   0.0,		 0.0,		  0,		  0.0d],
			[-100.0d,	  10.0,		   0.0,		 0.0,		  1,		  0.0d],
			[-100.0d,	  10.0,		   0.0,		 0.0,		  10,		  0.0d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[-100.0d,	  10.0,		   0.0,		 1.0,		  0,		  0.0d],
			[-100.0d,	  10.0,		   0.0,		 1.0,		  1,		  0.0d],
			[-100.0d,	  10.0,		   0.0,		 1.0,		  10,		  0.0d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[-100.0d,	  10.0,		   0.0,		 10.0,		  0,		  0.0d],
			[-100.0d,	  10.0,		   0.0,		 10.0,		  1,		  0.0d],
			[-100.0d,	  10.0,		   0.0,		 10.0,		  10,		  0.0d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[-100.0d,	  10.0,		   1.0,		 0.0,		  0,		  0.0d],
			[-100.0d,	  10.0,		   1.0,		 0.0,		  1,		  0.0d],
			[-100.0d,	  10.0,		   1.0,		 0.0,		  10,		  0.0d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[-100.0d,	  10.0,		   1.0,		 1.0,		  0,		  0.0d],
			[-100.0d,	  10.0,		   1.0,		 1.0,		  1,		  0.0d],
			[-100.0d,	  10.0,		   1.0,		 1.0,		  10,		  0.0d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[-100.0d,	  10.0,		   1.0,		 10.0,		  0,		  0.0d],
			[-100.0d,	  10.0,		   1.0,		 10.0,		  1,		  0.0d],
			[-100.0d,	  10.0,		   1.0,		 10.0,		  10,		  0.0d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[-100.0d,	  10.0,		   10.0,		 0.0,		  0,		  0.0d],
			[-100.0d,	  10.0,		   10.0,		 0.0,		  1,		  0.0d],
			[-100.0d,	  10.0,		   10.0,		 0.0,		  10,		  0.0d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[-100.0d,	  10.0,		   10.0,		 1.0,		  0,		  0.0d],
			[-100.0d,	  10.0,		   10.0,		 1.0,		  1,		  0.0d],
			[-100.0d,	  10.0,		   10.0,		 1.0,		  10,		  0.0d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[-100.0d,	  10.0,		   10.0,		 10.0,		  0,		  0.0d],
			[-100.0d,	  10.0,		   10.0,		 10.0,		  1,		  0.0d],
			[-100.0d,	  10.0,		   10.0,		 10.0,		  10,		  0.0d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[-1.0d,	  1.0,		   0.0,		 0.0,		  0,		  0.0d],
			[-1.0d,	  1.0,		   0.0,		 0.0,		  1,		  0.0d],
			[-1.0d,	  1.0,		   0.0,		 0.0,		  10,		  0.0d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[-1.0d,	  1.0,		   0.0,		 1.0,		  0,		  0.0d],
			[-1.0d,	  1.0,		   0.0,		 1.0,		  1,		  0.0d],
			[-1.0d,	  1.0,		   0.0,		 1.0,		  10,		  0.0d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[-1.0d,	  1.0,		   0.0,		 10.0,		  0,		  0.0d],
			[-1.0d,	  1.0,		   0.0,		 10.0,		  1,		  0.0d],
			[-1.0d,	  1.0,		   0.0,		 10.0,		  10,		  0.0d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[-1.0d,	  1.0,		   1.0,		 0.0,		  0,		  0.0d],
			[-1.0d,	  1.0,		   1.0,		 0.0,		  1,		  0.0d],
			[-1.0d,	  1.0,		   1.0,		 0.0,		  10,		  0.0d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[-1.0d,	  1.0,		   1.0,		 1.0,		  0,		  0.0d],
			[-1.0d,	  1.0,		   1.0,		 1.0,		  1,		  0.0d],
			[-1.0d,	  1.0,		   1.0,		 1.0,		  10,		  0.0d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[-1.0d,	  1.0,		   1.0,		 10.0,		  0,		  0.0d],
			[-1.0d,	  1.0,		   1.0,		 10.0,		  1,		  0.0d],
			[-1.0d,	  1.0,		   1.0,		 10.0,		  10,		  0.0d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[-1.0d,	  1.0,		   10.0,		 0.0,		  0,		  0.0d],
			[-1.0d,	  1.0,		   10.0,		 0.0,		  1,		  0.0d],
			[-1.0d,	  1.0,		   10.0,		 0.0,		  10,		  0.0d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[-1.0d,	  1.0,		   10.0,		 1.0,		  0,		  0.0d],
			[-1.0d,	  1.0,		   10.0,		 1.0,		  1,		  0.0d],
			[-1.0d,	  1.0,		   10.0,		 1.0,		  10,		  0.0d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[-1.0d,	  1.0,		   10.0,		 10.0,		  0,		  0.0d],
			[-1.0d,	  1.0,		   10.0,		 10.0,		  1,		  0.0d],
			[-1.0d,	  1.0,		   10.0,		 10.0,		  10,		  0.0d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[-1.0d,	  10.0,		   0.0,		 0.0,		  0,		  0.0d],
			[-1.0d,	  10.0,		   0.0,		 0.0,		  1,		  0.0d],
			[-1.0d,	  10.0,		   0.0,		 0.0,		  10,		  0.0d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[-1.0d,	  10.0,		   0.0,		 1.0,		  0,		  0.0d],
			[-1.0d,	  10.0,		   0.0,		 1.0,		  1,		  0.0d],
			[-1.0d,	  10.0,		   0.0,		 1.0,		  10,		  0.0d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[-1.0d,	  10.0,		   0.0,		 10.0,		  0,		  0.0d],
			[-1.0d,	  10.0,		   0.0,		 10.0,		  1,		  0.0d],
			[-1.0d,	  10.0,		   0.0,		 10.0,		  10,		  0.0d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[-1.0d,	  10.0,		   1.0,		 0.0,		  0,		  0.0d],
			[-1.0d,	  10.0,		   1.0,		 0.0,		  1,		  0.0d],
			[-1.0d,	  10.0,		   1.0,		 0.0,		  10,		  0.0d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[-1.0d,	  10.0,		   1.0,		 1.0,		  0,		  0.0d],
			[-1.0d,	  10.0,		   1.0,		 1.0,		  1,		  0.0d],
			[-1.0d,	  10.0,		   1.0,		 1.0,		  10,		  0.0d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[-1.0d,	  10.0,		   1.0,		 10.0,		  0,		  0.0d],
			[-1.0d,	  10.0,		   1.0,		 10.0,		  1,		  0.0d],
			[-1.0d,	  10.0,		   1.0,		 10.0,		  10,		  0.0d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[-1.0d,	  10.0,		   10.0,		 0.0,		  0,		  0.0d],
			[-1.0d,	  10.0,		   10.0,		 0.0,		  1,		  0.0d],
			[-1.0d,	  10.0,		   10.0,		 0.0,		  10,		  0.0d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[-1.0d,	  10.0,		   10.0,		 1.0,		  0,		  0.0d],
			[-1.0d,	  10.0,		   10.0,		 1.0,		  1,		  0.0d],
			[-1.0d,	  10.0,		   10.0,		 1.0,		  10,		  0.0d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[-1.0d,	  10.0,		   10.0,		 10.0,		  0,		  0.0d],
			[-1.0d,	  10.0,		   10.0,		 10.0,		  1,		  0.0d],
			[-1.0d,	  10.0,		   10.0,		 10.0,		  10,		  0.0d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[0.0d,	  1.0,		   0.0,		 0.0,		  0,		  0.0d],
			[0.0d,	  1.0,		   0.0,		 0.0,		  1,		  0.0d],
			[0.0d,	  1.0,		   0.0,		 0.0,		  10,		  0.0d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[0.0d,	  1.0,		   0.0,		 1.0,		  0,		  0.0d],
			[0.0d,	  1.0,		   0.0,		 1.0,		  1,		  0.0d],
			[0.0d,	  1.0,		   0.0,		 1.0,		  10,		  0.0d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[0.0d,	  1.0,		   0.0,		 10.0,		  0,		  0.0d],
			[0.0d,	  1.0,		   0.0,		 10.0,		  1,		  0.0d],
			[0.0d,	  1.0,		   0.0,		 10.0,		  10,		  0.0d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[0.0d,	  1.0,		   1.0,		 0.0,		  0,		  0.0d],
			[0.0d,	  1.0,		   1.0,		 0.0,		  1,		  0.0d],
			[0.0d,	  1.0,		   1.0,		 0.0,		  10,		  0.0d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[0.0d,	  1.0,		   1.0,		 1.0,		  0,		  0.0d],
			[0.0d,	  1.0,		   1.0,		 1.0,		  1,		  0.0d],
			[0.0d,	  1.0,		   1.0,		 1.0,		  10,		  0.0d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[0.0d,	  1.0,		   1.0,		 10.0,		  0,		  0.0d],
			[0.0d,	  1.0,		   1.0,		 10.0,		  1,		  0.0d],
			[0.0d,	  1.0,		   1.0,		 10.0,		  10,		  0.0d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[0.0d,	  1.0,		   10.0,		 0.0,		  0,		  0.0d],
			[0.0d,	  1.0,		   10.0,		 0.0,		  1,		  0.0d],
			[0.0d,	  1.0,		   10.0,		 0.0,		  10,		  0.0d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[0.0d,	  1.0,		   10.0,		 1.0,		  0,		  0.0d],
			[0.0d,	  1.0,		   10.0,		 1.0,		  1,		  0.0d],
			[0.0d,	  1.0,		   10.0,		 1.0,		  10,		  0.0d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[0.0d,	  1.0,		   10.0,		 10.0,		  0,		  0.0d],
			[0.0d,	  1.0,		   10.0,		 10.0,		  1,		  0.0d],
			[0.0d,	  1.0,		   10.0,		 10.0,		  10,		  0.0d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[0.0d,	  10.0,		   0.0,		 0.0,		  0,		  0.0d],
			[0.0d,	  10.0,		   0.0,		 0.0,		  1,		  0.0d],
			[0.0d,	  10.0,		   0.0,		 0.0,		  10,		  0.0d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[0.0d,	  10.0,		   0.0,		 1.0,		  0,		  0.0d],
			[0.0d,	  10.0,		   0.0,		 1.0,		  1,		  0.0d],
			[0.0d,	  10.0,		   0.0,		 1.0,		  10,		  0.0d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[0.0d,	  10.0,		   0.0,		 10.0,		  0,		  0.0d],
			[0.0d,	  10.0,		   0.0,		 10.0,		  1,		  0.0d],
			[0.0d,	  10.0,		   0.0,		 10.0,		  10,		  0.0d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[0.0d,	  10.0,		   1.0,		 0.0,		  0,		  0.0d],
			[0.0d,	  10.0,		   1.0,		 0.0,		  1,		  0.0d],
			[0.0d,	  10.0,		   1.0,		 0.0,		  10,		  0.0d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[0.0d,	  10.0,		   1.0,		 1.0,		  0,		  0.0d],
			[0.0d,	  10.0,		   1.0,		 1.0,		  1,		  0.0d],
			[0.0d,	  10.0,		   1.0,		 1.0,		  10,		  0.0d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[0.0d,	  10.0,		   1.0,		 10.0,		  0,		  0.0d],
			[0.0d,	  10.0,		   1.0,		 10.0,		  1,		  0.0d],
			[0.0d,	  10.0,		   1.0,		 10.0,		  10,		  0.0d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[0.0d,	  10.0,		   10.0,		 0.0,		  0,		  0.0d],
			[0.0d,	  10.0,		   10.0,		 0.0,		  1,		  0.0d],
			[0.0d,	  10.0,		   10.0,		 0.0,		  10,		  0.0d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[0.0d,	  10.0,		   10.0,		 1.0,		  0,		  0.0d],
			[0.0d,	  10.0,		   10.0,		 1.0,		  1,		  0.0d],
			[0.0d,	  10.0,		   10.0,		 1.0,		  10,		  0.0d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[0.0d,	  10.0,		   10.0,		 10.0,		  0,		  0.0d],
			[0.0d,	  10.0,		   10.0,		 10.0,		  1,		  0.0d],
			[0.0d,	  10.0,		   10.0,		 10.0,		  10,		  0.0d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[1.0d,	  1.0,		   0.0,		 0.0,		  0,		  1.0d],
			[1.0d,	  1.0,		   0.0,		 0.0,		  1,		  1.0d],
			[1.0d,	  1.0,		   0.0,		 0.0,		  10,		  1.0d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[1.0d,	  1.0,		   0.0,		 1.0,		  0,		  1.0d],
			[1.0d,	  1.0,		   0.0,		 1.0,		  1,		  0.9999d],
			[1.0d,	  1.0,		   0.0,		 1.0,		  10,		  0.998953778745888d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[1.0d,	  1.0,		   0.0,		 10.0,		  0,		  1.0d],
			[1.0d,	  1.0,		   0.0,		 10.0,		  1,		  0.999d],
			[1.0d,	  1.0,		   0.0,		 10.0,		  10,		  0.9895377874588795d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[1.0d,	  1.0,		   1.0,		 0.0,		  0,		  1.0d],
			[1.0d,	  1.0,		   1.0,		 0.0,		  1,		  0.9999d],
			[1.0d,	  1.0,		   1.0,		 0.0,		  10,		  0.998953778745888d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[1.0d,	  1.0,		   1.0,		 1.0,		  0,		  1.0d],
			[1.0d,	  1.0,		   1.0,		 1.0,		  1,		  0.9998d],
			[1.0d,	  1.0,		   1.0,		 1.0,		  10,		  0.997907557491776d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[1.0d,	  1.0,		   1.0,		 10.0,		  0,		  1.0d],
			[1.0d,	  1.0,		   1.0,		 10.0,		  1,		  0.9989d],
			[1.0d,	  1.0,		   1.0,		 10.0,		  10,		  0.9884915662047675d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[1.0d,	  1.0,		   10.0,		 0.0,		  0,		  1.0d],
			[1.0d,	  1.0,		   10.0,		 0.0,		  1,		  0.999d],
			[1.0d,	  1.0,		   10.0,		 0.0,		  10,		  0.9895377874588795d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[1.0d,	  1.0,		   10.0,		 1.0,		  0,		  1.0d],
			[1.0d,	  1.0,		   10.0,		 1.0,		  1,		  0.9989d],
			[1.0d,	  1.0,		   10.0,		 1.0,		  10,		  0.9884915662047675d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[1.0d,	  1.0,		   10.0,		 10.0,		  0,		  1.0d],
			[1.0d,	  1.0,		   10.0,		 10.0,		  1,		  0.998d],
			[1.0d,	  1.0,		   10.0,		 10.0,		  10,		  0.9790755749177591d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[1.0d,	  10.0,		   0.0,		 0.0,		  0,		  1.0d],
			[1.0d,	  10.0,		   0.0,		 0.0,		  1,		  1.0d],
			[1.0d,	  10.0,		   0.0,		 0.0,		  10,		  1.0d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[1.0d,	  10.0,		   0.0,		 1.0,		  0,		  1.0d],
			[1.0d,	  10.0,		   0.0,		 1.0,		  1,		  0.9999d],
			[1.0d,	  10.0,		   0.0,		 1.0,		  10,		  0.9984062575399d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[1.0d,	  10.0,		   0.0,		 10.0,		  0,		  1.0d],
			[1.0d,	  10.0,		   0.0,		 10.0,		  1,		  0.999d],
			[1.0d,	  10.0,		   0.0,		 10.0,		  10,		  0.984062575399d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[1.0d,	  10.0,		   1.0,		 0.0,		  0,		  1.0d],
			[1.0d,	  10.0,		   1.0,		 0.0,		  1,		  0.9999d],
			[1.0d,	  10.0,		   1.0,		 0.0,		  10,		  0.9984062575399d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[1.0d,	  10.0,		   1.0,		 1.0,		  0,		  1.0d],
			[1.0d,	  10.0,		   1.0,		 1.0,		  1,		  0.9998d],
			[1.0d,	  10.0,		   1.0,		 1.0,		  10,		  0.9968125150798d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[1.0d,	  10.0,		   1.0,		 10.0,		  0,		  1.0d],
			[1.0d,	  10.0,		   1.0,		 10.0,		  1,		  0.9989d],
			[1.0d,	  10.0,		   1.0,		 10.0,		  10,		  0.9824688329389d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[1.0d,	  10.0,		   10.0,		 0.0,		  0,		  1.0d],
			[1.0d,	  10.0,		   10.0,		 0.0,		  1,		  0.999d],
			[1.0d,	  10.0,		   10.0,		 0.0,		  10,		  0.984062575399d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[1.0d,	  10.0,		   10.0,		 1.0,		  0,		  1.0d],
			[1.0d,	  10.0,		   10.0,		 1.0,		  1,		  0.9989d],
			[1.0d,	  10.0,		   10.0,		 1.0,		  10,		  0.9824688329389d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[1.0d,	  10.0,		   10.0,		 10.0,		  0,		  1.0d],
			[1.0d,	  10.0,		   10.0,		 10.0,		  1,		  0.998d],
			[1.0d,	  10.0,		   10.0,		 10.0,		  10,		  0.968125150798d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[100.0d,	  1.0,		   0.0,		 0.0,		  0,		  100.0d],
			[100.0d,	  1.0,		   0.0,		 0.0,		  1,		  100.0d],
			[100.0d,	  1.0,		   0.0,		 0.0,		  10,		  100.0d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[100.0d,	  1.0,		   0.0,		 1.0,		  0,		  100.0d],
			[100.0d,	  1.0,		   0.0,		 1.0,		  1,		  99.99d],
			[100.0d,	  1.0,		   0.0,		 1.0,		  10,		  99.89537787458879d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[100.0d,	  1.0,		   0.0,		 10.0,		  0,		  100.0d],
			[100.0d,	  1.0,		   0.0,		 10.0,		  1,		  99.9d],
			[100.0d,	  1.0,		   0.0,		 10.0,		  10,		  98.95377874588796d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[100.0d,	  1.0,		   1.0,		 0.0,		  0,		  100.0d],
			[100.0d,	  1.0,		   1.0,		 0.0,		  1,		  99.99d],
			[100.0d,	  1.0,		   1.0,		 0.0,		  10,		  99.89537787458879d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[100.0d,	  1.0,		   1.0,		 1.0,		  0,		  100.0d],
			[100.0d,	  1.0,		   1.0,		 1.0,		  1,		  99.98d],
			[100.0d,	  1.0,		   1.0,		 1.0,		  10,		  99.79075574917759d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[100.0d,	  1.0,		   1.0,		 10.0,		  0,		  100.0d],
			[100.0d,	  1.0,		   1.0,		 10.0,		  1,		  99.89d],
			[100.0d,	  1.0,		   1.0,		 10.0,		  10,		  98.84915662047675d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[100.0d,	  1.0,		   10.0,		 0.0,		  0,		  100.0d],
			[100.0d,	  1.0,		   10.0,		 0.0,		  1,		  99.9d],
			[100.0d,	  1.0,		   10.0,		 0.0,		  10,		  98.95377874588796d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[100.0d,	  1.0,		   10.0,		 1.0,		  0,		  100.0d],
			[100.0d,	  1.0,		   10.0,		 1.0,		  1,		  99.89d],
			[100.0d,	  1.0,		   10.0,		 1.0,		  10,		  98.84915662047675d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[100.0d,	  1.0,		   10.0,		 10.0,		  0,		  100.0d],
			[100.0d,	  1.0,		   10.0,		 10.0,		  1,		  99.8d],
			[100.0d,	  1.0,		   10.0,		 10.0,		  10,		  97.9075574917759d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[100.0d,	  10.0,		   0.0,		 0.0,		  0,		  100.0d],
			[100.0d,	  10.0,		   0.0,		 0.0,		  1,		  100.0d],
			[100.0d,	  10.0,		   0.0,		 0.0,		  10,		  100.0d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[100.0d,	  10.0,		   0.0,		 1.0,		  0,		  100.0d],
			[100.0d,	  10.0,		   0.0,		 1.0,		  1,		  99.99d],
			[100.0d,	  10.0,		   0.0,		 1.0,		  10,		  99.84062575399d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[100.0d,	  10.0,		   0.0,		 10.0,		  0,		  100.0d],
			[100.0d,	  10.0,		   0.0,		 10.0,		  1,		  99.9d],
			[100.0d,	  10.0,		   0.0,		 10.0,		  10,		  98.4062575399d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[100.0d,	  10.0,		   1.0,		 0.0,		  0,		  100.0d],
			[100.0d,	  10.0,		   1.0,		 0.0,		  1,		  99.99d],
			[100.0d,	  10.0,		   1.0,		 0.0,		  10,		  99.84062575399d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[100.0d,	  10.0,		   1.0,		 1.0,		  0,		  100.0d],
			[100.0d,	  10.0,		   1.0,		 1.0,		  1,		  99.98d],
			[100.0d,	  10.0,		   1.0,		 1.0,		  10,		  99.68125150798d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[100.0d,	  10.0,		   1.0,		 10.0,		  0,		  100.0d],
			[100.0d,	  10.0,		   1.0,		 10.0,		  1,		  99.89d],
			[100.0d,	  10.0,		   1.0,		 10.0,		  10,		  98.24688329389d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[100.0d,	  10.0,		   10.0,		 0.0,		  0,		  100.0d],
			[100.0d,	  10.0,		   10.0,		 0.0,		  1,		  99.9d],
			[100.0d,	  10.0,		   10.0,		 0.0,		  10,		  98.4062575399d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[100.0d,	  10.0,		   10.0,		 1.0,		  0,		  100.0d],
			[100.0d,	  10.0,		   10.0,		 1.0,		  1,		  99.89d],
			[100.0d,	  10.0,		   10.0,		 1.0,		  10,		  98.24688329389d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[100.0d,	  10.0,		   10.0,		 10.0,		  0,		  100.0d],
			[100.0d,	  10.0,		   10.0,		 10.0,		  1,		  99.8d],
			[100.0d,	  10.0,		   10.0,		 10.0,		  10,		  96.8125150798d],

			

		]*.toArray()
	}

	
	@Test
	public void testAccumulationFactorByYearsAndInterest() {
		assertThat(AnnuityCalculator.calculateRestLoanInYear(capital, interest, redemption, specialRedemption, endOfYear)).isCloseTo(expected, offset(0.001d))
	}

}
