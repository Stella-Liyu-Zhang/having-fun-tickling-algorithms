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

```java
import java.util.*;
import java.util.HashMap;


## 399. Evaluate Division
- containsKey O(1)
class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        //Build directed weighted graph.
        Map<String, Map<String,Double>> graph = buildGraph(equations, values);
        double[] result = new double[queries.size()];

        for(int i = 0; i < queries.size(); i ++){
            result[i] = getPathWeight(queries.get(i).get(0), queries.get(i).get(1), new HashSet<>(), graph);
        }
        return result;
    }

    private double getPathWeight(String start, String end, Set<String> visited, Map<String, Map<String, Double>> graph){
        //rejection case
        if (!graph.containsKey(start)){
            return -1.0;
        }
        //accepting case
        if (graph.get(start).containsKey(end)){
            return graph.get(start).get(end);
        }

        visited.add(start);

        for(Map.Entry<String, Double> neighbor: graph.get(start).entrySet()){
            if (!visited.contains(neighbor.getKey())){
                double productWeight = getPathWeight(neighbor.getKey(), end, visited, graph);
                if (productWeight != -1.0){
                    return neighbor.getValue()*productWeight;
                }
            }

        }
        return -1.0;
    }
    private static Map<String, Map<String,Double>> buildGraph(List<List<String>> equations, double[] values){
        Map<String, Map<String,Double>> graph = new HashMap<>();
        String u,v;

        for(int i = 0; i < equations.size(); i ++){
            u = equations.get(i).get(0);
            v = equations.get(i).get(1);
            graph.putIfAbsent(u, new HashMap<>());
            graph.get(u).put(v,values[i]);
            graph.putIfAbsent(v,new HashMap<>());
            graph.get(v).put(u,1/values[i]);
        }
        return graph;
    }
}
```

## 2359. Find Closest Node to Given Two Nodes

- Time: O(n)
- Space: O(n)
-
