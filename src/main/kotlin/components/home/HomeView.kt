package components.home

import components.base.view.AbstractComponent
import components.base.view.layouts.RootLayout
import libs.dom.DOMNode

class HomeView: AbstractComponent() {

	override val layout = RootLayout(title = "Moosic")

	override fun render(): DOMNode {

		return (
			div(null, listOf(
				div(mapOf( "id" to "applicationHook" ), null),
				script("/public/js/script.js", mapOf("async" to "", "defer" to ""))
			))
		)
	}
}

