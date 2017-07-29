package net.hemisoft.financial.calculator.library;

import java.util.Arrays;
import java.util.List;

import net.hemisoft.financial.calculator.library.utils.AnnuityCalculator;

public class TestGenerator {
	static double[] captials = {-100, -1, 0, 1, 100};
	static double[] interests = {1, 10};
	static double[] redemptions = {0, 1, 10};
	static double[] specialRedemptions  = {0, 1, 10};
	static int[] endOfYears  = {0, 1, 10};
	static int[] time = {0, 1, 10};
	static int[] timeN = {0, 1, 10};
	
	
	public static void main(String... args) {
		
		annuityCalculateRedemptionAfterYear();
		
	}



	private static void annuityCalculateRedemptionAfterYear() {
		for(int c = 0; c < captials.length; c++) {
			for(int i = 0; i < interests.length; i++) {
				for(int r = 0; r < redemptions.length; r++) {
					for(int s = 0; s < specialRedemptions.length; s++) {
						System.out.println("// CAPITAL\tINTEREST\tREDEMPTION\tSPECIAL_REDEMPTION\tEND_OF_YEAR\tEXPECTED");
						for(int e = 0; e < endOfYears.length; e++) {
							double result = AnnuityCalculator.calculateRedemptionAfterYear(captials[c], interests[i], redemptions[r], specialRedemptions[s], endOfYears[e]);
							System.out.println("[" + captials[c] + "d,\t  " + interests[i] + ",\t\t   " + redemptions[r] + ",\t\t " + specialRedemptions[s] + ",\t\t  " + endOfYears[e] + ",\t\t  " + result + "d],");
						}
						System.out.println();
					}
				}
			}
		}
	}



	private static void annuityCalculateInterestAfterYear() {
		for(int c = 0; c < captials.length; c++) {
			for(int i = 0; i < interests.length; i++) {
				for(int t = 0; t < time.length; t++) {
					System.out.println("// CAPITAL\tINTEREST\tTIME\tTIME_N\tEXPECTED");
					for(int tn = 0; tn < timeN.length; tn++) {
						if(timeN[tn] >= time[t]) {
						double result = AnnuityCalculator.calculateInterestAfterYear(captials[c], interests[i], time[t], timeN[tn]);
						System.out.println("[" + captials[c] + "d,\t  " + interests[i] + ",\t\t   " + time[t] + ",\t\t " + timeN[tn] + ",\t\t  " + result + "d],");
						}
					}
					System.out.println();
				}
			}
		}
	}



	private static void annuityCalculatorCalculateRestLoanInYearTest() {
		for(int c = 0; c < captials.length; c++) {
			for(int i = 0; i < interests.length; i++) {
				for(int r = 0; r < redemptions.length; r++) {
					for(int s = 0; s < specialRedemptions.length; s++) {
						System.out.println("// CAPITAL\tINTEREST\tREDEMPTION\tSPECIAL_REDEMPTION\tEND_OF_YEAR\tEXPECTED");
						for(int e = 0; e < endOfYears.length; e++) {
							double result = AnnuityCalculator.calculateRestLoanInYear(captials[c], interests[i], redemptions[r], specialRedemptions[s], endOfYears[e]);
							System.out.println("[" + captials[c] + "d,\t  " + interests[i] + ",\t\t   " + redemptions[r] + ",\t\t " + specialRedemptions[s] + ",\t\t  " + endOfYears[e] + ",\t\t  " + result + "d],");
						}
						System.out.println();
					}
				}
			}
		}
	}
	

	private static void annuityCalculatorCalculateInterestInYear() {
		for(int c = 0; c < captials.length; c++) {
			for(int i = 0; i < interests.length; i++) {
				for(int r = 0; r < redemptions.length; r++) {
					for(int s = 0; s < specialRedemptions.length; s++) {
						System.out.println("// CAPITAL\tINTEREST\tREDEMPTION\tSPECIAL_REDEMPTION\tEND_OF_YEAR\tEXPECTED");
						for(int e = 0; e < endOfYears.length; e++) {
							double result = AnnuityCalculator.calculateInterestInYear(captials[c], interests[i], redemptions[r], specialRedemptions[s], endOfYears[e]);
							System.out.println("[" + captials[c] + "d,\t  " + interests[i] + ",\t\t   " + redemptions[r] + ",\t\t " + specialRedemptions[s] + ",\t\t  " + endOfYears[e] + ",\t\t  " + result + "d],");
						}
						System.out.println();
					}
				}
			}
		}
	}
	
}
