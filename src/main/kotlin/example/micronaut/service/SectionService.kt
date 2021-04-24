package example.micronaut.service

import example.micronaut.exception.NotFoundException
import example.micronaut.model.Section
import example.micronaut.repository.SectionRepository
import example.micronaut.request.SectionRequest
import org.bson.BsonValue
import javax.inject.Singleton

@Singleton
class SectionService(
    private val taleService: TaleService,
    private val sectionRepository: SectionRepository
) {

    fun createSection(request: SectionRequest): BsonValue? {
        val tale = request.taleId?.let { taleService.findById(it) }

        val insertedSection = sectionRepository.create(
            Section(
                section_number = request.section_number,
                title = request.title,
                text = request.text,
                tale = tale
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

    fun findBySectionNumber(section_number: String): Section =
        sectionRepository.findBySectionNumber(section_number)
            ?: throw NotFoundException("Section with section number $section_number was not found")

    fun findAllByTaleId(taleId: String): List<Section> =
        sectionRepository.findAllByTaleId(taleId)

}