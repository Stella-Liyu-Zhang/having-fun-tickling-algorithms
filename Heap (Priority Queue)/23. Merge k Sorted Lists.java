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
    n is the max number of lists
    m is the max number of nodes in a list
    Time complexity: O(n*m log (m*n))
    Space complexity: O(n*m)
    The insertion into a minHeap takes O(log n) time, where n is the number of elements in the minHeap. 
    Since we do this for all nodes across all lists, the time complexity for building the minHeap is O(K * N * log N), where K is the number of linked lists and N is the average number of nodes in each list.
    After building the minHeap, we create a new linked list by repeatedly extracting the minimum element from the minHeap and adding it to the result list. 
    The extraction operation takes O(log n) time. 
    Since there are a total of N elements in the minHeap (assuming N is the total number of nodes across all lists), this step takes O(N * log N) time.
    Hence, the overall time complexity of the algorithm is O(K * N * log N + N * log N), which can be simplified to O(N * (K + log N)).
    */
    public ListNode mergeKLists(ListNode[] lists) {
        //minHeap
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (ListNode node: lists){
            while(node != null){
                minHeap.add(node.val);
                node = node.next;
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        while(minHeap.isEmpty() == false){
            head.next = new ListNode(minHeap.remove());
            head = head.next;
        }
        return dummy.next;
    }
}