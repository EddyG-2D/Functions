import org.junit.Test

import org.junit.Assert.*

class CommissionKtTest {

    @Test
    fun calculationCommissionMasterCard() {
        val typeCard = "MasterCard"
        val previousSum = 0
        val percentCommissionMasterCard = 0.006
        val minCommissionMasterCard = 20
        val percentCommissionVisa = 0.0075
        val minCommissionVisa = 35
        val maxMonthLimitMasterCard = 75_000
        val maxDayLimitCard = 150_000
        val maxMonthLimitCard = 600_000
        val expectedResult = 79_950
        val amount = 80_000

        val result = calculationCommission(typeCard, previousSum, amount, percentCommissionMasterCard,
            minCommissionMasterCard, percentCommissionVisa, minCommissionVisa, maxMonthLimitMasterCard,
            maxDayLimitCard, maxMonthLimitCard)

        assertEquals(expectedResult, result)
    }

    @Test
    fun calculationCommissionMaxMonthlyLimitMasterCard() {
        val typeCard = "MasterCard"
        val previousSum = 50_000
        val percentCommissionMasterCard = 0.006
        val minCommissionMasterCard = 20
        val percentCommissionVisa = 0.0075
        val minCommissionVisa = 35
        val maxMonthLimitMasterCard = 75_000
        val maxDayLimitCard = 150_000
        val maxMonthLimitCard = 600_000
        val expectedResult = 25_000
        val amount = 25_000

        val result = calculationCommission(typeCard, previousSum, amount, percentCommissionMasterCard,
            minCommissionMasterCard, percentCommissionVisa, minCommissionVisa, maxMonthLimitMasterCard,
            maxDayLimitCard, maxMonthLimitCard)

        assertEquals(expectedResult, result)
    }

    @Test
    fun calculationCommissionMIR() {
        val typeCard = "MIR"
        val previousSum = 0
        val percentCommissionMasterCard = 0.006
        val minCommissionMasterCard = 20
        val percentCommissionVisa = 0.0075
        val minCommissionVisa = 35
        val maxMonthLimitMasterCard = 75_000
        val maxDayLimitCard = 150_000
        val maxMonthLimitCard = 600_000
        val expectedResult = 50_000
        val amount = 50_000

        val result = calculationCommission(typeCard, previousSum, amount, percentCommissionMasterCard,
            minCommissionMasterCard, percentCommissionVisa, minCommissionVisa, maxMonthLimitMasterCard,
            maxDayLimitCard, maxMonthLimitCard)

        assertEquals(expectedResult, result)
    }
    @Test
    fun calculationCommissionVisa() {
        val typeCard = "VISA"
        val previousSum = 0
        val percentCommissionMasterCard = 0.006
        val minCommissionMasterCard = 20
        val percentCommissionVisa = 0.0075
        val minCommissionVisa = 35
        val maxMonthLimitMasterCard = 75_000
        val maxDayLimitCard = 150_000
        val maxMonthLimitCard = 600_000
        val expectedResult = 9_925
        val amount = 10_000

        val result = calculationCommission(typeCard, previousSum, amount, percentCommissionMasterCard,
            minCommissionMasterCard, percentCommissionVisa, minCommissionVisa, maxMonthLimitMasterCard,
            maxDayLimitCard, maxMonthLimitCard)

        assertEquals(expectedResult, result)
    }

    @Test
    fun calculationMinCommissionVisa() {
        val typeCard = "VISA"
        val previousSum = 0
        val percentCommissionMasterCard = 0.006
        val minCommissionMasterCard = 20
        val percentCommissionVisa = 0.0075
        val minCommissionVisa = 35
        val maxMonthLimitMasterCard = 75_000
        val maxDayLimitCard = 150_000
        val maxMonthLimitCard = 600_000
        val expectedResult = 965
        val amount = 1_000

        val result = calculationCommission(typeCard, previousSum, amount, percentCommissionMasterCard,
            minCommissionMasterCard, percentCommissionVisa, minCommissionVisa, maxMonthLimitMasterCard,
            maxDayLimitCard, maxMonthLimitCard)

        assertEquals(expectedResult, result)
    }

    @Test
    fun maxDayLimitCard() {
        val typeCard = "MasterCard"
        val previousSum = 90_000
        val percentCommissionMasterCard = 0.006
        val minCommissionMasterCard = 20
        val percentCommissionVisa = 0.0075
        val minCommissionVisa = 35
        val maxMonthLimitMasterCard = 75_000
        val maxDayLimitCard = 150_000
        val maxMonthLimitCard = 600_000
        val expectedResult = 0
        val amount = 80_000

        val result = calculationCommission(typeCard, previousSum, amount, percentCommissionMasterCard,
            minCommissionMasterCard, percentCommissionVisa, minCommissionVisa, maxMonthLimitMasterCard,
            maxDayLimitCard, maxMonthLimitCard)

        assertEquals(expectedResult, result)
    }
    
    @Test
    fun maxMonthlyLimitCard() {
        val typeCard = "MasterCard"
        val previousSum = 500_000
        val percentCommissionMasterCard = 0.006
        val minCommissionMasterCard = 20
        val percentCommissionVisa = 0.0075
        val minCommissionVisa = 35
        val maxMonthLimitMasterCard = 75_000
        val maxDayLimitCard = 150_000
        val maxMonthLimitCard = 600_000
        val expectedResult = 0
        val amount = 180_000

        val result = calculationCommission(typeCard, previousSum, amount, percentCommissionMasterCard,
            minCommissionMasterCard, percentCommissionVisa, minCommissionVisa, maxMonthLimitMasterCard,
            maxDayLimitCard, maxMonthLimitCard)

        assertEquals(expectedResult, result)
    }
}

