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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    /*
    1. head == null -> null
    2. head -> return single treenode
    recur
    mid = ?
        - O(N)
        - fast
        - slow 
    left, mid-1
    mid+1. right
    O(N log N)- 
    input: linkedlist, ListNode
    output: tree, TreeNode
    
    O(log N)

    */
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null){
            return null;
        }
        if(head.next == null){
            return new TreeNode(head.val);
        }
        return sortedBST(head, null);

    }
    private TreeNode sortedBST(ListNode head, ListNode tail){
        if(head == tail){
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while(fast != tail && fast.next != tail){
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode mid = new TreeNode(slow.val);
        mid.left = sortedBST(head, slow);
        mid.right = sortedBST(slow.next, tail);
        return mid;
    }

}