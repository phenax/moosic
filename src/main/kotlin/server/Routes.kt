package server

import io.vertx.ext.web.Router
import io.vertx.core.Vertx
import io.vertx.ext.web.RoutingContext
import io.vertx.ext.web.handler.StaticHandler

import components.home.HomeController
import components.user.UserController

/**
 * Registers all routes
 */
class Routes(vertex: Vertx) {

	val router = Router.router(vertex)

	init {

		// Api routes
		router.route("/api/users").handler { UserController.index(it) }

		// Static stuff
		router.route("/public/*").handler(StaticHandler.create("src/main/public"))

		// Root html page render
		router.route("/*").handler { HomeController.index(it) }
	}
}
