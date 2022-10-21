## Table of Contents

- [Table of Contents](#table-of-contents)
- [22. Generate Parentheses](#22-generate-parentheses)
  - [Approach 1: Backtracking](#approach-1-backtracking)
  - [Approach 2: DP](#approach-2-dp)
- [15. 3Sum](#15-3sum)
  - [Approach 1: Two-pointers](#approach-1-two-pointers)
  - [Approach 2: Hashset + two-pointers](#approach-2-hashset--two-pointers)

## 22. Generate Parentheses

### Approach 1: Backtracking

![](assets/20221021085125.jpg)

Complexity Analysis:
![](assets/20221021085359.jpg)

```java
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backtrack(ans, n, 0, 0, "");
        return ans;
    }

    public void backtrack(List<String> ans, int max, int open, int closed, String s) {
        if (max * 2 == s.length()) {
            ans.add(s);

        }
        if (open < max) {
            backtrack(ans, max, open + 1, closed, s + "(");
        }
        if (closed < open) {
            backtrack(ans, max, open, closed + 1, s + ")");
        }
    }
}
```

### Approach 2: DP

First consider how to get the result f(n) from previous result f(0)...f(n-1).
Actually, the result f(n) will be put an extra () pair to f(n-1). Let the "(" always at the first position, to produce a valid result, we can only put ")" in a way that there will be i pairs () inside the extra () and n - 1 - i pairs () outside the extra pair.

Let us consider an example to get clear view:

```
f(0): ""

f(1): "("f(0)")"

f(2): "("f(0)")"f(1), "("f(1)")"

f(3): "("f(0)")"f(2), "("f(1)")"f(1), "("f(2)")"

So f(n) = "("f(0)")"f(n-1) , "("f(1)")"f(n-2) "("f(2)")"f(n-3) ... "("f(i)")"f(n-1-i) ... "(f(n-1)")"
```

```java
public class Solution
{
    public List<String> generateParenthesis(int n)
    {
        List<List<String>> lists = new ArrayList<>();
        lists.add(Collections.singletonList(""));

        for (int i = 1; i <= n; ++i)
        {
            final List<String> list = new ArrayList<>();

            for (int j = 0; j < i; ++j)
            {
                for (final String first : lists.get(j))
                {
                    for (final String second : lists.get(i - 1 - j))
                    {
                        list.add("(" + first + ")" + second);
                    }
                }
            }

            lists.add(list);
        }

        return lists.get(lists.size() - 1);
    }
}
```

## 15. 3Sum

### Approach 1: Two-pointers

for each arr[i], look at the rest of the array to see if there is a pair.

> Idea: [-1,0,1,2,-1,-4]
> Loop through the sorted array,
> Look at -1, check if there are a pair of ints in the rest of the array that addes up to 1, then look at 2, check if there is a pair of ints ....

- Time complexity : O(n^2)
- Space complexity : O(n^2)

```java
 public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> output = new LinkedList();

        for(int i = 0; i < nums.length - 2; i++){
            if (i == 0 || i > 0 && nums[i] != nums[i-1]){
                int sum = 0 - nums[i];
                int left = i+1;
                int right = nums.length - 1;

                while (left < right){
                    if (nums[left] + nums[right] == sum){
                        output.add(Arrays.asList(nums[i], nums[left], nums[right]));
                        while(left < right && nums[left] == nums[left+1]){
                            left ++;
                        }
                        while(left < right && nums[right] == nums[right-1]){
                            right --;
                        }
                        left ++;
                        right --;
                    }else if(nums[left] + nums[right] > sum){
                        right --;
                    }else{
                        left ++;
                    }
                }
            }
        }
        return output;
    }
```

### Approach 2: Hashset + two-pointers

```java

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        if(nums.length == 0){
            return new ArrayList<>(set);
        }
        Arrays.sort(nums);

        for(int i = 0; i < nums.length; i ++){
            int left = i+1, right = nums.length - 1;
            while (left < right){
                int sum = nums[i] + nums[right]+nums[left];
                if (sum == 0){
                    set.add(Arrays.asList(nums[i], nums[right], nums[left]));
                    left ++;
                    right --;
                }else if (sum < 0){
                    left ++;
                }else if (sum > 0){
                    right --;
                }
            }
        }
        return new ArrayList<>(set);
    }
}
```

##

Approach 1:

```java

```

##

Approach 1:

```java

```

##

Approach 1:

```java

```

##

Approach 1:

```java

```

##

Approach 1:

```java

```

##

Approach 1:

```java

```

##

Approach 1:

```java

```

##

Approach 1:

```java

```

##

Approach 1:

```java

```

##

Approach 1:

```java

```

##

Approach 1:

```java

```

##

Approach 1:

```java

```

##

Approach 1:

```java

```

##

Approach 1:

```java

```

##

Approach 1:

```java

```

##

Approach 1:

```java

```
