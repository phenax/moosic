package server

import io.vertx.ext.web.Router
import io.vertx.core.Vertx

import controller.HomeControllerKt
import io.vertx.ext.web.RoutingContext

// Route type
data class Route(
	val path: String,
	val handler: (RoutingContext) -> Unit
);

class Routes(vertx: Vertx) {
	val router = Router.router(vertx)

	// Controller initializations
	val homeCtrlr = HomeControllerKt()

	// List of simple routes
	val routes: List<Route> = listOf(
		Route("/", { ctx: RoutingContext -> homeCtrlr.index(ctx) }),
		Route("/test", { ctx: RoutingContext -> homeCtrlr.test(ctx) })
	)

	init {
		this.routes
			.forEach({
				this.router.route(it.path).handler(it.handler)
			})
	}
}
