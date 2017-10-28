package view.layouts

import view.AbstractLayout
import view.AbstractComponent
import view.Node

class EmptyLayout: AbstractLayout() {

	override fun render(component: AbstractComponent): Node {

		return h(component);
	}
}
