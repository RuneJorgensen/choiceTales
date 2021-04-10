package example.micronaut.data

import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class Section(@Id var id: Int, var title: String, var text: String)