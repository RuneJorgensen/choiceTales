package example.micronaut.data

import io.micronaut.context.annotation.Executable
import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository

@Repository
interface TaleRepository : CrudRepository<Tale, Int> {
    @Executable
    fun find(title: String): Tale


}