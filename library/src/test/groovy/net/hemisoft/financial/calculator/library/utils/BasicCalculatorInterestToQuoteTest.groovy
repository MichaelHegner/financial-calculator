package net.hemisoft.financial.calculator.library.utils

import static org.assertj.core.api.Assertions.assertThat
import static org.junit.Assert.*

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import org.junit.runners.Parameterized.Parameters

@RunWith(Parameterized.class)
class BasicCalculatorInterestToQuoteTest {
	def interest, expected
	
	
	public BasicCalculatorInterestToQuoteTest(interest, expected) {
		this.interest = interest
		this.expected = expected
	}

	@Parameters static cases() {
		[
		    [-100, -1],
			[-1, -0.01d],
		    [0, 0],
		    [1, 0.01d],
		    [100, 1],
		]*.toArray()
	}

	@Test
	public void testInterestToQuote() {
		assertThat(BasicCalculator.interestToQuote(interest)).isEqualTo(expected);
	}
}
