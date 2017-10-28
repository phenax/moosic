package view.pages

import view.AbstractComponent
import view.layouts.RootLayout
import view.Node

class HomePage: AbstractComponent() {

	override val layout = RootLayout("Moosic Homepage")

	override fun render(): Node {

		return (
			div(mapOf( "class" to "hello" ),
				listOf(
					text("Hello world Twice")
				)
			)
		)
	}
}
