package net.hemisoft.financial.calculator.service;

import net.hemisoft.financial.calculator.web.Deprecation

interface DeprecationService {
	def findAll()
	def findOne(id)
	def save(Deprecation d)
	def calculatePlan(Deprecation d)
}
