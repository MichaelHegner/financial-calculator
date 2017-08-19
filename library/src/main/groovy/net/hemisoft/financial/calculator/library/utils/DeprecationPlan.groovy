package net.hemisoft.financial.calculator.library.utils

import java.io.ObjectInputStream.BlockDataInputStream
import java.util.Map
import java.time.*

class DeprecationPlan {
	static final String YEAR = "YEAR"
	static final String DECLINING_BALANCE_BEGIN_OF_YEAR = "DECLINING_BALANCE_BEGIN_OF_YEAR"
	static final String DEPRECATION = "DEPRECATION"
	static final String DECLINING_BALANCE_END_OF_YEAR = "DECLINING_BALANCE_END_OF_YEAR"
	
	static def generateLinearDeprecationPlanByInterest(double capital, double interest) {
		int timeN = BasicCalculator.calculateInverse(interest)
		
		def resultMap = []
		resultMap.add(createInitialDeprecationYear(capital, timeN))
		(0..<timeN).each {index ->
			resultMap.add(createDeprecationYear(capital, interest, index, timeN))
		}
		
		resultMap
	}
	
	private static def createInitialDeprecationYear(capital, timeN) {
		def deprecationRow = [:]
		def currentYear = LocalDate.now().year - 1
		deprecationRow.YEAR = currentYear
		deprecationRow.DECLINING_BALANCE_BEGIN_OF_YEAR = 0
		deprecationRow.DEPRECATION = 0
		deprecationRow.DECLINING_BALANCE_END_OF_YEAR = DeprecationCalculator.calculateLinearDecliningBalanceAtEndOfYear(capital, -1, timeN)
		deprecationRow
	}
	
	private static def createDeprecationYear(capital, interest, index, timeN) {
		def deprecationRow = [:]
		def deprecation = DeprecationCalculator.calculateLinearDeprecationByInterest(capital, interest)
		def balanceAtBegin = DeprecationCalculator.calculateLinearDecliningBalanceAtBeginOfYear(capital, index, timeN)
		def balanceAtEnd = DeprecationCalculator.calculateLinearDecliningBalanceAtEndOfYear(capital, index, timeN)
		def currentYear = index + LocalDate.now().year
		deprecationRow.YEAR = currentYear
		deprecationRow.DECLINING_BALANCE_BEGIN_OF_YEAR = balanceAtBegin
		deprecationRow.DEPRECATION =deprecation
		deprecationRow.DECLINING_BALANCE_END_OF_YEAR = balanceAtEnd
		deprecationRow
	}
	
}
