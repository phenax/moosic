package server

import io.vertx.ext.mongo.MongoClient;
import io.vertx.core.json.JsonObject
import io.vertx.core.Vertx

import model.*

class Database(val vertx: Vertx) {

	var connection: MongoClient;

	init {
		connection = MongoClient.createShared(vertx, JsonObject(mapOf(
			// "username" to "john",
			// "password" to "passw0rd",
			"db_name" to "moosic",
			"host" to "127.0.0.1",
			"port" to 27017,
			"maxPoolSize" to 50,
			"useObjectId" to true
		)))

		connection.find("users", JsonObject("""{}"""), { println(it) })
	}
}
