## 112. Path Sum

## Sales Path

For example:

Given the rootNode of the tree in diagram above

Your function would return:

7 since it’s the minimal Sales Path cost (there are actually two Sales Paths in the tree whose cost is 7: 0→6→1 and 0→3→2→1→1)

```java
    static class Node {
        int cost;
        Node[] children;
        Node parent;

        Node(int cost) {
        this.cost = cost;
        children = null;
        parent = null;
        }
    }
    int getCheapestCost(Node rootNode) {
        int min = Integer.MIN_VALUE();
        if (rootNode == null){
            return 0;
        }
        if (rootNode.children.size() == 0){
            return rootNode.cost;
        }
        for(Node child: rootNode.children){
            int total = rootNode.cost + getCheapestCost(child);
            if (total < min){
                min = total;
            }
        }
        return min;
    }
```

## 430. Flatten a Multilevel Doubly Linked List

- if curr.child != null, use dfs to flatten
- else continue

- Time: O(n)
- Space: O(1)

```java
/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    /*
     if curr.child != null, use dfs to flatten
     else continue

     at node 12, tail node
     tail.next = current.next (9)
     node 9.prev = tail

     node 8.next = node 11
     node11.prev= node8;
     node 8.child = null


    */
    public Node flatten(Node head) {
        dfs(head);
        return head;
    }
    private Node dfs(Node node){
        Node pre = null;
        while(node != null){
            pre = node;
            if(node.child != null){
                //change the tail node
                Node tail = dfs(node.child);
                tail.next = node.next;
                if (node.next != null){
                    node.next.prev = tail;
                }

                //change the head node
                node.next = node.child;
                node.child.prev = node;
                node.child = null;

                //reset the pointers
                node = tail.next;
                pre = tail;

            }else{
                node = node.next;
            }
        }
        return pre;
    }
}
```
