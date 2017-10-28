package view

abstract class AbstractComponent: AbstractView() {
	abstract val layout: AbstractLayout

	override protected fun _render(): Node {
		return layout.render(this)
	}
}
