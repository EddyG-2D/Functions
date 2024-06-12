fun main () {
    var typeCard = "MIR"
    val previousSum = 0
    val percentCommissionMasterCard = 0.6
    val minCommissionMasterCard = 20
    val percentCommissionVisa = 0.75
    val minCommissionVisa = 35
    val maxMonthLimitMasterCard = 75_000
    val maxDayLimitCard = 150_000
    val maxMonthLimitCard = 600_000

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

    calculationCommission(typeCard, previousSum, amount, percentCommissionMasterCard, minCommissionMasterCard,
        percentCommissionVisa, minCommissionVisa, maxMonthLimitMasterCard, maxDayLimitCard, maxMonthLimitCard)
}

fun calculationCommission(typeCard: String, previousSum: Int, amount: Int, percentCommissionMasterCard: Double,
                          minCommissionMasterCard: Int, percentCommissionVisa: Double, minCommissionVisa: Int,
                          maxMonthLimitMasterCard: Int, maxDayLimitCard: Int, maxMonthLimitCard: Int) {
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
                    if ((amount * percentCommissionVisa / 100) < minCommissionVisa) {
                    sumTransfer = (amount - minCommissionVisa)
                    println("Сумма комиссии: $minCommissionVisa")

                } else {
                    sumTransfer = (amount - (amount * percentCommissionVisa / 100)).toInt()
                    println("Сумма комиссии: " + (amount * percentCommissionVisa / 100))
                }

                println("Сумма перевода: $sumTransfer")
            }

            if (typeCard == "MasterCard") {
                if ((amount + previousSum) <= maxMonthLimitMasterCard) {
                    sumTransfer = amount
                    println("Сумма комиссии: 0 руб.")
                }

                if (previousSum > maxMonthLimitMasterCard) {
                    sumTransfer = (amount - (amount * percentCommissionMasterCard / 100) - minCommissionMasterCard).toInt()
                    println("Сумма комиссии: " + ((amount * percentCommissionMasterCard / 100) + minCommissionMasterCard))
                }
                if ((amount + previousSum) > maxMonthLimitMasterCard && previousSum <= maxMonthLimitMasterCard) {
                    sumTransfer = ((amount - (((amount + previousSum) - maxMonthLimitMasterCard)
                            * percentCommissionMasterCard / 100)) - minCommissionMasterCard).toInt()
                    println("Сумма комиссии: " + ((((amount + previousSum) - maxMonthLimitMasterCard)
                            * percentCommissionMasterCard / 100) + minCommissionMasterCard))
                }
                println("Сумма перевода: $sumTransfer")
            }

            } else {
            println("Превышен лимит перевода по карте за сутки")
        }

       } else {
        println("Превышен лимит перевода по карте за месяц")
    }

}