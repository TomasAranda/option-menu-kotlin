class Menu(override val name: String): OptionItem {
    private val items = mutableListOf<OptionItem>()

    fun addItem(item: OptionItem) {
        items.add(item)
    }

    override fun open(indentation: Int) {
        val indentString = " ".repeat(indentation)

        println("$indentString/ $name")

        for ((index, item) in items.withIndex()) {
            item.open(indentation*2)
        }
    }
}