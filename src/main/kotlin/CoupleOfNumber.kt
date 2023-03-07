import kotlin.math.min

/**
 * 숫자 짝꿍 by programmers lv.1
 * https://school.programmers.co.kr/learn/courses/30/lessons/131128
 * */
fun main(args: Array<String>) {
    CoupleOfNumber().solution("100", "12345")
}

class CoupleOfNumber {
    fun solution(X: String, Y: String): String {
        // 예외처리
        if (X.length < 3 || Y.length < 3 || X.length > 3_000_000 || Y.length > 3_000_000  || X.startsWith("0") || Y.startsWith("0")) {
            return "-1"
        }

        // 각 문자열을 map을 통해 정리한다.
        val xMap = mutableMapOf<Int, Int>()
        for (element in X) {
            val number = element.digitToIntOrNull() ?: return "-1"
            val count = xMap[number] ?: 0
            xMap[number] = count + 1
        }

        val yMap = mutableMapOf<Int, Int>()
        for (element in Y) {
            val number = element.digitToIntOrNull() ?: return "-1"
            val count = yMap[number] ?: 0
            yMap[number] = count + 1
        }

        // 2개의 map을 비교하면서 동일하게 존재하는 숫자를 list의 담는다.
        val items = mutableListOf<Int>()
        xMap.keys.forEach {
            val xData = xMap[it] ?: 0
            val yData = yMap[it] ?: 0
            val count = min(xData, yData)
            for (i in 0 until count) {
                items.add(it)
            }
        }

        // 공통 숫자가 없는 경우, -1 반환
        if (items.size == 0) {
            return "-1"
        }

        // 숫자를 정렬해서 반환한다.
        var zeroSize = 0
        val buffer = StringBuffer()
        items.sortedDescending().forEach {
            if (it == 0) zeroSize += 1
            buffer.append(it)
        }

        if (items.size == zeroSize) return "0"

        return buffer.toString()
    }
}