package net.hemisoft.financial.calculator.library.utils

import java.io.ObjectInputStream.BlockDataInputStream
import java.util.Map
import java.time.*

class DeprecationPlan {
	static final String YEAR = "YEAR"
	static final String DECLINING_BALANCE_BEGIN_OF_YEAR = "DECLINING_BALANCE_BEGIN_OF_YEAR"
	static final String DEPRECATION = "DEPRECATION"
	static final String DECLINING_BALANCE_END_OF_YEAR = "DECLINING_BALANCE_END_OF_YEAR"
	
	static Map<Integer, Map<String, Double>> generateLinearDeprecationPlanByInterest(double capital, double interest) {
		int timeN = BasicCalculator.calculateInverse(interest)
		def deprecation = DeprecationCalculator.calculateLinearDeprecationByInterest(capital, interest)
		
		Map<Integer, Map<String, Double>> resultMap = new HashMap<>()
		for (int timeCounter = 0; timeCounter < timeN; timeCounter++) {
			def balanceAtBegin = DeprecationCalculator.calculateLinearDecliningBalanceAtBeginOfYear(capital, timeCounter, timeN)
			def balanceAtEnd = DeprecationCalculator.calculateLinearDecliningBalanceAtEndOfYear(capital, timeCounter, timeN)
			
			def deprecationRow = [:]
			deprecationRow.YEAR = timeCounter + LocalDate.now().year
			deprecationRow.DECLINING_BALANCE_BEGIN_OF_YEAR = balanceAtBegin
			deprecationRow.DEPRECATION =deprecation
			deprecationRow.DECLINING_BALANCE_END_OF_YEAR = balanceAtEnd
			
			resultMap.put(timeCounter + LocalDate.now().year, deprecationRow)
		}
		
		resultMap
	}
}
