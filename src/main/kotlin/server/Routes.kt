package server

import io.vertx.ext.web.Router
import io.vertx.core.http.HttpServer
import io.vertx.core.Vertx

import controller.HomeControllerKt


class Routes(vertx: Vertx) {

	public var router = Router.router(vertx)

	init {
		this._initializeRoutes();
	}

	private fun _initializeRoutes() {

		val homeCtrlr = HomeControllerKt()

		this.router.route("/").handler({ homeCtrlr.index(it) })
	}
}
