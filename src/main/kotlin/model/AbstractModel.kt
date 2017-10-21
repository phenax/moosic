package model

import io.vertx.ext.mongo.MongoClient;
import server.Database;
import io.reactivex.*
import io.vertx.core.AsyncResult
import io.vertx.core.json.JsonObject

abstract class AbstractModelTable {

	val db = Database.connect()

	abstract val collectionName: String;

	fun find(query: Map<String, Any>): Single<List<JsonObject>> {

		return Single.create({

			subscriber: SingleEmitter<List<JsonObject>> ->

				db.find(collectionName, JsonObject(query), {

					if(it.cause() != null) {
						subscriber.onError(it.cause())
					} else {
						subscriber.onSuccess(it.result())
					}
				})
		})
	}
}

abstract class AbstractModel {
	
	constructor() {
		this.initialize()
	}

	abstract fun initialize();
}

