package view.layouts

import view.AbstractLayout
import view.AbstractComponent
import view.Node


class RootLayout(val title: String = "Moosic"): AbstractLayout() {

	override fun render(component: AbstractComponent): Node {
		return (
			html(null, listOf(
				head(null, listOf(
					h("title",
						mapOf("data-prefix" to title),
						listOf( text(title) )
					)
				)),
				body(null, listOf( h(component) ))
			))
		);
	}
}
