class Solution {
    /*
    Brutal force solution:
    left_max
    right_max
    res += min(left_max, right_max) - height[i]

    


    */
    public int trap(int[] height) {
        int res = 0;
        int size = height.length;
        for(int i = 1; i < size-1; i ++){
            int left_max = 0, right_max = 0;
            for(int j = i ; j >= 0; j--){
                left_max = Math.max(left_max, height[j]);
            }
            for(int k = i; k <= size-1; k++){
                right_max = Math.max(right_max, height[k]);
            }
            res+=Math.min(left_max, right_max) - height[i];
        }

        return res;
    }
}