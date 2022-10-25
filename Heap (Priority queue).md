## Build a maxheap according the the value comparison, and throw map's key into the set

```java
 //max heap building
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        maxHeap.addAll(map.keySet());
```
