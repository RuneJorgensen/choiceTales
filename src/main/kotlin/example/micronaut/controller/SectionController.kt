package example.micronaut.controller

import example.micronaut.model.Message
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

    @Get("/id/{id}")
    fun sectionById(@PathVariable id : String): HttpResponse<SectionResponse> {
        println("In index and sectionId is $id")
        val section = sectionService.findById(id)
        println("We got something from section ${section.id}")
        return HttpResponse.ok(
            SectionResponse.fromEntity(section)
        )
    }


    @Get("/{sectionNumber}")
    fun sectionBySectionNumber(@PathVariable sectionNumber: String): HttpResponse<SectionResponse> {
        println("In index and section number is $sectionNumber")
        val section = sectionService.findBySectionNumber(sectionNumber)
        println("We got something from section $sectionNumber")
        return HttpResponse.ok(
            SectionResponse.fromEntity(section)
        )
    }

    @Get("/tale/{taleId}")
    fun findAllSectionsByTaleId(@PathVariable taleId: String): HttpResponse<List<SectionResponse>> {
        val sections = sectionService.findAllByTaleId(taleId)
            .map { SectionResponse.fromEntity(it) }
        return HttpResponse.ok(sections)
    }
}