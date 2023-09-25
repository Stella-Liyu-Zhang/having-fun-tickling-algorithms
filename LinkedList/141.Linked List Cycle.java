/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
        /*
    Solution 1: HashSet
    put all the nodes into a hashset, and check if duplicates exist.

    Solution 2:  Floyd's Cycle Finding Algorithm
    If there is no cycle in the list, the fast pointer will eventually reach the end and we can return false in this case.
    O(N)/O(N)

    Now consider a cyclic list and imagine the slow and fast pointers are two runners racing around a circle track. The fast runner will eventually meet the slow runner.
    O(N)/O(1)
    */
    public boolean hasCycle(ListNode head) {
        if(head == null) return false;
        ListNode fast = head.next;
        ListNode slow = head;
        while(slow != fast){
            if(fast == null || fast.next ==null){
                return false;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return true;
    }
}