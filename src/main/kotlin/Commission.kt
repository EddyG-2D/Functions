fun main () {
    var typeCard = "MIR"
    val previousSum = 0

       print("Введите сумму перевода в рублях: ")
    val amount: Int = readln().toInt()

       print("Введите номер (первую цифру) карты для перевода: ")
    val numberCard = readln().toCharArray()
    val symbolCard = (numberCard.first())
    when (symbolCard.toString()) {
        "2" -> typeCard = "MIR"
        "4" -> typeCard = "VISA"
        "5" -> typeCard = "MasterCard"
    }

    calculationCommission(typeCard, previousSum, amount)
}

fun calculationCommission(typeCard: String, previousSum: Int, amount: Int) {
    val percentComissionMasterCard = 0.6
    val minСomissionMasterCard = 20
    val percentComissionVisa = 0.75
    val minComissionVisa = 35
    val maxMonthLimitMasterCard = 75_000
    val maxDayLimitCard = 150_000
    val maxMonthLimitCard = 600_000
    var sumTransfer = 0

    println(typeCard)

       if (amount + previousSum <= maxMonthLimitCard) {
            if (amount + previousSum <= maxDayLimitCard) {
                if (typeCard == "MIR") {
                    sumTransfer = amount
                    println("Сумма комиссии: 0 руб.")
                    println("Сумма перевода: $sumTransfer")
                }

                if (typeCard == "VISA") {
                    if ((amount * percentComissionVisa / 100) < minComissionVisa) {
                    sumTransfer = (amount - minComissionVisa)
                    println("Сумма комиссии: $minComissionVisa")
                } else {
                    sumTransfer = (amount - (amount * percentComissionVisa / 100)).toInt()
                    println("Сумма комиссии: " + (amount * percentComissionVisa / 100))
                }
                println("Сумма перевода: $sumTransfer")
            }

            if (typeCard == "MasterCard") {
                if ((amount + previousSum) <= maxMonthLimitMasterCard) {
                    sumTransfer = amount
                    println("Сумма комиссии: 0 руб.")
                    println("Сумма перевода: $sumTransfer")
                } else {
                    sumTransfer = ((amount - (((amount + previousSum) - maxMonthLimitMasterCard)
                            * percentComissionMasterCard / 100)) - minСomissionMasterCard).toInt()
                    println("Сумма комиссии: " + ((((amount + previousSum) - maxMonthLimitMasterCard)
                            * percentComissionMasterCard / 100) + minСomissionMasterCard))
                    println("Сумма перевода: $sumTransfer")
                }
            }

            } else {
            println("Превышен лимит перевода по карте за сутки")
        }

       } else {
        println("Превышен лимит перевода по карте за месяц")
    }

}