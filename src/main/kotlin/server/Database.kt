package server

import io.vertx.ext.mongo.MongoClient
import io.vertx.core.json.JsonObject
import io.vertx.core.Vertx

import model.*


val connectionConfig = mapOf(
	//"username"      to "john",
	//"password"      to "passw0rd",
	"db_name"       to "moosic",
	"host"          to "127.0.0.1",
	"port"          to 27017,
	"maxPoolSize"   to 50,
	"useObjectId"   to true
)


fun newConnection(vertx: Vertx): MongoClient {
	return MongoClient.createShared(vertx, JsonObject(connectionConfig))
}

class Database {

	companion object Factory {

		var dbConnection: MongoClient = newConnection(Vertx.vertx());

		fun connect(): MongoClient {
			return dbConnection
		}
	}

	val connection: MongoClient = Database.connect()

	init {
		
	}
}
