class Solution {
    /*
    Brutal force solution:
    left_max
    right_max
    res += min(left_max, right_max) - height[i]

    O(n^2)
    Two pointer olutioon
    left
    right

    */
    public int trap(int[] height) {
       int n = height.length;
        if(n <= 2) return 0;

        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        leftMax[0] = height[0];
        rightMax[n-1] = height[n-1];

        for(int i = 1, j = n - 2; i <= n-1 && j >= 0; i ++, j --){
            leftMax[i] = Math.max(leftMax[i-1], height[i]);
            rightMax[j] = Math.max(rightMax[j+1], height[j]);
        }
        int water = 0;
        for(int p = 1; p < n-1 ; p ++){
            int trapped = Math.min(leftMax[p-1], rightMax[p+1]) - height[p];
            if(trapped > 0){
                water += trapped;
            }
        }
        return water;
    }
}