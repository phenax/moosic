package view.layouts

import view.AbstractLayout
import view.AbstractComponent
import view.Node


class RootLayout(val title: String = "Title"): AbstractLayout() {

	override fun render(component: AbstractComponent): Node {
		return (
			html(null, listOf(
				head(null, listOf(
					h("title", null, listOf( text(title) ))
				)),
				body(null, listOf(
					h(component)
				))
			))
		);
	}
}
