class BankAccount(val accountHolder: String, initialBalance: Double = 0.0) {
    // El setter impide que el saldo quede negativo
    var balance: Double = initialBalance
        set(value) {
            require(value >= 0.0) { "Balance must be non-negative" }
            field = value
        }

    // Propiedad de respaldo: la lista modificable solo se ve desde dentro
    private val _transactionHistory: MutableList<String> = mutableListOf()

    // Desde fuera solo se puede consultar, como List<String>
    val transactionHistory: List<String>
        get() = _transactionHistory

    // El setter no se ejecuta al inicializar: validamos aquí el saldo inicial
    init {
        require(initialBalance >= 0.0) { "Balance must be non-negative" }
    }

    fun deposit(amount: Double) {
        require(amount > 0.0) { "Deposit amount must be positive" }
        balance += amount
        _transactionHistory.add("Deposit: $amount")
    }

    fun withdraw(amount: Double) {
        require(amount > 0.0) { "Withdrawal amount must be positive" }
        require(amount <= balance) { "Insufficient funds" }
        balance -= amount
        _transactionHistory.add("Withdraw: $amount")
    }
}

fun main() {
    val account = BankAccount("Daniel", 100.0)
    account.deposit(30.0)
    account.withdraw(10.0)
    account.withdraw(120.0)   // se queda a 0: está permitido
    println("Titular: ${account.accountHolder} · Saldo: ${account.balance}")

    try {
        account.deposit(-5.0)
    } catch (e: IllegalArgumentException) {
        println("Error: ${e.message}")
    }
    try {
        account.withdraw(50.0)
    } catch (e: IllegalArgumentException) {
        println("Error: ${e.message}")
    }
    try {
        account.balance = -1.0
    } catch (e: IllegalArgumentException) {
        println("Error: ${e.message}")
    }

    println("Historial:")
    for (transaction in account.transactionHistory) {
        println("- $transaction")
    }
}
