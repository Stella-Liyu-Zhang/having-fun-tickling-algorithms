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

## 27. Remove Element
A[i--] is the same as executing:
```java
A[i];
i--;
```
Moreover:
> --i decrements and then uses the variable.

> i-- uses and then decrements the variable.

## 485. Max Consecutive Ones
We need to track both the currNum of ones whenever we come across a block of 1s. And each time we take the maximum of the currNum and maxNum so that maxNum is always representing the maximum number of ones.

If we didn't come across any 1's, we will set the currNum to 0.

## 209. Minimum Size Subarray Sum

Given an array of positive integers nums and a positive integer target, return the minimal length of a contiguous subarray ```[numsl, numsl+1, ..., numsr-1, numsr]``` of which the sum is greater than or equal to target. 

If there is no such subarray, return 0 instead.

> First, check if the array is empty. If so, return 0;
```java
        if (nums.length == 0) return 0;
```
The algorithm follows:
- FIrst, we set the minimimum value that shall be returned to be the maximum value in integer, sum = 0, and left = 0 (since we start from the very leftest of the array.)
```java
        int minNum = Integer.MAX_VALUE;
        int val_sum = 0;
        int left = 0;
```
- Next, we loop through the whole array, and increment the array until the sum is greater than or equal to target.
```java
        for (int i = 0; i < nums.length; i++){
            val_sum += nums[i];
```
  - Once the (val_sum >= target), we set the minNum to be the minimal one of the current length of the array (i-left+1)
  - we will decrement the val_sum by the leftest element, and increment left window by 1.
```java
            while (val_sum >= target){
                minNum = Math.min(minNum, i-left+1);
                val_sum -= nums[left];
                left ++;
            }
```
- By doing this, we continue to add new elements in the array and the window is moved one right.
- Ultimately, we will return the minNum. If the minNum is still equal to the Integer.MAX_VALUE, then there is no such sum >= target, we will return 0.
```java
        return minNum != Integer.MAX_VALUE ? minNum : 0;
```
## 76. Minimum Window Substring
First, what need ed to be approached is to make sure 
