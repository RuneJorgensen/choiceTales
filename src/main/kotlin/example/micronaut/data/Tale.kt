package example.micronaut.data


import example.micronaut.annotation.NoArg
import javax.persistence.Entity
import javax.persistence.Id

@NoArg
@Entity
data class Tale(
    @Id var id: Int,
    var title: String,
    var description: String
    )