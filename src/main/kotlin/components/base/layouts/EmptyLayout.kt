package components.base.layouts

import components.base.AbstractLayout
import components.base.AbstractComponent
import libs.dom.DOMNode

class EmptyLayout: AbstractLayout() {

	override fun render(component: AbstractComponent): DOMNode {

		return h(component);
	}
}
