package kotlin_test

/**
 * 13. Roman to Integer
 *
 * https://leetcode.com/problems/roman-to-integer/description/
 * */

fun main(args: Array<String>) {
    RomanInteger().romanToInt("MDLX")
}

class RomanInteger {
    fun romanToInt(s: String): Int {
        val map = mutableMapOf(
            'I' to 1,
            'V' to 5,
            'X' to 10,
            'L' to 50,
            'C' to 100,
            'D' to 500,
            'M' to 1000,
        )

        var number = 0

        for (i in s.indices) {
            val data = map.getValue(s[i])
            if (i != s.length - 1 && data < map.getValue(s[i+1])) {
                number -= data
            } else {
                number += data
            }
        }
        return number
    }
}