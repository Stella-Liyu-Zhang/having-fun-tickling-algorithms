/**
 * Definition for singly-linked list.
 * class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null)
            return false;
        // fast pointer
        ListNode fast = head.next;
        // slow pointer
        ListNode slow = head;

        while (slow != fast) {
            if (fast == null || fast.next == null) {
                // In this case, we reaches the end (i.e. there's no such a cycle)
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
