package components.user

import components.base.AbstractModelData

data class UserEntity(
	override val _id: String = "",
	var name: String = "",
	var email: String = ""
): AbstractModelData()

