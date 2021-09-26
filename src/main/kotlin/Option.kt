class Option(override val name: String): OptionItem {
    override fun open(indentation: Int) {
        val indentString = " ".repeat(indentation)
        println(indentString + name)
    }
}