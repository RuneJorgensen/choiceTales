package example.micronaut.response

import example.micronaut.model.Tale

class TaleResponse(
    val id: String,
    val title: String,
    val description: String
) {
    companion object {
        fun fromEntity(tale: Tale): TaleResponse =
            TaleResponse(
                id = tale.id!!.toHexString(),
                title = tale.title,
                description = tale.description
            )
    }
}