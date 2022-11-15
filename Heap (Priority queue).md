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

## 253. Meeting Rooms II

- Question
  Given an array of meeting time intervals consisting of start and end times `[[s1,e1],[s2,e2],...] (si < ei)`, find the minimum number of conference rooms required.

For example, Given `[[0, 30],[5, 10],[15, 20]]`, return `2`.

### minHeap + sort

```java
/*
  - sort the intervals according to the 0 index (starting time) in an ascending order
   [0, 30],[5, 10],[15, 20]

O(m log m)
O(m)
*/
    public int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 0){
                return 0;
        }
        Arrays.sort(intervals, (s1,s2) -> Integer.Compare(s1[0], s2[0])); //mlogm
        PriorityQueue<Integer> pq = new Queue<>();
        int rooms = 0;
        for(int i = 0; i < intervals.length; i ++){//m
                pq.offer(intervals[i][1]); //logn
                if (intervals[i][0] < pq.peek()){//O(1)
                        rooms ++;
                }else{//no overlaps exist
                        pq.poll(); //logn
                }
        }

        return rooms;
    }
```

### 2-pointer + sort

```java
/*
extract the two arrays representing start end time
[0, 30],[5, 10],[15, 20]
[0,5, 15]
[10,20,30]
i = 0
j = 0
activate = 0
max = 0
len = 3

we sort start time and end time.
initialize the start and end index as 0.
if start time < end time, means we have a meeting in active, active++.
else active--.
We need to record the max number of the active room.
*/
public int minMeetingRooms(int[][] intervals) {
        int len = intervals.length;
        int[] startTime = new int[len];
        int[] endTime = new int[len];
        int i = 0;
        for(int[] interval: intervals){
                startTime[i] = interval[0];
                endTime[i] = interval[1];
        }

        Array.sort(startTime);
        Array.sort(endTime);
        int i = 0, j = 0, max = 0, active = 0;
        while (i < len && j < len){
                if (startTime[i] < endTime[j]){
                        active ++;
                        i ++;
                }else{
                        active --;
                        j ++;
                }
                max = Math.max(max, active);
        }
        return max;

}
```
