fun main() {
    val rootMenu = Menu("File Menu")

    val newMenu = Menu("New")
    val recentMenu = Menu("Open Recent")

    val settingsOption = Option("Settings")
    val exitOption = Option("Exit")

    val newProjectOption = Option("New Project")
    val newKotlinFileOption = Option("New Kotlin File")
    val newModuleOption = Option("New Module")

    val recent1Option = Option("recentFile1")
    val recent2Option = Option("recentFile2")
    val recent3Option = Option("recentFile3")

    rootMenu.addItem(newMenu)
    rootMenu.addItem(recentMenu)
    rootMenu.addItem(settingsOption)
    rootMenu.addItem(exitOption)

    newMenu.addItem(newProjectOption)
    newMenu.addItem(newKotlinFileOption)
    newMenu.addItem(newModuleOption)

    recentMenu.addItem(recent1Option)
    recentMenu.addItem(recent2Option)
    recentMenu.addItem(recent3Option)

    rootMenu.open()
}