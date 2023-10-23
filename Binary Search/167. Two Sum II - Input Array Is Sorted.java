class Solution {
    /*
    Use hashtable: O(N), O(N)
    Binary search:
    We use two indices, initially pointing to the first and the last element, respectively. 
    Compare the sum of these two elements with target. 
    If the sum is equal to target, we found the exactly only solution. 
    If it is less than target, we increase the smaller index by one. If it is greater than target, we decrease the larger index by one. 
    Move the indices and repeat the comparison until the solution is found.

    Time: O(N)
    Space: O(1)
    */
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length-1;
        int[] res = new int[2];
        while(left < right){
            if(numbers[left] + numbers[right] == target){
                res[0] = left + 1;
                res[1] = right + 1;
                return res;
            }else if (numbers[left] + numbers[right] < target){
                left ++;
            }else{
                right --;
            }
        }
        return res;
    }
}