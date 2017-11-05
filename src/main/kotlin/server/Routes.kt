package server

import io.vertx.ext.web.Router
import io.vertx.core.Vertx
import io.vertx.ext.web.RoutingContext
import io.vertx.ext.web.handler.StaticHandler

import components.home.HomeController

/**
 * Registers all routes
 */
class Routes(vertex: Vertx) {

	val router = Router.router(vertex)

	init {

		router.route("/public/*").handler(StaticHandler.create("src/main/public"))
		router.route("/test").handler { HomeController.test(it) }

		router.route("/*").handler { HomeController.index(it) }
	}
}
