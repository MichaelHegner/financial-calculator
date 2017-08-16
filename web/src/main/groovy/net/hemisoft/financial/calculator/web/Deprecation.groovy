package net.hemisoft.financial.calculator.web

import javax.validation.constraints.Digits
import javax.validation.constraints.NotNull

import org.hibernate.validator.constraints.NotEmpty

import groovy.transform.Immutable
import lombok.Getter
import lombok.NonNull
import lombok.Setter

@Setter
class Deprecation {
	Long id;
	
	@Digits(integer=10, fraction=0)
	@NotNull(message = "Capital is required.")
	BigDecimal capital;

	@Digits(integer=10, fraction=0)
	@NotNull(message = "Interest is required.")
	BigDecimal interest;
	
	final Date created = new Date();
}
