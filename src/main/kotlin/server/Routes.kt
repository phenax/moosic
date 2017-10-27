package server

import io.vertx.ext.web.Router
import io.vertx.core.Vertx

import controller.*
import io.vertx.ext.web.RoutingContext
import io.vertx.ext.web.handler.StaticHandler


class Routes(vertex: Vertx) {

	val router = Router.router(vertex)

	init {

		router.route("/").handler { HomeController.index(it) }
		router.route("/test").handler { HomeController.test(it) }

		router.route("/*").handler(StaticHandler.create("src/main/public"))
	}
}
