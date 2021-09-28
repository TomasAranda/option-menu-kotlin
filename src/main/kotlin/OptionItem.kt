interface OptionItem {
    val name: String
    var upperMenu: Menu?

    fun open(itemIndex: Int? = null): OptionItem?
    fun getItemName(): String
}