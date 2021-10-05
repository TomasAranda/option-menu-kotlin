import java.lang.NumberFormatException

fun main() {
    // Aux variable for user input
    var selectedOption: Int? = 0

    // BEGINNING OF MENU ELEMENTS DEFINITION
    val rootMenu = Menu("File Menu")

    val newMenu = Menu("New")
    val recentMenu = Menu("Open Recent")

    val settingsOption = Option("Settings", action = { println("OPENED SETTINGS") })
    val exitOption = Option("Exit") {
        selectedOption = -1
        println("EXITING")
    }

    val newProjectOption = Option("New Project") { println("OPENED NEW PROJECT") }
    val newKotlinFileOption = Option("New Kotlin File") { println("OPENED NEW KOTLIN FILE") }
    val newModuleOption = Option("New Module") { println("OPENED NEW MODULE") }

    val recent1Option = Option("recentFile1") { println("OPENED recentFile1") }
    val recent2Option = Option("recentFile2") { println("OPENED recentFile2") }
    val recent3Option = Option("recentFile3") { println("OPENED recentFile3") }

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
    // END OF MENU ELEMENTS DEFINITION

    var currentItem: OptionItem? = rootMenu

    val selectOption = { try { readLine()?.toInt() } catch (e: NumberFormatException) { null } }

    userInputLoop@ while (selectedOption!! >= 0) {
        println("Select an item:")
        println("(0 to go to the upper folder)")
        println("(negative value to exit)")
        currentItem?.open()
        selectedOption = selectOption()

        when (selectedOption) {
        // Handle invalid input
            null -> {
                println("Option invalid. Try again")
                selectedOption = 0
            }
        // Go to upper folder
            0 -> {
                if (currentItem?.upperMenu == null) {
                    println("This is the root directory.")
                } else currentItem = currentItem.upperMenu
            }
        // Open item or folder
            else -> {
                currentItem = try { currentItem?.open(selectedOption!! - 1) } catch (e: IndexOutOfBoundsException) { currentItem }
                if (currentItem !is Menu) {
                    currentItem?.open()
                    if (selectedOption!! < 0) {
                        break@userInputLoop
                    }
                    selectedOption = null
                }
                // When final option is reached ask for exiting or going back
                while (selectedOption == null) {
                    println("Do you want to go back? (0) \nOr Exit? (any other number)")
                    selectedOption = selectOption()
                    when (selectedOption) {
                        0 -> {
                            currentItem = currentItem?.upperMenu
                        }
                        else -> {
                            break@userInputLoop
                        }
                    }
                }
            }
        }
    }

    println("Goodbye!")

}