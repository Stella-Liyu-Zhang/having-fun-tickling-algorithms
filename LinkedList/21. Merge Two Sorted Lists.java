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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
          //recursively
        //O(n1+n2) recursive stack space, where n1-length of LL1 and n2- length of LL2
        //Obviously, for both recursive and iterative, it's O(N+M) where N and M are lengths of the 2 linked lists


          if (list1 == null) return list2;
          if (list2 == null) return list1;
              if (list1.val <= list2.val){
                  list1.next = mergeTwoLists (list1.next, list2);
                  return list1;
              }else{
                  list2.next = mergeTwoLists (list1, list2.next);
                  return list2;
              }
    }
}

 //iteratively
           if (list1 == null) return list2;
           if (list2 == null) return list1;
           ListNode dummy = new ListNode(0);
           ListNode curr = dummy;
            while(list1 != null && list2 != null){
                if(list1.val <= list2.val){
                    curr.next = list1;
                    list1 = list1.next;
                }else{
                    curr.next = list2;
                    list2 = list2.next;
                }
                curr = curr.next;
            }
           
            curr.next = list1 == null ? list2 : list1;
            return dummy.next;
