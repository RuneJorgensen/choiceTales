package example.micronaut.data

import example.micronaut.annotation.NoArg
import javax.persistence.Entity
import javax.persistence.Id

@NoArg
@Entity
data class Section(
    @Id var id: Int,
    var section_number: Int,
    var title: String,
    var text: String,
    var tale_id: Int
    )