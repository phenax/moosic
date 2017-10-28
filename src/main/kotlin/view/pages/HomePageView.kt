package view.pages

import view.AbstractView
import view.AbstractComponent
import view.Node

class CustomComponent(val children: List<Node>?): AbstractComponent() {
	override fun render(): Node {
		return h("div", null, children)
	}
}

class HomePageView: AbstractView() {

	override fun render(): Node {

		return h(CustomComponent(listOf(
			h("div", mapOf( "class" to "hello" ),
				listOf(
					text("Hello world Twice")
				)
			)
		)))
	}
}
