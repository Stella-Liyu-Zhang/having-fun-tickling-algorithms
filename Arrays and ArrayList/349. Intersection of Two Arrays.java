class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> intersection = new HashSet<>();
        for(int i: nums1){
            set1.add(i);
        }
        for(int j: nums2){
            if(set1.contains(j)){
                intersection.add(j);
            }
        }
        int[] output = new int[intersection.size()];
        int i = 0;
        for(int element: intersection){
            output[i++] = element;

        }
        return output;
    }
}

// binary search solution
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        //Binary search
        Set<Integer> set = new HashSet<>();
        Arrays.sort(nums2);
        for(int num: nums1){
            if(binarySearch(nums2, num)){
                set.add(num);
            }
        }
        int[] ans = new int[set.size()];
        int i = 0;
        for(Integer num: set){
            ans[i++] = num;
        }
        return ans;
    }
    private boolean binarySearch(int[] nums, int target){
        int low = 0;
        int high = nums.length - 1;
        while (low <= high){
            int mid = low + (high-low)/2;
            if(nums[mid] == target){
                return true;
            }else if (nums[mid] > target){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return false;
    }
}