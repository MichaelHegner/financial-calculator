package net.hemisoft.financial.calculator.library.utils

class DeprecationCalculator {
	
	static double calculateLinearDecliningBalanceAtEndOfYear(double capital, int time, int timeN) {
		assert time <= timeN
		calculateLinearDecliningBalanceAtBeginOfYear(capital, time + 1, timeN)
	}
	
	static double calculateLinearDecliningBalanceAtBeginOfYear(double capital, int time, int timeN) {
		assert time <= timeN
		def deprecation = calculateLinearDeprecationByYear(capital, timeN)
		def sumDeprecation = deprecation * time
		capital - sumDeprecation
	}
	
	
	static double calculateLinearDeprecationByInterest(double capital, double interest) {
		BasicCalculator.calculateInterestOfAmount(capital, interest);
	}
	
	static double calculateLinearDeprecationByYear(double capital, int year) {
		year == 0 ? capital : capital / year;
	}
	
	private DeprecationCalculator(){}

}
