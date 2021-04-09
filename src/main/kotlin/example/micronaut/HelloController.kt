package example.micronaut

import example.micronaut.model.Message
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Produces

@Controller("/hello")
class HelloController {

    @Get("/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    fun index(name : String): Message {

        return Message("Hello $name")
    }
}