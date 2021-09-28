class Menu(override val name: String, override var upperMenu: Menu? = null): OptionItem {
    private val items = mutableListOf<OptionItem>()

    fun addItem(item: OptionItem) {
        item.upperMenu = this
        items.add(item)
    }

    override fun open(itemIndex: Int?): OptionItem {
        if (itemIndex != null) return items[itemIndex]

        println(this.getItemName())
        for ((index, item) in items.withIndex()) {
            println(" ${(index + 1)} ${item.getItemName()}")
        }
        return this
    }

    override fun getItemName(): String {
        return "/ $name"
    }
}