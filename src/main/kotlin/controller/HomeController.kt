package controller

import io.vertx.ext.web.RoutingContext

class HomeControllerKt: AbstractControllerKt() {

	val hello = "nicecontent"

	fun index(ctx: RoutingContext) {
		this.sendJSON(ctx, this)
	}

	fun test(ctx: RoutingContext) {
		this.sendFile(ctx, ".gitignore").subscribe(
			{ println("File sent") },
			{ println(it) }
		)
	}
}


