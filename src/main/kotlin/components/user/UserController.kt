package components.user

import io.vertx.ext.web.RoutingContext
import io.vertx.core.json.JsonObject

import components.base.AbstractController

class UserController {

	companion object Factory: AbstractController() {

		fun index(ctx: RoutingContext) {

			val filterOptions: Map<String, String> = mapOf()

			UserModel
				.find(filterOptions)
				.subscribe({ this.sendJSON(ctx, it) }, { println(it) })
		}
	}
}

