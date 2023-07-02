package kotlin_test

/**
 * 3. Longest Substring Without Repeating Characters
 *
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * */
fun main(args: Array<String>) {
    LongestSubstring().lengthOfLongestSubstring("abcabcbb")
}


// 방법
// 1. 중복 사전을 만든다.
// 2. 단어별 중복을 찾는다.
// 3. 현재 문자와 비교하여, 가장 긴 값을 저장한다.

class LongestSubstring {
    fun lengthOfLongestSubstring(s: String): Int {
        var answer = 0
        var substring = ""
        val dictionary = mutableSetOf<Char>()

        for(c in s) {
            println("word ($c): $substring")
            if (dictionary.contains(c)) {
                if (answer < substring.length) answer = substring.length
                // 해당 문자 이후 글자들만 살리기
                substring = substring.substringAfter(c)
            } else {
                dictionary.add(c)
            }
            substring += c
        }

        println("answer: $substring, $answer")

        if (answer < substring.length) answer = substring.length

        println("answer(2): $substring, $answer")


        return answer
    }
}