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

### 438. Find All Anagrams in a String

```java
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();

        if (s.length() == 0 || s== null){
            return ans;
        }

        //ascci values frequency table
        int[] table = new int[26];
        for(char c: p.toCharArray()){
            table[c - 'a'] ++;
        }
        //sliding windows approach
        //boundaries left and right
        int left = 0;
        int right = 0;
        int diff = p.length();
        /*
         * Each time we update the size, and
         when size == 0, we add into ans
         diff = length of currently found anagram. If it equals the length of anagram to find, it must have been found

         find an anagram, expand the right boundary
         then move the left boundary
         */
        while (right < s.length()){
            char temp = s.charAt(right);
            if (table[s.charAt(right ++) - 'a'] -- >= 1){ //such a character exists, part of anagram
                diff --;
            }
            if (diff == 0){ //find the whole anagram
                ans.add(left);//add the starting index
            }
            if (right - left == p.length() && table[s.charAt(left ++ ) - 'a'] ++ >= 0){//the window expands to the size of the anagram
                // left ++; //move the left boundary
                // table[temp - 'a'] ++;
                //increment diff
                diff ++;
            }
        }
        return ans;
    }
}
```
