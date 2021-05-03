package example.micronaut.controller

import example.micronaut.request.SectionRequest
import example.micronaut.response.SectionResponse
import example.micronaut.service.SectionService
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.*
import java.net.URI

@Controller("/section")
class SectionController(
    private val sectionService: SectionService
) {

    @Post("/create")
    fun create(@Body request: SectionRequest): HttpResponse<Void> {
        val createdId = sectionService.createSection(request)

        return HttpResponse.created(
            URI.create(
                createdId!!.asObjectId().value.toHexString()
            )
        )
    }

    @Get("/all")
    fun findAll(): HttpResponse<List<SectionResponse>> {
        val sections = sectionService.findAll()
            .map { SectionResponse.fromEntity(it) }
        return HttpResponse.ok(sections)
    }

    @Get("/id/{id}")
    fun sectionById(@PathVariable id : String): HttpResponse<SectionResponse> {
        println("In index and sectionId is $id")
        val section = sectionService.findById(id)
        println("We got something from section ${section.id}")
        return HttpResponse.ok(
            SectionResponse.fromEntity(section)
        )
    }


    @Get("/{taleTitle}/{sectionNumber}")
    fun sectionByTaleTitleSectionNumber(@PathVariable taleTitle: String, @PathVariable sectionNumber: String): HttpResponse<SectionResponse> {
        val section = sectionService.findByTaleTitleSectionNumber(taleTitle, sectionNumber)
        return HttpResponse.ok(
            SectionResponse.fromEntity(section)
        )
    }

    @Get("/tale/{taleTitle}")
    fun findAllSectionsByTaleTitle(@PathVariable taleTitle: String): HttpResponse<List<SectionResponse>> {
        val sections = sectionService.findAllByTaleTitle(taleTitle)
            .map { SectionResponse.fromEntity(it) }
        return HttpResponse.ok(sections)
    }

    @Get("/taleid/{taleId}")
    fun findAllSectionsByTaleId(@PathVariable taleId: String): HttpResponse<List<SectionResponse>> {
        val sections = sectionService.findAllByTaleId(taleId)
            .map { SectionResponse.fromEntity(it) }
        return HttpResponse.ok(sections)
    }

    @Put("/id/{id}")
    fun update(@PathVariable id: String, @Body request: SectionRequest): HttpResponse<SectionResponse> {
        val updatedSection = sectionService.updateSection(id, request)

        return HttpResponse.ok(
            SectionResponse.fromEntity(updatedSection)
        )
    }
}