class Solution {
    /*
    swap each node with previous one

    1) recursive O(N), O(N)

    2) iterative O(N), O(1)

    */
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null){
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }
}