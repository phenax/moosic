package components.base.model

// Document class
abstract class AbstractModelDocument {

	// abstract var entity: AbstractModelData;

	constructor() {
		this.initialize()
	}

	abstract fun initialize()
}

