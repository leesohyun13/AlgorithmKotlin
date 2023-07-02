package kotlin_test

/**
 * Example:
 * var li = kotlin_test.ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class kotlin_test.ListNode(var `val`: Int) {
 *     var next: kotlin_test.ListNode? = null
 * }
 */

fun main(args: Array<String>) {
//    kotlin_test.addTwoNumbers().kotlin_test.addTwoNumbers()
}

class addTwoNumbers {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?, carry: Int = 0): ListNode? {
        if (l1 == null && l2 == null && carry == 0) return null
        val data1 = l1?.`val` ?: 0
        val data2 = l2?.`val` ?: 0
        val sum = data1 + data2 + carry
        return ListNode(sum % 10).apply { next = addTwoNumbers(l1?.next, l2?.next, sum / 10) }
    }
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}