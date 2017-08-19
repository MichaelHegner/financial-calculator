package net.hemisoft.financial.calculator.repository;

import net.hemisoft.financial.calculator.web.Deprecation

interface DeprecationRepository {
	def findAll()
	def findOne(id)
	def save(Deprecation d)
}
