import org.junit.Test

import org.junit.Assert.*

class CommissionKtTest {

    @Test
    fun calculationCommission() {
        var typeCard = "MIR"
        var sumTransfer = 0
        val expectedResult = 0

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
        val result =  calculationCommission(typeCard, previousSum = 0, amount,
            percentCommissionMasterCard = 0.6, minCommissionMasterCard = 20,
            percentCommissionVisa = 0.75, minCommissionVisa = 35,
            maxMonthLimitMasterCard = 75_000, maxDayLimitCard = 150_000,
            maxMonthLimitCard = 600_000)

        assertEquals(expectedResult, result)

    }
}

