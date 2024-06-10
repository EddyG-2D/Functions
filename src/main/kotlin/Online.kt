fun main () {
    
    print("Введите количество секунд: ")
    val elapsedTime: Int = readln().toInt()
    agoToText(elapsedTime)
}

fun agoToText (timeVisiting:Int) {
    var solution = "давно"
    when (timeVisiting) {
        in 0..60 -> solution = "только что"
        in 61..3600 -> solution = agoToMinute(timeVisiting)
        in 3601..86400 -> solution = agoToHour(timeVisiting)
        in 86401..259200 -> solution = agoToDay(timeVisiting)
        else -> solution
    }
    println("был(а) $solution")
}

fun agoToMinute (timeVisiting:Int):String {
    var solution = ""

    when (timeVisiting / 60 % 10) {
        0 -> solution = "${timeVisiting / 60} минут назад"
        1 -> solution = "${timeVisiting / 60} минуту назад"
        in 2..4 -> solution = "${timeVisiting / 60} минуты назад"
        in 5..10 -> solution = "${timeVisiting / 60} минут назад"
    }

    when (timeVisiting / 60) {
        in 0..1 -> solution = "${timeVisiting / 60} минуту назад"
        in 2..4 -> solution = "${timeVisiting / 60} минуты назад"
        in 5..20 -> solution = "${timeVisiting / 60} минут назад"
    }
    return solution
}

fun agoToHour (timeVisiting:Int):String {
    var solution = ""

    when (timeVisiting / 3600 % 10) {
        1 -> solution = "${timeVisiting / 3600} час назад"
        in 2..4 -> solution = "${timeVisiting / 3600} часа назад"
        in 5..10 -> solution = "${timeVisiting / 3600} часов назад"
    }

    when (timeVisiting / 3600) {
        in 0..1 -> solution = "${timeVisiting / 3600} час назад"
        in 2..4 -> solution = "${timeVisiting / 3600} часа назад"
        in 5..20 -> solution = "${timeVisiting / 3600} часов назад"
    }
    return solution
}

fun agoToDay (timeVisiting:Int):String {
    var solution = ""

    when (timeVisiting / 86400) {
        1 -> solution = "вчера"
        in 2..3 -> solution = "позавчера"

    }
    return solution
}