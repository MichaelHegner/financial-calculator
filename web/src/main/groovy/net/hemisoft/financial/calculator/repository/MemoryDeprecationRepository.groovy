package net.hemisoft.financial.calculator.repository

import java.util.concurrent.atomic.AtomicLong

import org.springframework.stereotype.Repository

import net.hemisoft.financial.calculator.web.Deprecation

@Repository
class MemoryDeprecationRepository implements DeprecationRepository {
	final AtomicLong idGenerator = new AtomicLong(0)
	final def db = [:]
	
	@Override
	def findAll() {
		db.values()
	}

	@Override
	def findOne(id) {
		db.get(id)
	}

	@Override
	def save(Deprecation deprecation) {
		def id = idGenerator.incrementAndGet()
		deprecation.id = id
		db.put(deprecation.id, deprecation)
		findOne(deprecation.id)
	}

}
