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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pointer_1= l1;
        ListNode pointer_2 = l2;
        
        int sum = 0, sum1 = 0, sum2 = 0;
        
        while (l1 != null){
            pointer_1 = pointer_1.next;
            sum1 += pointer_1.val;
        }
        while (l2 != null){
            pointer_2 = pointer_2.next;
            sum2 += pointer_2.val;
        }
        
        sum = sum1+sum2;
        ListNode ans;
        ans.val = sum1
        
    }
}