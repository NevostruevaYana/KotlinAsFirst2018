@file:Suppress("UNUSED_PARAMETER", "ConvertCallChainIntoSequence")

package lesson4.task1

import lesson3.task1.minDivisor
import lesson1.task1.discriminant
import kotlin.math.sqrt

/**
 * Пример
 *
 * Найти все корни уравнения x^2 = y
 */
fun sqRoots(y: Double) =
        when {
            y < 0 -> listOf()
            y == 0.0 -> listOf(0.0)
            else -> {
                val root = sqrt(y)
                // Результат!
                listOf(-root, root)
            }
        }

/**
 * Пример
 *
 * Найти все корни биквадратного уравнения ax^4 + bx^2 + c = 0.
 * Вернуть список корней (пустой, если корней нет)
 */
fun biRoots(a: Double, b: Double, c: Double): List<Double> {
    if (a == 0.0) {
        return if (b == 0.0) listOf()
        else sqRoots(-c / b)
    }
    val d = discriminant(a, b, c)
    if (d < 0.0) return listOf()
    if (d == 0.0) return sqRoots(-b / (2 * a))
    val y1 = (-b + sqrt(d)) / (2 * a)
    val y2 = (-b - sqrt(d)) / (2 * a)
    return sqRoots(y1) + sqRoots(y2)
}

/**
 * Пример
 *
 * Выделить в список отрицательные элементы из заданного списка
 */
fun negativeList(list: List<Int>): List<Int> {
    val result = mutableListOf<Int>()
    for (element in list) {
        if (element < 0) {
            result.add(element)
        }
    }
    return result
}

/**
 * Пример
 *
 * Изменить знак для всех положительных элементов списка
 */
fun invertPositives(list: MutableList<Int>) {
    for (i in 0 until list.size) {
        val element = list[i]
        if (element > 0) {
            list[i] = -element
        }
    }
}

/**
 * Пример
 *
 * Из имеющегося списка целых чисел, сформировать список их квадратов
 */
fun squares(list: List<Int>) = list.map { it * it }

/**
 * Пример
 *
 * Из имеющихся целых чисел, заданного через vararg-параметр, сформировать массив их квадратов
 */
fun squares(vararg array: Int) = squares(array.toList()).toTypedArray()

/**
 * Пример
 *
 * По заданной строке str определить, является ли она палиндромом.
 * В палиндроме первый символ должен быть равен последнему, второй предпоследнему и т.д.
 * Одни и те же буквы в разном регистре следует считать равными с точки зрения данной задачи.
 * Пробелы не следует принимать во внимание при сравнении символов, например, строка
 * "А роза упала на лапу Азора" является палиндромом.
 */
fun isPalindrome(str: String): Boolean {
    val lowerCase = str.toLowerCase().filter { it != ' ' }
    for (i in 0..lowerCase.length / 2) {
        if (lowerCase[i] != lowerCase[lowerCase.length - i - 1]) return false
    }
    return true
}

/**
 * Пример
 *
 * По имеющемуся списку целых чисел, например [3, 6, 5, 4, 9], построить строку с примером их суммирования:
 * 3 + 6 + 5 + 4 + 9 = 27 в данном случае.
 */
fun buildSumExample(list: List<Int>) = list.joinToString(separator = " + ", postfix = " = ${list.sum()}")

/**
 * Простая
 *
 * Найти модуль заданного вектора, представленного в виде списка v,
 * по формуле abs = sqrt(a1^2 + a2^2 + ... + aN^2).
 * Модуль пустого вектора считать равным 0.0.
 */
fun abs(v: List<Double>): Double = sqrt(v.map { it * it }.sum())

/**
 * Простая
 *
 * Рассчитать среднее арифметическое элементов списка list. Вернуть 0.0, если список пуст
 */
fun mean(list: List<Double>): Double {
    if (list.isEmpty()) return 0.0
    var s = 0.0
    var n = 0
    for (i in list) {
        s += i
        n += 1
    }
    return s / n
}

/**
 * Средняя
 *
 * Центрировать заданный список list, уменьшив каждый элемент на среднее арифметическое всех элементов.
 * Если список пуст, не делать ничего. Вернуть изменённый список.
 *
 * Обратите внимание, что данная функция должна изменять содержание списка list, а не его копии.
 */
fun center(list: MutableList<Double>): MutableList<Double> {
    val n = mean(list)
    for (i in 0 until list.size) list[i] -= n
    return list
}

/**
 * Средняя
 *
 * Найти скалярное произведение двух векторов равной размерности,
 * представленные в виде списков a и b. Скалярное произведение считать по формуле:
 * C = a1b1 + a2b2 + ... + aNbN. Произведение пустых векторов считать равным 0.0.
 */
