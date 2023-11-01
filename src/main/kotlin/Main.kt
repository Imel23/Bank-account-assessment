fun main() {
    var accountType=""
    var userChoice=0
    println("Welcome to your banking system. \n")
    println("What type of account would you like to create?\n" )
    println("1. Debit account")
    println("2. Credit account")
    println("3. Checking account")

    while(accountType=="") {
        while ((userChoice !in listOf(1, 2, 3))) {
            println("Choose an option (1, 2 or 3)")
            userChoice = readln().toInt()
        }
        println("The selected option is $userChoice")
        when (userChoice) {
            1 -> accountType = "debit"
            2 -> accountType = "credit"
            3 -> accountType = "checking"
        }
        println("You have created a $accountType account.")
    }
}