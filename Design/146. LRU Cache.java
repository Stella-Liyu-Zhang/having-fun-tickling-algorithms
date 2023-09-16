class LRUCache {
    int capacity;
    HashMap<Integer, Node> map;
    Node head = new Node(0,0);
    Node tail = new Node(0,0);

    class Node{
        Node prev, next;
        int key, value;

        Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head.next = tail;
        tail.prev = head;
    }

    /*
    check if exists in the map
    access any value from the cache, we need to move data to the top of the cache
    remove the node,and then insert it.
    */
    public int get(int key) {
        if(map.containsKey(key) ){
            Node data = map.get(key);
            remove(data);
            insert(data);
            return data.value;
        }
        return -1;
    }

    /*
    if value is already present, we move it to the top
    if the cache is full,
    turn tail.prev --> least recently used 
    */
    public void put(int key, int value) {
        //key already present, we remove it from the map.
        if(map.containsKey(key)){
            remove(map.get(key));
        }
        //cache is full
        //remove tail.prev,
        if(capacity == map.size()){
            remove(tail.prev);
        }
        insert(new Node(key, value));
    }
    //delete a node from the linkedlist
    void remove(Node node){
        map.remove(node.key);
        //remove from the linkedlist
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    //store next to the head
    void insert(Node node){
        map.put(node.key, node);

        Node headNext = head.next;
        head.next = node;
        node.prev = head;
        node.next = headNext;
        headNext.prev = node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */