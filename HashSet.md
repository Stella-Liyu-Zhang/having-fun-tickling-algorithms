## 287. Find the Duplicate Number

### Approach 1: HashSet

- time: O(n)
- Space: O(n)

```java
class Solution {
    public int findDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet();
        for(int i = 0; i < nums.length; i ++){
            if (set.contains(nums[i])){
                return nums[i];
            }
            set.add(nums[i]);
        }
        return -1;
    }
}
```

### Approach 2: Sort

Algorithm

- Sort the input array (numsnums).
- Iterate through the array, comparing the current number to the previous number (i.e. compare `nums[i]` to `nums[i - 1]` where i > 0).
- Return the first number that is equal to its predecessor.

- time: `O(nlogn)`
- Space:` O(n) or O(log n)`
  - In Java, Arrays.sort() for primitives is implemented using a variant of the Quick Sort algorithm, which has a space complexity of `O(logn)`

```java
class Solution {
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        for(int i = 1;i < nums.length; i ++){
            if (nums[i] == nums[i-1]){
                return nums[i];
            }
        }
        return -1;
    }
}
```

### Approach 3: Negative Marking

- Time: O(n)
- Space: O(1)

```java
class Solution {
    public int findDuplicate(int[] nums) {
        int dup = -1;
        for(int i = 0; i < nums.length; i ++){
            int cur = Math.abs(nums[i]);
            if (nums[cur] < 0){
                dup = cur;
                break;
            }
            nums[cur] *= -1;
        }
        //restore the numbers
        for(int i = 0; i < nums.length; i ++){
            nums[i] = Math.abs(nums[i]);
        }
        return dup;
    }
}
```

### Approach 4: Binary Search

```java
class Solution {
    public int findDuplicate(int[] nums) {
        //low and high represent the range of values of the target
        int low = 1;
        int high = nums.length - 1;
        int dup = -1;

        while(low <= high){
            int cur = (low + high) / 2;
            //count how many numbers are less than or equal to 'cur'
            int count = 0;
            for(int num : nums){
                if (num <= cur){
                    count ++;
                }
            }

            if (count > cur){
                dup = cur;
                high = cur - 1;
            }else{
                low = cur + 1;
            }
        }
        return dup;
    }
}
```

- time: `O(nlogn)`
- Space: ` O(1)`

## 139. Word Break
