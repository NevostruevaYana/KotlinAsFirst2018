package lesson6.task1

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test

class Tests {
    @Test
    @Tag("Example")
    fun timeStrToSeconds() {
        assertEquals(36000, timeStrToSeconds("10:00:00"))
        assertEquals(41685, timeStrToSeconds("11:34:45"))
        assertEquals(86399, timeStrToSeconds("23:59:59"))
    }

    @Test
    @Tag("Example")
    fun twoDigitStr() {
        assertEquals("00", twoDigitStr(0))
        assertEquals("09", twoDigitStr(9))
        assertEquals("10", twoDigitStr(10))
        assertEquals("99", twoDigitStr(99))
    }

    @Test
    @Tag("Example")
    fun timeSecondsToStr() {
        assertEquals("10:00:00", timeSecondsToStr(36000))
        assertEquals("11:34:45", timeSecondsToStr(41685))
        assertEquals("23:59:59", timeSecondsToStr(86399))
    }

    @Test
    @Tag("Normal")
    fun dateStrToDigit() {
        assertEquals("15.07.2016", dateStrToDigit("15 июля 2016"))
        assertEquals("", dateStrToDigit("3 мартобря 1918"))
        assertEquals("18.11.2018", dateStrToDigit("18 ноября 2018"))
        assertEquals("", dateStrToDigit("23"))
        assertEquals("03.04.2011", dateStrToDigit("3 апреля 2011"))
        assertEquals("", dateStrToDigit("32 сентября 2011"))
        assertEquals("", dateStrToDigit("29 февраля 1993"))
    }

    @Test
    @Tag("Normal")
    fun dateDigitToStr() {
        assertEquals("15 июля 2016", dateDigitToStr("15.07.2016"))
        assertEquals("", dateDigitToStr("01.02.20.19"))
        assertEquals("", dateDigitToStr("28.00.2000"))
        assertEquals("3 апреля 2011", dateDigitToStr("03.04.2011"))
        assertEquals("", dateDigitToStr("ab.cd.ef"))
        assertEquals("", dateStrToDigit("32.09.2011"))
        assertEquals("", dateStrToDigit("29.02.1993"))
    }

    @Test
    @Tag("Normal")
    fun flattenPhoneNumber() {
        assertEquals("+79211234567", flattenPhoneNumber("+7 (921) 123-45-67"))
        assertEquals("123456798", flattenPhoneNumber("12 --  34- 5 -- 67 -98"))
        assertEquals("", flattenPhoneNumber("ab-123"))
        assertEquals("+12345", flattenPhoneNumber("+12 (3) 4-5"))
        assertEquals("", flattenPhoneNumber("134_+874"))
    }

    @Test
    @Tag("Normal")
    fun bestLongJump() {
        assertEquals(717, bestLongJump("706 % - 717 - 703"))
        assertEquals(-1, bestLongJump("% - - % -"))
        assertEquals(754, bestLongJump("700 717 707 % 754"))
        assertEquals(-1, bestLongJump("700 + 700"))
        assertEquals(2147483647, bestLongJump("1168944873 2147483647 -  % 1 -  % 2147483647 2147483647 - 2147483647 0 45943859 -"))
    }

    @Test
    @Tag("Hard")
    fun bestHighJump() {
        assertEquals(878524193, bestHighJump("147483648 %%- 147483647 %%+ 147483647 %+ 147483647 %%- 147483648 + 59502032 %%- 147483648 + 143622343 %- 0 + 0 %+ 147483648 %+ 93633087 %- 899042451 %%- 147483648 %+ 804876203 %%+ 147483647 %- 81991004 %%+ 593832442 + 147483648 + 0 %%- 1 + 616279957 + 147483647 + 1 %+ 502463204 %%+ 17364532 %%- 147483647 + 838738849 + 0 %- 0 %+ 147483647 %- 866921088 %+ 147483647 %%+ 1 %%- 1 %- 0 %+ 1 + 147483648 %+ 516685274 %%+ 243482274 %%+ 147483648 %%+ 0 + 147483648 %- 462852149 %+ 147483648 %%- 147483647 %%- 1 %+ 0 + 267824815 %%- 1 + 1 %- 147483648 %+ 1 %+ 147483647 %%- 147483647 %- 0 %%- 803382949 %- 515185187 %%- 561077597 %- 147483648 %%+ 106657170 %%- 0 + 0 %- 147483647 %%- 708208992 %- 147483647 %+ 779127281 %- 107002891 + 1 %+ 431897156 + 1 %- 466962902 %%- 0 %+ 147483648 %%+ 147483647 + 1 %%- 147483648 %+ 1 %%- 288171716 + 147483648 %- 512882312 %%+ 327010373 %%- 1 %- 147483648 %%+ 147483647 %- 147483647 %+ 502173014 + 147483647 %+ 0 %+ 147483647 %+ 147483648 %%- 0 %%+ 759869442 %%+ 153941240 %- 0 + 0 %%+ 1 %%+ 32099209 %%- 147483647 + 802014045 %%- 623716826 %+ 0 %- 147483648 %+ 147483647 %%- 147483647 %+ 79349513 %- 1 %+ 1 %+ 204547856 %%- 612348572 %- 147483648 + 0 + 32750669 %- 1 %+ 185678520 %- 1 %- 636046865 %- 147483647 %+ 147483647 %+ 147483648 %- 0 + 1 + 380441688 %+ 147483647 %%- 353137332 %+ 147483648 %%- 1 + 1 %+ 557665417 + 1 + 147483648 %- 527745117 %+ 0 %+ 147483647 + 0 %- 334146688 %%- 147483648 %+ 147483647 + 0 + 147483648 + 0 %+ 878524193 %%+ 625469136 %+ 147483648 %- 153891688 %+ 147483647 %- 147483647 %- 614380997 %- 104920316 %+ 147483647 %+ 404619232 %+ 269977360 %- 1 %%- 0 %%+ 0 %- 695555219 + 147483647 %%- 1 %+ 712489325 +"))
    }

