package example.micronaut.repository

import com.mongodb.client.MongoClient
import com.mongodb.client.model.Filters
import com.mongodb.client.result.InsertOneResult
import example.micronaut.model.Section
import org.bson.types.ObjectId
import javax.inject.Singleton

@Singleton
class SectionRepository(private val mongoClient: MongoClient) {

    fun create(section: Section): InsertOneResult =
        getCollection()
            .insertOne(section)

    fun findAll(): List<Section> =
        getCollection()
            .find()
            .toList()
    fun findById(id: String): Section? =
        getCollection()
            .find(
                Filters.eq("_id", ObjectId(id))
            )
            .toList()
            .firstOrNull()


    private fun getCollection() =
        mongoClient
            .getDatabase("example")
            .getCollection("section", Section::class.java)


}