package net.hemisoft.financial.calculator.library.utils

class BasicCalculator {
	
	/**
	 * Calculates the Interest of an amount as absolute value.
	 * @param K as capital
	 * @param z as interest
	 * @param t as year
	 * @param interval the interval of years for the next interest increase.
	 * @return returns the interest as absolute value.
	 */
	static double calculateInterestOfAmountWithInterval(double capital, double interest, int time, int interval) {
		if(interval <= 0) throw new IllegalArgumentException("Interval must be greater or equal 0")
		int tInterval = time %  interval == 0 ? time :  time - time %  interval
		capital * accumulationFactorByYearsAndInterest(tInterval, interest)
	}
	
	/**
	 * Calculates the Interest of an amount as absolute value.
	 * @param K as capital
	 * @param z as interest
	 * @return returns the interest as absolute value.
	 */
	static double calculateInterestOfAmount(double capital, double interest) {
		capital * interestToQuote(interest)
	}

	/**
	 * Calculates the Accumulation Factor(german: Aufzinsungsfaktor)
	 * @param years to accumulate
	 * @param interest to accumulate
	 * @return the accumulation quote
	 */
	static double accumulationFactorByYearsAndInterest(int years, double interest) {
		Math.pow(1 + interestToQuote(interest), years)
	}
	
	/**
	 * Calculates the Inverse of given interest => the year
	 * @param interest reducing the capital
	 * @return the reverse if interest
	 */
	static double calculateInverse(double interest) {
		1 / interestToQuote(interest)
	}
	
	/**
	 * Calculates the interest of given year
	 * @param year number of year till redemption
	 * @return the calculated interest
	 */
	static double calculateYearToInterest(int year) {
		if(year == 0) throw new IllegalArgumentException("Year must be not equal 0")
		100 / year
	}
	
	/**
	 * Converts a value as quote, e.g. 20 (%) to 0.2
	 * @param interest
	 * @return
	 */
	static double interestToQuote(double interest) {
		interest / 100
	}
	
	private BasicCalculator() {}
}
