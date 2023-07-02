package kotlin_test

/**
 *
 * 17. Letter Combinations of a Phone Number
 *
 * Difficulty: Medium
 *
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
 * */

fun main(args: Array<String>) {
    LetterCombinationOfPhone().solution("234")
}

class LetterCombinationOfPhone {

    fun solution(digits: String): List<String> {
        var answer: List<String> = mutableListOf()

        if (digits.isEmpty()) {
            return answer
        }

        val phone: Map<String, List<String>> = mapOf(
            "2" to listOf("a", "b", "c"),
            "3" to listOf("d", "e", "f"),
            "4" to listOf("g", "h", "i"),
            "5" to listOf("j", "k", "l"),
            "6" to listOf("m", "o", "n"),
            "7" to listOf("p", "q", "r", "s"),
            "8" to listOf("t", "u", "v"),
            "9" to listOf("w", "x", "y", "z"),
        )


        digits.split("").mapNotNull { phone[it] }.forEach {
            answer = makeTexts(answer, it)
        }

        return answer
    }

    private fun makeTexts(l1: List<String>, l2: List<String>): List<String> {
        val al = mutableListOf<String>()
        if (l1.isEmpty())
            return l2
        for (s1 in l1) {
            for (s2 in l2) {
                al.add(s1 + s2)
            }
        }
        return al
    }
}