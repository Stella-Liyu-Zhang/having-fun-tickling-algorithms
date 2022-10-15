class Solution {
    public int maxArea(int[] height) {
        // Between 2 walls, the smaller height[] is the height of the box. and the area
        // is 1*(min(height[a], height[b]))
        // Between n walls, the smaller height is the (n-1)*(min(height[0],
        // height[n-1]));

        int maxArea = Integer.MIN_VALUE;
        int left = 0, right = height.length - 1;
        while (left < right) {
            int currArea = (right - left) * (Math.min(height[right], height[left]));
            maxArea = Math.max(maxArea, currArea);
            if (height[left] < height[right])
                left++;
            else
                right--;
        }
        return maxArea;
    }
}