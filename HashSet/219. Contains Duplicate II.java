class Solution {
    /*
    Use a treeset
    Time: O(nlog(min(k,n)))
    Space: O(min(n,k)) 
    Space is the size of the sliding window which should not exceed n or k.
    A BST supports search, delete and insert operations all in O(log⁡k)O(\log k)O(logk) time, where kkk is the number of elements in the BST.


    Use a hashset
    Time: O(N), 
    Space: O(min(n,k))


    */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> set = new HashSet();
        for(int i = 0; i < nums.length; i ++){
            if(set.contains(nums[i])){
                return true;
            }
            set.add(nums[i]);
            if(set.size() > k){
                set.remove(nums[i - k]);
            }
        }
        return false;
    }
}