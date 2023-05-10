/**
 * 공원 산책 by Lv.1
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/172928?language=kotlin
 * */
fun main(args: Array<String>) {
//    StrollPark().solution(arrayOf("O0S","OOO","OXO","OOO"), arrayOf("N 1","N 1","N 1","N 1","N 1"))
    StrollPark().solution(arrayOf("SOO", "OXX", "OOO"), arrayOf("E 2", "S 2", "W 1"))
}

class StrollPark {
    fun solution(park: Array<String>, routes: Array<String>): IntArray {
        val parkLoad = mutableListOf<CharArray>()
        var startPoint = Pair(0, 0)
        // park를 2차 배열로 만들어 검색하기 편하게 구성
        park.forEachIndexed { index, s ->
            parkLoad.add(s.toCharArray())
            if (s.contains("S")) {
                // 시작점 찾기
                startPoint = Pair(index, s.indexOf("S"))
            }
        }

        routes.forEach {
            val direction = it.split(" ")[0]
            val len = it.split(" ")[1].toInt()

            var x = startPoint.second
            var y = startPoint.first

            for (i in 0 until len) {
                when (direction) {
                    "E" -> {
                        x++
                    }

                    "W" -> {
                        x--
                    }

                    "N" -> {
                        y--
                    }

                    "S" -> {
                        y++
                    }

                    else -> Unit
                }

                // 아래 2가지 방법에 벗어나지 않으면, 위치 갱신
                // 주어진 방향으로 이동할 때 공원을 벗어나는지 확인합니다.
                // 주어진 방향으로 이동 중 장애물을 만나는지 확인합니다.
                if (x >= 0 && y >= 0 && y < park.size && x < park[0].length) {
                    if (parkLoad[y][x] == 'X') {
                        break
                    }
                    // 범위내 & 장애물 x
                    if (i == len - 1) {
                        startPoint = y to x
                    }
                }
            }
        }


        println("Result: $startPoint")
        return intArrayOf(startPoint.first, startPoint.second)
    }
}