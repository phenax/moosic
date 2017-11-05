package components.base

// Document class
abstract class AbstractModelDocument {

	// abstract var entity: AbstractModelData;

	constructor() {
		this.initialize()
	}

	abstract fun initialize()
}

