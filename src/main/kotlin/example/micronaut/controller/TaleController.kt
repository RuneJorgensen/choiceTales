package example.micronaut.controller

import example.micronaut.response.TaleResponse
import example.micronaut.service.TaleService
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

@Controller("/tale")
class TaleController(
    private val taleService: TaleService
) {

    @Get("/{id}")
    fun taleByTitle(id : String): HttpResponse<TaleResponse> {
        val tale = taleService.findById(id)
        return HttpResponse.ok(
            TaleResponse.fromEntity(tale)
        )
    }

}