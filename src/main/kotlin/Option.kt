class Option(override val name: String, val action: () -> Unit): OptionItem {
    override var upperMenu: Menu? = null

    override fun open(itemIndex: Int?): OptionItem? {
        action()
        return null
    }

    override fun getItemName(): String {
        return "► $name"
    }
}