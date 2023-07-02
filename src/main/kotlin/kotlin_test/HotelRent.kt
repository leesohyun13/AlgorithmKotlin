package kotlin_test

/**
 * 호텔 대실 by lv.2
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/155651
 * */
fun main(args: Array<String>) {
    HotelRent().solution(arrayOf(arrayOf("15:00", "17:00"), arrayOf("16:40", "18:20"), arrayOf("18:30", "19:20"), arrayOf("14:10", "19:20"), arrayOf("18:20", "21:20")))
}

class HotelRent {
    /**
     * 문제 풀기전 방향
     *
     * 1) 시간 순서로 정렬: 입실 (입실/퇴실 시간을 숫자로 변환)
     * 2) 순서대로 꺼내서 입실 & 이전 방의 퇴실 시간 비교
     *
     * Hint
     * 입실, 퇴실 시간 순으로 정렬시켜서 하나씩 꺼내면서 비교하기
     * 이때, 입실 = 퇴실 시간인 경우, 퇴실 시간이 우선되어야 함. !!!!
     *
     * Point
     * - Compare 조건
     * - 비교 방식 :
     * */
    // 퇴실 시간이 우선되어야 해서, 퇴실시간이 입실시간보다 작아야 함.
    private val endTime = 1
    private val startTime = 2

    fun solution(book_time: Array<Array<String>>): Int {
        var answer = 0

        val list = mutableListOf<Pair<Int, Int>>().apply {
            addAll(book_time.flatMap { convertTime(it) }.sortedWith { o1, o2 ->
                if (o1.first != o2.first) o1.first.compareTo(o2.first)
                else o1.second.compareTo(o2.second)
            })
        }

        var room = 0
        list.forEach {
            if (it.second == startTime) {
                room++
            } else {
                room--
            }
            answer = maxOf(room, answer)
        }

        return answer
    }

    private fun convertTime(times: Array<String>): List<Pair<Int, Int>> {
        return listOf(convertTimeToInt(times[0], startTime), convertTimeToInt(times[1], endTime))
    }

    // 여기서 청소시간 추가해야 함
    private fun convertTimeToInt(time: String, type: Int): Pair<Int, Int> {
        return Pair(time.split(":").mapIndexed { index, s ->
            if (index == 0) s.toInt() * 60 else if (index == 1 && type == startTime) s.toInt() else s.toInt() + 10
        }.sum(), type)
    }
}