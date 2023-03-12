/**
 * 신고 결과 받기 by programmers lv.1
 * https://school.programmers.co.kr/learn/courses/30/lessons/92334
 * */
fun main(args: Array<String>) {
    GettingReportResult().solution(arrayOf("muzi", "frodo", "apeach", "neo"), arrayOf("muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"),2)
}

class GettingReportResult {
    fun solution(id_list: Array<String>, report: Array<String>, k: Int): IntArray {
        var answer = IntArray(id_list.size)

        val reportResultMap = mutableMapOf<String, Int>() // 신고당한 결과
        val reporterMap = mutableMapOf<String, Int>() // 신고자

        // array -> set 중복 신고 제거
        val reportList = report.toSet()

        // 신고당한 결과 정리
        reportList.map { it.split(" ")[1] }.forEach {
            reportResultMap[it] = reportResultMap.getOrDefault(it, 0) + 1
            println("reportList[$it] = ${reportResultMap[it]}")
        }

        // 신고자에게 몇번 연락할지
        reportResultMap.filterValues { it >= k }.keys.forEach { block ->
            println("reportResultMap[$block]")
            reportList.filter { it.contains(block) }.filter { it.split(" ")[1] == block }.map { it.split(" ")[0] }.forEach { user ->
                reporterMap[user] = reporterMap.getOrDefault(user, 0) + 1
                println("reporterMap[$user] = ${reporterMap[user]}")
            }
        }

        id_list.forEachIndexed { index, id ->
            answer[index] = reporterMap.getOrDefault(id, 0)
            println("answer[$index] = ${reporterMap.getOrDefault(id, 0)}")
        }

        return answer
    }

    fun solution2(id_list: Array<String>, report: Array<String>, k: Int): IntArray {
        return report.map { it.split(" ") }
            .groupBy { it[1] }
            .asSequence()
            .map { it.value.distinct() }
            .filter { it.size >= k }
            .flatten()
            .map { it[0] }
            .groupingBy { it }
            .eachCount()
            .run { id_list.map { getOrDefault(it, 0) }.toIntArray() }

    }
}