@file:Suppress("UNUSED_PARAMETER", "ConvertCallChainIntoSequence")

package lesson4.task1

import kotlinx.html.DEL
import lesson7.task1.transliterate
import kotlin.math.sqrt

fun sqr(x: Int) = x * x
fun sqr(x: Double) = x * x
fun discriminant(a: Double, b: Double, c: Double) = sqr(b) - 4 * a * c


// Урок 4: списки
// Максимальное количество баллов = 12
// Рекомендуемое количество баллов = 8
// Вместе с предыдущими уроками = 24/33

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
    val lowerCase = str.lowercase().filter { it != ' ' }
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
 * Простая (2 балла)
 *
 * Найти модуль заданного вектора, представленного в виде списка v,
 * по формуле abs = sqrt(a1^2 + a2^2 + ... + aN^2).
 * Модуль пустого вектора считать равным 0.0.
 */
fun abs(v: List<Double>): Double = TODO()

/**
 * Простая (2 балла)
 *
 * Рассчитать среднее арифметическое элементов списка list. Вернуть 0.0, если список пуст
 */
fun mean(list: List<Double>): Double = TODO()

/**
 * Средняя (3 балла)
 *
 * Центрировать заданный список list, уменьшив каждый элемент на среднее арифметическое всех элементов.
 * Если список пуст, не делать ничего. Вернуть изменённый список.
 *
 * Обратите внимание, что данная функция должна изменять содержание списка list, а не его копии.
 */
fun center(list: MutableList<Double>): MutableList<Double> = TODO()

/**
 * Средняя (3 балла)
 *
 * Найти скалярное произведение двух векторов равной размерности,
 * представленные в виде списков a и b. Скалярное произведение считать по формуле:
 * C = a1b1 + a2b2 + ... + aNbN. Произведение пустых векторов считать равным 0.
 */
fun times(a: List<Int>, b: List<Int>): Int = TODO()

/**
 * Средняя (3 балла)
 *
 * Рассчитать значение многочлена при заданном x:
 * p(x) = p0 + p1*x + p2*x^2 + p3*x^3 + ... + pN*x^N.
 * Коэффициенты многочлена заданы списком p: (p0, p1, p2, p3, ..., pN).
 * Значение пустого многочлена равно 0 при любом x.
 */
fun polynom(p: List<Int>, x: Int): Int = TODO()

/**
 * Средняя (3 балла)
 *
 * В заданном списке list каждый элемент, кроме первого, заменить
 * суммой данного элемента и всех предыдущих.
 * Например: 1, 2, 3, 4 -> 1, 3, 6, 10.
 * Пустой список не следует изменять. Вернуть изменённый список.
 *
 * Обратите внимание, что данная функция должна изменять содержание списка list, а не его копии.
 */
fun accumulate(list: MutableList<Int>): MutableList<Int> = TODO()

/**
 * Средняя (3 балла)
 *
 * Разложить заданное натуральное число n > 1 на простые множители.
 * Результат разложения вернуть в виде списка множителей, например 75 -> (3, 5, 5).
 * Множители в списке должны располагаться по возрастанию.
 */
fun factorize(n: Int): List<Int> = TODO()

/**
 * Сложная (4 балла)
 *
 * Разложить заданное натуральное число n > 1 на простые множители.
 * Результат разложения вернуть в виде строки, например 75 -> 3*5*5
 * Множители в результирующей строке должны располагаться по возрастанию.
 */
fun factorizeToString(n: Int): String = TODO()

/**
 * Средняя (3 балла)
 *
 * Перевести заданное целое число n >= 0 в систему счисления с основанием base > 1.
 * Результат перевода вернуть в виде списка цифр в base-ичной системе от старшей к младшей,
 * например: n = 100, base = 4 -> (1, 2, 1, 0) или n = 250, base = 14 -> (1, 3, 12)
 */
fun convert(n: Int, base: Int): List<Int> = TODO()

/**
 * Сложная (4 балла)
 *
 * Перевести заданное целое число n >= 0 в систему счисления с основанием 1 < base < 37.
 * Результат перевода вернуть в виде строки, цифры более 9 представлять латинскими
 * строчными буквами: 10 -> a, 11 -> b, 12 -> c и так далее.
 * Например: n = 100, base = 4 -> 1210, n = 250, base = 14 -> 13c
 *
 * Использовать функции стандартной библиотеки, напрямую и полностью решающие данную задачу
 * (например, n.toString(base) и подобные), запрещается.
 */
fun convertToString(n: Int, base: Int): String = TODO()

/**
 * Средняя (3 балла)
 *
 * Перевести число, представленное списком цифр digits от старшей к младшей,
 * из системы счисления с основанием base в десятичную.
 * Например: digits = (1, 3, 12), base = 14 -> 250
 */
fun decimal(digits: List<Int>, base: Int): Int = TODO()

/**
 * Сложная (4 балла)
 *
 * Перевести число, представленное цифровой строкой str,
 * из системы счисления с основанием base в десятичную.
 * Цифры более 9 представляются латинскими строчными буквами:
 * 10 -> a, 11 -> b, 12 -> c и так далее.
 * Например: str = "13c", base = 14 -> 250
 *
 * Использовать функции стандартной библиотеки, напрямую и полностью решающие данную задачу
 * (например, str.toInt(base)), запрещается.
 */
fun decimalFromString(str: String, base: Int): Int = TODO()

