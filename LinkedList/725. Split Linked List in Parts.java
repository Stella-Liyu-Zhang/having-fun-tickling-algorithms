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
    /*
    N nodes


    Time Complexity: O(N+k)
    Space: O(max(N,K))

    */
    public ListNode[] splitListToParts(ListNode head, int k) {
        //Get the length of the list first
        ListNode curr = head;
        int N = 0;
        while(curr != null){
            curr = curr.next;
            N++;
        }
        int width = N/k, extra = N % k;
        curr = head;
        ListNode[] res = new ListNode[k];
        for(int i = 0; i < k; i ++){
            ListNode newHead = new ListNode(0);
            ListNode write = newHead;
            for(int j = 0 ; j < width + (i < extra ? 1:0); j ++){
                write = write.next = new ListNode(curr.val);
                if(curr != null){
                    curr = curr.next;
                }
            }
            res[i] = newHead.next;
        }
        return res;
    }
}