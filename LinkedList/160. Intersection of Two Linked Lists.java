/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;
        ListNode Bhead = headB;
        ListNode Ahead = headA;

        while (Ahead != Bhead) {
            if (Ahead == null) {
                Ahead = headB;
            } else {
                Ahead = Ahead.next;
            }
            if (Bhead == null) {
                Bhead = headA;
            } else {
                Bhead = Bhead.next;
            }

        }
        return Ahead;
    }
}