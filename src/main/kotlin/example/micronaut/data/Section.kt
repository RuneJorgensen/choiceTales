package example.micronaut.data

import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class Section(@Id var id: Int = 1, var title: String = "", var text: String = "")