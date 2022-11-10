class Solution {
    /*
     * no need to use hashmap bc there's only one nums
     * circular -->
     * 'aeiou' 'eiouaeioua' duplicate the string, and see if contains.
     * [1,2,1]
     * extend the array with an extended for loop
     * 
     * 
     */
    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        int[] ans = new int[len];
        Arrays.fill(ans, -1);
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < len * 2; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % len]) {
                ans[stack.pop()] = nums[i % len];
            }
            if (i < len) {
                stack.push(i);
            }
        }

        return ans;
    }
}