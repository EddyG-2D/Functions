fun main () {
    var typeCard = "MIR"
    val previousSum = 0
    val percentCommissionMasterCard = 0.006
    val minCommissionMasterCard = 20
    val percentCommissionVisa = 0.0075
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

fun calculationCommission(typeCard: String, previousSum: Int = 0, amount: Int,
                          percentCommissionMasterCard: Double = 0.006, minCommissionMasterCard: Int = 20,
                          percentCommissionVisa: Double = 0.0075, minCommissionVisa: Int = 35,
                          maxMonthLimitMasterCard: Int = 75_000, maxDayLimitCard: Int = 150_000,
                          maxMonthLimitCard: Int = 600_000): Int {
    var sumTransfer = 0
    println(typeCard)

    if (amount + previousSum <= maxMonthLimitCard) {
        if (amount + previousSum <= maxDayLimitCard) {
            if (typeCard == "MIR") {
                sumTransfer = amount
                println("Сумма комиссии: 0 руб.")
                println("Сумма перевода: $sumTransfer руб.")
            }


            if (typeCard == "VISA") {
                if ((amount * percentCommissionVisa) < minCommissionVisa) {
                    sumTransfer = (amount - minCommissionVisa)
                    println("Сумма комиссии: $minCommissionVisa руб.")

                } else {
                    sumTransfer = (amount - (amount * percentCommissionVisa)).toInt()
                    println("Сумма комиссии: " + (amount * percentCommissionVisa) + " руб.")
                }

                println("Сумма перевода: $sumTransfer руб.")
            }

            if (typeCard == "MasterCard") {
                if ((amount + previousSum) <= maxMonthLimitMasterCard) {
                    sumTransfer = amount
                    println("Сумма комиссии: 0 руб.")
                }

                if (previousSum > maxMonthLimitMasterCard) {
                    sumTransfer = (amount - (amount * percentCommissionMasterCard) - minCommissionMasterCard).toInt()
                    println("Сумма комиссии: " + ((amount * percentCommissionMasterCard) + minCommissionMasterCard) + " руб.")
                }
                if ((amount + previousSum) > maxMonthLimitMasterCard && previousSum <= maxMonthLimitMasterCard) {
                    sumTransfer = ((amount - (((amount + previousSum) - maxMonthLimitMasterCard)
                            * percentCommissionMasterCard)) - minCommissionMasterCard).toInt()
                    println(
                        "Сумма комиссии: " + ((((amount + previousSum) - maxMonthLimitMasterCard)
                                * percentCommissionMasterCard) + minCommissionMasterCard) + " руб."
                    )
                }
                println("Сумма перевода: $sumTransfer руб.")
            }

        } else {
            println("Превышен лимит перевода по карте за сутки")
        }

    } else {
        println("Превышен лимит перевода по карте за месяц")
    }
    return sumTransfer
}
