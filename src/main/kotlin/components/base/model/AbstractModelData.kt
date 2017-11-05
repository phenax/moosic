package components.base.model

abstract class AbstractModelData {

	abstract val _id: String

	val id: String
		get() { return this._id; }
}
