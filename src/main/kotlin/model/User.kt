package model

import io.vertx.ext.mongo.MongoClient;

data class UserEntity(
	var _id: String = "",
	var name: String = "",
	var email: String = ""
);

class User: AbstractModel() {

	// For all the table operations 
	companion object Table: AbstractModelCollection<UserEntity>() {
		override val collectionName = "users"
		override val entityClass = (UserEntity::class.java) // Parenthesis because something is screwing with syntax highlighting
	}

	var user = UserEntity("", "");

	/*
	val name: String
		fun get() = user.name
		fun set(name: String) { user.name = name }
	val email: String
		fun get() = user.email
		fun set(email: String) { user.email = email }
	*/

	override fun initialize() {
		
	}
}

