## 1

```java
import java.util.Map;
import java.util.TreeMap;
public class Main
{
	public static void main(String[] args) {
	    Map<Integer, String> m = new TreeMap<Integer, String>();
	    m.put(11,"a");
	    m.put(null, null);
	    m.put(11,"b");
	    m.put(null, "f");
	    System.out.println(m.size());
	}
}
```

-- Runtime exception
NullPointerException is a runtime exception in Java that occurs when a variable is accessed which is not pointing to any object and refers to nothing or null.

Since the NullPointerException is a runtime exception, it doesn't need to be caught and handled explicitly in application code.

## 2

```java
public static void main(String[] args) {
	    PriorityQueue todo = new PriorityQueue();
	    todo.add("dishes");
	    todo.add("laundry");
	    todo.add("bills");
	    todo.offer("bills");
	    System.out.print(todo.size() + " " + todo.poll()); // 4 bills
	    System.out.print(" " +todo.peek() + todo.poll()); // bills bills
	    System.out.print( " " +todo.poll() + " " + todo.poll()); //dishes, laundry

}

4 bills billsbills dishes laundry
```

The two functions come from two different interfaces that PriorityQueue implements:

- `add()` comes from Collection.
- `offer()` comes from Queue.

For a capacity-constrained queue, the difference is that

- `add()` always returns `true` and throws an exception if it can't add the element.
- `offer()` is allowed to return `false` if it can't add the element.

However, this doesn't apply to `PriorityQueue`; the two functions are synonymous.

## 3

```java
public class Main
{
	public static void main(String[] args) {
	    try{
	        System.out.println(doStuff(args));
	    }catch(Exception e){
	        System.out.println("exc");
	    }
	    doStuff(args);
	}
	static int doStuff(String[] args){
	    return Integer.parseInt(args[0]);
	}
}
exc
Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 0 out of bounds for length 0
        at Main.doStuff(Main.java:22)
        at Main.main(Main.java:19)
```

## 4

```java
public class Main
{
	public static void main(String[] args) {
	    String[] cities = {"Bangalore", "Pune", "San Francisco", "New York City"};
	    mySort ms = new mySort();
	    Arrays.sort(cities, ms);
	    System.out.println(Arrays.binarySearch(cities, "New York City"));
	}
	static class mySort implements Comparator{
	    public int compare(String a, String b){
	        return b.compareTo(a);
	    }
	}
}

Main.java:19: error: mySort is not abstract and does not override abstract method compare(Object,Object) in Comparator
	static class mySort implements Comparator{
	       ^
Note: Main.java uses unchecked or unsafe operations.
Note: Recompile with -Xlint:unchecked for details.
1 error
```

## 5

```java
class Test
{
    private Demo d;
    void start()
    {
        d = new Demo();
        this.takeDemo(d); /* Line 7 */
    } /* Line 8 */
    void takeDemo(Demo demo)
    {
        demo = null;
        demo = new Demo();
    }
}

When is the Demo object eligible for garbage collection?
A.	After line 7
B.	After line 8
C.	After the start() method completes
D.	When the instance running this code is made eligible for garbage collection.

Option D is correct. By a process of elimination.

Option A is wrong. The variable d is a member of the Test class and is never directly set to null.

Option B is wrong. A copy of the variable d is set to null and not the actual variable d.

Option C is wrong. The variable d exists outside the start() method (it is a class member). So, when the start() method finishes the variable d still holds a reference.
```

## 6 reductionCost

Given an array, reduce the array to a single element with minimum cost. For reducing, remove two elements from the array, add those two numbers and keep the sum back in the array. The cost of each operation is the sum of the elements removed in that step.

Example, let the array `A = [1,2,3]`

Then, we can remove 1 and 2, add both of them and keep the sum back in array. Cost of this step would be `(1+2) = 3.`

So `A = [3,3], Cost = 3`

In second step, we can remove both elements from the array and keep the sum back in array again. Cost of this step would be `3 + 3 = 6.`

So, `A = [6], Cost = 6`

So total cost turns out to be `9 (6+3).`

```java

class Result {
    public static int reductionCost(List<Integer> num) {
        //return the minimum total cost of reducing the array to one element
        //the minimum cost is get when we add 2 minimum elements of the array
        //the head of the queue is the least element based on natural ordering
        PriorityQueue<Integer> queue = new PriorityQueue<>(num);

        int cost = 0;
        while (queue.size()>=2){
            int first = queue.poll();
            int second = queue.poll();
            int sum = first + second;
            cost += sum;
            queue.offer(sum);
        }
        return cost;
    }

}
```

## 7 getAnagram

```java
class Result {

    /*
     * Complete the 'getAnagram' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

    public static int getAnagram(String s) {
        //Return the minimum number of operations needed to make the first half an anagram of its second half
        /*123456
         len: 6
         half: 3
         a 0
         b 4
         ans 0
        */
        int len = s.length();
        int ans = 0;
        int[] arr = new int[10];
        for(int i = 0; i < len/2; i ++){
            arr[Character.getNumericValue(s.charAt(i))] ++;
        }
        for(int j = len/2; j < len; j ++){
            arr[Character.getNumericValue(s.charAt(j))] --;
        }
        for(int k = 0; k < 10; k++){
            if (arr[k] > 0){
                ans += arr[k];
            }
        }
        return ans;
    }

}

```

## 8

For a given array of integers, perform operations on the array. Return the resulting array after all operations have been applied in the order given. Each operation contains two indices. Reverse the subarray between those zero-based indices, inclusive.

```
1: arr is : [1, 2, 3]
1: operations is : [[0, 2], [1, 2], [0, 2]]

2: arr is : [640, 26, 276, 224, 737, 677, 893, 87, 422, 30]
2: operations is : [[0, 9], [2, 2], [5, 5], [1, 6], [5, 6], [5, 9], [0, 8], [6, 7], [1, 9], [3, 3]]
```

```java
private static void reverseArray(List<Integer> arr, List<List<Integer>> h) {
    for (List<Integer> list : h) {
        reverse(arr, list.get(0), list.get(1));
    }
}

private static void reverse(List<Integer> arr, Integer start, Integer end) {
    int endval = end;
    for (int i = start; i < end; i++) {
        if (i < endval) {
            int temp = arr.get(i);
            arr.set(i, arr.get(endval));
            arr.set(endval, temp);
            endval--;
        }
    }
}
```
