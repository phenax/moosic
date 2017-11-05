package components.base.model

import server.Database

import io.vertx.ext.mongo.MongoClient
import io.reactivex.*
import io.vertx.core.AsyncResult
import io.vertx.core.json.JsonObject


// Collection class
abstract class AbstractModelCollection<T> {

	val db = Database.connect()

	// Mongodb collection name
	abstract val collectionName: String

	// Class of the entity data class
	abstract val entityClass: Class<T>


	/**
	 * Run a find query on collection
	 *
	 * @param  query   BSON Query
	 * @return         Single observable
	 */
	fun find(query: Map<String, Any>): Single<List<T>> {

		return Single.create({

			subscriber: SingleEmitter<List<T>> ->

				db.find(collectionName, JsonObject(query), { res ->

					if(res.cause() != null) {
						subscriber.onError(res.cause())
					} else {

						val results =
							res.result().map { it.mapTo(entityClass) }

						subscriber.onSuccess(results)
					}
				})
		})
	}
}
