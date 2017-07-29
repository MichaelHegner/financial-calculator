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
class AnnuityCalculatorCalculateRedemptionAfterYearTest {
	def capital, interest, redemption, specialRedemption, endOfYear, expected
	
	
	public AnnuityCalculatorCalculateRedemptionAfterYearTest(capital, interest, redemption, specialRedemption, endOfYear, expected) {
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
			[-100.0d,	  1.0,		   0.0,		 0.0,		  0,		  -1.0d],
			[-100.0d,	  1.0,		   0.0,		 0.0,		  1,		  -1.0d],
			[-100.0d,	  1.0,		   0.0,		 0.0,		  10,		  -1.0d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[-100.0d,	  1.0,		   0.0,		 1.0,		  0,		  -2.0d],
			[-100.0d,	  1.0,		   0.0,		 1.0,		  1,		  -2.0d],
			[-100.0d,	  1.0,		   0.0,		 1.0,		  10,		  -2.0d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[-100.0d,	  1.0,		   0.0,		 10.0,		  0,		  -11.0d],
			[-100.0d,	  1.0,		   0.0,		 10.0,		  1,		  -11.0d],
			[-100.0d,	  1.0,		   0.0,		 10.0,		  10,		  -11.0d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[-100.0d,	  1.0,		   1.0,		 0.0,		  0,		  -2.0d],
			[-100.0d,	  1.0,		   1.0,		 0.0,		  1,		  -2.0d],
			[-100.0d,	  1.0,		   1.0,		 0.0,		  10,		  -2.0d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[-100.0d,	  1.0,		   1.0,		 1.0,		  0,		  -3.0d],
			[-100.0d,	  1.0,		   1.0,		 1.0,		  1,		  -3.0d],
			[-100.0d,	  1.0,		   1.0,		 1.0,		  10,		  -3.0d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[-100.0d,	  1.0,		   1.0,		 10.0,		  0,		  -12.0d],
			[-100.0d,	  1.0,		   1.0,		 10.0,		  1,		  -12.0d],
			[-100.0d,	  1.0,		   1.0,		 10.0,		  10,		  -12.0d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[-100.0d,	  1.0,		   10.0,		 0.0,		  0,		  -11.0d],
			[-100.0d,	  1.0,		   10.0,		 0.0,		  1,		  -11.0d],
			[-100.0d,	  1.0,		   10.0,		 0.0,		  10,		  -11.0d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[-100.0d,	  1.0,		   10.0,		 1.0,		  0,		  -12.0d],
			[-100.0d,	  1.0,		   10.0,		 1.0,		  1,		  -12.0d],
			[-100.0d,	  1.0,		   10.0,		 1.0,		  10,		  -12.0d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[-100.0d,	  1.0,		   10.0,		 10.0,		  0,		  -21.0d],
			[-100.0d,	  1.0,		   10.0,		 10.0,		  1,		  -21.0d],
			[-100.0d,	  1.0,		   10.0,		 10.0,		  10,		  -21.0d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[-100.0d,	  10.0,		   0.0,		 0.0,		  0,		  -10.0d],
			[-100.0d,	  10.0,		   0.0,		 0.0,		  1,		  -10.0d],
			[-100.0d,	  10.0,		   0.0,		 0.0,		  10,		  -10.0d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[-100.0d,	  10.0,		   0.0,		 1.0,		  0,		  -11.0d],
			[-100.0d,	  10.0,		   0.0,		 1.0,		  1,		  -11.0d],
			[-100.0d,	  10.0,		   0.0,		 1.0,		  10,		  -11.0d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[-100.0d,	  10.0,		   0.0,		 10.0,		  0,		  -20.0d],
			[-100.0d,	  10.0,		   0.0,		 10.0,		  1,		  -20.0d],
			[-100.0d,	  10.0,		   0.0,		 10.0,		  10,		  -20.0d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[-100.0d,	  10.0,		   1.0,		 0.0,		  0,		  -11.0d],
			[-100.0d,	  10.0,		   1.0,		 0.0,		  1,		  -11.0d],
			[-100.0d,	  10.0,		   1.0,		 0.0,		  10,		  -11.0d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[-100.0d,	  10.0,		   1.0,		 1.0,		  0,		  -12.0d],
			[-100.0d,	  10.0,		   1.0,		 1.0,		  1,		  -12.0d],
			[-100.0d,	  10.0,		   1.0,		 1.0,		  10,		  -12.0d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[-100.0d,	  10.0,		   1.0,		 10.0,		  0,		  -21.0d],
			[-100.0d,	  10.0,		   1.0,		 10.0,		  1,		  -21.0d],
			[-100.0d,	  10.0,		   1.0,		 10.0,		  10,		  -21.0d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[-100.0d,	  10.0,		   10.0,		 0.0,		  0,		  -20.0d],
			[-100.0d,	  10.0,		   10.0,		 0.0,		  1,		  -20.0d],
			[-100.0d,	  10.0,		   10.0,		 0.0,		  10,		  -20.0d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[-100.0d,	  10.0,		   10.0,		 1.0,		  0,		  -21.0d],
			[-100.0d,	  10.0,		   10.0,		 1.0,		  1,		  -21.0d],
			[-100.0d,	  10.0,		   10.0,		 1.0,		  10,		  -21.0d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[-100.0d,	  10.0,		   10.0,		 10.0,		  0,		  -30.0d],
			[-100.0d,	  10.0,		   10.0,		 10.0,		  1,		  -30.0d],
			[-100.0d,	  10.0,		   10.0,		 10.0,		  10,		  -30.0d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[-1.0d,	  1.0,		   0.0,		 0.0,		  0,		  -0.01d],
			[-1.0d,	  1.0,		   0.0,		 0.0,		  1,		  -0.01d],
			[-1.0d,	  1.0,		   0.0,		 0.0,		  10,		  -0.01d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[-1.0d,	  1.0,		   0.0,		 1.0,		  0,		  -0.02d],
			[-1.0d,	  1.0,		   0.0,		 1.0,		  1,		  -0.02d],
			[-1.0d,	  1.0,		   0.0,		 1.0,		  10,		  -0.02d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[-1.0d,	  1.0,		   0.0,		 10.0,		  0,		  -0.11d],
			[-1.0d,	  1.0,		   0.0,		 10.0,		  1,		  -0.11d],
			[-1.0d,	  1.0,		   0.0,		 10.0,		  10,		  -0.11d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[-1.0d,	  1.0,		   1.0,		 0.0,		  0,		  -0.02d],
			[-1.0d,	  1.0,		   1.0,		 0.0,		  1,		  -0.02d],
			[-1.0d,	  1.0,		   1.0,		 0.0,		  10,		  -0.02d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[-1.0d,	  1.0,		   1.0,		 1.0,		  0,		  -0.03d],
			[-1.0d,	  1.0,		   1.0,		 1.0,		  1,		  -0.03d],
			[-1.0d,	  1.0,		   1.0,		 1.0,		  10,		  -0.03d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[-1.0d,	  1.0,		   1.0,		 10.0,		  0,		  -0.12d],
			[-1.0d,	  1.0,		   1.0,		 10.0,		  1,		  -0.12d],
			[-1.0d,	  1.0,		   1.0,		 10.0,		  10,		  -0.12d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[-1.0d,	  1.0,		   10.0,		 0.0,		  0,		  -0.11d],
			[-1.0d,	  1.0,		   10.0,		 0.0,		  1,		  -0.11d],
			[-1.0d,	  1.0,		   10.0,		 0.0,		  10,		  -0.11d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[-1.0d,	  1.0,		   10.0,		 1.0,		  0,		  -0.12d],
			[-1.0d,	  1.0,		   10.0,		 1.0,		  1,		  -0.12d],
			[-1.0d,	  1.0,		   10.0,		 1.0,		  10,		  -0.12d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[-1.0d,	  1.0,		   10.0,		 10.0,		  0,		  -0.21d],
			[-1.0d,	  1.0,		   10.0,		 10.0,		  1,		  -0.21d],
			[-1.0d,	  1.0,		   10.0,		 10.0,		  10,		  -0.21d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[-1.0d,	  10.0,		   0.0,		 0.0,		  0,		  -0.1d],
			[-1.0d,	  10.0,		   0.0,		 0.0,		  1,		  -0.1d],
			[-1.0d,	  10.0,		   0.0,		 0.0,		  10,		  -0.1d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[-1.0d,	  10.0,		   0.0,		 1.0,		  0,		  -0.11d],
			[-1.0d,	  10.0,		   0.0,		 1.0,		  1,		  -0.11d],
			[-1.0d,	  10.0,		   0.0,		 1.0,		  10,		  -0.11d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[-1.0d,	  10.0,		   0.0,		 10.0,		  0,		  -0.2d],
			[-1.0d,	  10.0,		   0.0,		 10.0,		  1,		  -0.2d],
			[-1.0d,	  10.0,		   0.0,		 10.0,		  10,		  -0.2d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[-1.0d,	  10.0,		   1.0,		 0.0,		  0,		  -0.11d],
			[-1.0d,	  10.0,		   1.0,		 0.0,		  1,		  -0.11d],
			[-1.0d,	  10.0,		   1.0,		 0.0,		  10,		  -0.11d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[-1.0d,	  10.0,		   1.0,		 1.0,		  0,		  -0.12d],
			[-1.0d,	  10.0,		   1.0,		 1.0,		  1,		  -0.12d],
			[-1.0d,	  10.0,		   1.0,		 1.0,		  10,		  -0.12d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[-1.0d,	  10.0,		   1.0,		 10.0,		  0,		  -0.21d],
			[-1.0d,	  10.0,		   1.0,		 10.0,		  1,		  -0.21d],
			[-1.0d,	  10.0,		   1.0,		 10.0,		  10,		  -0.21d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[-1.0d,	  10.0,		   10.0,		 0.0,		  0,		  -0.2d],
			[-1.0d,	  10.0,		   10.0,		 0.0,		  1,		  -0.2d],
			[-1.0d,	  10.0,		   10.0,		 0.0,		  10,		  -0.2d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[-1.0d,	  10.0,		   10.0,		 1.0,		  0,		  -0.21d],
			[-1.0d,	  10.0,		   10.0,		 1.0,		  1,		  -0.21d],
			[-1.0d,	  10.0,		   10.0,		 1.0,		  10,		  -0.21d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[-1.0d,	  10.0,		   10.0,		 10.0,		  0,		  -0.3d],
			[-1.0d,	  10.0,		   10.0,		 10.0,		  1,		  -0.3d],
			[-1.0d,	  10.0,		   10.0,		 10.0,		  10,		  -0.3d],
			
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
			[1.0d,	  1.0,		   0.0,		 0.0,		  0,		  0.0d],
			[1.0d,	  1.0,		   0.0,		 0.0,		  1,		  0.0d],
			[1.0d,	  1.0,		   0.0,		 0.0,		  10,		  0.0d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[1.0d,	  1.0,		   0.0,		 1.0,		  0,		  0.01d],
			[1.0d,	  1.0,		   0.0,		 1.0,		  1,		  0.010001d],
			[1.0d,	  1.0,		   0.0,		 1.0,		  10,		  0.01001046221254112d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[1.0d,	  1.0,		   0.0,		 10.0,		  0,		  0.1d],
			[1.0d,	  1.0,		   0.0,		 10.0,		  1,		  0.10001d],
			[1.0d,	  1.0,		   0.0,		 10.0,		  10,		  0.1001046221254112d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[1.0d,	  1.0,		   1.0,		 0.0,		  0,		  0.01d],
			[1.0d,	  1.0,		   1.0,		 0.0,		  1,		  0.010001d],
			[1.0d,	  1.0,		   1.0,		 0.0,		  10,		  0.01001046221254112d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[1.0d,	  1.0,		   1.0,		 1.0,		  0,		  0.019999999999999997d],
			[1.0d,	  1.0,		   1.0,		 1.0,		  1,		  0.020002d],
			[1.0d,	  1.0,		   1.0,		 1.0,		  10,		  0.02002092442508224d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[1.0d,	  1.0,		   1.0,		 10.0,		  0,		  0.11d],
			[1.0d,	  1.0,		   1.0,		 10.0,		  1,		  0.110011d],
			[1.0d,	  1.0,		   1.0,		 10.0,		  10,		  0.11011508433795232d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[1.0d,	  1.0,		   10.0,		 0.0,		  0,		  0.1d],
			[1.0d,	  1.0,		   10.0,		 0.0,		  1,		  0.10001d],
			[1.0d,	  1.0,		   10.0,		 0.0,		  10,		  0.1001046221254112d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[1.0d,	  1.0,		   10.0,		 1.0,		  0,		  0.11d],
			[1.0d,	  1.0,		   10.0,		 1.0,		  1,		  0.110011d],
			[1.0d,	  1.0,		   10.0,		 1.0,		  10,		  0.11011508433795232d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[1.0d,	  1.0,		   10.0,		 10.0,		  0,		  0.19999999999999998d],
			[1.0d,	  1.0,		   10.0,		 10.0,		  1,		  0.20002d],
			[1.0d,	  1.0,		   10.0,		 10.0,		  10,		  0.2002092442508224d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[1.0d,	  10.0,		   0.0,		 0.0,		  0,		  0.0d],
			[1.0d,	  10.0,		   0.0,		 0.0,		  1,		  0.0d],
			[1.0d,	  10.0,		   0.0,		 0.0,		  10,		  0.0d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[1.0d,	  10.0,		   0.0,		 1.0,		  0,		  0.009999999999999995d],
			[1.0d,	  10.0,		   0.0,		 1.0,		  1,		  0.010009999999999991d],
			[1.0d,	  10.0,		   0.0,		 1.0,		  10,		  0.010159374246010003d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[1.0d,	  10.0,		   0.0,		 10.0,		  0,		  0.1d],
			[1.0d,	  10.0,		   0.0,		 10.0,		  1,		  0.10010000000000001d],
			[1.0d,	  10.0,		   0.0,		 10.0,		  10,		  0.1015937424601d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[1.0d,	  10.0,		   1.0,		 0.0,		  0,		  0.009999999999999995d],
			[1.0d,	  10.0,		   1.0,		 0.0,		  1,		  0.010009999999999991d],
			[1.0d,	  10.0,		   1.0,		 0.0,		  10,		  0.010159374246010003d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[1.0d,	  10.0,		   1.0,		 1.0,		  0,		  0.01999999999999999d],
			[1.0d,	  10.0,		   1.0,		 1.0,		  1,		  0.020019999999999982d],
			[1.0d,	  10.0,		   1.0,		 1.0,		  10,		  0.020318748492019992d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[1.0d,	  10.0,		   1.0,		 10.0,		  0,		  0.10999999999999999d],
			[1.0d,	  10.0,		   1.0,		 10.0,		  1,		  0.11010999999999999d],
			[1.0d,	  10.0,		   1.0,		 10.0,		  10,		  0.11175311670610999d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[1.0d,	  10.0,		   10.0,		 0.0,		  0,		  0.1d],
			[1.0d,	  10.0,		   10.0,		 0.0,		  1,		  0.10010000000000001d],
			[1.0d,	  10.0,		   10.0,		 0.0,		  10,		  0.1015937424601d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[1.0d,	  10.0,		   10.0,		 1.0,		  0,		  0.10999999999999999d],
			[1.0d,	  10.0,		   10.0,		 1.0,		  1,		  0.11010999999999999d],
			[1.0d,	  10.0,		   10.0,		 1.0,		  10,		  0.11175311670610999d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[1.0d,	  10.0,		   10.0,		 10.0,		  0,		  0.19999999999999998d],
			[1.0d,	  10.0,		   10.0,		 10.0,		  1,		  0.2002d],
			[1.0d,	  10.0,		   10.0,		 10.0,		  10,		  0.2031874849202d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[100.0d,	  1.0,		   0.0,		 0.0,		  0,		  0.0d],
			[100.0d,	  1.0,		   0.0,		 0.0,		  1,		  0.0d],
			[100.0d,	  1.0,		   0.0,		 0.0,		  10,		  0.0d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[100.0d,	  1.0,		   0.0,		 1.0,		  0,		  1.0d],
			[100.0d,	  1.0,		   0.0,		 1.0,		  1,		  1.0001d],
			[100.0d,	  1.0,		   0.0,		 1.0,		  10,		  1.001046221254112d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[100.0d,	  1.0,		   0.0,		 10.0,		  0,		  10.0d],
			[100.0d,	  1.0,		   0.0,		 10.0,		  1,		  10.001d],
			[100.0d,	  1.0,		   0.0,		 10.0,		  10,		  10.010462212541121d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[100.0d,	  1.0,		   1.0,		 0.0,		  0,		  1.0d],
			[100.0d,	  1.0,		   1.0,		 0.0,		  1,		  1.0001d],
			[100.0d,	  1.0,		   1.0,		 0.0,		  10,		  1.001046221254112d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[100.0d,	  1.0,		   1.0,		 1.0,		  0,		  2.0d],
			[100.0d,	  1.0,		   1.0,		 1.0,		  1,		  2.0002d],
			[100.0d,	  1.0,		   1.0,		 1.0,		  10,		  2.002092442508224d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[100.0d,	  1.0,		   1.0,		 10.0,		  0,		  11.0d],
			[100.0d,	  1.0,		   1.0,		 10.0,		  1,		  11.0011d],
			[100.0d,	  1.0,		   1.0,		 10.0,		  10,		  11.011508433795232d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[100.0d,	  1.0,		   10.0,		 0.0,		  0,		  10.0d],
			[100.0d,	  1.0,		   10.0,		 0.0,		  1,		  10.001d],
			[100.0d,	  1.0,		   10.0,		 0.0,		  10,		  10.010462212541121d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[100.0d,	  1.0,		   10.0,		 1.0,		  0,		  11.0d],
			[100.0d,	  1.0,		   10.0,		 1.0,		  1,		  11.0011d],
			[100.0d,	  1.0,		   10.0,		 1.0,		  10,		  11.011508433795232d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[100.0d,	  1.0,		   10.0,		 10.0,		  0,		  20.0d],
			[100.0d,	  1.0,		   10.0,		 10.0,		  1,		  20.002d],
			[100.0d,	  1.0,		   10.0,		 10.0,		  10,		  20.020924425082242d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[100.0d,	  10.0,		   0.0,		 0.0,		  0,		  0.0d],
			[100.0d,	  10.0,		   0.0,		 0.0,		  1,		  0.0d],
			[100.0d,	  10.0,		   0.0,		 0.0,		  10,		  0.0d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[100.0d,	  10.0,		   0.0,		 1.0,		  0,		  1.0d],
			[100.0d,	  10.0,		   0.0,		 1.0,		  1,		  1.0009999999999994d],
			[100.0d,	  10.0,		   0.0,		 1.0,		  10,		  1.015937424600999d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[100.0d,	  10.0,		   0.0,		 10.0,		  0,		  10.0d],
			[100.0d,	  10.0,		   0.0,		 10.0,		  1,		  10.009999999999998d],
			[100.0d,	  10.0,		   0.0,		 10.0,		  10,		  10.15937424601d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[100.0d,	  10.0,		   1.0,		 0.0,		  0,		  1.0d],
			[100.0d,	  10.0,		   1.0,		 0.0,		  1,		  1.0009999999999994d],
			[100.0d,	  10.0,		   1.0,		 0.0,		  10,		  1.015937424600999d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[100.0d,	  10.0,		   1.0,		 1.0,		  0,		  2.0d],
			[100.0d,	  10.0,		   1.0,		 1.0,		  1,		  2.001999999999999d],
			[100.0d,	  10.0,		   1.0,		 1.0,		  10,		  2.0318748492019996d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[100.0d,	  10.0,		   1.0,		 10.0,		  0,		  11.0d],
			[100.0d,	  10.0,		   1.0,		 10.0,		  1,		  11.011d],
			[100.0d,	  10.0,		   1.0,		 10.0,		  10,		  11.175311670611d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[100.0d,	  10.0,		   10.0,		 0.0,		  0,		  10.0d],
			[100.0d,	  10.0,		   10.0,		 0.0,		  1,		  10.009999999999998d],
			[100.0d,	  10.0,		   10.0,		 0.0,		  10,		  10.15937424601d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[100.0d,	  10.0,		   10.0,		 1.0,		  0,		  11.0d],
			[100.0d,	  10.0,		   10.0,		 1.0,		  1,		  11.011d],
			[100.0d,	  10.0,		   10.0,		 1.0,		  10,		  11.175311670611d],
			
			// CAPITAL	INTEREST	REDEMPTION	SPECIAL_REDEMPTION	END_OF_YEAR	EXPECTED
			[100.0d,	  10.0,		   10.0,		 10.0,		  0,		  20.0d],
			[100.0d,	  10.0,		   10.0,		 10.0,		  1,		  20.02d],
			[100.0d,	  10.0,		   10.0,		 10.0,		  10,		  20.31874849202d],

		]*.toArray()
	}

	
	@Test
	public void testAccumulationFactorByYearsAndInterest() {
		assertThat(AnnuityCalculator.calculateRedemptionAfterYear(capital, interest, redemption, specialRedemption, endOfYear)).isCloseTo(expected, offset(0.001d))
	}

}
