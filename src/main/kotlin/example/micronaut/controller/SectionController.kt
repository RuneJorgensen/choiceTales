package example.micronaut.controller

import example.micronaut.model.Message
import example.micronaut.request.SectionRequest
import example.micronaut.response.SectionResponse
import example.micronaut.service.SectionService
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.*
import java.net.URI

@Controller("/choicetale")
class SectionController(
    private val sectionService: SectionService
) {

    @Post
    fun create(@Body request: SectionRequest): HttpResponse<Void> {
        val createdId = sectionService.createSection(request)

        return HttpResponse.created(
            URI.create(
                createdId!!.asObjectId().value.toHexString()
            )
        )
    }

    @Get("/{name}")
    fun index(name : String): Message {

        return Message("Hello $name")
    }


    @Get("/sectionbyid/{id}")
    fun sectionById(@PathVariable id : String): HttpResponse<SectionResponse> {
        println("In index and sectionId is $id")
        val section = sectionService.findById(id)
        println("We got something from section ${section.id}")
        return HttpResponse.ok(
            SectionResponse.fromEntity(section)
        )
    }
}