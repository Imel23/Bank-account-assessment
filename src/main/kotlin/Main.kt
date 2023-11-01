
var accountBalance=(0..1000).random()

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
    println("Account Balance: $accountBalance")
    val money=(0..1000).random()
    println("deposited/withdrawn Balance: $money")
    var output=0
    output = withdraw(money)
    println("output: $output")
    output = debitWithdraw(money)
    println("output: $output")
    output = deposit(money)
    println("output: $output")
    output = creditDeposit(money)
    println("output: $output")

}

fun withdraw(amount: Int):Int{
    accountBalance-=amount
    println("Amount of money withdrawn: $amount, account’s updated balance: $accountBalance")
    return amount
}

fun debitWithdraw(amount: Int):Int{

    if(accountBalance==0){
        println("Can't withdraw, no money on this account!")
        return accountBalance
    }else if(amount > accountBalance){
        println("Not enough money on this account! The checking balance is ${accountBalance} dollars.")
        return 0
    }else{
        return withdraw(amount)
    }
}

fun deposit(amount: Int): Int{
    accountBalance+=amount
    println("Amount of money deposited: $amount, account’s updated balance: $accountBalance")
    return amount
}

fun creditDeposit(amount: Int):Int{
    if(accountBalance==0){
        println("You don't need to deposit anything in order to pay off the account since it has already been paid off.")
        return accountBalance
    }else if((accountBalance + amount)>0){
        println("Deposit failed, you tried to pay off an amount greater than the credit balance. The checking " +
                "balance is $accountBalance dollars")
        return 0
    }else if(amount==-accountBalance){
        accountBalance = 0
        println("You have paid off this account!")
        return amount
    }else{
        return deposit(amount)
    }
}