fun times(a: List<Double>, b: List<Double>): Double {
    var s = 0.0
    for (i in 0 until a.size) s += a[i] * b[i]
    return s
}

/**
 * Средняя
 *
 * Рассчитать значение многочлена при заданном x:
 * p(x) = p0 + p1*x + p2*x^2 + p3*x^3 + ... + pN*x^N.
 * Коэффициенты многочлена заданы списком p: (p0, p1, p2, p3, ..., pN).
 * Значение пустого многочлена равно 0.0 при любом x.
 */
fun polynom(p: List<Double>, x: Double): Double {
    var x1 = 1.0
    var s = 0.0
    for (i in 0 until p.size){
        s += p[i] * x1
        x1 *= x
    }
    return s
}

/**
 * Средняя
 *
 * В заданном списке list каждый элемент, кроме первого, заменить
 * суммой данного элемента и всех предыдущих.
 * Например: 1, 2, 3, 4 -> 1, 3, 6, 10.
 * Пустой список не следует изменять. Вернуть изменённый список.
 *
 * Обратите внимание, что данная функция должна изменять содержание списка list, а не его копии.
 */
fun accumulate(list: MutableList<Double>): MutableList<Double> {
    list.foldIndexed(0.0) { i, n, _ ->
        list[i] += n
        list[i]
    }
    return list
}

/**
 * Средняя
 *
 * Разложить заданное натуральное число n > 1 на простые множители.
 * Результат разложения вернуть в виде списка множителей, например 75 -> (3, 5, 5).
 * Множители в списке должны располагаться по возрастанию.
 */
fun factorize(n: Int): List<Int> {
    val s = mutableListOf<Int>()
    var i = n
    while (i > 1) {
        s.add(minDivisor(i))
        i /= minDivisor(i)
    }
    return s
}

/**
 * Сложная
 *
 * Разложить заданное натуральное число n > 1 на простые множители.
 * Результат разложения вернуть в виде строки, например 75 -> 3*5*5
 * Множители в результирующей строке должны располагаться по возрастанию.
 */
fun factorizeToString(n: Int): String = factorize(n).joinToString(separator = "*")

/**
 * Средняя
 *
 * Перевести заданное целое число n >= 0 в систему счисления с основанием base > 1.
 * Результат перевода вернуть в виде списка цифр в base-ичной системе от старшей к младшей,
 * например: n = 100, base = 4 -> (1, 2, 1, 0) или n = 250, base = 14 -> (1, 3, 12)
 */
fun convert(n: Int, base: Int): List<Int> {
    val list = mutableListOf<Int>()
    var m = n
    do {
        list.add(0, m % base)
        m /= base
    } while (m != 0)
    return list
}

/**
 * Сложная
 *
 * Перевести заданное целое число n >= 0 в систему счисления с основанием 1 < base < 37.
 * Результат перевода вернуть в виде строки, цифры более 9 представлять латинскими
 * строчными буквами: 10 -> a, 11 -> b, 12 -> c и так далее.
 * Например: n = 100, base = 4 -> 1210, n = 250, base = 14 -> 13c
 */
fun convertToString(n: Int, base: Int): String{
    val list = convert(n, base)
    val a = "abcdefghijklmnopqrstuvwxyz"
    val m = StringBuilder()
    if (n == 0) m.append(n)
    else
        for (element in list) {
            if (element < 10) m.append(element.toString())
            else m.append(a[element - 10].toString())
        }
    return m.toString()
}

/**
 * Средняя
 *
 * Перевести число, представленное списком цифр digits от старшей к младшей,
 * из системы счисления с основанием base в десятичную.
 * Например: digits = (1, 3, 12), base = 14 -> 250
 */
fun decimal(digits: List<Int>, base: Int): Int {
    var a = 0
    var st = 1
    digits.reversed().forEach {
        a += it * st
        st *= base
    }
    return a
}

/**
 * Сложная
 *
 * Перевести число, представленное цифровой строкой str,
 * из системы счисления с основанием base в десятичную.
 * Цифры более 9 представляются латинскими строчными буквами:
 * 10 -> a, 11 -> b, 12 -> c и так далее.
 * Например: str = "13c", base = 14 -> 250
 */
fun decimalFromString(str: String, base: Int): Int {
    var a = 0
    var st = 1
    str.reversed().forEach {
        val k = if (it <= '9') it - '0' else (it + 10 - 'a')
        a += k * st
        st *= base
    }
    return a
}

/**
 * Сложная
 *
 * Перевести натуральное число n > 0 в римскую систему.
 * Римские цифры: 1 = I, 4 = IV, 5 = V, 9 = IX, 10 = X, 40 = XL, 50 = L,
 * 90 = XC, 100 = C, 400 = CD, 500 = D, 900 = CM, 1000 = M.
 * Например: 23 = XXIII, 44 = XLIV, 100 = C
 */
