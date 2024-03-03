class ListNode{
    int key;
    int value;
    ListNode prev;
    ListNode next;
    public ListNode(int key, int value){
         this.key = key;
         this.value = value;
    }
}
class LRUCache {
 int capacity;
    HashMap<Integer, ListNode> map;
    ListNode head = new ListNode(-1, -1);
    ListNode tail = new ListNode(-1, -1);

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap();
        head.next = tail;
        tail.prev = head;
    }
    public int get(int key) {
        if(map.containsKey(key)){
            ListNode node = map.get(key);
            remove(node);
            add(node);
            return node.value;
        }
        return -1;
    }
    public void put(int key, int value) {
        if(map.containsKey(key)){
            //update
            ListNode oldNode = map.get(key);
            remove(oldNode);

        }
        ListNode newNode = new ListNode(key, value);
        add(newNode);
        map.put(key, newNode);

        if(map.size() > capacity){
            ListNode toDelete = head.next;
            remove(toDelete);
            map.remove(toDelete.key);
        }
    }
    public void add(ListNode node){
        //add before tail
        //beforeTail -> node -> tail
        ListNode beforeTail = tail.prev;

        beforeTail.next = node;
        node.prev = beforeTail;
        node.next = tail;
        tail.prev = node;
    }

    public void remove(ListNode node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */