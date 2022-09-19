/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null)
            return null;

        ListNode fast = head;
        ListNode slow = head;
        int length = 1;

        // get the total length
        while (fast.next != null) {
            length++;
            fast = fast.next;
        }
        // when to start to break the linkedlist = (length-k)%length
        for (int i = 1; i < length - k % length; i++) {
            slow = slow.next;
        }
        // rotate the head and the slow
        fast.next = head;
        head = slow.next;
        slow.next = null;

        return head;
    }
}