fun roman1(n: Int): String = buildString {
    val a = StringBuilder()
    when (n) {
        in 1..3 -> for (i in 1..n) a.append('I')
        4 -> {
            a.append('I')
            a.append('V')
        }
        5 -> a.append('V')
        in 6..8 -> {
            a.append('V')
            for (i in 1..n - 5) a.append('I')
        }
        9 -> {
            a.append('I')
            a.append('X')
        }
    }
    return a.toString()
}

fun roman2(n: Int): String = buildString {
    val a = StringBuilder()
    when (n) {
        in 10..39 -> {
            val y = n / 10
            for (i in 1..y) a.append('X')
        }
        in 40..49 -> {
            a.append('X')
            a.append('L')
        }
        in 50..59 -> a.append('L')
        in 60..89 -> {
            val m = n / 10 - 5
            a.append('L')
            for (i in 1..m) a.append('X')
        }
        in 90..99 -> {
            a.append('X')
            a.append('C')
        }
    }
    return a.toString()
}

fun roman3(n: Int): String {
    val a = StringBuilder()
    when (n) {
        in 100..399 -> {
            val f = n / 100
            for (i in 1..f) a.append('C')
        }
        in 400..499 -> {
            a.append('C')
            a.append('D')
        }
        in 500..599 -> a.append('D')
        in 600..899 -> {
            val h = n / 100 - 5
            a.append('D')
            for (i in 1..h) a.append('C')
        }
        in 900..999 -> {
            a.append('C')
            a.append('M')
        }
    }
    return a.toString()
}

fun roman(n: Int): String {
    var a = ""
    when (n) {
        in 100..999 -> {
            val b = roman3(n % 1000)
            val c = roman2(n % 100)
            val d = roman1(n % 10)
            a = a + b + c + d
        }
        in 10..99 -> {
            val c = roman2(n % 100)
            val d = roman1(n % 10)
            a = c + d
        }
        in 1..9 -> {
            val d = roman1(n % 10)
            a = d
        }
        else -> {
            val k = n / 1000
            for (i in 1..k) a += 'M'
            val b = roman3(n % 1000)
            val c = roman2(n % 100)
            val d = roman1(n % 10)
            a = a + b + c + d
        }
    }
    return a
}

/**
 * Очень сложная
 *
 * Записать заданное натуральное число 1..999999 прописью по-русски.
 * Например, 375 = "триста семьдесят пять",
 * 23964 = "двадцать три тысячи девятьсот шестьдесят четыре"
 */

fun russian(n: Int): String {
    val b = listOf<String>("одна тысяча", "две тысячи", "три тысячи", "четыре тысячи",
            "пять тысяч", "шесть тысяч", "семь тысяч", "восемь тысяч", "девять тысяч")
    val c = listOf<String>("один", "два", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять")
    val d = listOf<String>("десять", "одиннадцать", "двенадцать", "тринадцать", "четырнадцать", "пятнадцать",
            "шестнадцать", "семнадцать", "восемнадцать", "девятнадцать")
    val e = listOf<String>("двадцать", "тридцать", "сорок", "пятьдесят", "шестьдесят", "семьдесят",
            "восемьдесят", "девяносто")
    val f = listOf<String>("сто", "двести",
            "триста", "четыреста", "пятьсот", "шестьсот", "семьсот", "восемьсот", "девятьсот")
    val rus = StringBuilder()
    val space = " "
    if (n / 100000 > 0) rus.append(f[n / 100000 - 1] + space)
    if (n / 1000 > 0) when (n / 10000 % 10) {
        1 -> rus.append(d[n / 1000 % 10] + " тысяч")
        0 -> {
            if (n / 1000 % 10 == 0) rus.append("тысяч") else rus.append(b[n / 1000 % 10 - 1])
        }
        else -> {
            rus.append(e[n / 10000 % 10 - 2] + space)
            if (n / 1000 % 10 > 0) rus.append(b[n / 1000 % 10 - 1]) else rus.append("тысяч")
        }
    }
    if (n % 1000 > 0 && n / 1000 > 0 && n % 1000 !in 1..9) rus.append(space)
    if (n / 100 % 10 > 0) rus.append(f[n / 100 % 10 - 1])
    if (n / 10 % 10 > 0) {
        if (n !in 10..99) rus.append(space)
        when (n / 10 % 10) {
            1 -> rus.append(d[n % 10])
            else -> rus.append(e[n / 10 % 10 - 2])
        }
    }
    if (n % 10 > 0 && n / 10 % 10 != 1) if (n > 9) rus.append(space + c[n % 10 - 1]) else rus.append(c[n % 10 - 1])
    return rus.toString()
}