    @Test
    @Tag("Hard")
    fun plusMinus() {
        assertThrows(IllegalArgumentException::class.java) { plusMinus(" ") }
        assertEquals(0, plusMinus("0"))
        assertEquals(4, plusMinus("2 + 2"))
        assertEquals(6, plusMinus("2 + 31 - 40 + 13"))
        assertEquals(-1, plusMinus("0 - 1"))
        assertThrows(IllegalArgumentException::class.java) { plusMinus("+2") }
        assertThrows(IllegalArgumentException::class.java) { plusMinus("+ 4") }
        assertThrows(IllegalArgumentException::class.java) { plusMinus("4 - -2") }
        assertThrows(IllegalArgumentException::class.java) { plusMinus("44 - - 12") }
        assertThrows(IllegalArgumentException::class.java) { plusMinus("4 - + 12") }
        assertThrows(IllegalArgumentException::class.java) { plusMinus(" r[?7UkL?st.okg/n") }
    }

    @Test
    @Tag("Hard")
    fun firstDuplicateIndex() {
        assertEquals(-1, firstDuplicateIndex("Привет"))
        assertEquals(9, firstDuplicateIndex("Он пошёл в в школу"))
        assertEquals(40, firstDuplicateIndex("Яблоко упало на ветку с ветки оно упало на на землю"))
        assertEquals(9, firstDuplicateIndex("Мы пошли прямо Прямо располагался магазин"))
    }

    @Test
    @Tag("Hard")
    fun mostExpensive() {
        assertEquals("Курица", mostExpensive("Хлеб 39.9; Молоко 62.5; Курица 184.0; Конфеты 89.9"))
        assertEquals("Вино", mostExpensive("Вино 255.0"))
    }

    @Test
    @Tag("Hard")
    fun fromRoman() {
        assertEquals(3000, fromRoman("MMM"))
        assertEquals(934, fromRoman("CMXXXIV"))
        assertEquals(1978, fromRoman("MCMLXXVIII"))
        assertEquals(694, fromRoman("DCXCIV"))
        assertEquals(49, fromRoman("XLIX"))
        assertEquals(-1, fromRoman("Z"))
    }

    @Test
    @Tag("Impossible")
    fun computeDeviceCells() {
        assertEquals(listOf(0, 0, 0, 0, 0, 1, 1, 1, 1, 1), computeDeviceCells(10, "+>+>+>+>+", 10000))
        assertEquals(listOf(-1, -1, -1, -1, -1, 0, 0, 0, 0, 0), computeDeviceCells(10, "<-<-<-<-<-", 10000))
        assertEquals(listOf(1, 1, 1, 1, 1, 0, 0, 0, 0, 0), computeDeviceCells(10, "- <<<<< +[>+]", 10000))
        assertEquals(listOf(0, 8, 7, 6, 5, 4, 3, 2, 1, 0, 0),
                computeDeviceCells(11, "<<<<< + >>>>>>>>>> --[<-] >+[>+] >++[--< <[<] >+[>+] >++]", 10000))

        assertEquals(listOf(0, 0, 0, 0, 0, 1, 1, 0, 0, 0), computeDeviceCells(10, "+>+>+>+>+", 4))
        assertEquals(listOf(0, 0, -1, -1, -1, 0, 0, 0, 0, 0), computeDeviceCells(10, "<-<-<-<-<-", 6))
        assertEquals(listOf(1, 1, 1, 0, 0, -1, 0, 0, 0, 0), computeDeviceCells(10, "- <<<<< +[>+]", 17))
        assertEquals(listOf(0, 6, 5, 4, 3, 2, 1, 0, -1, -1, -2),
                computeDeviceCells(11, "<<<<< + >>>>>>>>>> --[<-] >+[>+] >++[--< <[<] >+[>+] >++]", 256))
        assertThrows(IllegalArgumentException::class.java) { computeDeviceCells(10, "===", 3) }
        assertThrows(IllegalArgumentException::class.java) { computeDeviceCells(10, "+>+>[+>", 3) }
        assertThrows(IllegalStateException::class.java) { computeDeviceCells(20, ">>>>>>>>>>>>>", 12) }
    }
}