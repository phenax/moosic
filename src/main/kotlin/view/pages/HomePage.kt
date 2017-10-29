package view.pages

import view.AbstractComponent
import view.layouts.RootLayout
import view.Node

class HomePage: AbstractComponent() {

	override val layout = RootLayout(title = "Moosic")

	override fun render(): Node {

		return (
			div(null, listOf(
				div(mapOf( "id" to "applicationHook" ), null),
				script("/js/script.js", mapOf("async" to "", "defer" to ""))
			))
		)
	}
}
