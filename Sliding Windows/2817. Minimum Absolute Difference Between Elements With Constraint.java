class Solution {
    public int minAbsoluteDifference(List<Integer> nums, int x) {
        //Initialize a variable ans with the maximum possible integer value (INT_MAX). This variable will store the minimum absolute difference between elements.
        int ans = Integer.MAX_VALUE;

        //Use a multiset named s to store elements that are at most x indices away from the current index i.
        TreeSet<Integer> set = new TreeSet();
        //Iterate through the array nums starting from index x (since you need to have at least x indices between the elements):
        for(int i = x; i < nums.size(); i ++){
        //a. Insert the element at index i - x into the multiset s. This step effectively maintains a sliding window of size x, ensuring that only elements within the range of the window are present in the set.
            set.add(nums.get(i-x));
            //E floor(E element): Returns the greatest element in the set that is less than or equal to the given element, or null if there is no such element.
            //E ceiling(E element): Returns the smallest element in the set that is greater than or equal to the given element, or null if there is no such element.
            Integer high = set.ceiling(nums.get(i));
            Integer low = set.floor(nums.get(i));
        
            if (high != null){
                ans = Math.min(ans, Math.abs(nums.get(i) - high));
            }
            if (low != null){
                ans = Math.min(ans, Math.abs(nums.get(i) - low));
            }
            //After iterating through the array, the variable ans will hold the minimum absolute difference between two elements that are at least x indices apart.

        }

        return ans;
    }
}