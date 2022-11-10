class Solution {
    /*
    Brutal force approach: loop through nums1, and then nested loop through nums2
    
    first, loop through
    Hashmap: each number  its next greates element
    
    */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < nums2.length; i ++){
            while(stack.isEmpty() == false && stack.peek() < nums2[i]){
                map.put(stack.pop(), nums2[i]);
            }
            stack.push(nums2[i]);
        }
        for(int j = 0; j < nums1.length; j ++){
            int curr = map.getOrDefault(nums1[j], -1);
            nums1[j] = curr;
        }
        return nums1; 
    }
}