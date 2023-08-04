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
class Solution {
    //non-recursive solution, O(1)
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null){
            return null;
        }
        int len = 0;
        ListNode l = head;
        while (l != null){
            len ++;
            l = l.next;
        }
        int round = len/k;
        if (round == 0) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;

        for(int i = 0; i < round; i ++){
            ListNode start = pre.next;
            ListNode then = start.next;
            for(int j = 0; j < k-1; j++){
                start.next = then.next;
                then.next = pre.next;
                pre.next = then;
                then = start.next;
            }
            pre = start;
        }
        return dummy.next;
    }
    
}