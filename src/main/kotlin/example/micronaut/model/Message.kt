package example.micronaut.model

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty

class Message @JsonCreator

constructor(@param:JsonProperty("text") val text : String)
