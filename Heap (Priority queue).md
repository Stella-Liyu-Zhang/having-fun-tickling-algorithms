## MinHeap versus MaxHeap

- Min-Heap

  > In a Min-Heap the key present at the root node must be less than or equal among the keys present at all of its children. The same property must be recursively true for all sub-trees in that Binary Tree. In a Min-Heap the minimum key element present at the root. Below is the Binary Tree that satisfies all the property of Min Heap.

- Max Heap

  > In a Max-Heap the key present at the root node must be greater than or equal among the keys present at all of its children. The same property must be recursively true for all sub-trees in that Binary Tree. In a Max-Heap the maximum key element present at the root. Below is the Binary Tree that satisfies all the property of Max Heap.

- Performance Analysis of Min-Heap and Max-Heap:
  - Get Maximum or Minimum Element: O(1)
  - Insert Element into Max-Heap or Min-Heap: O(log N)
  - Remove Maximum or Minimum Element: O(log N)

## Priority Queue:

A priority queue can be implemented by using a heap because it supports insert(), delete(), extractMax(), decreaseKey() operations in O(log N) time.

## Build a maxheap according the the value comparison, and throw map's key into the set

```java
 //max heap building
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        maxHeap.addAll(map.keySet());
```

## poll() method versus peek() method

- The `java.util.PriorityQueue.poll()` method in Java is used to retrieve or fetch and remove the first element of the Queue or the element present at the head of the Queue.

- The `peek() `method only retrieved the element at the head but the `poll()` also removes the element along with the retrieval. It returns `NULL `if the queue is empty.

## String compareTo method

```java
String s1="hello";
String s2="hello";
String s3="meklo";
String s4="hemlo";
String s5="flag";
System.out.println(s1.compareTo(s2));//0 because both are equal
System.out.println(s1.compareTo(s3));//-5 because "h" is 5 times lower than "m"
System.out.println(s1.compareTo(s4));//-1 because "l" is 1 times lower than "m"
System.out.println(s1.compareTo(s5));//2 because "h" is 2 times greater than "f"
```

## Queue where the add and offer methods are different

If a collection refuses to add a particular element for any reason other than that it already contains the element, it must throw an exception (rather than returning false). This preserves the invariant that a collection always contains the specified element after this call returns.
