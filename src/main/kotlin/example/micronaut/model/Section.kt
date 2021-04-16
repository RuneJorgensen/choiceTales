package example.micronaut.model

import example.micronaut.annotation.NoArg
import org.bson.types.ObjectId

@NoArg
data class Section(
    var id: ObjectId? = null,
    var section_number: String,
    var title: String,
    var text: String
    )