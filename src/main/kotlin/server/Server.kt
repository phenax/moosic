package server

import io.vertx.core.AbstractVerticle
import io.vertx.core.Future
import io.vertx.core.Handler
import io.vertx.core.http.HttpServerResponse
import io.vertx.core.json.Json
import io.vertx.ext.web.Router
import io.vertx.ext.web.RoutingContext


@Suppress("unused")
class ServerKt: AbstractVerticle() {

	override fun start(startFuture: Future<Void>?) {

		val PORT = config().getInteger("http.port", 8080)

		// Instantiate routes, db, etc.
		val routes = Routes(vertx)
		val db = Database()

		vertx
			.createHttpServer()
			.requestHandler { routes.router.accept(it) }
			.listen(PORT) {
				result ->
					if(result.succeeded()) {
						println("Server started on port $PORT")
						startFuture?.complete()
					} else {
						startFuture?.fail(result.cause())
					}
			}
	}
}
