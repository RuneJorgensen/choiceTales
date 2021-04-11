package example.micronaut

import example.micronaut.data.TaleRepository
import example.micronaut.model.Message
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Produces
import io.micronaut.security.annotation.Secured
import io.micronaut.security.rules.SecurityRule
import javax.inject.Inject

@Secured(SecurityRule.IS_AUTHENTICATED)
@Controller("/tale")
class TaleController {

    @Inject
    lateinit var taleRepository: TaleRepository


    @Get("/{title}")
    @Produces(MediaType.APPLICATION_JSON)
    fun taleByTitle(title : String): Message {
        val tale = taleRepository.find(title)
        return Message("${tale.description}")
    }

    @Get("/id/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    fun taleById(id : Int): Message {
        val tale = taleRepository.findById(id)
        return Message("${tale.get().description}")
    }


}