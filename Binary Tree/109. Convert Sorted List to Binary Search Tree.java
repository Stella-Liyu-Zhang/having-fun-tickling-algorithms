class Solution {
    //O(nlog(n))
    public TreeNode sortedListToBST(ListNode head) {
        //check empty LiSTNode
        if (head == null){
            return null;
        }
        if (head.next == null){
            return new TreeNode(head.val);
        }
        return toBST(head, null);
        
    }

    private TreeNode toBST (ListNode head, ListNode tail){
        ListNode slow = head, fast = head;
        if (head == tail) return null;

        while (fast != tail && fast.next != tail){
            slow = slow.next;
            fast = fast.next.next;
        }

        TreeNode thread = new TreeNode(slow.val);
        thread.left = toBST(head, slow);
        thread.right = toBST(slow.next, tail);

        return thread;
    }
}