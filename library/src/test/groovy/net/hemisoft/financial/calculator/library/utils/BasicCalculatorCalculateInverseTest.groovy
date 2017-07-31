package net.hemisoft.financial.calculator.library.utils

import static org.assertj.core.api.Assertions.assertThat
import static org.junit.Assert.*

import java.awt.geom.Point2D.Double

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import org.junit.runners.Parameterized.Parameters

@RunWith(Parameterized.class)
class BasicCalculatorCalculateInverseTest {
	def interest, expected
	
	
	public BasicCalculatorCalculateInverseTest(interest, expected) {
		this.interest = interest
		this.expected = expected
	}

	@Parameters static cases() {
		[
		    [-5, 	   -20],
			[-1, 	  -100],
		    [0, 	  null], // INFINITE
		    [1, 	   100],
		    [5, 		20],
		]*.toArray()
	}

	@Test
	public void testInterestToQuote() {
		if(0 == interest)
			assert BasicCalculator.calculateInverse(interest).infinite
		else
			assert BasicCalculator.calculateInverse(interest) == expected
	}
}
