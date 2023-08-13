class Solution {
    public int maxSum(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        for(int i = 0; i < nums.length - 1; i ++){
            for(int j = i+1; j < nums.length; j ++){
                int sum = nums[i] + nums[j];
                if (findMaxDigit(nums[i]) == findMaxDigit(nums[j])){//max digit are equal
                    hs.add(sum);
                }
            }
        }
        if (hs.size() == 0) return -1;
        else{
            List<Integer> list = new ArrayList<>(hs);
            Integer max = Collections.max(list);
            return max.intValue();
        }
        
    }
    private int findMaxDigit(int number){
        int max = 0;
        while(number > 0){
            int digit = number%10;
            if(digit > max){
                max = digit;
            }
            number /= 10;
        }
        return max;
    }
}