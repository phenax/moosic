package controller

import io.vertx.ext.web.RoutingContext
import io.vertx.core.json.JsonObject

import model.*
import view.pages.HomePageView

class HomeController {

	companion object Factory: AbstractController() {

		fun index(ctx: RoutingContext) {
			render(ctx, HomePageView())
		}

		fun test(ctx: RoutingContext) {
			sendFile(ctx, ".gitignore")
				.subscribe({}, { println(it) })
		}
	}
}


