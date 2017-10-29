package view

import java.io.File

abstract class Node {
	abstract fun toHtml(): String
}

class HtmlNode(val nodeName: String, val props: Map<String, String>? = null, val children: List<Node>? = null): Node() {

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

class FileNode(val filePath: String, val loadOnCreate: Boolean): Node() {

	private val _fileContents = if(loadOnCreate) _readFile() else ""

	private fun _readFile(): String {
		return File(filePath)
			.inputStream()
			.bufferedReader()
			.use { it.readText() }
	}

	override fun toHtml(): String {
		return if(loadOnCreate) _fileContents else _readFile()
	}
}
