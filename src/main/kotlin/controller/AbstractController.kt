package controller

import io.vertx.ext.web.RoutingContext
import com.google.gson.Gson


abstract class AbstractControllerKt {

	public fun send(ctx: RoutingContext, content: String, contentType: String): AbstractControllerKt {

		ctx.response()
			.putHeader("Content-Type", contentType)
			.end(content)

		return this;
	}

	public fun sendHTML(ctx: RoutingContext, strContent: String): AbstractControllerKt {
		return this.send(ctx, strContent, "text/html");
	}

	public fun sendJSON(ctx: RoutingContext, obj: Any): AbstractControllerKt {

		val jsonString = Gson().toJson(obj)

		return this.send(ctx, jsonString, "application/json");
	}
}
