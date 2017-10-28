package view

abstract class AbstractLayout: AbstractView() {
	override fun render(): Node { throw Exception("Need to pass component") }
	abstract fun render(component: AbstractComponent): Node
}
