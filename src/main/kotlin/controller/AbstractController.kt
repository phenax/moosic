package controller

import io.vertx.ext.web.RoutingContext
import com.google.gson.Gson
import io.reactivex.*
import io.vertx.core.AsyncResult


abstract class AbstractControllerKt {

	fun send(ctx: RoutingContext, content: String, contentType: String): AbstractControllerKt {

		ctx.response()
			.putHeader("Content-Type", contentType)
			.end(content)

		return this
	}

	fun sendHTML(ctx: RoutingContext, strContent: String): AbstractControllerKt {
		return this.send(ctx, strContent, "text/html")
	}

	fun sendJSON(ctx: RoutingContext, obj: Any): AbstractControllerKt {
		val jsonString = Gson().toJson(obj)
		return this.send(ctx, jsonString, "application/json")
	}

	fun sendFile(ctx: RoutingContext, fileName: String): Single<Boolean> {

		val response = ctx.response()

		var file = Single.create({
			subscriber: SingleEmitter<Boolean> ->
				response.sendFile(fileName, {
					if(it.cause() != null) {
						subscriber.onError(it.cause())
					} else {
						subscriber.onSuccess(true)
					}
				})
		})

		file.subscribe({}, { this.throwNotFoundException(ctx) })

		return file
	}

	fun sendStaticFile(ctx: RoutingContext, fileName: String): Single<Boolean> {
		return this.sendFile(ctx, "src/public/$fileName")
	}


	fun throwNotFoundException(ctx: RoutingContext): AbstractControllerKt {

		val response = ctx.response()
		response.statusCode = 404
		response.statusMessage = "Resource not found"

		return this.send(ctx, "Resource not found", "text/html")
	}
}
