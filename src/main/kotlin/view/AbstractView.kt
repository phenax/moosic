package view

abstract class AbstractView {
	abstract fun render(): Node

	open protected fun _render(): Node = render()

	// Render to node and html methods
	fun renderToNode(): Node = _render()
	fun renderToHtml(): String = renderToNode().toHtml()


	// Html node shorthand
	fun h(nodeName: String, props: Map<String, String>?, children: List<Node>?): Node {
		return HtmlNode(nodeName, props, children)
	}

	// Mount a custom component
	fun h(component: AbstractComponent): Node = component.render()

	// Text node shorthand
	fun text(text: String): Node = TextNode(text)

	// File node shorthand
	fun file(text: String, loadOnCreate: Boolean): Node = FileNode(text, loadOnCreate)

	// Html element shorthands
	fun html(props: Map<String, String>?, children: List<Node>?): Node = h("html", props, children)
	fun body(props: Map<String, String>?, children: List<Node>?): Node = h("body", props, children)
	fun head(props: Map<String, String>?, children: List<Node>?): Node = h("head", props, children)
	fun div(props: Map<String, String>?, children: List<Node>?): Node = h("div", props, children)
	fun h1(props: Map<String, String>?, children: List<Node>?): Node = h("h1", props, children)
	fun h2(props: Map<String, String>?, children: List<Node>?): Node = h("h2", props, children)
	fun h3(props: Map<String, String>?, children: List<Node>?): Node = h("h3", props, children)
	fun h4(props: Map<String, String>?, children: List<Node>?): Node = h("h4", props, children)
	fun h5(props: Map<String, String>?, children: List<Node>?): Node = h("h5", props, children)
	fun h6(props: Map<String, String>?, children: List<Node>?): Node = h("h6", props, children)
	fun script(src: String, props: Map<String, String> = mapOf<String, String>()): Node {
		val mutableProps = props.toMutableMap()
		mutableProps.put("src", src)
		return h("script", mutableProps, null)
	}
}
