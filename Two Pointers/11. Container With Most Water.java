class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxArea = 0;
        while(left < right){
            int currArea = Math.min(height[right], height[left])*(right - left);
            maxArea = Math.max(currArea, maxArea);
            if(height[left] <= height[right]){
                left ++;
            }else{
                right --;
            }
        }
        return maxArea;
    }
}