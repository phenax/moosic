package model

import io.vertx.ext.mongo.MongoClient;

/*data class UserEntity(
	val name: String,
	val email: String
);*/

class User: AbstractModel() {

	// For all the table operations 
	companion object Table: AbstractModelTable() {

		override val collectionName = "users";
	}

	/*var user = UserEntity("", "");

	val name: String
		fun get() = user.name
		fun set(name: String) { user.name = name }
	val email: String
		fun get() = user.email
		fun set(email: String) { user.email = email }*/

	override fun initialize() {
		
	}
}

