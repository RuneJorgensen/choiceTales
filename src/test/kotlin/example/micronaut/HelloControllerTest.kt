package example.micronaut

import example.micronaut.model.Message
import io.micronaut.http.HttpRequest
import io.micronaut.http.client.RxHttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import javax.inject.Inject

@MicronautTest
class HelloControllerTest {

    @Inject
    @field:Client("/")
    lateinit var client : RxHttpClient

    @Test
    fun testHello() {
        val request: HttpRequest<Any> = HttpRequest.GET<Any>("/hello/Rune")
        val body = client.toBlocking().retrieve(request, Message::class.java)
        Assertions.assertNotNull(body)
        Assertions.assertEquals("Hello Rune", body.text)
    }
}