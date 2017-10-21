package server

import io.vertx.ext.web.Router
import io.vertx.core.Vertx

import controller.HomeControllerKt
import io.vertx.ext.web.RoutingContext
import io.vertx.ext.web.handler.StaticHandler

// Route type
data class Route(
	val path: String,
	val handler: (RoutingContext) -> Unit
);

class Routes(vertex: Vertx) {

	val router = Router.router(vertex)

	// Controller initializations
	val homeController = HomeControllerKt()

	// List of simple routes
	val routes: List<Route> = listOf(
		Route("/", { ctx: RoutingContext -> homeController.index(ctx) }),
		Route("/test", { ctx: RoutingContext -> homeController.test(ctx) })
	)

	init {
		routes.forEach({
			router.route(it.path).handler(it.handler)
		})

		router.route("/*").handler(StaticHandler.create("src/main/public"))
	}
}
