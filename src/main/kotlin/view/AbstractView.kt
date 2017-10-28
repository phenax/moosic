package view


abstract class Node {
	abstract fun toHtml(): String
}


class HtmlNode(val nodeName: String, val props: Map<String, String>?, val children: List<Node>?): Node() {

	override fun toHtml(): String {

		var propsString = props?.map({ "${it.key}=\"${it.value}\"" })?.joinToString(" ")
		var childrenHtml = children?.map({ it.toHtml() })?.joinToString(" ")

		propsString = if(propsString != null) " $propsString" else ""
		childrenHtml = if(childrenHtml != null) childrenHtml else ""

		return "<$nodeName$propsString>${childrenHtml}</$nodeName>"
	}
}

class TextNode(val text: String): Node() {

	override fun toHtml(): String {
		return text;
	}
}

abstract class AbstractComponent: AbstractView() {
	override abstract fun render(): Node
}

abstract class AbstractView {
	abstract fun render(): Node

	fun renderToHtml(): String {
		return render().toHtml()
	}

	fun h(nodeName: String, props: Map<String, String>?, children: List<Node>?): Node {
		return HtmlNode(nodeName, props, children)
	}
	fun h(component: AbstractComponent): Node {
		return component.render()
	}

	fun text(text: String): Node {
		return TextNode(text)
	}

	// fun html(props?: Map<String, String>, children?: List<Node>) { return h("html", props, children) }
	// fun body(props?: Map<String, String>, children?: List<Node>) { return h("body", props, children) }
	// fun head(props?: Map<String, String>, children?: List<Node>) { return h("head", props, children) }
	// fun div(props?: Map<String, String>, children?: List<Node>) { return h("div", props, children) }
	// fun h1(props?: Map<String, String>, children?: List<Node>) { return h("h1", props, children) }
	// fun h2(props?: Map<String, String>, children?: List<Node>) { return h("h2", props, children) }
	// fun h3(props?: Map<String, String>, children?: List<Node>) { return h("h3", props, children) }
	// fun h4(props?: Map<String, String>, children?: List<Node>) { return h("h4", props, children) }
	// fun h5(props?: Map<String, String>, children?: List<Node>) { return h("h5", props, children) }
	// fun h6(props?: Map<String, String>, children?: List<Node>) { return h("h6", props, children) }

	// fun script(src: String, async: Boolean = true, defer: Boolean = true) {
	// 	val props = MutableMap()

	// 	props.put("src", src)

	// 	if(async) props.put("async", "async")
	// 	if(defer) props.put("defer", "defer")

	// 	return h("script", props)
	// }
}
