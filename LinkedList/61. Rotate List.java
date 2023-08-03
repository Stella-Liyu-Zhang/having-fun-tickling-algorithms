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
        if (head == null || head.next == null){
            return head;
        }
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

/*
Time complexity : O(N)\mathcal{O}(N)O(N) where NNN is a number
of elements in the list.

Space complexity : O(1)\mathcal{O}(1)O(1) since it's a
constant space solution.
*/