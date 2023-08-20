/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    /*
    DFS
    Allocate memory, and copy all the connections
    undirected graph, 2 ways
    1 [2,3]
    2 [1,4]
    3 [1,4]
    4 [2,3]
    given the first node

    traverse over all the nodes, make clones, copies of each node
    make the same connections as the input graph
    key: int,
    value: Node

    assume unique integers for each
    a map that stores the copied node!
    1 -> new Node[1]
    2 -> new Node[2]
    take copy of node1 to connect with the copy of node2

    call the function recursively non each neighbors

    Time: O(N)
    Space: O(N) copy of every node in the original graph
    */
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        Map<Integer, Node> map = new HashMap<>();
        return cloneGraph(map, node);
    }
    private Node cloneGraph(Map<Integer, Node> map, Node node){
        if (map.containsKey(node.val)){
            return map.get(node.val);
        }
        Node copy = new Node(node.val);
        map.put(node.val, copy);
        for(Node neighbor: node.neighbors){
            copy.neighbors.add(cloneGraph(map, neighbor));
        }
        return copy;
    }
}