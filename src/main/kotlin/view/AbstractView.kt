package view

abstract class AbstractView {
	abstract fun render(): Node

	open protected fun _render(): Node { return render() }

	// Render to node and html methods
	fun renderToNode(): Node { return _render() }
	fun renderToHtml(): String { return renderToNode().toHtml() }


	// Html node shorthand
	fun h(nodeName: String, props: Map<String, String>?, children: List<Node>?): Node {
		return HtmlNode(nodeName, props, children)
	}

	// Mount a custom component
	fun h(component: AbstractComponent): Node { return component.render() }

	// Text node shorthand
	fun text(text: String): Node { return TextNode(text) }

	// Html element shorthands
	fun html(props: Map<String, String>?, children: List<Node>?): Node { return h("html", props, children) }
	fun body(props: Map<String, String>?, children: List<Node>?): Node { return h("body", props, children) }
	fun head(props: Map<String, String>?, children: List<Node>?): Node { return h("head", props, children) }
	fun div(props: Map<String, String>?, children: List<Node>?): Node { return h("div", props, children) }
	fun h1(props: Map<String, String>?, children: List<Node>?): Node { return h("h1", props, children) }
	fun h2(props: Map<String, String>?, children: List<Node>?): Node { return h("h2", props, children) }
	fun h3(props: Map<String, String>?, children: List<Node>?): Node { return h("h3", props, children) }
	fun h4(props: Map<String, String>?, children: List<Node>?): Node { return h("h4", props, children) }
	fun h5(props: Map<String, String>?, children: List<Node>?): Node { return h("h5", props, children) }
	fun h6(props: Map<String, String>?, children: List<Node>?): Node { return h("h6", props, children) }
	fun script(src: String, props: Map<String, String>?): Node { return h("script", props, null) }
}
