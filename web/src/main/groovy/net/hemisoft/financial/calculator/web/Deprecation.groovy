package net.hemisoft.financial.calculator.web

import javax.validation.constraints.AssertTrue
import javax.validation.constraints.Digits
import javax.validation.constraints.NotNull

class Deprecation {
	Long id;
	
	@Digits(integer=10, fraction=0)
	@NotNull(message = "Capital is required.")
	BigDecimal capital;

	@Digits(integer=10, fraction=0)
	BigDecimal interest;
	
	@Digits(integer=10, fraction=0)
	BigInteger year;
	
	final Date created = new Date();
	
	@AssertTrue(message = "Interest or Year is required.")
	boolean isInterestOrYear() {
		null != interest || year != null
	}
}
