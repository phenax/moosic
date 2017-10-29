package view.layouts

import view.AbstractLayout
import view.AbstractComponent
import view.Node


class RootLayout(val title: String = "Moosic"): AbstractLayout() {

	val inlineStyleComponent = file("src/main/public/css/inline-styles.css", true)

	override fun render(component: AbstractComponent): Node {

		return (
			html(null, listOf(
				head(null, listOf(
					h("title",
						mapOf("data-prefix" to title),
						listOf( text(title) )
					),
					h("style", null, listOf( inlineStyleComponent ))
				)),
				body(null, listOf( h(component) ))
			))
		);
	}
}
