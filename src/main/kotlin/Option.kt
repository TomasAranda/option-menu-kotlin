class Option(override val name: String, override var upperMenu: Menu? = null, val action: () -> Unit): OptionItem {
    override fun open(itemIndex: Int?): OptionItem? {
        action()
        return null
    }

    override fun getItemName(): String {
        return "► $name"
    }
}