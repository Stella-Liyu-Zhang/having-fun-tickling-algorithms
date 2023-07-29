/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
 /*
 1 -> 2 -> 3
 2->1->3
 */
// Iteration method
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        while(head != null && head.next != null){
            ListNode sec = head.next;
            head.next = sec.next;
            sec.next = head;
            pre.next = sec;
            pre = head;
            head = head.next;
        }
        return dummy.next;
    }
}