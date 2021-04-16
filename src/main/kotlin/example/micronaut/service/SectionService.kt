package example.micronaut.service

import example.micronaut.exception.NotFoundException
import example.micronaut.model.Section
import example.micronaut.repository.SectionRepository
import example.micronaut.repository.TaleRepository
import example.micronaut.request.SectionRequest
import org.bson.BsonValue
import javax.inject.Singleton

@Singleton
class SectionService(
    private val taleRepository: TaleRepository,
    private val sectionRepository: SectionRepository
) {

    fun createSection(request: SectionRequest): BsonValue? {
        val insertedSection = sectionRepository.create(
            Section(
                section_number = request.section_number,
                title = request.title,
                text = request.text
            )
        )
        return insertedSection.insertedId
    }

    fun findAll(): List<Section> {
        return sectionRepository.findAll()
    }

    fun findById(id: String): Section =
        sectionRepository.findById(id)
            ?: throw NotFoundException("Section with id $id was not found")

}