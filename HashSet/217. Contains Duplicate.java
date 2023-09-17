class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet();
        for(int i: nums){
            set.add(i);
        }
        if(set.size() == nums.length){
            return false;
        }
        return true;
    }
}