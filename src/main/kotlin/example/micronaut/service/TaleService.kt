package example.micronaut.service

import example.micronaut.exception.NotFoundException
import example.micronaut.model.Tale
import example.micronaut.repository.TaleRepository
import example.micronaut.request.TaleRequest
import javax.inject.Singleton

@Singleton
class TaleService(
    private val taleRepository: TaleRepository
) {

    fun createTale(request: TaleRequest) {
        taleRepository.create(Tale(
            title = request.title,
            description = request.description
        ))
    }

    fun findAll(): List<Tale> =
        taleRepository.findAll()

    fun findById(id: String): Tale =
        taleRepository.findById(id)
            ?: throw NotFoundException("Tale with id $id not found")
}