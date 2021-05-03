package example.micronaut.repository

import com.mongodb.client.MongoClient
import com.mongodb.client.model.Filters
import com.mongodb.client.result.InsertOneResult
import example.micronaut.model.Tale
import org.bson.types.ObjectId
import javax.inject.Singleton

@Singleton
class TaleRepository(
    private val mongoClient: MongoClient
) {

    fun create(tale: Tale): InsertOneResult =
        getCollection()
            .insertOne(tale)

    fun findAll(): List<Tale>  =
        getCollection()
            .find()
            .toList()

    fun findById(id: String): Tale? =
        getCollection()
            .find(
                Filters.eq("_id", ObjectId(id))
            )
            .toList()
            .firstOrNull()

    fun findByTitle(title: String): Tale? =
        getCollection()
            .find(
                Filters.eq("title", title)
            )
            .toList()
            .firstOrNull()

    private fun getCollection() =
        mongoClient
            .getDatabase("choicetales_dev_db")
            .getCollection("tale", Tale::class.java)


}