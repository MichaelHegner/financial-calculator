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
class AnnuityCalculatorCalculateInterestInYearTest {
	def capital, interest, redemption, specialRedemption, endOfYear, expected
	
	
	public AnnuityCalculatorCalculateInterestInYearTest(capital, interest, redemption, specialRedemption, endOfYear, expected) {
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
			[1.0d,	  1.0,		   0.0,		 0.0,		  0,		  0.01d],
			[1.0d,	  1.0,		   0.0,		 0.0,		  1,		  0.01d],
			[1.0d,	  1.0,		   0.0,		 0.0,		  10,		  0.01d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[1.0d,	  1.0,		   0.0,		 1.0,		  0,		  0.01d],
			[1.0d,	  1.0,		   0.0,		 1.0,		  1,		  0.009999000000000001d],
			[1.0d,	  1.0,		   0.0,		 1.0,		  10,		  0.00998953778745888d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[1.0d,	  1.0,		   0.0,		 10.0,		  0,		  0.01d],
			[1.0d,	  1.0,		   0.0,		 10.0,		  1,		  0.00999d],
			[1.0d,	  1.0,		   0.0,		 10.0,		  10,		  0.009895377874588796d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[1.0d,	  1.0,		   1.0,		 0.0,		  0,		  0.01d],
			[1.0d,	  1.0,		   1.0,		 0.0,		  1,		  0.009999000000000001d],
			[1.0d,	  1.0,		   1.0,		 0.0,		  10,		  0.00998953778745888d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[1.0d,	  1.0,		   1.0,		 1.0,		  0,		  0.01d],
			[1.0d,	  1.0,		   1.0,		 1.0,		  1,		  0.009998d],
			[1.0d,	  1.0,		   1.0,		 1.0,		  10,		  0.00997907557491776d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[1.0d,	  1.0,		   1.0,		 10.0,		  0,		  0.01d],
			[1.0d,	  1.0,		   1.0,		 10.0,		  1,		  0.009989d],
			[1.0d,	  1.0,		   1.0,		 10.0,		  10,		  0.009884915662047675d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[1.0d,	  1.0,		   10.0,		 0.0,		  0,		  0.01d],
			[1.0d,	  1.0,		   10.0,		 0.0,		  1,		  0.00999d],
			[1.0d,	  1.0,		   10.0,		 0.0,		  10,		  0.009895377874588796d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[1.0d,	  1.0,		   10.0,		 1.0,		  0,		  0.01d],
			[1.0d,	  1.0,		   10.0,		 1.0,		  1,		  0.009989d],
			[1.0d,	  1.0,		   10.0,		 1.0,		  10,		  0.009884915662047675d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[1.0d,	  1.0,		   10.0,		 10.0,		  0,		  0.01d],
			[1.0d,	  1.0,		   10.0,		 10.0,		  1,		  0.009980000000000001d],
			[1.0d,	  1.0,		   10.0,		 10.0,		  10,		  0.009790755749177591d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[1.0d,	  10.0,		   0.0,		 0.0,		  0,		  0.1d],
			[1.0d,	  10.0,		   0.0,		 0.0,		  1,		  0.1d],
			[1.0d,	  10.0,		   0.0,		 0.0,		  10,		  0.1d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[1.0d,	  10.0,		   0.0,		 1.0,		  0,		  0.1d],
			[1.0d,	  10.0,		   0.0,		 1.0,		  1,		  0.09999000000000001d],
			[1.0d,	  10.0,		   0.0,		 1.0,		  10,		  0.09984062575399d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[1.0d,	  10.0,		   0.0,		 10.0,		  0,		  0.1d],
			[1.0d,	  10.0,		   0.0,		 10.0,		  1,		  0.0999d],
			[1.0d,	  10.0,		   0.0,		 10.0,		  10,		  0.09840625753990001d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[1.0d,	  10.0,		   1.0,		 0.0,		  0,		  0.1d],
			[1.0d,	  10.0,		   1.0,		 0.0,		  1,		  0.09999000000000001d],
			[1.0d,	  10.0,		   1.0,		 0.0,		  10,		  0.09984062575399d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[1.0d,	  10.0,		   1.0,		 1.0,		  0,		  0.1d],
			[1.0d,	  10.0,		   1.0,		 1.0,		  1,		  0.09998000000000001d],
			[1.0d,	  10.0,		   1.0,		 1.0,		  10,		  0.09968125150798d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[1.0d,	  10.0,		   1.0,		 10.0,		  0,		  0.1d],
			[1.0d,	  10.0,		   1.0,		 10.0,		  1,		  0.09989d],
			[1.0d,	  10.0,		   1.0,		 10.0,		  10,		  0.09824688329389d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[1.0d,	  10.0,		   10.0,		 0.0,		  0,		  0.1d],
			[1.0d,	  10.0,		   10.0,		 0.0,		  1,		  0.0999d],
			[1.0d,	  10.0,		   10.0,		 0.0,		  10,		  0.09840625753990001d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[1.0d,	  10.0,		   10.0,		 1.0,		  0,		  0.1d],
			[1.0d,	  10.0,		   10.0,		 1.0,		  1,		  0.09989d],
			[1.0d,	  10.0,		   10.0,		 1.0,		  10,		  0.09824688329389d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[1.0d,	  10.0,		   10.0,		 10.0,		  0,		  0.1d],
			[1.0d,	  10.0,		   10.0,		 10.0,		  1,		  0.0998d],
			[1.0d,	  10.0,		   10.0,		 10.0,		  10,		  0.0968125150798d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[100.0d,	  1.0,		   0.0,		 0.0,		  0,		  1.0d],
			[100.0d,	  1.0,		   0.0,		 0.0,		  1,		  1.0d],
			[100.0d,	  1.0,		   0.0,		 0.0,		  10,		  1.0d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[100.0d,	  1.0,		   0.0,		 1.0,		  0,		  1.0d],
			[100.0d,	  1.0,		   0.0,		 1.0,		  1,		  0.9999d],
			[100.0d,	  1.0,		   0.0,		 1.0,		  10,		  0.9989537787458879d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[100.0d,	  1.0,		   0.0,		 10.0,		  0,		  1.0d],
			[100.0d,	  1.0,		   0.0,		 10.0,		  1,		  0.9990000000000001d],
			[100.0d,	  1.0,		   0.0,		 10.0,		  10,		  0.9895377874588797d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[100.0d,	  1.0,		   1.0,		 0.0,		  0,		  1.0d],
			[100.0d,	  1.0,		   1.0,		 0.0,		  1,		  0.9999d],
			[100.0d,	  1.0,		   1.0,		 0.0,		  10,		  0.9989537787458879d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[100.0d,	  1.0,		   1.0,		 1.0,		  0,		  1.0d],
			[100.0d,	  1.0,		   1.0,		 1.0,		  1,		  0.9998d],
			[100.0d,	  1.0,		   1.0,		 1.0,		  10,		  0.997907557491776d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[100.0d,	  1.0,		   1.0,		 10.0,		  0,		  1.0d],
			[100.0d,	  1.0,		   1.0,		 10.0,		  1,		  0.9989d],
			[100.0d,	  1.0,		   1.0,		 10.0,		  10,		  0.9884915662047675d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[100.0d,	  1.0,		   10.0,		 0.0,		  0,		  1.0d],
			[100.0d,	  1.0,		   10.0,		 0.0,		  1,		  0.9990000000000001d],
			[100.0d,	  1.0,		   10.0,		 0.0,		  10,		  0.9895377874588797d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[100.0d,	  1.0,		   10.0,		 1.0,		  0,		  1.0d],
			[100.0d,	  1.0,		   10.0,		 1.0,		  1,		  0.9989d],
			[100.0d,	  1.0,		   10.0,		 1.0,		  10,		  0.9884915662047675d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[100.0d,	  1.0,		   10.0,		 10.0,		  0,		  1.0d],
			[100.0d,	  1.0,		   10.0,		 10.0,		  1,		  0.998d],
			[100.0d,	  1.0,		   10.0,		 10.0,		  10,		  0.9790755749177591d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[100.0d,	  10.0,		   0.0,		 0.0,		  0,		  10.0d],
			[100.0d,	  10.0,		   0.0,		 0.0,		  1,		  10.0d],
			[100.0d,	  10.0,		   0.0,		 0.0,		  10,		  10.0d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[100.0d,	  10.0,		   0.0,		 1.0,		  0,		  10.0d],
			[100.0d,	  10.0,		   0.0,		 1.0,		  1,		  9.999d],
			[100.0d,	  10.0,		   0.0,		 1.0,		  10,		  9.984062575399001d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[100.0d,	  10.0,		   0.0,		 10.0,		  0,		  10.0d],
			[100.0d,	  10.0,		   0.0,		 10.0,		  1,		  9.990000000000002d],
			[100.0d,	  10.0,		   0.0,		 10.0,		  10,		  9.84062575399d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[100.0d,	  10.0,		   1.0,		 0.0,		  0,		  10.0d],
			[100.0d,	  10.0,		   1.0,		 0.0,		  1,		  9.999d],
			[100.0d,	  10.0,		   1.0,		 0.0,		  10,		  9.984062575399001d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[100.0d,	  10.0,		   1.0,		 1.0,		  0,		  10.0d],
			[100.0d,	  10.0,		   1.0,		 1.0,		  1,		  9.998000000000001d],
			[100.0d,	  10.0,		   1.0,		 1.0,		  10,		  9.968125150798d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[100.0d,	  10.0,		   1.0,		 10.0,		  0,		  10.0d],
			[100.0d,	  10.0,		   1.0,		 10.0,		  1,		  9.989d],
			[100.0d,	  10.0,		   1.0,		 10.0,		  10,		  9.824688329389d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[100.0d,	  10.0,		   10.0,		 0.0,		  0,		  10.0d],
			[100.0d,	  10.0,		   10.0,		 0.0,		  1,		  9.990000000000002d],
			[100.0d,	  10.0,		   10.0,		 0.0,		  10,		  9.84062575399d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[100.0d,	  10.0,		   10.0,		 1.0,		  0,		  10.0d],
			[100.0d,	  10.0,		   10.0,		 1.0,		  1,		  9.989d],
			[100.0d,	  10.0,		   10.0,		 1.0,		  10,		  9.824688329389d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[100.0d,	  10.0,		   10.0,		 10.0,		  0,		  10.0d],
			[100.0d,	  10.0,		   10.0,		 10.0,		  1,		  9.98d],
			[100.0d,	  10.0,		   10.0,		 10.0,		  10,		  9.68125150798d],
			

		]*.toArray()
	}

	
	@Test
	public void testAccumulationFactorByYearsAndInterest() {
		assertThat(AnnuityCalculator.calculateInterestInYear(capital, interest, redemption, specialRedemption, endOfYear)).isCloseTo(expected, offset(0.001d))
	}

}
