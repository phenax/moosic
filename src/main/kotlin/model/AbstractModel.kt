package model

import io.vertx.ext.mongo.MongoClient;

abstract class AbstractModelTable {

}

abstract class AbstractModel {
	
	constructor() {
		this.initialize()
	}

	abstract fun initialize();
}