/**
 * Сложная (5 баллов)
 *
 * Перевести натуральное число n > 0 в римскую систему.
 * Римские цифры: 1 = I, 4 = IV, 5 = V, 9 = IX, 10 = X, 40 = XL, 50 = L,
 * 90 = XC, 100 = C, 400 = CD, 500 = D, 900 = CM, 1000 = M.
 * Например: 23 = XXIII, 44 = XLIV, 100 = C
 */
fun roman(n: Int): String {
    var num = n
    var a = arrayOfNulls<String>(1001)
    a[1] = "I"
    a[4] = "IV"
    a[5] = "V"
    a[9] = "IX"
    a[10] = "X"
    a[40] = "XL"
    a[50] = "L"
    a[90] = "XC"
    a[100] = "C"
    a[400] = "CD"
    a[500] = "D"
    a[900] = "CM"
    a[1000] = "M"

    var ans: String = ""
    if (num >= 1000)
        while (num >= 1000) {
            ans += a[1000]
            num -= 1000
        }

    var num100 = 100
    var num900 = 900
    var num400 = 400
    var num500 = 500

    repeat(3) {
        if (num >= num100)
            if (num - num900 >= 0) {
                ans += a[num900]
                num -= num900
            } else
                if ((num / num100 == 4) || (num / num100 == 5)) {
                    if (num / num100 == 4) {
                        ans += a[num400]
                        num -= num400
                    } else {
                        ans += a[num500]
                        num -= num500
                    }
                } else
                    if (num / num100 < 4)
                        while (num >= num100) {
                            ans += a[num100]
                            num -= num100
                        }
                    else {
                        ans += a[num500]
                        num -= num500
                        while (num >= num100) {
                            ans += a[num100]
                            num -= num100
                        }
                    }
        num100 /= 10
        num900 /= 10
        num400 /= 10
        num500 /= 10
    }
    return ans
}

/**
 * Очень сложная (7 баллов)
 *
 * Записать заданное натуральное число 1..999999 прописью по-русски.
 * Например, 375 = "триста семьдесят пять",
 * 23964 = "двадцать три тысячи девятьсот шестьдесят четыре"
 */
fun russian(n: Int): String {
    var ans: String = ""
    var a = arrayOfNulls<String>(5001)
    a[0] = ""
    a[1] = "один"
    a[2] = "два"
    a[3] = "три"
    a[4] = "четыре"
    a[5] = "пять"
    a[6] = "шесть"
    a[7] = "семь"
    a[8] = "восемь"
    a[9] = "девять"
    a[10] = "десять"
    a[11] = "одиннадцать"
    a[12] = "двенадцать"
    a[13] = "тринадцать"
    a[14] = "четырнадцать"
    a[15] = "пятнадцать"
    a[16] = "шестнадцать"
    a[17] = "семнадцать"
    a[18] = "восемнадцать"
    a[19] = "девятнадцать"
    a[20] = "двадцать"
    a[30] = "тридцать"
    a[40] = "сорок"
    a[50] = "пятьдесят"
    a[60] = "шестьдесят"
    a[70] = "семьдесят"
    a[80] = "восемьдесят"
    a[90] = "девяносто"
    a[100] = "сто"
    a[200] = "двести"
    a[300] = "триста"
    a[400] = "четыреста"
    a[500] = "пятьсот"
    a[600] = "шестьсот"
    a[700] = "семьсот"
    a[800] = "восемьсот"
    a[900] = "девятьсот"
    a[1000] = "одна тысяча"
    a[2000] = "две тысячи"
    a[3000] = "тысячи"
    a[5000] = "тысяч"

    if (n >= 1000) {
        val thou = n / 1000
        if (thou < 10)
            when (thou) {
                1 -> ans += a[1000]
                2 -> ans += a[2000]
                in 3..4 -> ans += a[thou] + " " + a[3000]
                in 5..9 -> ans += a[thou] + " " + a[5000]
            }
        else {
            val hun = thou / 100 * 100
            ans += a[hun] + " "
            val doz = thou % 100
            if (((doz < 20) && (doz > 9)) || (doz % 10 == 0))
                ans += a[doz] + " " + a[5000] + " "
            else {
                ans += a[doz / 10 * 10] + " "
                val uni = doz % 10
                when (uni) {
                    1 -> ans += a[1000] + " "
                    2 -> ans += a[2000] + " "
                    in 3..4 -> ans += a[uni] + " " + a[3000] + " "
                    in 5..9 -> ans += a[uni] + " " + a[5000] + " "
                }
            }
        }
    }

    val thou = n % 1000
    val hun = thou / 100 * 100
    ans += a[hun] + " "
    val doz = thou % 100
    if (((doz < 20) && (doz > 9)) || (doz % 10 == 0))
        ans += a[doz] + " "
    else
        ans += a[doz / 10 * 10] + " " + a[doz % 10]

    var list = mutableListOf<Char>()

    for (i in 0..ans.lastIndex)
        list.add(ans[i])

    while (list[list.lastIndex] == ' ')
        list.removeAt(list.lastIndex)

    while (list[0] == ' ')
        list.removeAt(0)

repeat(3){
    var count = list.lastIndex
    while (count > 0) {
        if ((list[count - 1] == list[count]) && (list[count] == ' ')) {
            list.removeAt(count)
            count -= 1
        }
        count -= 1
    }
}
    return list.joinToString(prefix = "", postfix = "", separator = "")
}
