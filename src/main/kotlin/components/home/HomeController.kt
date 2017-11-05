package components.home

import io.vertx.ext.web.RoutingContext
import io.vertx.core.json.JsonObject

import components.base.AbstractController

class HomeController {

	companion object Factory: AbstractController() {

		fun index(ctx: RoutingContext) {
			render(ctx, HomeView())
		}

		fun test(ctx: RoutingContext) {
			sendFile(ctx, ".gitignore")
				.subscribe({}, { println(it) })
		}
	}
}

