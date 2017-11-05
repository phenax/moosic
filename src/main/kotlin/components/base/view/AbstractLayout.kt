package components.base.view

import libs.dom.DOMNode

/**
 * Layout
 */
abstract class AbstractLayout: AbstractView() {

	// Dont need empty render
	override fun render(): DOMNode { throw Exception("Need to pass component to render layout") }

	// Render component inside layout
	abstract fun render(component: AbstractComponent): DOMNode
}
