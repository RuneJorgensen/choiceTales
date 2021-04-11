package example.micronaut.data

import io.micronaut.context.annotation.Executable
import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository

@Repository
interface SectionRepository : CrudRepository<Section, Int> {
    @Executable
    fun find(title: String): Section

}