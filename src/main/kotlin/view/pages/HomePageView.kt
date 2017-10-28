package view.pages

import view.AbstractComponent
import view.layouts.RootLayout
import view.Node

class HomePageView: AbstractComponent() {

	override val layout = RootLayout()

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
