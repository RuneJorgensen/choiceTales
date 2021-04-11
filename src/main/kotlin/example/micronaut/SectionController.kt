package example.micronaut

import example.micronaut.data.SectionRepository
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
class SectionController {

    @Inject
    lateinit var sectionRepository: SectionRepository

    @Get("/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    fun index(name : String): Message {

        return Message("Hello $name")
    }

    @Get("/section/{title}")
    @Produces(MediaType.APPLICATION_JSON)
    fun section(title : String): Message {
        val section = sectionRepository.find(title)
        return Message("${section.text}")
    }

    @Get("/sectionbyid/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    fun sectionById(id : Int): Message {
        println("In index and sectionId is $id")
        val section = sectionRepository.findById(id)
        println("We got something from section ${section.get().id}")
        return Message("${section.get().text}")
    }
}