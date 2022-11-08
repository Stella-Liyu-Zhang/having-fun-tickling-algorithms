# Two pointer techniques

## Two-pointer Technique - Scenario I

In the previous chapter, we solve some problems by iterating the array. Typically, we only use one pointer starting from the first element and ending at the last one to do iteration. However, sometimes, we might need to use two pointers at the same time to do the iteration.

> Reverse the elements in an array.

The idea is to swap the first element with the end, advance to the next element and swapping repeatedly until it reaches the middle position.

We can use two pointers at the same time to do the iteration:

> one starts from the first element and another starts from the last element.

Continue swapping the elements until the two pointers meet each other.

```java
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

Given an array of positive integers nums and a positive integer target, return the minimal length of a contiguous subarray `[numsl, numsl+1, ..., numsr-1, numsr]` of which the sum is greater than or equal to target.

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

## 11. Container With Most Water

> Proof
> In this problem, the smart scan way is to set two pointers initialized at both ends of the array. Every time move the smaller value pointer to inner array. Then after the two pointers meet, all possible max cases have been scanned and the max situation is 100% reached somewhere in the scan. Following is a brief prove of this.

Given a1,a2,a3.....an as input array. Lets assume a10 and a20 are the max area situation. We need to prove that a10 can be reached by left pointer and during the time left pointer stays at a10, a20 can be reached by right pointer. That is to say, the core problem is to prove: when left pointer is at a10 and right pointer is at a21, the next move must be right pointer to a20.

Since we are always moving the pointer with the smaller value, i.e. if a10 > a21, we should move pointer at a21 to a20, as we hope. Why a10 >a21? Because if a21>a10, then area of a10 and a20 must be less than area of a10 and a21. Because the area of a10 and a21 is at least height[a10] _ (21-10) while the area of a10 and a20 is at most height[a10] _ (20-10). So there is a contradiction of assumption a10 and a20 has the max area. So, a10 must be greater than a21, then next move a21 has to be move to a20. The max cases must be reached.

## 125. Valid Palindrome

```java
 s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
```

```java
public boolean isPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int ap = 0, bp = s.length() - 1;
        while(ap < bp){
            if (s.charAt(ap) != s.charAt(bp)){
                return false;
            }
            ap ++;
            bp --;
        }
        return true;
}
```
