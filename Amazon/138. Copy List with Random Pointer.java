/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

Recursion:
map<Oldnode, Newnode>

recur(head.next)
recur(head.random)

*/

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> memo = new HashMap();
        return copyListHelper(head, memo);
    }
    private Node copyListHelper (Node head, HashMap<Node, Node> memo){
        if(memo.containsKey(head)){
            return memo.get(head);
        }
        if(head == null) return null;

        Node newHead = new Node(head.val, null, null);
        
        // Save this value in the hash map. This is needed since there might be
        // loops during traversal due to randomness of random pointers and this would help us avoid
        // them.
        memo.put(head, newHead);

        newHead.next = copyListHelper(head.next, memo);
        newHead.random = copyListHelper(head.random, memo);

        return newHead;
    }
}