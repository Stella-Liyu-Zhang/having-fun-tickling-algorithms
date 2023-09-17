class Solution {
    /*
     * 
     *
     */
    public int minStartValue(int[] nums) {
        int sum = 0;
        int minStepSum = 0;
        for(int i : nums){
            sum += i;
            minStepSum = Math.min(minStepSum, sum);
        }
        return -minStepSum + 1;

    }
}