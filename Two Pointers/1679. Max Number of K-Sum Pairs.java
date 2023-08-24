class Solution {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0, right = nums.length-1;
        int count = 0;
        while(left < right){
            if(nums[left] + nums[right] < k){
                left ++;
            }else if (nums[left] + nums[right] > k){
                right --;
            }else{
                left ++;
                right --;
                count ++;
            }
        }
        return count;
    }
}

//second solution: hashmap one pass
class Solution {
    /*
    key: nums[i] 
    value: occurance
    Time: O(n)
    Space: O(n)
    */
    public int maxOperations(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap();
        int count = 0;
        for(int i: nums){
            if(map.getOrDefault(k-i, 0) > 0){ //check complement element
                map.put(k-i, map.get(k-i)-1); //make sure the occurence --
                count ++;
            }else{
                //put current in the map
                map.put(i, map.getOrDefault(i, 0) + 1);
            }
        }
        return count;
    }
}