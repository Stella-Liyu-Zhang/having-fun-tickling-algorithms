/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }

    Time complexity : O(max⁡(m,n)). Assume that mmm and nnn represents the length of l1 and l2 respectively, the algorithm above iterates at most max(m,n) times.
    Space complexity : O(1)

    Initialize current node to dummy head of the returning list.
    Initialize carry to 000.
    Loop through lists l1 and l2 until you reach both ends and carry is 0.
    Set x to node l1's value. If l1 has reached the end of l1, set to 0.
    Set y to node l2's value. If l2 has reached the end of l2, set to 0.
    Set sum = x + y + carry.
    Update carry=sum/10carry = sum / 10carry=sum/10.
    Create a new node with the digit value of (sum mod 10) and set it to current node's next, then advance current node to next.
    Advance both l1 and l2.
    Return dummy head's next node.
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        int carry = 0;

        while(l1 != null || l2 != null || carry != 0){
            int x = (l1 == null)? 0 : l1.val;
            int y = (l2 == null) ? 0 : l2.val;
            int sum = carry + x + y;
            carry = sum / 10;
            ListNode newNode = new ListNode(sum%10);
            curr.next = newNode;
            curr = curr.next;
            if (l1 != null){
                l1 = l1.next;
            }
            if (l2 != null){
                l2 = l2.next;
            }
        }
        return dummy.next;
    }
}