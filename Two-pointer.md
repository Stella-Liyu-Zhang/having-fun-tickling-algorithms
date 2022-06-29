# Two pointer techniques

##   Two-pointer Technique - Scenario I
In the previous chapter, we solve some problems by iterating the array. Typically, we only use one pointer starting from the first element and ending at the last one to do iteration. However, sometimes, we might need to use two pointers at the same time to do the iteration.

> Reverse the elements in an array.

The idea is to swap the first element with the end, advance to the next element and swapping repeatedly until it reaches the middle position.

We can use two pointers at the same time to do the iteration: 

> one starts from the first element and another starts from the last element. 

Continue swapping the elements until the two pointers meet each other.

``` java
public static void reverse(int[] v, int N) {
    int i = 0;
    int j = N - 1;
    while (i < j) {
        swap(v, i, j);  // this is a self-defined function
        i++;
        j--;
    }
}
```
## Summary
To summarize, one of the typical scenarios to use two-pointer technique is that you want to 

> Iterate the array from two ends to the middle.

**Notice**
> This technique is often used in a sorted array.

## 344. Reverse String
Thoughts: 
- We use a two-pointer technique with one pointer at the first index, the other pointer at the end of the array.
- and we just swap each pairs of pointered elements in the array.

## 
