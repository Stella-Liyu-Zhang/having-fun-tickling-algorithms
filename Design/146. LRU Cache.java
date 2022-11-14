class LRUCache {
    final Node head = new Node();
    final Node tail = new Node();
    Map<Integer, Node> nodeMap;
    int cache_capacity;

    public LRUCache(int capacity) {
        // Initialize the LRU cache with positive size capacity.
        nodeMap = new HashMap(capacity);
        this.cache_capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        // Return the value of the key if the key exists, otherwise return -1.
        int result = -1;
        Node node = nodeMap.get(key);
        if (node != null) { // move to the front of the cache
            result = node.val;
            remove(node);
            add(node);
        }
        return result;
    }

    public void put(int key, int value) {
        Node node = nodeMap.get(key);
        if (node != null) {
            remove(node);
            node.val = value;
            add(node);
        } else {
            if (nodeMap.size() == cache_capacity) {
                nodeMap.remove(tail.prev.key); // remove from the hashmap
                remove(tail.prev); // remove from the linkedlist
            }
            Node new_node = new Node();
            new_node.key = key;
            new_node.val = value;

            nodeMap.put(key, new_node);
            add(new_node);
        }

    }

    public void add(Node node) {
        // add to the front of the linkedlist, because we are removing from the tail
        Node head_next = head.next;
        head.next = node;
        node.prev = head; // dummy node, doesn't represent value
        node.next = head_next;
        head_next.prev = node;
    }

    public void remove(Node node) {
        // remove the node
        Node next_node = node.next;
        Node prev_node = node.prev;

        next_node.prev = prev_node;
        prev_node.next = next_node;
    }

    class Node { // doubly linkedlist has prev, next nodes specified.
        int key;
        int val;
        Node prev;
        Node next;
    }

}
// linkedlist: delete/insert are constant time, and need ordering
// hashmaps are unordered, need linkedlist to structure, put things in the
// constant time, head.next = new node.
// delete things, pop off the tail
// doubly linkedlist: reference to the head and tail

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */