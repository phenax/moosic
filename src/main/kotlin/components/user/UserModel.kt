package components.user

import io.vertx.ext.mongo.MongoClient;

import components.base.AbstractModelDocument
import components.base.AbstractModelCollection

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

