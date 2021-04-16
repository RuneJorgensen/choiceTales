package example.micronaut.model


import example.micronaut.annotation.NoArg
import org.bson.types.ObjectId

@NoArg
data class Tale(
    var id: ObjectId? = null,
    var title: String,
    var description: String
    )