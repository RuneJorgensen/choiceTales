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
class SectionControllerTest {

    @Inject
    @field:Client("/")
    lateinit var client : RxHttpClient

    @Test
    fun testHello() {
        val request: HttpRequest<Any> = HttpRequest.GET<Any>("/tale/Rune").basicAuth("sherlock", "password")
        val body = client.toBlocking().exchange(request, Message::class.java).body()
        Assertions.assertNotNull(body)
        Assertions.assertEquals("Hello Rune", body.text)
    }
}