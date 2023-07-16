# Binary search

## Normal Binary search

### Template:

```java
public int fn(int[] arr, int target) {
    int left = 0;
    int right = arr.length - 1;
    while (left <= right) {
        int mid = left + (right - left) / 2;
        if (arr[mid] == target) { //found the target
            return mid;
        }
        if (arr[mid] > target) {
            right = mid - 1;
        } else {
            left = mid + 1;
        }
    }

    // left is the insertion point
    return left;
}
```

## Binary search: duplicate elements, left-most insertion point

### Template:

```java
public int fn(int[] arr, int target) {
    int left = 0;
    int right = arr.length;
    while (left < right) {
        int mid = left + (right - left) / 2;
        if (arr[mid] >= target) {
            right = mid
        } else {
            left = mid + 1;
        }
    }

    return left;
}
```

## Binary search: Greedy problem

### Template:

```java
public int fn(int[] arr) {
    int left = MINIMUM_POSSIBLE_ANSWER;
    int right = MAXIMUM_POSSIBLE_ANSWER;
    while (left <= right) {
        int mid = left + (right - left) / 2;
        if (check(mid)) {
            right = mid - 1;
        } else {
            left = mid + 1;
        }
    }

    return left;
}

public boolean check(int x) {
    // this function is implemented depending on the problem
    return BOOLEAN;
}
```

## 34. Find First and Last Position of Element in Sorted Array

### Approach 1: binary search twice

```java
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = {-1,-1};
        ans[0] = findFirst(nums, target);
        ans[1] = findSecond(nums, target);
        return ans;
    }
    //[5,7,7,8,8,10], target = 8
    private int findFirst(int[] nums, int target){
        int left = 0, right = nums.length - 1;
        int start = -1;
        while (left <= right){
            int mid = left + (right-left)/2;
            if (nums[mid] < target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
            if (nums[mid] == target){
                start = mid; //this is the start
                right = mid - 1; //let's see if there is one more on the left.
            }
        }
        return start;
    }
    private int findSecond(int[] nums, int target){
        int left = 0, right = nums.length - 1;
        int end = -1;
        while (left <= right){
            int mid = left + (right - left)/2;
            if (nums[mid] > target){
                right = mid-1;
            }else{
                left = mid + 1;
            }
            if (nums[mid] == target){
                end = mid; //this is the end
                left = mid + 1;// lets see if there is one more on the right
            }
        }
        return end;
    }
}
```

### Approach 2: One binary search with a cheating trick

- we are finding the left one that is the one right next to the 7.5 or 8.5
- So we are returning the left one for the smaller double
- and return the left-1 for the bigger double

```java
class Solution {
    public int[] searchRange(int[] nums, int target) {
        double left = target - 0.5;
        double right = target + 0.5;
        int l = bs(nums, left);
        int r = bs(nums, right);
        if (l == r){
            return new int[] {-1 , -1};
        }
        return new int[]{l, r-1};
    }

    private int bs(int[] nums, double target){
        int left = 0, right = nums.length - 1;
        while (left <= right){
            int mid = left + (right-left)/2;
            if (nums[mid] < target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return left;
    }
}

```

## 438. Find All Anagrams in a String

rearrangement of letters of the string, permutation in math

### Original approach --fail

```java
//original solution
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        HashSet<Character> hs = new HashSet<>();
        for(char c: p.toCharArray()){
            hs.add(c);
        }
        int length = p.length();
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < s.length() - p.length(); i ++){
            boolean containsAll = true;
            for(int j = i; j < i+p.length(); j ++){
                if (hs.contains(s.charAt(j)) == false){
                    containsAll = false;
                }
            }
            if (containsAll = true){
                list.add(i);
            }
        }
        return list;
    }
}
```
