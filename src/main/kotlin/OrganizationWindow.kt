
/**
 * 바탕화면 정리 by programmers lv.1
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/161990?language=kotlin
 *
 * */
fun main(args: Array<String>) {
    OrganizationWindow().solution(arrayOf(".##...##.", "#..#.#..#", "#...#...#", ".#.....#.", "..#...#..", "...#.#...", "....#...."))
}

class OrganizationWindow  {
    /**
     * 구현 방법
     *  wallpaper를 돌면서 x, y좌표를 구한다.
     *  x, y 좌표의 위치값을 잘 계산해봐야 한다.
     * */
    fun solution(wallpaper: Array<String>): IntArray {
        var answer = intArrayOf(Int.MAX_VALUE, Int.MAX_VALUE, 0, 0)

        val col: Int = wallpaper[0].length

        for (i in wallpaper.indices) {
            for (k in 0 until col) {
                val text = wallpaper[i]
                if (text[k] == '#') {
                    println("THIS!! : ${i}, $k")
                    val start = answer.isStartPoint(i, k)
                    val end = answer.isEndPoint(i + 1, k + 1)
                    answer[0] = start.first
                    answer[1] = start.second
                    answer[2] = end.first
                    answer[3] = end.second
                }
            }
        }

        return answer
    }

    private fun IntArray.isStartPoint(x: Int, y: Int) : Pair<Int, Int> {
        val originX = get(0)
        val originY = get(1)
        var newX = originX
        var newY = originY
        if (originX > x) {
            newX = x
        }
        if (originY > y) {
            newY = y
        }
        return Pair(newX, newY)
    }

    private fun IntArray.isEndPoint(x: Int, y: Int) : Pair<Int, Int> {
        val originX = get(2)
        val originY = get(3)
        var newX = originX
        var newY = originY
        if (originX < x) {
            newX = x
        }
        if (originY < y) {
            newY = y
        }
        return Pair(newX, newY)
    }
}
