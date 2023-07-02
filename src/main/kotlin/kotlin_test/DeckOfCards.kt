package kotlin_test

/**
 * 카드 뭉치 by programmers lv.1
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/159994
 *
 * */
fun main(args: Array<String>) {
    DeckOfCards().solution(arrayOf("i","drink", "water"), arrayOf("cake","to"), arrayOf("i", "cake", "drink", "water", "to"))
}

class DeckOfCards {
    private val no = "No"
    private val yes = "Yes"
    fun solution(cards1: Array<String>, cards2: Array<String>, goal: Array<String>): String {
        // 예외처리 : 1 ≤ cards1의 길이, cards2의 길이 ≤ 10
        if (cards1.isEmpty() || cards2.isEmpty() || cards1.size > 10 || cards2.size > 10) {
            return no
        }

        // 2 ≤ goal의 길이 ≤ cards1의 길이 + cards2의 길이
        if (goal.size < 2 || goal.size > (cards1.size + cards2.size)) {
            return no
        }

        // 예외처리 : cards1과 cards2에는 서로 다른 단어만 존재합니다.
        setOf(cards1, cards2).let {
            if (it.size != (cards1.size + cards2.size)) return no
        }

        // goal을 card1, card2 차례대로 비교해본다.
        var cards1Index = 0
        var cards2Index = 0
        goal.forEach {
            when {
                cards1Index < cards1.size && it == cards1[cards1Index] -> cards1Index++
                cards2Index < cards2.size && it == cards2[cards2Index] -> cards2Index++
                else -> return no
            }
        }
        return yes
    }
}