package example.micronaut.data

import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class Tale(@Id var id: Int = 1, var title: String = "", var description: String = "")