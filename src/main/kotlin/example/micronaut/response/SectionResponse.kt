package example.micronaut.response

import example.micronaut.model.Section

class SectionResponse(
    val id: String,
    val section_number: String,
    val title: String,
    val text: String
) {

    companion object {
        fun fromEntity(section: Section): SectionResponse =
            SectionResponse(
                id = section.id!!.toHexString(),
                section_number = section.section_number,
                title = section.title,
                text = section.text
            )
    }
}