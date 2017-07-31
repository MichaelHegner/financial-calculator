package net.hemisoft.financial.calculator.library.utils

class DeprecationCalculator {
	static double linearDeprecationByInterest(double capital, double interest) {
		BasicCalculator.calculateInterestOfAmount(capital, interest);
	}
	
	static double linearDeprecationByYear(double capital, int year) {
		year == 0 ? capital : capital / year;
	}
	
	private DeprecationCalculator(){}

}
