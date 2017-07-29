package net.hemisoft.financial.calculator.library.utils

class AnnuityCalculator {
	
	/**
	 * Calculates the redemption at the end of the given year
	 * @param captial as e.g. loan
	 * @param interest to pay for the loan (e.g. 4%).
	 * @param redemptionAtBegin redemption reducing the loan (e.g. 4%).
	 * @param specialRedemption also reducing loan by free will (e.g. 4%).
	 * @param endOfYear the end of the year to calculate the rest of the capital
	 * @return the redemption at the end of the given year.
	 */
	static double calculateRedemptionAfterYear(double capital, double interest, double redemptionAtBegin, double specialRedemption = 0, int endOfYear = 1) {
		def annuity = calculateAnnuityInYear(capital, interest , redemptionAtBegin + specialRedemption)
		def interestInYear = calculateInterestInYear(capital, interest, redemptionAtBegin, specialRedemption, endOfYear)
		annuity - interestInYear;
	}
	
	/**
	 * Calculates the interest in the given year p.a.
	 * @param captial as e.g. loan
	 * @param t the year to calculate
	 * @param n complete time loan running in years
	 * @param z as percent like 2.2%
	 * @return the interest to pay in the given year.
	 */
	static double calculateInterestAfterYear(double captial, int time, double timeN, double interest) {
		def q = 1 + (interest / 100); // TODO: Use Basic Calculator
		def qn = BasicCalculator.accumulationFactorByYearsAndInterest(timeN + 1, interest)
		def qt = BasicCalculator.accumulationFactorByYearsAndInterest(time, interest)
		Math.max(captial * ( (qn - qt) * (q - 1) ) / ( qn - 1 ), 0)
	}
	
	/**
	 * Calculates the intestest at the end of the given year
	 * @param captial as e.g. loan
	 * @param interest to pay for the loan (e.g. 4%).
	 * @param redemption redemption reducing the loan (e.g. 4%).
	 * @param specialRedemption also reducing loan by free will (e.g. 4%).
	 * @param endOfYear the end of the year to calculate the rest of the loan
	 * @return the interest at the end of the given year.
	 */
	static double calculateInterestInYear(double captial, double interest, double redemption, double specialRedemption = 0, int endOfYear = 1) {
		def restLoan = calculateRestLoanInYear(captial, interest, redemption, specialRedemption, endOfYear)
		BasicCalculator.calculateInterestOfAmount(restLoan, interest)
	}
	
	/**
	 * Calculates the rest loan at the end of the given year.
	 * @param captial as e.g. loan
	 * @param interest to pay for the loan (e.g. 4%).
	 * @param redemption redemption reducing the loan (e.g. 4%).
	 * @param specialRedemption also reducing loan by free will (e.g. 4%).
	 * @param endOfYear the end of the year to calculate the rest of the loan
	 * @return the rest loan at the end of the given year.
	 */
	static double calculateRestLoanInYear(double captial, double interest, double redemption, double specialRedemption = 0, int endOfYear = 1) {
		def redemptionOfFirstYear = calculateRedemptionAmountOfFirstYear(captial, interest, redemption)
		def T1 = redemptionOfFirstYear + calculateSpecialRedemptionInYear(captial, specialRedemption)
		def qPowN = BasicCalculator.accumulationFactorByYearsAndInterest(endOfYear, interest)
		Math.max(captial - ( T1 * (qPowN - 1) ) / ( interest ), 0)
	}
	
	//
	
	/**
	 * Calculates the special redemption (german: Sondertilgung) as amount in the year.
	 * @param captial as e.g. loan
	 * @param specialRedemption as special redemption in % (e.g. 4%)
	 * @return the special redemption as amount in the year.
	 */
	static double calculateSpecialRedemptionInYear(double capital, double specialRedemption = 0) {
		BasicCalculator.calculateInterestOfAmount(capital, specialRedemption)
	}
	
	/**
	 * Calculates the annuity (german: Annuität) as amount in the year.
	 * @param captial as e.g. loan
	 * @param iterest in % (e.g. 4% interest)
	 * @param redemption in % (e.g. 4% redemption)
	 * @return the annuity of the year as amount.
	 */
	static double calculateAnnuityInYear(double capital, double interest, double redemption) {
		BasicCalculator.calculateInterestOfAmount(capital, interest + redemption)
	}
	
	//
	
	/**
	 * Calculates the redemption (german: Tilgung) of the first year as amount.
	 * @param captial as e.g. loan
	 * @param interest in % (e.g. 4% interest)
	 * @param redemption in % (e.g. 4% redemption)
	 * @return the redemption of the first year as amount.
	 */
	static double calculateRedemptionAmountOfFirstYear(double capital, double interest, double redemption) {
		calculateAnnuityInYear(capital, interest, redemption) - calculateInterestAmountOfFirstYear(capital, interest)
	}
	
	/**
	 * Calculates the Interest in the first year as absolute amount
	 * @param captial as e.g. loan
	 * @param interest in % (e.g. 2%)
	 * @return the amount of the interest in the first year
	 */
	static double calculateInterestAmountOfFirstYear(double captial, double interest) {
		BasicCalculator.calculateInterestOfAmount(captial, interest)
	}
	
	private AnnuityCalculator() {}
}
