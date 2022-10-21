public /*
Idea: [-1,0,1,2,-1,-4]
Loop through the sorted array,
Look at -1, check if there are a pair of ints in the rest of the array that addes up to 1, then look at 2, check if there is a pair of ints ....



*/
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> output = new LinkedList();
        
        for(int i = 0; i < nums.length - 2; i++){
            if (i == 0 || i > 0 && nums[i] != nums[i-1]){
                int sum = 0 - nums[i];
                int left = i+1;
                int right = nums.length - 1;
                
                while (left < right){
                    if (nums[left] + nums[right] == sum){
                        output.add(Arrays.asList(nums[i], nums[left], nums[right]));
                        while(left < right && nums[left] == nums[left+1]){
                            left ++;
                        }
                        while(left < right && nums[right] == nums[right-1]){
                            right --;
                        }
                        left ++;
                        right --;
                    }else if(nums[left] + nums[right] > sum){
                        right --;
                    }else{
                        left ++;
                    }
                }
            }
        }
        return output;
    }
}{

}
