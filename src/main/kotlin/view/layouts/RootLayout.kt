package view.layouts

import view.AbstractLayout
import view.AbstractComponent
import view.Node

class RootLayout: AbstractLayout() {

	override fun render(component: AbstractComponent): Node {
		return (
			html(null, listOf(
				head(null, listOf(

				)),
				body(null, listOf(
					div(null, listOf(
						text("Hello world"),
						h(component)
					))
				))
			))
		);
	}
}
