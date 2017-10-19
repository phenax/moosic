package server

import io.vertx.core.AbstractVerticle
import io.vertx.core.Future
import io.vertx.core.Handler
import io.vertx.core.http.HttpServerResponse
import io.vertx.core.json.Json
import io.vertx.ext.web.Router
import io.vertx.ext.web.RoutingContext


@Suppress("unused")
class ServerKt : AbstractVerticle() {

	override fun start(startFuture: Future<Void>?) {

		val port = config().getInteger("http.port", 8080)

		val routes = Routes(vertx)

		vertx
			.createHttpServer()
			.requestHandler { routes.router.accept(it) }
			.listen(port) {
				result ->
					if(result.succeeded()) {
						println("Server started on port $port")
						startFuture?.complete()
					} else {
						startFuture?.fail(result.cause())
					}
			}
	}
}
