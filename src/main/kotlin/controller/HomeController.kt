package controller

import io.vertx.ext.web.RoutingContext

import model.*

class HomeController {
	companion object Factory: AbstractController() {

		fun index(ctx: RoutingContext) {
			this.sendJSON(ctx, "Hello world")
		}

		fun test(ctx: RoutingContext) {
			this.sendFile(ctx, ".gitignore")
				.subscribe({}, { println(it) })
		}
	}
}


