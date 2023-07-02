package kotlin_test

import kotlin.math.min

/**
 * 대충 만든 자판 by programmers lv.1
 * https://school.programmers.co.kr/learn/courses/30/lessons/160586
 *
 * */
fun main(args: Array<String>) {
    Solution().solution(arrayOf("ABACD","BCEFD"), arrayOf("ABCD","AABB"))
}


// 최초 문제 풀이 순서
// 1. keymap[i]에서 원하는 문자 얻기 위한 click 횟수 계산 메소드
// 2. 여러 keymap 비교해서 가장 작은 숫자를 출력한다 or -1
// 3. target 만큼 실행한다.

// 변경후 문제 풀이 순서
// 1. keyIndex map을 만들어 데이터를 미리 저장해놓는다.
// 2. targets를 모두 돌면서 클릭 횟수를 더한다.
class Solution {
    fun solution(keymap: Array<String>, targets: Array<String>): IntArray {
        val answer = IntArray(targets.size)

        // 예외처리
        // - keymap, targets 1-100 사이 원소 길이를 가져야 한다
        // - 원소는 대문자만 가질 수 있다.
        if (keymap.isEmpty() || targets.isEmpty()) {
            return intArrayOf()
        }

        // step1. keymap 문자와 index 정보를 map으로 만들어 놓는다.
        val keyIndex = hashMapOf<Char, Int>()
        keymap.forEach {
            it.toCharArray().forEachIndexed { index, char ->
                when(keyIndex.containsKey(char)) {
                    true -> {
                        keyIndex[char] = min(keyIndex[char] ?: Int.MAX_VALUE, index)
                    }
                    else -> {
                        keyIndex[char] = index
                    }
                }
            }
        }

        targets.forEachIndexed { index, target ->
            val data = target.toCharArray()
            var count = 0
            var isNoChar = false
            for (i in data.indices) {
                if (keyIndex.containsKey(data[i])) {
                    count += keyIndex[data[i]]?.inc() ?: 0
                } else {
                    isNoChar = true
                    break
                }
            }
            answer[index] = if (isNoChar) -1 else count
        }

        // step3-2. 모든 target 클릭 횟수 결과를 array로 만든다.
//        targets.forEachIndexed { index, target ->
//            // step3-1. 각 target를 넣어서 총 합을 구한다.
//            // 예외처리: 문자열이 100자 초과하는 경우 -1
//            if (target.isEmpty() || target.length > 100) {
//                answer[index] = -1
//                return@forEachIndexed
//            }
//            val result = target.split("").filterNot { it == "" }.sumOf { getClickedCount(keymapItems, it) }
//            println("[TARGET] target:$target, index: $index, result: $result")
//            answer[index] = result
//        }

        return answer
    }

    // step2. keymap 중에서 target 문자를 가장 적게 클릭할 수 있는 횟수를 찾는다.
    private fun getClickedCount(keymaps: List<List<String>>, target: String) : Int {
        var minIndex = -1
        var flag = false
        keymaps.forEach { keymap ->
            val count = getKeymapItemIndex(keymap, target)
            println("keymap: $keymap, target: $target, clicked count: $count")
            when {
                minIndex == -1 && count != -1 -> minIndex = count
                minIndex != -1 && count != -1 && minIndex > count -> minIndex = count
                else -> Unit
            }
            if (count != -1) flag = true
        }
        println("[RESULT] target: $target, minIndex: $minIndex")
        return if (flag.not()) -1 else minIndex
    }

    // step1. keymap에서 target 문자가 존재하는지, 몇번째 index인지 결과 얻을 수 있다.
    private fun getKeymapItemIndex(keymap: List<String>, targetText: String) : Int {
        // 예외처리: 문자열이 100자 초과하는 경우 -1 반환
        if (keymap.isEmpty() || keymap.size > 100) return -1
        val result = keymap.indexOfFirst { it == targetText }
        return if (result != -1) result + 1 else result
    }
}