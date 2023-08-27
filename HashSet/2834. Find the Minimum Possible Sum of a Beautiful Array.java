class Solution {
    /*
    Iterate from 1 and keep on adding the number to a unorderd set, if the compliment of it (k- i) is not already present in the set. 
    Also add this to the answer as well.
    */
    public long minimumPossibleSum(int n, int target) {
        HashSet<Long> set = new HashSet<>();
        long ans = 0;
        for (long i = 1; set.size() < n; i ++){
            if(set.contains(target - i) == false){
                set.add(i);
                ans+=i;
            }
        }
        return ans;
    }
}