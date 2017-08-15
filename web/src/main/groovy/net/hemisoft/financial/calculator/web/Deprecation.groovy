package net.hemisoft.financial.calculator.web

import javax.validation.constraints.Digits
import javax.validation.constraints.NotNull

import org.hibernate.validator.constraints.NotEmpty

import groovy.transform.Immutable
import lombok.Getter
import lombok.NonNull

//@Immutable
class Deprecation {
	private Long id;
	
//	@Digits(integer=10, fraction=0)
	@NotNull(message = "Capital is required.")
	private BigDecimal capital;

//	@Digits(integer=10, fraction=0)
	@NotNull(message = "Interest is required.")
	private BigDecimal interest;
	
	private Date created = new Date();

	
	//
	
	
	
	public void setId(Long id) {
		this.id = id;
	}

	public void setCapital(BigDecimal capital) {
		this.capital = capital;
	}
	
	public void setInterest(BigDecimal interest) {
		this.interest = interest;
	}
	
}
