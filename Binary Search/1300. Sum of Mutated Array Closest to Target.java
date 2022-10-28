class Solution {
    public int findBestValue(int[] arr, int target) {
        int max = -1;
        for(int a : arr){
            max = Math.max(max,a);
        }
        int left = 0, right = max;
        int diff = target;
        int prev = max;
        while(left <= right){
            int mid = (left + right)/2;
            int sum = getSum(arr, mid);
            int currDiff = Math.abs(target-sum);
            if (currDiff < diff){
                diff = currDiff;
                prev = mid;
            }else if (currDiff == diff){
                prev = Math.min(prev, mid);
            }
            if(sum > target){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return prev;
        
    }
    public int getSum(int[] arr, int value){
        int sum = 0;
        for(int a : arr){
            if (a > value){
                sum += value;
            }else{
                sum += a;
            }
        }
        return sum;
    }
}