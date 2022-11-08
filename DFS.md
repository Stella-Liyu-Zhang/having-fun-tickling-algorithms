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

##

`
