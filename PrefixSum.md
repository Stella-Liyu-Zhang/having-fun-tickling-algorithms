## 523. Continuous Subarray Sum

Let pref[i] denote the sum of the first ii elements of the array numsnums,
i.e. pref[i]=nums[0] + nums[1] + ... + nums[i-1]. In particular pref[0]=0

```
        mod operation
        subarray --> try every single subaray
        n^2 subarrays, O(n^2) --> brutal force to get the sum

        prefix: first n computed, easily calcualted compute every subarray in O(1), just substract!

        (a+(n*x))%x is same as (a%x)

        For e.g. in case of the array [23,2,6,4,7] the running sum is [23,25,31,35,42] and the remainders are [5,1,1,5,0]. We got remainder 5 at index 0 and at index 3. That               means, in between these two indexes we must have added a number which is multiple of the k.
```

Time, space: O(n)

```java
Map<Integer, Integer> map = new HashMap<>(Map.of(0,-1));
        int sum = 0;
        for(int i = 0; i < nums.length; i ++){
            sum += nums[i];
            if (k != 0) sum = sum % k;
            Integer prev = map.get(sum);
            if (prev != null){
                if (i - prev > 1){
                    return true;
                }
            }else{
                map.put(sum, i);
            }
        }
return false;
```

## 974. Subarray Sums Divisible by K

- time: O(n)
- Space: O(m)

```java
public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int sum=0, count=0;
        for(int i = 0; i < nums.length; i ++){
            sum = (sum + nums[i]) % k;
            if(sum < 0) sum += k;  // Because -1 % 5 = -1, but we need the positive mod 4
            count += map.getOrDefault(sum, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
}
```
