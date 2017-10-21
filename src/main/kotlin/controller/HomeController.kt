package controller

import io.vertx.ext.web.RoutingContext
import io.vertx.core.json.JsonObject

import model.*

class HomeController {
	companion object Factory: AbstractController() {

		fun index(ctx: RoutingContext) {
			User.find(mapOf())
				.subscribe({ res: List<JsonObject> ->
					this.sendJSON(ctx, res)
				})
		}

		fun test(ctx: RoutingContext) {
			this.sendFile(ctx, ".gitignore")
				.subscribe({}, { println(it) })
		}
	}
}


