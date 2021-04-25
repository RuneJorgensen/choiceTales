package example.micronaut.controller

import example.micronaut.request.TaleRequest
import example.micronaut.response.SectionResponse
import example.micronaut.response.TaleResponse
import example.micronaut.service.TaleService
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
import java.net.URI

@Controller("/tale")
class TaleController(
    private val taleService: TaleService
) {

    @Post("/create")
    fun create(@Body request: TaleRequest): HttpResponse<Void> {
        val createdId = taleService.createTale(request)

        return HttpResponse.created(
            URI.create(
                createdId!!.asObjectId().value.toHexString()
            )
        )
    }

    @Get("/all")
    fun findAll(): HttpResponse<List<TaleResponse>> {
        val tales = taleService.findAll()
            .map { TaleResponse.fromEntity(it) }
        return HttpResponse.ok(tales)
    }

    @Get("/{id}")
    fun taleById(id : String): HttpResponse<TaleResponse> {
        val tale = taleService.findById(id)
        return HttpResponse.ok(
            TaleResponse.fromEntity(tale)
        )
    }

    @Get("/title/{title}")
    fun taleByTitle(title : String): HttpResponse<TaleResponse> {
        val tale = taleService.findByTitle(title)
        return HttpResponse.ok(
            TaleResponse.fromEntity(tale)
        )
    }


}