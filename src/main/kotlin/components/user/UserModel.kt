package components.user

import io.vertx.ext.mongo.MongoClient;

import components.base.*

data class UserEntity(
	override val _id: String = "",
	var name: String = "",
	var email: String = ""
): AbstractModelData()

// User entity
class UserModel: AbstractModelDocument() {

	// For all the collection operations 
	companion object Table: AbstractModelCollection<UserEntity>() {
		override val collectionName = "users"
		override val entityClass = (UserEntity::class.java) // Parenthesis because something is screwing with syntax highlighting
	}

	var entity = UserEntity("1");

	override fun initialize() {
		
	}
}

