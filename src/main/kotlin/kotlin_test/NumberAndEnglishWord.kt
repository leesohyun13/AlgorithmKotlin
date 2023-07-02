package kotlin_test

/**
 * 숫자 문자열과 영단어 by programmers lv.1
 * https://school.programmers.co.kr/learn/courses/30/lessons/81301
 * */
fun main(args: Array<String>) {
    NumberAndEnglishWord().solution2("2three45sixseven")
}

class NumberAndEnglishWord {

    fun solution(s: String): Int {
        val answer = StringBuffer()
        val dictionary = mutableListOf("zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine")
        val word = StringBuffer()

        s.toCharArray().forEachIndexed { index, c ->
            if (c.digitToIntOrNull() == null) {
                word.append(c)
                val text = word.toString()
                if (dictionary.contains(text)) {
                    answer.append(dictionary.indexOf(text))
                    word.setLength(0)
                }
            } else {
                word.setLength(0)
                answer.append(c)
            }
        }

        return answer.toString().toInt()
    }

    fun solution2(s: String): Int {
        var answer = s
        mutableListOf("zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine").let {
            it.forEachIndexed { index, s ->
                answer = answer.replace(s, index.toString())
            }
        }

        return answer.toInt()
    }
}